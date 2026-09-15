public class Libro {
    // Atributos privados (Encapsulamiento)
    private String titulo;
    private String autor;
    private boolean disponible;

    // Constructor por defecto
    public Libro() {
        this.disponible = true; // Por defecto el libro inicia disponible
    }

    // Constructor opcional con parámetros
    public Libro(String titulo, String autor, boolean disponible) {
        setTitulo(titulo);
        this.autor = autor;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Error: El título no puede estar vacío.");
        } else {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método para mostrar información
    public void mostrarInfo() {
        String estado = disponible ? "Disponible" : "Prestado";
        System.out.println("--- INFORMACIÓN DEL LIBRO ---");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Estado: " + estado);
        System.out.println("-----------------------------");
    }

    // Método para prestar el libro
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("El libro '" + titulo + "' ha sido prestado con éxito.");
        } else {
            System.out.println("El libro '" + titulo + "' ya se encuentra prestado.");
        }
    }

    // Método para devolver el libro
    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("El libro '" + titulo + "' ha sido devuelto correctamente.");
        } else {
            System.out.println("El libro '" + titulo + "' ya estaba disponible en la biblioteca.");
        }
    }
}