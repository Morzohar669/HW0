import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * Prints a message according to a given grade.
     *
     * It is guaranteed that the grade is within the range [0, 100].
     *
     * @param grade The grade
     */
    public static void gradeMessage(int grade) {
        // switch statement with int data type
        String gradeString;
        int extera = grade % 10;

        switch (grade - extera) {

            case 100:
                gradeString = "Excellent";
                break;
            case 90:
                gradeString = "Great";
                break;
            case 80:
                gradeString = "Very Good";
                break;
            case 70:
                gradeString = "Good";
                break;
            default:
                gradeString = "OK";
        }
        System.out.println(gradeString);
    }

    /**
     * Compresses a given string.
     *
     * The compression process is done by replacing a sequence of identical consecutive characters
     * with that same character followed by the length of sequence.
     *
     * It is guaranteed that the string contains only letters (lowercase and uppercase).
     *
     * @param stringToCompress The string to compress
     * @return The compressed version of the string
     */
    public static String compressString(String stringToCompress) {
        String compressedString = "";

        int countConsecutive = 0;

        for (int i = 0; i < stringToCompress.length(); i++) {
            countConsecutive++;

            if ((i + 1 >= stringToCompress.length() || stringToCompress.charAt(i + 1) != stringToCompress.charAt(i))) {
                compressedString = compressedString + stringToCompress.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }

        return compressedString;
    }

    /**
     * Decompresses a given string.
     *
     * The decompression process is done by duplicating each sequence of characters
     * according to the number which appears after the sequence.
     *
     * It is guaranteed that the string is a legal compressed string.
     *
     * @param compressedString The string to decompress
     * @return The decompressed string
     */
    public static String decompressString(String compressedString) {
        String decompressedString = "";

        String momentarily = "";

        for (int i = 0; i < compressedString.length(); i++) {

            if (Character.isAlphabetic(compressedString.charAt(i))) {
                momentarily += compressedString.charAt(i);

            } else { // is number then
                int ord = compressedString.charAt(i) - 48;

                if (i + 1 >= compressedString.length() || Character.isAlphabetic(compressedString.charAt(i + 1))) {

                    for (int j = 0; j < ord; j++) {
                        decompressedString += momentarily;
                    }
                    momentarily = "";
                }
            }
        }

        return decompressedString;
    }

    public static void main(String[] args) throws FileNotFoundException {
        gradeMessage(101);
        String str = compressString("abcaaaabcddd");
        System.out.println(str);
        String deStr = decompressString("abc12d3");
        System.out.println(deStr);
        StringBuilder arr = new StringBuilder();
        arr.append(str);
        System.out.println(arr);





//        String filePath = args[0];
//        File file = new File(filePath);
//        Scanner scanner = new Scanner(file);
//
//        // Tests for part A
//        int numberOfGrades = scanner.nextInt();
//        for (int i = 0; i < numberOfGrades; i++) {
//            int grade = scanner.nextInt();
//            gradeMessage(grade);
//        }
//
//        // Tests for part B1
//        int numberOfStringsToCompress = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 0; i < numberOfStringsToCompress; i++) {
//            String stringToCompress = scanner.nextLine();
//            String compressedString = compressString(stringToCompress);
//            System.out.println("The compressed version of " + stringToCompress + " is " + compressedString);
//        }
//
//        // Tests for part B2
//        int numberOfDecompressedStrings = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 0; i < numberOfDecompressedStrings; i++) {
//            String compressedString = scanner.nextLine();
//            String decompressedString = decompressString(compressedString);
//            System.out.println("The decompressed version of " + compressedString + " is " + decompressedString);
//        }
//
//        // Tests for both part B1 and B2
//        int numberOfCombinedTests = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 0; i < numberOfCombinedTests; i++) {
//            String stringToCompress = scanner.nextLine();
//            String compressedString = compressString(stringToCompress);
//            String decompressedString = decompressString(compressedString);
//            System.out.println("decompress(compress(" + stringToCompress + ")) == " + stringToCompress + "? " + stringToCompress.equals(decompressedString));
        }
    }

