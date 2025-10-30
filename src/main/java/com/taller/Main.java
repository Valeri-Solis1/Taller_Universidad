package com.taller;

import java.sql.Connection;

import javax.swing.JOptionPane;

import com.taller.modelo.ConexionDatabase;

public class Main {
    public static void main(String[] args) {
                Connection conn = ConexionDatabase.getConnection();
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "Conexión exitosa a la base de datos.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.");
        }
    }
}