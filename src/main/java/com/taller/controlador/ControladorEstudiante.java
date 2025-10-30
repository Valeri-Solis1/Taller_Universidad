package com.taller.controlador;

import com.taller.modelo.EstudiantesDao;

public class ControladorEstudiante {
   
      private EstudiantesDao estudianteDao;

    public ControladorEstudiante() {
        estudianteDao = new EstudiantesDao();

    }

    public boolean crearEstudiante(com.taller.modelo.Estudiantes e) {
        return estudianteDao.crearEstudiante(e);
    }

    public com.taller.modelo.Estudiantes obtenerEstudiante(int id) {
        return estudianteDao.obtenerEstudiante(id);
    }
    public boolean actualizarEstudiante(com.taller.modelo.Estudiantes e) {
        return estudianteDao.actualizarEstudiante(e);
    }
    public boolean eliminarEstudiante(int id) {
        return estudianteDao.eliminarEstudiante(id);
    }
    public java.util.List<com.taller.modelo.Estudiantes> listarEstudiantes() {
        return estudianteDao.listarEstudiantes();
    }
}
