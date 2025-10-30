package com.taller.modelo;

public class Asistencias {
    
     private int asistenia_id;
    private int estudiante_id;
    private int curso_id;
    private String fecha_clase;
    private String estado_asistencia;
    private String novedades;
   

    public Asistencias(int asistenia_id, int estudiante_id, int curso_id, String fecha_clase, String estado_asistencia, String novedades) {
        this.asistenia_id = asistenia_id;
        this.estudiante_id = estudiante_id;
        this.curso_id = curso_id;
        this.fecha_clase = fecha_clase;
        this.estado_asistencia = estado_asistencia;
        this.novedades = novedades;

    }

    public int getAsistenia_id() {
        return asistenia_id;
    }   
    public int getEstudiante_id() {
        return estudiante_id;
    }
    public int getCurso_id() {
        return curso_id;
    }
    public String getFecha_clase() {
        return fecha_clase;
    }
    public String getEstado_asistencia() {
        return estado_asistencia;
    }
    public String getNovedades() {
        return novedades;
    }
}
