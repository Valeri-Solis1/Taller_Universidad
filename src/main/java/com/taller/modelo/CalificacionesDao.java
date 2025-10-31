package com.taller.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalificacionesDao {
    
    public boolean registrarCalificacion(Calificaciones c){ 
       boolean exito = false;
       String sql = "{CALL sp_registrar_calificacion(?, ?, ?, ?)}";
         try (Connection conn = ConexionDatabase.getInstance().getConnection();
                CallableStatement cs = conn.prepareCall(sql)) {
    
              cs.setInt(1, c.getEstudiante_id());
              cs.setInt(2, c.getComponenete_evalucion_id());
              cs.setDouble(3, c.getNota());
              cs.setDouble(4, c.getComentarios_caliicacion());
    
              ResultSet rs = cs.executeQuery();
              if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
              }
    
         } catch (SQLException ex) {
              System.err.println("Error registrarCalificacion: " + ex.getMessage());
         }
            return exito;
    }

    public Calificaciones obtenerCalificacion(int estudiante_id) {
        Calificaciones c= null;
        String sql = "{CALL sp_obtener_calificacion_estudiante(?, ?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, estudiante_id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                c = new Calificaciones(
                    rs.getInt("calificacion_id"),
                    rs.getInt("estudiante_id"),
                    rs.getInt("componenete_evalucion_id"),
                    rs.getDouble("nota"),
                    rs.getDouble("comentarios_caliicacion")
                );
            }

        } catch (SQLException ex) {
            System.err.println("Error obtenerCalificacion: " + ex.getMessage());
        }
        return c;
    }

    public boolean actualizarCalificacion(Calificaciones c) {
        boolean exito = false;
        String sql = "{CALL sp_actualizar_calificacion(?, ?, ?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, c.getCalificacion_id());
            cs.setDouble(2, c.getNota());
            cs.setDouble(3, c.getComentarios_caliicacion());

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error actualizarCalificacion: " + ex.getMessage());
        }
        return exito;
    }

    public boolean eliminarCalificacion(int id) {
        boolean exito = false;
        String sql = "{CALL sp_eliminar_calificacion(?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error eliminarCalificacion: " + ex.getMessage());
        }
        return exito;
    }

    public boolean CalcularNotaFinal(int estudiante_id) {
        boolean exito = false;
        String sql = "{CALL sp_calcular_nota_final(?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, estudiante_id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error CalcularNotaFinal: " + ex.getMessage());
        }
        return exito;
    }

}
