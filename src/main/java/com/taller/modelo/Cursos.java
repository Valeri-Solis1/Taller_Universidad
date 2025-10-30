package com.taller.modelo;

public class Cursos {
     private int curso_id;
    private String nombre_curso;
    private int periodo_academico_id;
    private int docente_id;
    private String descripcion_curso;

    public Cursos(int curso_id, String nombre_curso, int periodo_academico_id, int docente_id, String descripcion_curso) {
        this.curso_id = curso_id;
        this.nombre_curso = nombre_curso;
        this.periodo_academico_id = periodo_academico_id;
        this.docente_id = docente_id;
        this.descripcion_curso = descripcion_curso;
    }
    public int getCurso_id() {
        return curso_id;
    }
    public String getNombre_curso() {
        return nombre_curso;
    }
    public int getPeriodo_academico_id() {
        return periodo_academico_id;
    }
    public int getDocente_id() {
        return docente_id;
    }
    public String getDescripcion_curso() {
        return descripcion_curso;
    }
}
