package com.gasca1234.solocomsupodelaapiexamen;

public class ganadores {
    private String id;
    private String nombre;
    private String numero;
    private String urlImg;

    public ganadores(String id, String nombre, String numero, String urlImg) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.urlImg = urlImg;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
