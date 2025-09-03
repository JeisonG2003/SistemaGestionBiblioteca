package biblioteca;

import java.util.ArrayList;
import java.util.List;

// Clase que representa a un usuario de la biblioteca
public class Usuario {
    private String id;
    private String nombre;
    private List<String> isbnsPrestados; // Lista de ISBN de libros prestados

    public Usuario(String id, String nombre) {
        if (id == null || nombre == null || id.isEmpty() || nombre.isEmpty()) {
            throw new IllegalArgumentException(" ID y nombre no pueden estar vacíos");
        }
        this.id = id;
        this.nombre = nombre;
        this.isbnsPrestados = new ArrayList<>();
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<String> getIsbnsPrestados() { return isbnsPrestados; }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}
