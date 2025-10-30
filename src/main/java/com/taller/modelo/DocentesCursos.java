package com.taller.modelo;

public class DocentesCursos {
    private int docente_id;
    private int curso_id;

    public DocentesCursos(int docente_id, int curso_id) {
        this.docente_id = docente_id;
        this.curso_id = curso_id;
    }

    public int getDocente_id() {
        return docente_id;
    }

    public void setDocente_id(int docente_id) {
        this.docente_id = docente_id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

}
