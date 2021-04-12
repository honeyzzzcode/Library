package library;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String nextString(String msg) {
        System.out.println(msg + " ");
        return scanner.next();
    }

    public static int nextInt(String message) {
        System.out.println(message + ":");
        return scanner.nextInt();


    }
}
