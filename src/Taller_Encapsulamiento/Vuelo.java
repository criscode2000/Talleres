/*aqui solo lo de vuelo */
/* Ejercicio 2 — Vuelo
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
public class Vuelo {
    // Atributos privados (Encapsulamiento)
    private String numero;
    private String origen;
    private String destino;
    private int ocupacion;
    private int capacidadMaxima;

    // Constructor por defecto
    public Vuelo() {
        this.ocupacion = 0; // Por defecto el vuelo inicia con 0 pasajeros
    }

    // Getters y Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(int ocupacion) {
        if (ocupacion < 0 || ocupacion > capacidadMaxima) {
            System.out.println("Error: La ocupación no puede ser negativa ni mayor a la capacidad máxima.");
        } else {
            this.ocupacion = ocupacion;
        }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }