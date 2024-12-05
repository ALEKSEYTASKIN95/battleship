import java.io.IOException;

public class Cleaner {
    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            System.out.println("Error in process cleaner");
            throw new RuntimeException(e.getMessage());
        }
    }
}
