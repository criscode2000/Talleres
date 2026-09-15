/*Ejercicio 2 — Vuelo
Crea una clase llamada Vuelo que represente un vuelo aéreo. La clase debe tener los siguientes atributos privados:

numero (String) — código del vuelo, por ejemplo "AV9401"
origen (String) — ciudad de origen
destino (String) — ciudad de destino
ocupacion (int) — número de pasajeros a bordo
capacidadMaxima (int) — máximo de pasajeros permitidos
La clase debe tener:

Un getter y setter para cada atributo.
El setter de ocupacion debe rechazar valores negativos o mayores a capacidadMaxima.
Un método mostrarInfo() que imprima los datos del vuelo.
Un método embarcar(int pasajeros) que sume pasajeros a la ocupación. Si no hay suficiente espacio, debe avisarlo sin cambiar la ocupación.
Un método desembarcar(int pasajeros) que reste pasajeros. No puede quedar en negativo.
En App.java crea dos objetos de tipo Vuelo y prueba todos los métodos. */

/* aqui solo lo que va en app */
public class App {
    public static void main(String[] args) {
        // Objeto 1: Vuelo AV9401
        Vuelo vuelo1 = new Vuelo();
        vuelo1.setNumero("AV9401");
        vuelo1.setOrigen("Bogotá");
        vuelo1.setDestino("Medellín");
        vuelo1.setCapacidadMaxima(150);
        vuelo1.setOcupacion(100);

        // Objeto 2: Vuelo AV9402
        Vuelo vuelo2 = new Vuelo();
        vuelo2.setNumero("AV9402");
        vuelo2.setOrigen("Cali");
        vuelo2.setDestino("Cartagena");
        vuelo2.setCapacidadMaxima(200);
        vuelo2.setOcupacion(50);

        // Pruebas con vuelo1
        System.out.println("=== PRUEBAS CON VUELO 1 ===");
        vuelo1.mostrarInfo();
        vuelo1.embarcar(30);   // Debe embarcar exitosamente
        vuelo1.embarcar(25);   // Debe indicar que no hay suficiente espacio
        vuelo1.mostrarInfo();
        vuelo1.desembarcar(50); // Debe desembarcar exitosamente
        vuelo1.desembarcar(100); // Debe indicar que no puede quedar en negativo

        System.out.println();

        // Pruebas con vuelo2
        System.out.println("=== PRUEBAS CON VUELO 2 ===");
        vuelo2.mostrarInfo();
        vuelo2.embarcar(160);   // Debe indicar que no hay suficiente espacio
        vuelo2.embarcar(100);   // Debe embarcar exitosamente
        vuelo2.mostrarInfo();
    }
}