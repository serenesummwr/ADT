import java.util.Scanner;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<String> lines = new Vector<>();

        System.out.println("Enter lines of input, use 'quit' to end the program.");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            lines.add(input);
        }

        System.out.println("\nNumber of lines: " + lines.size());

        if (!lines.isEmpty()) {
            System.out.println("First line: " + lines.firstElement());

            System.out.println("Lines in reverse order:");
            for (int i = lines.size() - 1; i >= 0; i--) {
                System.out.println(lines.get(i));
            }
        }

        scanner.close();
    }
}