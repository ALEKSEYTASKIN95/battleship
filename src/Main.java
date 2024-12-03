
public class Main {

    public static void main(String[] args) {
        Players b = new Players();
        System.out.println("Игрок#1, введите имя:");
        b.playerName1 = b.scanner.nextLine();
        System.out.println("Игрок#2, введите имя:");
        b.playerName2 = scanner.nextLine();
        b.placeShips(playerName1, battlefield1);
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
}
