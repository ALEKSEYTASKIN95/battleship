
public class Turn {

    public  void makeTurn(String playerName, int[][] monitor, int[][] battlefield) {
        while (true) {
            System.out.println(playerName + ", сделайте ваш ход.");
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < monitor.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < monitor[1].length; j++) {
                    if (monitor[i][j] == 0) {
                        System.out.print("- ");
                    } else if (monitor[i][j] == 1) {
                        System.out.print(". ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
            System.out.println("Введите коордтнату OX");
            int x = scanner.nextInt();
            System.out.println("Введите коордтнату OY");
            int y = scanner.nextInt();
            if(x < 10 && y < 10 && x >= 0 && y >= 0) {
                if (battlefield[x][y] == 1) {
                    System.out.println("Попадание! Сделайте ход снова!");
                    monitor[y][x] = 2;
                } else {
                    System.out.println("Мимо! Ваш соперник ходит!");
                    monitor[y][x] = 1;
                    break;
                }
                clearScreen();
            } else {
                System.out.println("Неверные координаты");
                break;
            }
        }
    }
}
