package com.taller.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsistenciasDao {
    
    public boolean registrarAsistencia(Asistencias a){ 
        boolean exito = false;
        String sql = "{CALL sp_registrar_asistencia(?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, a.getEstudiante_id());
            cs.setInt(2, a.getCurso_id());
            cs.setString(3, a.getFecha_clase());
            cs.setString(4, a.getEstado_asistencia());
            cs.setString(5, a.getNovedades());


            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error registrarAsistencia: " + ex.getMessage());
        }
        return exito;
    }

    // -------------------- OBTENER POR ID --------------------
    public Asistencias obtenerAsistencia(int estudiante_id) {
        Asistencias a= null;
        String sql = "{CALL sp_obtener_asistencias_estudiante(?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, estudiante_id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                a = new Asistencias(
                    rs.getInt("asistenia_id"),
                    rs.getInt("estudiante_id"),
                    rs.getInt("curso_id"),
                    rs.getString("fecha_clase"),
                    rs.getString("estado_asistencia"),
                    rs.getString("novedades")
                );
            }

        } catch (SQLException ex) {
            System.err.println("Error obtenerAsistencia: " + ex.getMessage());
        }
        return a;
    }

    // -------------------- ACTUALIZAR --------------------
    public boolean actualizarAsistencia(Asistencias a) {
        boolean exito = false;
        String sql = "{CALL sp_actualizar_asistencia(?, ?, ?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, a.getAsistenia_id());
            cs.setString(5, a.getEstado_asistencia());
            cs.setString(6, a.getNovedades());

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error actualizarAsistencia: " + ex.getMessage());
        }
        return exito;

    }

    // -------------------- ELIMINAR --------------------
    public boolean eliminarAsistencia(int id) {
        boolean exito = false;
        String sql = "{CALL sp_eliminar_asistencia(?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error eliminarAsistencia: " + ex.getMessage());
        }
        return exito;
    }

}


