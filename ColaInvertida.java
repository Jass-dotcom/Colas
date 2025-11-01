package colas;
import java.util.*;

public class ColaInvertida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();
        Stack<Integer> pila = new Stack<>();

        System.out.println("ingresa numeros para la cola a (escribe fin para terminar)");

        while (true) {
            System.out.print("> ");
            String entrada = sc.next();
            if (entrada.equalsIgnoreCase("fin")) break;
            try {
                int num = Integer.parseInt(entrada);
                a.add(num);
                System.out.println("cola a: " + a);
            } catch (NumberFormatException e) {
                System.out.println("valor no valido");
            }
        }

        while (!a.isEmpty()) {
            pila.push(a.remove());
        }

        while (!pila.isEmpty()) {
            b.add(pila.pop());
        }

        System.out.println("\ncola a despues de mover: " + a);
        System.out.println("cola b despues de mover (invertida): " + b);

        sc.close();
    }
}
