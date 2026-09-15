/*Taller: Encapsulamiento en Java
Practica el encapsulamiento creando clases con atributos privados, getters, setters y métodos.

Ejercicio 1 — Libro
Crea una clase llamada Libro que represente un libro de una biblioteca. La clase debe tener los siguientes atributos privados:

titulo (String) — el título del libro
autor (String) — el nombre del autor
disponible (boolean) — indica si el libro está disponible para préstamo
La clase debe tener:

Un getter y setter para cada atributo.
El setter de titulo debe rechazar títulos vacíos.
Un método mostrarInfo() que imprima en consola los datos del libro.
Un método prestar() que marque el libro como no disponible e imprima un mensaje. Si ya estaba prestado, debe avisarlo.
Un método devolver() que marque el libro como disponible e imprima un mensaje.
En App.java crea dos objetos de tipo Libro, asigna sus datos y prueba todos los métodos. */
 
public class App {
    public static void main(String[] args) {
        // Objeto 1: Cien años de soledad
        Libro libro1 = new Libro();
        libro1.setTitulo("Cien años de soledad");
        libro1.setAutor("Gabriel García Márquez");
        libro1.setDisponible(true);

        // Objeto 2: Don Quijote de la Mancha
        Libro libro2 = new Libro();
        libro2.setTitulo("Don Quijote de la Mancha");
        libro2.setAutor("Miguel de Cervantes");
        libro2.setDisponible(true);

        // Pruebas con libro1
        System.out.println("=== PRUEBAS CON LIBRO 1 ===");
        libro1.mostrarInfo();
        libro1.prestar();   // Debe prestarse exitosamente
        libro1.prestar();   // Debe indicar que ya está prestado
        libro1.mostrarInfo();
        libro1.devolver();  // Debe devolverse exitosamente
        
        System.out.println();

        // Pruebas con libro2
        System.out.println("=== PRUEBAS CON LIBRO 2 ===");
        libro2.setTitulo(""); // Prueba de validación de título vacío
        libro2.mostrarInfo();
        libro2.devolver();  // Debe indicar que ya estaba disponible
        libro2.prestar();   // Debe prestarse exitosamente
    }
}