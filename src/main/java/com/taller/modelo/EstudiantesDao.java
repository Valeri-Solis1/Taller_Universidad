package com.taller.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDao {
       // -------------------- CREAR --------------------
    public boolean crearEstudiante(Estudiantes e){
        boolean exito = false;
        String sql = "{CALL sp_crear_estudiante(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, e.getIdentificacion());
            cs.setString(2, e.getNombre());
            cs.setString(3, e.getCorreo_institucional());
            cs.setString(4, e.getCorreo_personal());
            cs.setString(5, e.getTelefono());
            cs.setBoolean(6, e.isEs_vocero());
            cs.setString(7, e.getTipo_documento());
            cs.setString(8, e.getGenero());
            cs.setString(9, e.getComentarios());

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error crearEstudiante: " + ex.getMessage());
        }
        return exito;
    }

    // -------------------- OBTENER POR ID --------------------
    public Estudiantes obtenerEstudiante(int id) {
        Estudiantes e= null;
        String sql = "{CALL sp_obtener_estudiante(?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                e = new Estudiantes(
                    rs.getInt("estudiante_id"),
                    rs.getString("identificacion"),
                    rs.getString("nombre"),
                    rs.getString("correo_institucional"),
                    rs.getString("correo_personal"),
                    rs.getString("telefono"),
                    rs.getBoolean("es_vocero"),
                    rs.getString("tipo_documento"),
                    rs.getString("genero"),
                    rs.getString("comentarios")
                );
            }

        } catch (SQLException ex) {
            System.err.println("Error obtenerEstudiante: " + ex.getMessage());
        }
        return e;
    }

    public Estudiantes ObtenerEstudiantePorNombre(String nombre) {
        Estudiantes e = null;
        String sql = "{CALL sp_obtener_estudiante_por_nombre(?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, nombre);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                e = new Estudiantes(
                    rs.getInt("estudiante_id"),
                    rs.getString("identificacion"),
                    rs.getString("nombre"),
                    rs.getString("correo_institucional"),
                    rs.getString("correo_personal"),
                    rs.getString("telefono"),
                    rs.getBoolean("es_vocero"),
                    rs.getString("tipo_documento"),
                    rs.getString("genero"),
                    rs.getString("comentarios")
                );
            }

        } catch (SQLException ex) {
            System.err.println("Error ObtenerEstudiantePorNombre: " + ex.getMessage());
        }
        return e;
    }

    // -------------------- LISTAR TODOS --------------------
    public List<Estudiantes>listarEstudiantes() {
        List<Estudiantes> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_estudiantes()}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Estudiantes e= new Estudiantes(
                    rs.getInt("estudiante_id"),
                    rs.getString("identificacion"),
                    rs.getString("nombre"),
                    rs.getString("correo_institucional"),
                    rs.getString("correo_personal"),
                    rs.getString("telefono"),
                    rs.getBoolean("es_vocero"),
                    rs.getString("tipo_documento"),
                    rs.getString("genero"),
                    rs.getString("comentarios")
                );
                lista.add(e);
            }

        } catch (SQLException ex) {
            System.err.println("Error listarEstudiantes: " + ex.getMessage());
        }
        return lista;
    }

    // -------------------- ACTUALIZAR --------------------
    public boolean actualizarEstudiante(Estudiantes e){
        boolean exito = false;
        String sql = "{CALL sp_actualizar_estudiante(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, e.getEstudiante_id());
            cs.setString(2, e.getIdentificacion());
            cs.setString(3, e.getNombre());
            cs.setString(4, e.getCorreo_institucional());
            cs.setString(5, e.getCorreo_personal());
            cs.setString(6, e.getTelefono());
            cs.setBoolean(7, e.isEs_vocero());
            cs.setString(8, e.getTipo_documento());
            cs.setString(9, e.getGenero());
            cs.setString(10, e.getComentarios());

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error actualizarEstudiante: " + ex.getMessage());
        }
        return exito;
    }

    // -------------------- ELIMINAR --------------------
    public boolean eliminarEstudiante(int id) {
        boolean exito = false;
        String sql = "{CALL sp_eliminar_estudiante(?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error eliminarEstudiante: " + ex.getMessage());
        }
        return exito;
    }
}
