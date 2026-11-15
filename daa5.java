class EightQueens {

    static int N = 8;
    static int board[][] = new int[N][N];

    // Check whether queen can be placed safely
    static boolean isSafe(int row, int col) {

        // Check left side of current row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Solve using backtracking
    static boolean solve(int col) {

        if (col >= N)
            return true;

        for (int row = 0; row < N; row++) {

            if (isSafe(row, col)) {

                board[row][col] = 1;

                if (solve(col + 1))
                    return true;

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Place first queen
        board[0][0] = 1;

        if (solve(1)) {

            System.out.println("8 Queens Solution:");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("No solution exists");
        }
    }
}
