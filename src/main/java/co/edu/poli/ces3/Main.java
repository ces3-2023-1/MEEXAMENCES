package co.edu.poli.ces3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.Biblioteca;
import models.Libro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {
    public Main() {
    }

 /*   public List<Libro> buscarLibrosPorPrecio(double precio) {
        List<Libro> libros = new ArrayList<>();
        try {
            // Crear el parser de XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Leer el archivo XML
            Document document = builder.parse(new File("biblioteca.xml"));

            // Crear el objeto JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Biblioteca.class);

            // Crear el objeto Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Obtener el objeto raíz Biblioteca
            Biblioteca biblioteca = (Biblioteca) unmarshaller.unmarshal(document);

            // Buscar los libros que tengan el precio especificado
            for (Libro libro : biblioteca.getLibros()) {
                if (libro.getPrecio() == precio) {
                    libros.add(libro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }*/


    public static void imprimirAutoresDistintos(List<Libro> listaLibros) {
        Map<String, Biblioteca> mapAutores = new HashMap<String, Biblioteca>();
        for (Libro oLibro : listaLibros) {
            List<Biblioteca> listaAutores = oLibro.getAutores();
            if (listaAutores != null) {
                for (Biblioteca autor : listaAutores) {
                    if (!mapAutores.containsKey(autor.getCedula())) {
                        System.out.println("Cédula : " + autor.getCedula() + ", Nombre :" + autor.getNombre());
                        mapAutores.put(autor.getCedula(), autor);
                    }
                }
            }
        }
    }

  /*  public Set<String> listarAutores() {
        Set<String> autores = new HashSet<>();
        try {
            // Crear el parser de XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Leer el archivo XML
            Document document = builder.parse(new File("biblioteca.xml"));

            // Crear el objeto JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Biblioteca.class);

            // Crear el objeto Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Obtener el objeto raíz Biblioteca
            Biblioteca biblioteca = (Biblioteca) unmarshaller.unmarshal(document);

            // Obtener los autores de cada libro y agregarlos al set
            for (Libro libro : biblioteca.getLibros()) {
                for (Autor autor : libro.getAutores()) {
                    autores.add(autor.getNombre() + " " + autor.getApellido());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autores;
    }*/


    public static void imprimirOrdenadoPorTitulo(List<Libro> listaLibros) {
        Collections.sort(listaLibros, new Comparator<Libro>() {
            public int compare(Libro s1, Libro s2) {
                return s1.getTitulo().compareTo(s2.getTitulo());
            }
        });

        for (Libro oLibro : listaLibros) {
            System.out.println("------------------------------------------------------");
            System.out.println("Titulo del libro: " + oLibro.getTitulo());
            System.out.println("Año: " + oLibro.getAno());
            List<Biblioteca> lista = oLibro.getAutores();
            if (lista != null) {
                for (Biblioteca autor : lista) {
                    System.out.println("Autor: " + autor.getNombre());
                }
            }
        }
    }


    public static void imprimirBuscarLibrosPorPrecio(List<Libro> listaLibros, double dPrecio) {
        for (Libro oLibro : listaLibros) {
            if (oLibro.getPrecio() == dPrecio) {
                System.out.println("El libro : " + oLibro.getTitulo() + " con el precio (" + dPrecio + ")");
            }
        }
    }

 /*   public List<Libro> listarLibrosOrdenados() {
        List<Libro> libros = new ArrayList<>();
        try {
            // Crear el parser de XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Leer el archivo XML
            Document document = builder.parse(new File("biblioteca.xml"));

            // Crear el objeto JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Biblioteca.class);

            // Crear el objeto Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Obtener el objeto raíz Biblioteca
            Biblioteca biblioteca = (Biblioteca)*/


            public static void main(String[] args) {
        try {

            ObjectMapper mapper = new XmlMapper();

            InputStream inputStream = new FileInputStream(new File("src\\resources\\Examen.xml"));

            TypeReference<List<Libro>> typeReference = new TypeReference<List<Libro>>() {
            };
            List<Libro> listaLibros = mapper.readValue(inputStream, typeReference);

            //Llamar los métodos
            System.out.println("Libros con el precio de  39.95");
            System.out.println("----------------------------------");
            imprimirBuscarLibrosPorPrecio(listaLibros, 39.95);
            System.out.println("----------------------------------");

            System.out.println("Distintos autores");
            System.out.println("----------------------------------");
            imprimirAutoresDistintos(listaLibros);
            System.out.println("----------------------------------");

            System.out.println("Orden de titulo");
            imprimirOrdenadoPorTitulo(listaLibros);
        } catch (IOException e) {


            System.out.println(e.getMessage());
        }

    }
}

