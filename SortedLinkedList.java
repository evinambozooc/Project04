

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The SortedLinkedList program implements a simple command-line application 
 * that reads integers from the user input, stores them in a LinkedList, 
 * and sorts them in ascending order. 
 *
 * Design:
 * - Utilizes a LinkedList to dynamically store integers.
 * - Provides a user-friendly interface for input.
 * - Supports comma-separated values for ease of input.
 * 
 * Reusable components:
 * - Error handling can be reused for different types of input validation.
 * - The sorting functionality from the Collections class can be reused for any list.
 */
public class SortedLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>(); // Initialize a LinkedList to store integers
        
        // Using try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter integers (type 'exit' to finish):");

            while (true) {
                String input = scanner.nextLine(); // Read the whole line of input

                if (input.equalsIgnoreCase("exit")) {
                    break; // Exit if the user types 'exit'
                }

                // Split the input by commas and process each part
                String[] parts = input.split(","); // Split by commas
                for (String part : parts) {
                    part = part.trim(); // Remove leading and trailing spaces
                    if (!part.isEmpty()) { // Check if the part is not empty
                        try {
                            numbers.add(Integer.parseInt(part)); // Parse and add the integer
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, please enter an integer or 'exit'.");
                            break; // Exit the loop on invalid input
                        }
                    }
                }
            }
        } // Scanner is automatically closed here
        
        // Sort the LinkedList
        Collections.sort(numbers);
        
        // Print the sorted list
        System.out.println("Sorted numbers: " + numbers);
    }
}
