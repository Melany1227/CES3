package com.ces3.demobdexample.Servlet;
import com.ces3.demobdexample.Config.DbConnection;
import com.ces3.demobdexample.Models.Faculty;
import com.ces3.demobdexample.Models.Subject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="subject", value = "/subject")
public class SubjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Connection conn = DbConnection.getConnection();
        List<Subject> subjectList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM subject WHERE deleted_at IS NULL";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getInt("id"));
                subject.setName(rs.getString("name"));
                subject.setCode(rs.getString("code"));
                subject.setDescription(rs.getString("description"));
                subject.setCredit(rs.getInt("credit"));

                String facultyStr = rs.getString("faculty");
                if (facultyStr != null) {
                    subject.setFaculty(Faculty.valueOf(facultyStr.toUpperCase()));
                }

                subject.setCreate_at(rs.getTimestamp("create_at"));
                subject.setUpdated_at(rs.getTimestamp("updated_at"));
                subject.setDeleted_at(rs.getTimestamp("deleted_at"));

                subjectList.add(subject);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JSONObject error = new JSONObject();
            error.put("error", "Error al obtener subjects: " + e.getMessage());
            out.print(error);
            return;
        } finally {
            DbConnection.closeConnection();
        }

        JSONObject result = new JSONObject();
        result.put("subjects", subjectList);
        out.print(result);
        out.flush();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = req.getReader().readLine()) != null) sb.append(line);
            JSONObject json = new JSONObject(sb.toString());

            String name = json.getString("name");
            String code = json.getString("code");
            String description = json.getString("description");
            int credit = json.getInt("credit");
            int faculty_id = json.getInt("faculty_id");

            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO subject (name, code, description, credit, faculty, create_at) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP)"
            );

            stmt.setString(1, name);
            stmt.setString(2, code);
            stmt.setString(3, description);
            stmt.setInt(4, credit);
            stmt.setInt(5, faculty_id);

            int rows = stmt.executeUpdate();
            out.print(new JSONObject().put("message", rows > 0 ? "Asignatura creada" : "Error al crear asignatura"));

            stmt.close();
            DbConnection.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            out.print(new JSONObject().put("error", "Error al crear subject: " + e.getMessage()));
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
            while ((line = req.getReader().readLine()) != null) sb.append(line);
            JSONObject json = new JSONObject(sb.toString());

            int id = json.getInt("id");
            String name = json.getString("name");
            String code = json.getString("code");
            String description = json.getString("description");
            int credit = json.getInt("credit");
            int faculty_id = json.getInt("faculty_id");

            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE subject SET name = ?, code = ?, description = ?, credit = ?, faculty = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?"
            );

            stmt.setString(1, name);
            stmt.setString(2, code);
            stmt.setString(3, description);
            stmt.setInt(4, credit);
            stmt.setInt(5, faculty_id);
            stmt.setInt(6, id);

            int rows = stmt.executeUpdate();
            out.print(new JSONObject().put("message", rows > 0 ? "Asignatura actualizada" : "Asignatura no encontrada"));

            stmt.close();
            DbConnection.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            out.print(new JSONObject().put("error", "Error al actualizar subject: " + e.getMessage()));
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
            while ((line = req.getReader().readLine()) != null) sb.append(line);
            JSONObject json = new JSONObject(sb.toString());

            int id = json.getInt("id");

            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE subject SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?"
            );

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            out.print(new JSONObject().put("message", rows > 0 ? "Asignatura eliminada (soft delete)" : "Asignatura no encontrada"));

            stmt.close();
            DbConnection.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            out.print(new JSONObject().put("error", "Error al eliminar subject: " + e.getMessage()));
        } finally {
            out.flush();
        }
    }

}




