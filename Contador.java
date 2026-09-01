import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vocales = "aeiou";
        String consonantes = "bcdfghjklmnñpqrtvwxyz";
        int numVocales = 0;
        int numConsonantes = 0;
        System.out.println("Introduzca la palabra.");
        String palabra = scanner.nextLine();
        for (char letra : palabra.toCharArray()) {
            if (vocales.contains(String.valueOf(letra))) {
                numVocales++;
            }
            else if(consonantes.contains(String.valueOf(letra))){
                numConsonantes++;
            }
        }
        scanner.close();
        System.out.println("Resultados:");
        System.out.println("Número de consonantes: " + numConsonantes);
        System.out.println("Número de vocales: " + numVocales);
    }
}
