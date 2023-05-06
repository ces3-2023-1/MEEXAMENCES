package models;

import java.util.List;

public class Libro implements Comparable {
    String titulo;
    String Editorial;
    double precio;

    String centro;
    Object autor;
    String ano;

    String codigo_pais;
    List<Biblioteca> autores;
    private String editorial;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public Object getAutor() {
        return autor;
    }

    public void setAutor(Object autor) {
        this.autor = autor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public List<Biblioteca> getAutores() {
        return autores;
    }

    public void setAutores(List<Biblioteca> autores) {
        this.autores = autores;
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    @Override
    public int compareTo(Object o) {
        return this.getTitulo().compareTo(((Libro) o).getTitulo());
    }
}
