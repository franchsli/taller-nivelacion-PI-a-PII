import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Introduzca un número.");
            double num1 = scanner.nextDouble();
            System.out.println("Introduzca el operador (+, *, - o /).");
            scanner.nextLine(); // Limpiar el buffer
            String operador = scanner.nextLine();
            System.out.println("Introduzca otro número.");
            double num2 = scanner.nextDouble();
            System.out.println("Solución:");

            switch (operador) {
                case "+":
                    System.out.println(num1 + num2);
                    break;
                
                case "-":
                    System.out.println(num1 - num2);
                    break;
                
                case "*":
                    System.out.println(num1 * num2);
                    break;

                case "/":
                    if (num2 != 0) {
                        System.out.println(num1 / num2);
                    } else {
                        System.out.println("Error: No se puede dividir entre cero.");
                    }
                    break;
            
                default:
                    System.out.println("Operador no válido.");
                    break;
            }
            System.out.println("¿Desea seguir operando? Escriba S/N");
            scanner.nextLine(); // Limpiar el buffer
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("N")) {
                System.out.println("Cerrando calculadora...");
                break;
            }
        }
        System.out.println("Calculadora cerrada.");
        scanner.close();
    }
}
