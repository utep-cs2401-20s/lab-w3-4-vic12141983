public class TorusGameOfLife extends gameOfLife {

    public TorusGameOfLife() {

    }

    public TorusGameOfLife(int s) {
        size = s;
        board = new int[s][s];
        previous = new int[s][s];
    }

    // Constructor with parameters to assign size of array and board into previous
    // board is going to be a squared matrix
    // For loop to complete assigment of board to previous
    public TorusGameOfLife(int[][] arr) {
        size = arr.length;
        board = new int[size][size];
        previous = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                previous[i][j] = arr[i][j];
            }
        }
    }

    public void printBoard() {

        for (int i = 0; i < previous.length; i++) {
            for (int j = 0; j < previous[i].length; j++) {
                board[i][j] = previous[i][j];
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }


    @Override
    public int neighbors(int x, int y) {
        int count = 0;

        // condition that checks the boundary of array left limit and right limit as well top and bottom

        // conditions that wraps back around


        if (previous[x % board.length][y] == 0) {
            count++;
        }
        if (previous[x][y % board.length] == 0) {
            count++;
        }


        if (previous[x % board.length][y % board.length] == 0) {
            count++;
        }


        return count;
    }

}




