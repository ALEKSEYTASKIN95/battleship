public class Ships implements CheckingThePlacementImpl {

    public  void placeShips(String playerName, int[][] battlefield)  {
        Field f = new Field();

        int deck = 4;

        while (deck >= 1) {
            System.out.println();
            System.out.println(playerName + ", разместите " + deck + " палубный корабль:");
            System.out.println();

            f.drawField(battlefield);

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
            clearScreen();
        }
    }
}
