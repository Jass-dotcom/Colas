import java.util.Scanner;

class Nodo {
    String mision;
    Nodo siguiente;

    public Nodo(String mision) {
        this.mision = mision;
        this.siguiente = null;
    }
}
class PilaMisiones {
    private Nodo cima;

    public PilaMisiones() {
        this.cima = null;
    }


    public void agregarMision(String mision) {
        Nodo nueva = new Nodo(mision);
        nueva.siguiente = cima;
        cima = nueva;
        System.out.println("nueva mision agregada: \"" + mision + "\"");
    }
    public void completarMision() {
        if (cima == null) {
            System.out.println("no tienes misiones pendientes");
        } else {
            System.out.println("mision completada: \"" + cima.mision + "\"");
            cima = cima.siguiente;
        }
    }
    public void mostrarMisiones() {
        if (cima == null) {
            System.out.println("No hay misiones activas en tu lista, tomate un descanso");
        } else {
            System.out.println("\n misiones pendientes en tu lista:");
            Nodo actual = cima;
            while (actual != null) {
                System.out.println("🔸 " + actual.mision);
                actual = actual.siguiente;
            }
        }
    }

    public boolean estaVacia() {
        return cima == null;
    }
}
public class MisionesDelForajido {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilaMisiones pila = new PilaMisiones();
        int opcion;

        System.out.println("Bienvenido"); 
        System.out.println("Administra tus misiones y demuestra tu valor.\n");

        do {
        System.out.println("===== MENU =====");
            System.out.println("1. Aceptar nueva misión");
            System.out.println("2. Completar última misión");
            System.out.println("3. Ver misiones actuales");
            System.out.println("4. Salir del juego");
            System.out.print(" opcion? ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("escribe el nombre de la mision: ");
                    String mision = sc.nextLine();
                    pila.agregarMision(mision);
                    break;
                case 2:
                    pila.completarMision();
                    break;
                case 3:
                    pila.mostrarMisiones();
                    break;
                case 4:
                    System.out.println("Adioss, Hasta la proxima mision!");
                    break;
                default:
                    System.out.println("opcion invalida");
            }
            System.out.println();
        } while (opcion != 4);

        sc.close();
    }
}
