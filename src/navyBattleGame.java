import java.util.Scanner;

public class navyBattleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        fillMatrix(matrix,scanner);
        int row = -1;
        int col = -1;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("S")){
                    row = i;
                    col = j;
                }
            }
        }
        matrix[row][col] = "-";
        int mines = 0;
        int cruiser = 0;
        String command = scanner.nextLine();
        while (true){
            switch (command){
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            if (matrix[row][col].equals("-")){
                matrix[row][col] = "-";
            }
            if (matrix[row][col].equals("*")){
                matrix[row][col] = "-";
                mines++;
                if (mines == 3){
                    matrix[row][col] = "S";
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row , col);
                    break;
                }
            }
            if (matrix[row][col].equals("C")){
                matrix[row][col] = "-";
                cruiser++;
                if (cruiser == 3){
                    matrix[row][col] = "S";
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(String.join("",matrix[i]));
        }

    }
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
