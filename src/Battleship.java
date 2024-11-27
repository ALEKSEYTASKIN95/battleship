import java.io.IOException;
import java.util.Scanner;

public class Battleship {

    static String playerName1;
    static String playerName2;
    static Scanner scanner = new Scanner(System.in);
    static int[][] battlefield1 = new int[10][10];
    static int[][] battlefield2 = new int[10][10];
    static int[][] monitor1 = new int[10][10];
    static int[][] monitor2 = new int[10][10];


    public static void main(String[] args) {
        System.out.println("Player#1, please enter your name:");
        playerName1 = scanner.nextLine();
        System.out.println("Player#2, please enter your name:");
        playerName2 = scanner.nextLine();
        placeShips(playerName1, battlefield1);
        placeShips(playerName2, battlefield2);
        while (true) {
            makeTurn(playerName1, monitor1, battlefield2);
            if (isWinCondition()) {
                break;
            }
            makeTurn(playerName2, monitor2, battlefield1);
            if (isWinCondition()) {
                break;
            }
        }

    }


    public static void placeShips(String playerName, int[][] battlefield) {
        int deck = 4;

        while (deck >= 1) {
            System.out.println();
            System.out.println(playerName + ", разместите " + deck + " палубный корабль:");
            System.out.println();

            drawField(battlefield);

            System.out.println("Введите коордтнату OX");
            int x = scanner.nextInt();
            System.out.println("Введите коордтнату OY");
            int y = scanner.nextInt();
            System.out.println("Выберите направление:");
            System.out.println("1. Вертикальное.");
            System.out.println("2. Горизонтальное.");
            int direction = scanner.nextInt();
            if (!isAvailable(x, y, deck, direction, battlefield)) {
                System.out.println("Неверные координаты");
                continue;
            }
            for (int i = 0; i < deck; i++) {
                if (direction == 1) {
                    battlefield[x][y + i] = 1;
                } else {
                    battlefield[x + i][y] = 1;
                }
            }
            deck--;
        }
    }

    public static void drawField(int[][] battlefield) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < battlefield.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < battlefield[i].length; j++) {
                if (battlefield[j][i] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public static void makeTurn(String playerName, int[][] monitor, int[][] battlefield) {
        while (true) {
            System.out.println(playerName + ", please make your turn.");
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < monitor.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < monitor[i].length; j++) {
                    if (monitor[j][i] == 0) {
                        System.out.print("- ");
                    } else if (monitor[j][i] == 1) {
                        System.out.print(". ");
                    } else {
                        System.out.println("X ");
                    }
                }
                System.out.println();
            }
            System.out.println("Please enter OX coordinate");
            int x = scanner.nextInt();
            System.out.println("Please enter OY coordinate");
            int y = scanner.nextInt();
            if (battlefield[y][x] == 1) {
                System.out.println("Hit! Make your turn again!");
                monitor[y][x] = 2;
            } else {
                System.out.println("Miss! Your opponents turn!");
                monitor[y][x] = 1;
                break;
            }
            clearScreen();
        }
    }

    public static boolean isWinCondition() {
        int counter1 = 0;
        for (int[] ints : monitor1) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 2) {
                    System.out.println("debug");
                    counter1++;
                }
            }
        }
        int counter2 = 0;
        for (int i = 0; i < monitor2.length; i++) {
            for (int j = 0; j < monitor2[i].length; j++) {
                if (monitor2[i][j] == 2) {
                    System.out.println("debug");
                    counter2++;
                }
            }
        }
        if (counter1 >= 10) {
            System.out.println(playerName1 + " WIN!!!");
            return true;
        }
        if (counter2 >= 10) {
            System.out.println(playerName2 + " WIN!!!");
            return true;
        }
        return false;
    }

    public static boolean isAvailable(int x, int y, int deck, int rotation, int[][] battlefield) {
        // проверка на выход корабля за длинну поля
        if (rotation == 1) {
            if (y + deck > 10) {
                return false;
            }
        }
        if (rotation == 2) {
            if (x + deck > 10) {
                return false;
            }
        }
        // проверка на соседство постановки кораблей
        while (deck != 0) {
            for (int i = 0; i < deck; i++) {
                int xi = 0;
                int yi = 0;
                if (rotation == 1) {
                    yi = i;
                } else {
                    xi = i;
                }
                //   battlefield[x + i][y];
                if (x + 1 + xi < battlefield.length && x + 1 + xi >= 0) {
                    if (battlefield[x + 1 + xi][y + yi] != 0) {
                        return false;
                    }
                }
                if (x - 1 + xi < battlefield.length && x - 1 + xi >= 0) {
                    if (battlefield[x - 1 + xi][y + yi] != 0) {
                        return false;
                    }
                }
                if (y + 1 + yi < battlefield.length && y + 1 + yi >= 0) {
                    if (battlefield[x + xi][y + 1 + yi] != 0) {
                        return false;
                    }
                }
                if (y - 1 + yi < battlefield.length && y - 1 + yi >= 0) {
                    if (battlefield[x + xi][y - 1 + yi] != 0) {
                        return false;
                    }
                }
            }
            deck--;
            clearScreen();
        }
        return true;
    }

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
