package laboration2;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Get command prompt input using Scanner. Wrap input methods and handle
 * clearing of buffers and potential exceptions.
 */
public class SystemInput {

    private final Scanner sc;

    public SystemInput() {
        sc = new Scanner(System.in);
    }

    /**
     * Empty buffer and display error message. Call after input exception.
     */
    private void handleBadInput() {
        // "Empty" buffer (.* = match any char zero or more times)
        sc.skip(".*");
        System.out.println("Bad input. Please reenter.");
    }

    public double getDouble() {
        while (true) {
            try {
                double d = sc.nextDouble();
                sc.nextLine(); // Clear new line character(s)
                return d;
            } catch (NoSuchElementException e) {
                handleBadInput();
            }
        }
    }

    public int getInt() {
        while (true) {
            try {
                int i = sc.nextInt();
                sc.nextLine(); // Clear new line character(s)
                return i;
            } catch (NoSuchElementException e) {
                handleBadInput();
            }

        }
    }

    public String getString() {
        return sc.nextLine();
    }

}
