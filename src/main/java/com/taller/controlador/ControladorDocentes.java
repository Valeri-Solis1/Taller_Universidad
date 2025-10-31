package com.taller.controlador;

import com.taller.modelo.Docentes;
import com.taller.modelo.DocentesDao;

public class ControladorDocentes {
    
    public DocentesDao docenteDao;

    public ControladorDocentes() {
        docenteDao = new DocentesDao();
    }
    public boolean crearDocente(Docentes d) {
        return docenteDao.crearDocente(d);
    }
    public Docentes obtenerDocente(int id) {
        return docenteDao.obtenerDocente(id);
    }
    public boolean actualizarDocente(Docentes d) {
        return docenteDao.actualizarDocente(d);
    }
    public boolean eliminarDocente(int id) {
        return docenteDao.eliminarDocente(id);
    }
    public java.util.List<Docentes> listarDocentes() {
        return docenteDao.ListarDocentes();
    }
    
}
