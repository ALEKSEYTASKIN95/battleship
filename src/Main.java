import java.util.Scanner;

/*
Создание игроков
Инициализация полей игроков, и вспомагательных полей
Запрос имен игроков и расстановка кораблей
Запуск процесса игры пока один из игроков не победит
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Player a = new Player();
        Player b = new Player();

        int[][] battlefield1 = new int[10][10];
        int[][] battlefield2 = new int[10][10];

        int[][] monitor1 = new int[10][10];
        int[][] monitor2 = new int[10][10];

        System.out.println("Игрок#1, введите имя:");
        a.setPlayerName(scanner.nextLine());

        System.out.println("Игрок#2, введите имя:");
        b.setPlayerName(scanner.nextLine());

        Ships.placeShips(a.getPlayerName(), battlefield1);
        Ships.placeShips(b.getPlayerName(), battlefield2);

        while (true) {
            Turn.makeTurn(a.playerName, monitor1, battlefield2);
            if (Checking.isWinCondition(a.playerName, b.playerName, monitor1)) {
                break;
            }
            Turn.makeTurn(b.playerName, monitor2, battlefield1);
            if (Checking.isWinCondition(a.playerName, b.playerName, monitor1)) {
                break;
            }
        }

    }
}
