package com.taller.modelo;

public class Docentes {
     private int docente_id;
    private String nombre_docente;
    private String identificacion;
    private String tipo_identificacion;
    private String genero;
    private String correo;
    private String titulo_estudios;
    private String idiomas;
    private String certificaciones;

    public Docentes(int docente_id, String nombre_docente, String identificacion, String tipo_identificacion, String genero, String correo, String titulo_estudios, String idiomas, String certificaciones) {
        this.docente_id = docente_id;
        this.nombre_docente = nombre_docente;
        this.identificacion = identificacion;
        this.tipo_identificacion = tipo_identificacion;
        this.genero = genero;
        this.correo = correo;
        this.titulo_estudios = titulo_estudios;
        this.idiomas = idiomas;
        this.certificaciones = certificaciones;
    }
    public int getDocente_id() {
        return docente_id;
    }
    public String getNombre_docente() {
        return nombre_docente;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public String getTipo_identificacion() {
        return tipo_identificacion;
    }
    public String getGenero() {
        return genero;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTitulo_estudios() {
        return titulo_estudios;
    }
    public String getIdiomas() {
        return idiomas;
    }
    public String getCertificaciones() {
        return certificaciones;
    }
}
