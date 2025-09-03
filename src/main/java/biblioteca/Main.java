package biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Registrar usuarios
        biblioteca.registrarUsuario(new Usuario("U1", "Ana"));
        biblioteca.registrarUsuario(new Usuario("U2", "Luis"));

        // Añadir libros
        biblioteca.añadirLibro(new Libro("ISBN-001","Clean Code","Robert C. Martin","Software"));
        biblioteca.añadirLibro(new Libro("ISBN-002","Effective Java","Joshua Bloch","Java"));

        // Prestar libros
        biblioteca.prestarLibro("U1", "ISBN-001");
        biblioteca.prestarLibro("U2", "ISBN-002");

        // Listar libros prestados a Ana
        System.out.println("\n Libros prestados a Ana:");
        for (Libro l : biblioteca.listarPrestados("U1")) {
            System.out.println("   - " + l.getTitulo() + " de " + l.getAutor());
        }

        // Devolver un libro
        biblioteca.devolverLibro("U1", "ISBN-001");

        // Buscar por autor
        System.out.println("\n Libros por autor 'Bloch':");
        for (Libro l : biblioteca.buscarPorAutor("Bloch")) {
            System.out.println("   - " + l);
        }

        // Buscar por categoría
        System.out.println("\n Libros por categoría 'Software':");
        for (Libro l : biblioteca.buscarPorCategoria("Software")) {
            System.out.println("   - " + l);
        }
    }
}
