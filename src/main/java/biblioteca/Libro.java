package biblioteca;

// Clase que representa un libro. Es inmutable (una vez creado no se cambia).
public class Libro {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String categoria;

    // Constructor con validación
    public Libro(String isbn, String titulo, String autor, String categoria) {
        if (isbn == null || titulo == null || autor == null || categoria == null ||
            isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty() || categoria.isEmpty()) {
            throw new IllegalArgumentException(" Ningún dato del libro puede estar vacío");
        }
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }

    // Mostrar bonito en consola
    @Override
    public String toString() {
        return "[" + isbn + "] " + titulo + " — " + autor + " (" + categoria + ")";
    }
}
