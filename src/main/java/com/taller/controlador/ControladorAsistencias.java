package com.taller.controlador;

import com.taller.modelo.AsistenciasDao;

public class ControladorAsistencias {
    
    private AsistenciasDao asistenciaDao;

    public ControladorAsistencias() {
        asistenciaDao = new AsistenciasDao();
    }
    public boolean registrarAsistencia(com.taller.modelo.Asistencias a) {
        return asistenciaDao.registrarAsistencia(a);
    }
    public com.taller.modelo.Asistencias obtenerAsistencia(int estudiante_id) {
        return asistenciaDao.obtenerAsistencia(estudiante_id);
    }
    public boolean actualizarAsistencia(com.taller.modelo.Asistencias a) {
        return asistenciaDao.actualizarAsistencia(a);
    }
    public boolean eliminarAsistencia(int id) {
        return asistenciaDao.eliminarAsistencia(id);
    }
    


}
