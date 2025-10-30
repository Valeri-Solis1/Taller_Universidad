package com.taller.modelo;

public class Calificaciones {
    
    private int calificacion_id;
    private int estudiante_id;
    private int componenete_evalucion_id;
    private double nota;
    private double comentarios_caliicacion;
    

    public Calificaciones(int calificacion_id, int estudiante_id, int componenete_evalucion_id, double nota, double comentarios_caliicacion) {
        this.calificacion_id = calificacion_id;
        this.estudiante_id = estudiante_id;
        this.componenete_evalucion_id= componenete_evalucion_id;
        this.nota= nota;
        this.comentarios_caliicacion= comentarios_caliicacion;
    }

    public int getCalificacion_id() {
        return calificacion_id;
    }
    public int getEstudiante_id() {
        return estudiante_id;
    }
    public int getComponenete_evalucion_id() {
        return componenete_evalucion_id;
    }
    public double getNota() {
        return nota;
    }
    public double getComentarios_caliicacion() {
        return comentarios_caliicacion;
    }

}
