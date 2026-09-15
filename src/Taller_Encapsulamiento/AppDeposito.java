/* aqui solo lo que va en app */
/* Ejercicio 3 — Depósito de agua
Observa el siguiente diagrama y crea la clase correspondiente:

┌─────────────────────┐                    ┌─────────────────────┐
│   Depósito de agua  │ ── desbordamiento ─→│   Depósito de agua  │
├─────────────────────┤                    ├─────────────────────┤
│ capacidad           │                    │ capacidad           │
│ volumenActual       │                    │ volumenActual       │
│ depositoDesborde    │ ← relación con     ├─────────────────────┤
├─────────────────────┤   otro depósito    │ agregarAgua(cant)   │
│ agregarAgua(cant)   │                    │ quitarAgua(cant)    │
│ quitarAgua(cant)    │                    └─────────────────────┘
└─────────────────────┘
Cuando el depósito principal se desborda, el agua sobrante no se pierde: va a llenar otro depósito de la misma clase.

La clase DepositoAgua debe tener:

Atributos privados capacidad y volumenActual (ambos double).
Un atributo privado depositoDesborde de tipo DepositoAgua — representa el depósito que recibirá el agua sobrante. Puede ser null si no hay ninguno conectado.
Getters y setters para todos los atributos. El setter de capacidad debe rechazar valores menores o iguales a cero.
Un método mostrarEstado() que imprima la capacidad, el volumen actual y el espacio libre.
Un método agregarAgua(double cantidad) que sume al volumen. Si se supera la capacidad, el volumen queda en el máximo y el agua sobrante se envía al depositoDesborde llamando a su propio método agregarAgua(). Si no hay depósito de desborde, solo se imprime un aviso.
Un método quitarAgua(double cantidad) que reste del volumen. Si no hay suficiente agua, el volumen queda en cero y se imprime un aviso.
En App.java crea dos objetos: conéctalos de modo que el desbordamiento del primero llene el segundo, y prueba el caso de desbordamiento. */

public class AppDeposito {
    public static void main(String[] args) {
        // 1. Crear los dos objetos DepositoAgua
        DepositoAgua deposito1 = new DepositoAgua(100.0); // Capacidad 100 Litros
        DepositoAgua deposito2 = new DepositoAgua(50.0);  // Capacidad 50 Litros

        // 2. Conectar el desbordamiento: el desborde de deposito1 apunta a deposito2
        deposito1.setDepositoDesborde(deposito2);

        System.out.println("==========================================");
        System.out.println("       ESTADO INICIAL DE DEPÓSITOS        ");
        System.out.println("==========================================");
        deposito1.mostrarEstado("Depósito Principal (D1)");
        deposito2.mostrarEstado("Depósito Secundario (D2)");

        // 3. Primera prueba: Agregar agua dentro del límite de D1
        System.out.println("\n>>> AGREGANDO 60 LITROS A D1...");
        deposito1.agregarAgua(60.0);
        deposito1.mostrarEstado("Depósito Principal (D1)");

        // 4. Segunda prueba: Provocar desbordamiento en D1 (Espacio libre: 40L, enviamos 70L)
        // D1 debe llenarse (100L) y transferir los 30L sobrantes a D2.
        System.out.println("\n>>> AGREGANDO 70 LITROS MÁS A D1 (DEBE DESBORDAR 30L A D2)...");
        deposito1.agregarAgua(70.0);

        System.out.println("\n==========================================");
        System.out.println("       ESTADO TRAS EL DESBORDAMIENTO      ");
        System.out.println("==========================================");
        deposito1.mostrarEstado("Depósito Principal (D1)");
        deposito2.mostrarEstado("Depósito Secundario (D2)");

        // 5. Tercera prueba: Provocar desbordamiento en D2 (sin tercer depósito)
        System.out.println("\n>>> AGREGANDO 30 LITROS MÁS A D2 (DEBE DESBORDAR Y PERDERSE)...");
        deposito2.agregarAgua(30.0); // D2 tenía 30L + 30L = 60L (supera su capacidad de 50L)
        deposito2.mostrarEstado("Depósito Secundario (D2)");

        // 6. Cuarta prueba: Retirar agua
        System.out.println("\n>>> QUITANDO 120 LITROS A D1...");
        deposito1.quitarAgua(120.0); // Solo tiene 100L
        deposito1.mostrarEstado("Depósito Principal (D1)");
    }
}