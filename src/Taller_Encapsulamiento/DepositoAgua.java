/* Ejercicio 3 — Depósito de agua */
public class DepositoAgua {
    private double capacidad;
    private double volumenActual;
    private DepositoAgua depositoDesborde;

    public DepositoAgua(double capacidad) {
        setCapacidad(capacidad);
        this.volumenActual = 0;
        this.depositoDesborde = null;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        if (capacidad <= 0) {
            System.out.println("Error: La capacidad debe ser mayor a cero.");
        } else {
            this.capacidad = capacidad;
        }
    }

    public double getVolumenActual() {
        return volumenActual;
    }

    public void setVolumenActual(double volumenActual) {
        this.volumenActual = volumenActual;
    }

    public DepositoAgua getDepositoDesborde() {
        return depositoDesborde;
    }

    public void setDepositoDesborde(DepositoAgua depositoDesborde) {
        this.depositoDesborde = depositoDesborde;
    }

    // Muestra capacidad, volumen actual y espacio libre
    public void mostrarEstado(String nombre) {
        double espacioLibre = capacidad - volumenActual;
        System.out.println("--- ESTADO DE " + nombre.toUpperCase() + " ---");
        System.out.println("Capacidad total: " + capacidad + " L");
        System.out.println("Volumen actual:  " + volumenActual + " L");
        System.out.println("Espacio libre:   " + espacioLibre + " L");
        System.out.println("--------------------------------");
    }

    // Agrega agua y transfiere el sobrante al depósito de desborde si existe
    public void agregarAgua(double cantidad) {
        double espacioLibre = capacidad - volumenActual;

        if (cantidad <= espacioLibre) {
            volumenActual += cantidad;
            System.out.println("Se agregaron " + cantidad + " L correctamente.");
        } else {
            volumenActual = capacidad; // Se llena completamente
            double sobrante = cantidad - espacioLibre;
            System.out.println("¡AVISO! El depósito se ha llenado. Sobran " + sobrante + " L.");

            if (depositoDesborde != null) {
                System.out.println("Enviando " + sobrante + " L al depósito de desborde...");
                depositoDesborde.agregarAgua(sobrante); // Recursión al siguiente depósito
            } else {
                System.out.println("ADVERTENCIA: No hay un depósito de desborde conectado. El agua sobrante se perdió.");
            }
        }
    }

    // Quita agua asegurando no quedar con saldo negativo
    public void quitarAgua(double cantidad) {
        if (cantidad <= volumenActual) {
            volumenActual -= cantidad;
            System.out.println("Se retiraron " + cantidad + " L de agua.");
        } else {
            System.out.println("¡AVISO! No hay suficiente agua (" + volumenActual + " L disponibles). Se retiró todo el agua restante.");
            volumenActual = 0;
        }
    }
}