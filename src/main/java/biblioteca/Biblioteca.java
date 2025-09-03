package biblioteca;

import java.util.*;

// Clase que representa la biblioteca
public class Biblioteca {
    private Map<String, Libro> catalogoPorIsbn; 
    private Map<String, Usuario> usuariosPorId; 
    private Set<String> isbnsPrestados;         

    // Constructor
    public Biblioteca() {
        catalogoPorIsbn = new HashMap<>();
        usuariosPorId = new HashMap<>();
        isbnsPrestados = new HashSet<>();
    }

    // Añadir un libro al catálogo
    public void añadirLibro(Libro libro) {
        if (libro == null) {
            System.out.println("️ No se puede añadir un libro nulo.");
            return;
        }
        catalogoPorIsbn.put(libro.getIsbn(), libro);
        System.out.println(" Libro añadido: " + libro);
    }

    // Quitar un libro del catálogo
    public void quitarLibro(String isbn) {
        if (isbnsPrestados.contains(isbn)) {
            System.out.println("️ El libro " + isbn + " está prestado y no puede ser eliminado.");
            return;
        }
        if (catalogoPorIsbn.remove(isbn) != null) {
            System.out.println(" Libro eliminado con ISBN " + isbn);
        } else {
            System.out.println("️ No existe un libro con ISBN " + isbn);
        }
    }

    // Registrar un nuevo usuario
    public void registrarUsuario(Usuario u) {
        if (usuariosPorId.containsKey(u.getId())) {
            System.out.println("️ El usuario con ID " + u.getId() + " ya está registrado.");
        } else {
            usuariosPorId.put(u.getId(), u);
            System.out.println(" Usuario registrado: " + u);
        }
    }

    // Dar de baja a un usuario
    public void darBajaUsuario(String id) {
        Usuario u = usuariosPorId.get(id);
        if (u == null) {
            System.out.println("️ Usuario no encontrado con ID " + id);
            return;
        }
        if (!u.getIsbnsPrestados().isEmpty()) {
            System.out.println("️ El usuario " + id + " tiene libros prestados, no puede darse de baja.");
            return;
        }
        usuariosPorId.remove(id);
        System.out.println(" Usuario dado de baja: " + id);
    }

    // Prestar un libro a un usuario
    public void prestarLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        if (u != null && catalogoPorIsbn.containsKey(isbn) && !isbnsPrestados.contains(isbn)) {
            u.getIsbnsPrestados().add(isbn);
            isbnsPrestados.add(isbn);
            System.out.println(" Libro " + isbn + " prestado a " + u.getNombre());
        } else {
            System.out.println("️ No se pudo prestar el libro " + isbn + " al usuario " + idUsuario);
        }
    }

    // Devolver un libro
    public void devolverLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        if (u != null && u.getIsbnsPrestados().contains(isbn)) {
            u.getIsbnsPrestados().remove(isbn);
            isbnsPrestados.remove(isbn);
            System.out.println(" Libro " + isbn + " devuelto por " + u.getNombre());
        } else {
            System.out.println("️ No se pudo devolver el libro " + isbn + " del usuario " + idUsuario);
        }
    }

    // Buscar libros por título
    public List<Libro> buscarPorTitulo(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    // Buscar libros por autor
    public List<Libro> buscarPorAutor(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getAutor().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    // Buscar libros por categoría
    public List<Libro> buscarPorCategoria(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getCategoria().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    // Listar libros prestados a un usuario
    public List<Libro> listarPrestados(String idUsuario) {
        List<Libro> resultado = new ArrayList<>();
        Usuario u = usuariosPorId.get(idUsuario);
        if (u != null) {
            for (String isbn : u.getIsbnsPrestados()) {
                resultado.add(catalogoPorIsbn.get(isbn));
            }
        }
        return resultado;
    }
}
