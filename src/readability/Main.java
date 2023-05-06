package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       TextDocument doc = new TextDocument(sc.nextLine());
       System.out.println(doc.readabilityLevel());
       System.out.println(doc.automatedReadabilityScore());



    }
}
