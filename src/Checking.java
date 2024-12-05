
public class Checking {

    public static boolean isWinCondition(String playerName1, String playerName2, int[][] monitor) {

        var counterPlayerN1 = checkCounter(monitor);

        var counterPlayerN2 = checkCounter(monitor);

        return checkWhoIsWin(playerName1, playerName2, counterPlayerN1, counterPlayerN2);
    }

    private static boolean checkWhoIsWin(String playerName1, String playerName2, int counterPlayerN1, int counterPlayerN2) {
        if (counterPlayerN1 >= 10) {
            System.out.println(playerName1 + " Победил!");
            return true;
        }
        if (counterPlayerN2 >= 10) {
            System.out.println(playerName2 + " Победил");
            return true;
        }
        return false;
    }

    public static int checkCounter(int[][] monitor) {
        int hitCounter = 0;

        for (int i = 0; i < monitor.length; i++) {
            for (int j = 0; j < monitor[i].length; j++) {
                if (monitor[i][j] == 2) {
                    hitCounter++;
                }
            }
        }
        return hitCounter;
    }
}