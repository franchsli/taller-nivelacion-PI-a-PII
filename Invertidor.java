import java.util.Scanner;

public class Invertidor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce la cadena.");
        String cadena = scanner.nextLine();
        String cadenaInvertida = invertirTexto(cadena);
        System.out.println("La cadena " + cadena + "de forma invertida es:\n" + cadenaInvertida);

        scanner.close();
    }

    static String invertirTexto(String texto) {
        if (texto == null) return null;
        
        int length = texto.length();
        char[] caracteresInversos = new char[length]; 
        int posicion = 0;
        for (int i = length - 1; i >= 0; i--) {
            caracteresInversos[posicion] = texto.charAt(i);
            posicion++;
        }
        return new String(caracteresInversos); 
    }

}
