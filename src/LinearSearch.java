import java.util.Vector;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Dynamically set vector size and range
        System.out.print("Enter the number of elements in the vector: ");
        int size = validateInput(scanner);
        System.out.print("Enter the maximum value for random numbers: ");
        int maxValue = validateInput(scanner);

        Vector<Integer> myVector = initializeVector(size, maxValue);
        System.out.println("Generated Vector: " + myVector);

        // Step 2: Perform multiple searches
        performSearch(myVector, scanner);

        System.out.println("Program terminated.");
        scanner.close();
    }

    /**
     * Initializes a vector with random integer values.
     *
     * @param size     the number of elements to generate
     * @param maxValue the maximum value for random numbers
     * @return a Vector<Integer> filled with random integers
     */
    public static Vector<Integer> initializeVector(int size, int maxValue) {
        Vector<Integer> vector = new Vector<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            vector.add(random.nextInt(maxValue + 1)); // Generate random integers between 0 and maxValue
        }

        return vector;
    }

    /**
     * Handles user input, performs multiple searches using the linearSearch method, 
     * and displays results.
     *
     * @param vector  the Vector<Integer> to search
     * @param scanner the Scanner object for user input
     */
    public static void performSearch(Vector<Integer> vector, Scanner scanner) {
        while (true) {
            System.out.print("Enter a value to search (or type -1 to quit): ");
            int searchKey = validateInput(scanner);

            if (searchKey == -1) {
                break; // Exit loop if user inputs -1
            }

            int index = linearSearch(vector, searchKey);

            if (index != -1) {
                System.out.println("Value " + searchKey + " is found at index " + index + ".");
            } else {
                System.out.println("Value " + searchKey + " is not found in the vector.");
            }
        }
    }

    /**
     * Searches for the given searchKey in the vector.
     * If the key is found, it returns the index of the key; otherwise, it returns -1.
     *
     * @param vector    the Vector in which to search
     * @param searchKey the key to search for
     * @return the index of the searchKey if found, otherwise -1
     */
    public static int linearSearch(Vector<Integer> vector, int searchKey) {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) == searchKey) {
                return i; // Return the index if the key is found
            }
        }
        return -1; // Return -1 if the key is not found
    }

    /**
     * Validates user input to ensure it is an integer.
     *
     * @param scanner the Scanner object for user input
     * @return a valid integer input
     */
    public static int validateInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }
}