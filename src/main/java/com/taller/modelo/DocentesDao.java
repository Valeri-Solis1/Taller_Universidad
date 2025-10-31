package com.taller.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocentesDao {
    
    public boolean crearDocente(Docentes d){
        boolean exito = false;
        String sql = "{CALL sp_crear_docente(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, d.getNombre_docente());
            cs.setString(2, d.getIdentificacion());
            cs.setString(3, d.getTipo_identificacion());
            cs.setString(4, d.getGenero());
            cs.setString(5, d.getCorreo());
            cs.setString(6, d.getTitulo_estudios());
            cs.setString(7, d.getIdiomas());
            cs.setString(8, d.getCertificaciones());

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error crearDocente: " + ex.getMessage());
        }
        return exito;
    }

    public Docentes obtenerDocente(int id) {
        Docentes d = null;
        String sql = "{CALL sp_obtener_docente(?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                d = new Docentes(
                        rs.getInt("docente_id"),
                        rs.getString("nombre_docente"),
                        rs.getString("identificacion"),
                        rs.getString("tipo_identificacion"),
                        rs.getString("genero"),
                        rs.getString("correo"),
                        rs.getString("titulo_estudios"),
                        rs.getString("idiomas"),
                        rs.getString("certificaciones")
                );
            }

        } catch (SQLException ex) {
            System.err.println("Error obtenerDocente: " + ex.getMessage());
        }
        return d;
    }

    public List<Docentes> ListarDocentes() {
        List<Docentes> docentes = new ArrayList<>();
        String sql = "{CALL sp_listar_docentes()}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Docentes d = new Docentes(
                        rs.getInt("docente_id"),
                        rs.getString("nombre_docente"),
                        rs.getString("identificacion"),
                        rs.getString("tipo_identificacion"),
                        rs.getString("genero"),
                        rs.getString("correo"),
                        rs.getString("titulo_estudios"),
                        rs.getString("idiomas"),
                        rs.getString("certificaciones")
                );
                docentes.add(d);
            }

        } catch (SQLException ex) {
            System.err.println("Error obtenerTodosLosDocentes: " + ex.getMessage());
        }
        return docentes;
    }

    public boolean actualizarDocente(Docentes d) {
        boolean exito = false;
        String sql = "{CALL sp_actualizar_docente(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, d.getDocente_id());
            cs.setString(2, d.getNombre_docente());
            cs.setString(3, d.getIdentificacion());
            cs.setString(4, d.getTipo_identificacion());
            cs.setString(5, d.getGenero());
            cs.setString(6, d.getCorreo());
            cs.setString(7, d.getTitulo_estudios());
            cs.setString(8, d.getIdiomas());
            cs.setString(9, d.getCertificaciones());

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error actualizarDocente: " + ex.getMessage());
        }
        return exito;
    }

    public boolean eliminarDocente(int id) {
        boolean exito = false;
        String sql = "{CALL sp_eliminar_docente(?)}";

        try (Connection conn = ConexionDatabase.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString("resultado"));
                exito = rs.getString("resultado").startsWith("Éxito");
            }

        } catch (SQLException ex) {
            System.err.println("Error eliminarDocente: " + ex.getMessage());
        }
        return exito;
    }

}
