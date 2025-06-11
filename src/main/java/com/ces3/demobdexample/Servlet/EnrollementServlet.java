package com.ces3.demobdexample.Servlet;

import com.ces3.demobdexample.Config.DbConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name="enrollement", value = "/enrollement")
public class EnrollementServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DbConnection.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM enrollement WHERE deleted_at IS NULL";
            rs = stmt.executeQuery(sql);

            JSONArray enrollements = new JSONArray();

            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("id_user", rs.getInt("id_user"));
                obj.put("id_subject", rs.getInt("id_subject"));
                obj.put("date_enrollement", rs.getTimestamp("date_enrollement"));
                obj.put("state", rs.getString("state"));
                obj.put("term", rs.getString("term"));
                obj.put("create_at", rs.getTimestamp("create_at"));
                obj.put("updated_at", rs.getTimestamp("updated_at"));
                obj.put("deleted_at", rs.getTimestamp("deleted_at"));  // será null si está activa

                enrollements.put(obj);
            }

            out.print(new JSONObject().put("enrollements", enrollements));

        } catch (Exception e) {
            e.printStackTrace();
            out.print(new JSONObject().put("error", "Error al obtener enrollements: " + e.getMessage()));
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                DbConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = req.getReader().readLine()) != null) {
                sb.append(line);
            }

            JSONObject json = new JSONObject(sb.toString());

            int id_user = json.getInt("id_user");
            int id_subject = json.getInt("id_subject");
            String dateEnrollement = json.getString("date_enrollement"); // formato: "yyyy-MM-dd HH:mm:ss"
            String state = json.getString("state").toLowerCase(); // debe ser uno de los valores del ENUM
            String term = json.getString("term");

            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO enrollement (id_user, id_subject, date_enrollement, state, term, create_at, updated_at) " +
                            "VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)"
            );

            stmt.setInt(1, id_user);
            stmt.setInt(2, id_subject);
            stmt.setTimestamp(3, Timestamp.valueOf(dateEnrollement));
            stmt.setString(4, state);
            stmt.setString(5, term);

            int rows = stmt.executeUpdate();
            JSONObject responseJson = new JSONObject();
            responseJson.put("message", rows > 0 ? "Matrícula registrada exitosamente" : "No se pudo registrar la matrícula");
            out.print(responseJson);

            stmt.close();
            DbConnection.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
            JSONObject errorJson = new JSONObject();
            errorJson.put("error", "Error al registrar matrícula: " + e.getMessage());
            out.print(errorJson);
        } finally {
            out.flush();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = req.getReader().readLine()) != null) {
                sb.append(line);
            }

            JSONObject json = new JSONObject(sb.toString());

            int id_user = json.getInt("id_user");
            int id_subject = json.getInt("id_subject");

            String dateEnrollement = json.getString("date_enrollement"); // "yyyy-MM-dd HH:mm:ss"
            String state = json.getString("state").toLowerCase();
            String term = json.getString("term");

            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE enrollement SET date_enrollement = ?, state = ?, term = ?, updated_at = CURRENT_TIMESTAMP " +
                            "WHERE id_user = ? AND id_subject = ? AND deleted_at IS NULL"
            );

            stmt.setTimestamp(1, Timestamp.valueOf(dateEnrollement));
            stmt.setString(2, state);
            stmt.setString(3, term);
            stmt.setInt(4, id_user);
            stmt.setInt(5, id_subject);

            int rows = stmt.executeUpdate();

            JSONObject responseJson = new JSONObject();
            responseJson.put("message", rows > 0 ? "Matrícula actualizada exitosamente" : "No se encontró la matrícula para actualizar");
            out.print(responseJson);

            stmt.close();
            DbConnection.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
            JSONObject errorJson = new JSONObject();
            errorJson.put("error", "Error al actualizar matrícula: " + e.getMessage());
            out.print(errorJson);
        } finally {
            out.flush();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = req.getReader().readLine()) != null) {
                sb.append(line);
            }

            JSONObject json = new JSONObject(sb.toString());

            int id_user = json.getInt("id_user");
            int id_subject = json.getInt("id_subject");

            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE enrollement SET deleted_at = CURRENT_TIMESTAMP WHERE id_user = ? AND id_subject = ? AND deleted_at IS NULL"
            );

            stmt.setInt(1, id_user);
            stmt.setInt(2, id_subject);

            int rows = stmt.executeUpdate();

            JSONObject responseJson = new JSONObject();
            responseJson.put("message", rows > 0 ? "Matrícula eliminada correctamente (borrado lógico)" : "No se encontró la matrícula para eliminar");
            out.print(responseJson);

            stmt.close();
            DbConnection.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
            JSONObject errorJson = new JSONObject();
            errorJson.put("error", "Error al eliminar matrícula: " + e.getMessage());
            out.print(errorJson);
        } finally {
            out.flush();
        }
    }


}
