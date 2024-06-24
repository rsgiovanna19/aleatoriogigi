package view;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextLine();
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextInt();
    }
}
