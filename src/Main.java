import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

class SimplePasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minLength = 0;
        boolean validInput = false;

        // Loop to ensure valid input for password length
        while (!validInput) {
            try {
                System.out.print("Enter the password length. It must be between 8-20 characters: ");
                minLength = scanner.nextInt();

                if (minLength < 8 || minLength > 20) {
                    System.out.println("Error! Given number is off limits.");
                    continue;
                }

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }

        // User input for character types
        boolean includeLower = false, includeUpper = false, includeDigits = false, includeSymbols = false;
        validInput = false;

        while (!validInput) {
            System.out.print("Include lowercase letters? (y/n): ");
            includeLower = scanner.next().toLowerCase().charAt(0) == 'y';
            System.out.print("Include uppercase letters? (y/n): ");
            includeUpper = scanner.next().toLowerCase().charAt(0) == 'y';
            System.out.print("Include numbers? (y/n): ");
            includeDigits = scanner.next().toLowerCase().charAt(0) == 'y';
            System.out.print("Include symbols? (y/n): ");
            includeSymbols = scanner.next().toLowerCase().charAt(0) == 'y';

            if (!includeLower && !includeUpper && !includeDigits && !includeSymbols) {
                System.out.println("Error! At least one option must be chosen.");
            } else {
                validInput = true;
            }
        }

        String customSet = "";
        System.out.print("Would you like to use a custom character set? (y/n): ");
        boolean useCustomSet = scanner.next().toLowerCase().charAt(0) == 'y';
        if (useCustomSet) {
            System.out.print("Enter custom character set: ");
            customSet = scanner.next();
        }

        // Generate password
        String password = generatePassword(minLength, includeLower, includeUpper, includeDigits, includeSymbols, customSet);

        // Display generated password
        System.out.println("Generated password: " + password);
        scanner.close();
    }

    private static String generatePassword(int minLength, boolean includeLower, boolean includeUpper, boolean includeDigits, boolean includeSymbols, String customSet) {
        ArrayList<Character> characterPool = new ArrayList<>();
        SecureRandom random = new SecureRandom();

        // Add character sets based on user preferences
        if (includeLower) {
            for (char c : LOWERCASE.toCharArray()) {
                characterPool.add(c);
            }
        }
        if (includeUpper) {
            for (char c : UPPERCASE.toCharArray()) {
                characterPool.add(c);
            }
        }
        if (includeDigits) {
            for (char c : DIGITS.toCharArray()) {
                characterPool.add(c);
            }
        }
        if (includeSymbols) {
            for (char c : SYMBOLS.toCharArray()) {
                characterPool.add(c);
            }
        }
        if (!customSet.isEmpty()) {
            for (char c : customSet.toCharArray()) {
                characterPool.add(c);
            }
        }

        int passwordLength = minLength;
        Collections.shuffle(characterPool); // Shuffle the pool to ensure randomness

        char[] password = new char[passwordLength];

        // Build the password using random characters from the character pool
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(characterPool.size());
            password[i] = characterPool.get(randomIndex);
        }

        return new String(password);
    }
}
