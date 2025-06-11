package com.ces3.demobdexample.Servlet;

import com.ces3.demobdexample.Models.Gender;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ces3.demobdexample.Config.DbConnection;
import com.ces3.demobdexample.Models.User;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="user", value = "/user")
public class UserServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();


        Connection conn = DbConnection.getConnection();
        List<User> userList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId_user(rs.getInt("id_user"));
                user.setName(rs.getString("name"));
                user.setLastname(rs.getString("lastname"));
                user.setBirthdate(rs.getDate("birthdate"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIs_active(rs.getBoolean("is_active"));
                user.setPhone(rs.getString("phone"));

                String genderStr = rs.getString("gender");
                if (genderStr != null) {
                    user.setGender(Gender.valueOf(genderStr.toUpperCase()));
                }

                user.setCreated_at(rs.getTimestamp("created_at"));
                user.setUpdated_at(rs.getTimestamp("updated_at"));
                user.setDeleted_at(rs.getTimestamp("deleted_at"));

                userList.add(user);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection();
        }

        JSONObject list = new JSONObject();
        list.put("users", userList);
        out.print(list);
        out.flush();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = req.getReader().readLine()) != null) {
                sb.append(line);
            }

            JSONObject json = new JSONObject(sb.toString());

            User user = new User();
            user.setName(json.getString("name"));
            user.setLastname(json.getString("lastname"));
            user.setBirthdate(java.sql.Date.valueOf(json.getString("birthdate"))); // formato: "yyyy-MM-dd"
            user.setEmail(json.getString("email"));
            user.setPassword(sha1Encrypt(json.getString("password")));
            user.setIs_active(json.getBoolean("is_active"));
            user.setPhone(json.getString("phone"));
            user.setGender(Gender.valueOf(json.getString("gender").toUpperCase()));

            java.util.Date now = new java.util.Date();
            user.setCreated_at(now);
            user.setUpdated_at(now);

            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql = String.format(
                    "INSERT INTO user (name, lastname, birthdate, email, password, is_active, phone, gender, created_at, updated_at) " +
                            "VALUES ('%s', '%s', '%s', '%s', '%s', %b, '%s', '%s', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)",
                    user.getName(),
                    user.getLastname(),
                    user.getBirthdate(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getIs_active(),
                    user.getPhone(),
                    user.getGender().name().toLowerCase()
            );

            int rows = stmt.executeUpdate(sql);

            JSONObject responseJson = new JSONObject();
            responseJson.put("message", rows > 0 ? "Usuario creado exitosamente" : "No se pudo crear el usuario");
            out.print(responseJson);

            stmt.close();
            DbConnection.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
            JSONObject errorJson = new JSONObject();
            errorJson.put("error", "Error al procesar la solicitud: " + e.getMessage());
            out.print(errorJson);
        } finally {
            out.flush();
        }
    }

    private String sha1Encrypt(String input) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = req.getReader().readLine()) != null) {
                sb.append(line);
            }

            JSONObject json = new JSONObject(sb.toString());

            if (!json.has("id_user")) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(new JSONObject().put("error", "Falta el campo id_user"));
                return;
            }

            int id_user = json.getInt("id_user");

            String name = json.optString("name", null);
            String lastname = json.optString("lastname", null);
            String birthdate = json.optString("birthdate", null); // yyyy-MM-dd
            String email = json.optString("email", null);
            String password = json.optString("password", null);
            Boolean is_active = json.has("is_active") ? json.getBoolean("is_active") : null;
            String phone = json.optString("phone", null);
            String gender = json.optString("gender", null);

            Connection conn = DbConnection.getConnection();

            StringBuilder sql = new StringBuilder("UPDATE user SET ");
            List<String> updates = new ArrayList<>();

            if (name != null) updates.add("name = '" + name + "'");
            if (lastname != null) updates.add("lastname = '" + lastname + "'");
            if (birthdate != null) updates.add("birthdate = '" + birthdate + "'");
            if (email != null) updates.add("email = '" + email + "'");
            if (password != null) updates.add("password = '" + sha1Encrypt(password) + "'");
            if (is_active != null) updates.add("is_active = " + is_active);
            if (phone != null) updates.add("phone = '" + phone + "'");
            if (gender != null) updates.add("gender = '" + gender.toLowerCase() + "'");

            updates.add("updated_at = CURRENT_TIMESTAMP");

            sql.append(String.join(", ", updates));
            sql.append(" WHERE id_user = ").append(id_user);

            Statement stmt = conn.createStatement();
            int rows = stmt.executeUpdate(sql.toString());

            JSONObject responseJson = new JSONObject();
            responseJson.put("message", rows > 0 ? "Usuario actualizado correctamente" : "Usuario no encontrado o sin cambios");

            out.print(responseJson);

            stmt.close();
            DbConnection.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
            JSONObject errorJson = new JSONObject();
            errorJson.put("error", "Error al actualizar usuario: " + e.getMessage());
            out.print(errorJson);
        } finally {
            out.flush();
        }
    }

    @WebServlet(name = "userPatch", value = "/user/patch")
    public class UserPatchServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String methodOverride = req.getHeader("X-HTTP-Method-Override");
            if (methodOverride != null && methodOverride.equalsIgnoreCase("PATCH")) {
                handlePatchLike(req, resp);
            } else {
                resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                resp.getWriter().print(new JSONObject().put("error", "Método no permitido"));
            }
        }

        private void handlePatchLike(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();

            try {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = req.getReader().readLine()) != null) {
                    sb.append(line);
                }

                JSONObject json = new JSONObject(sb.toString());

                if (!json.has("id_user")) {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    out.print(new JSONObject().put("error", "Falta el campo id_user"));
                    return;
                }

                int id_user = json.getInt("id_user");

                String name = json.optString("name", null);
                String lastname = json.optString("lastname", null);
                String birthdate = json.optString("birthdate", null);
                String email = json.optString("email", null);
                String password = json.optString("password", null);
                Boolean is_active = json.has("is_active") ? json.getBoolean("is_active") : null;
                String phone = json.optString("phone", null);
                String gender = json.optString("gender", null);

                List<String> updates = new ArrayList<>();

                if (name != null) updates.add("name = '" + name + "'");
                if (lastname != null) updates.add("lastname = '" + lastname + "'");
                if (birthdate != null) updates.add("birthdate = '" + birthdate + "'");
                if (email != null) updates.add("email = '" + email + "'");
                if (password != null) updates.add("password = '" + sha1Encrypt(password) + "'");
                if (is_active != null) updates.add("is_active = " + is_active);
                if (phone != null) updates.add("phone = '" + phone + "'");
                if (gender != null) updates.add("gender = '" + gender.toLowerCase() + "'");

                updates.add("updated_at = CURRENT_TIMESTAMP");

                if (updates.isEmpty()) {
                    out.print(new JSONObject().put("message", "No se enviaron campos para actualizar"));
                    return;
                }

                String sql = "UPDATE user SET " + String.join(", ", updates) + " WHERE id_user = " + id_user;

                Connection conn = DbConnection.getConnection();
                Statement stmt = conn.createStatement();
                int rows = stmt.executeUpdate(sql);

                JSONObject responseJson = new JSONObject();
                responseJson.put("message", rows > 0 ? "Usuario actualizado parcialmente" : "Usuario no encontrado o sin cambios");
                out.print(responseJson);

                stmt.close();
                DbConnection.closeConnection();

            } catch (Exception e) {
                e.printStackTrace();
                out.print(new JSONObject().put("error", "Error en PATCH: " + e.getMessage()));
            } finally {
                out.flush();
            }
        }
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            jsonBuffer.append(line);
        }

        JSONObject json = new JSONObject(jsonBuffer.toString());
        int idUser = json.getInt("id_user");

        Connection conn = DbConnection.getConnection();
        try {
            String sql = "DELETE FROM user WHERE id_user = " + idUser;
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);

            JSONObject responseJson = new JSONObject();
            if (rowsAffected > 0) {
                responseJson.put("message", "Usuario eliminado exitosamente.");
            } else {
                responseJson.put("message", "Usuario no encontrado.");
            }
            out.print(responseJson);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(new JSONObject().put("error", "Error al eliminar usuario."));
        } finally {
            DbConnection.closeConnection();
        }
        out.flush();
    }

}
