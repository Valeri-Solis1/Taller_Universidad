package com.taller.controlador;

import com.taller.modelo.CalificacionesDao;

public class ControladorCalificaciones {
    
    private CalificacionesDao calificacionDao;

    public ControladorCalificaciones() {
        calificacionDao = new CalificacionesDao();
    }
    public boolean registrarCalificacion(com.taller.modelo.Calificaciones c) {
        return calificacionDao.registrarCalificacion(c);
    }
    public com.taller.modelo.Calificaciones obtenerCalificacion(int estudiante_id, int componente_evalucion_id) {
        return calificacionDao.obtenerCalificacion(estudiante_id, componente_evalucion_id);
    }
    public boolean actualizarCalificacion(com.taller.modelo.Calificaciones c) {
        return calificacionDao.actualizarCalificacion(c);
    }
    public boolean eliminarCalificacion(int id) {
        return calificacionDao.eliminarCalificacion(id);
    }
    
}
