public class gameOfLife {
    int size;
    int[][] board;
    int[][] previous;


    public gameOfLife() {

    }

    public gameOfLife(int s) {
        size = s;
        board = new int[s][s];
        previous = new int[s][s];
    }

    // Constructor assign size the length of array
    // board is new array with size as its rows and columns
    // create previous with same attributes
    // for loop that traverse the array and then array is stored into previous
    public gameOfLife(int[][] arr) {
        size = arr.length;
        board = new int[size][size];
        previous = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                previous[i][j] = arr[i][j];
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard() {
        this.board = board;

    }

    public void oneStep() {

        // For loop traverse previous
        // Condition that checks if the current position is alive or dead
        // According to rules of game
        for (int k = 0; k < previous.length; k++) {
            for (int c = 0; c < previous[k].length; c++) {
                // if less than 2 neighbors position of previous dies becomes a zero
                if ((neighbors(k, c) < 2 && previous[k][c] == 1)) {
                    previous[k][c] = 0;
                }
                // if neighbors are greater than three position of previous dies due to overpopulation
                if (neighbors(k, c) > 3 && previous[k][c] == 1) {
                    previous[k][c] = 0;
                }

                // if neighbors is 3 and position of previous was zero(dead) becomes one(alive)
                if (neighbors(k, c) == 3 && previous[k][c] == 0) {
                    previous[k][c] = 1;
                }


            }

        }


    }


    public int neighbors(int x, int y) {
        // count to verify if dead or alive
        int count = 0;
        // condition that keeps the x and y withing the lengths
        if (x >= 0 && x < previous.length - 1 && y < previous.length - 1 && y >= 0) {
            // Condition to check neighbor below
            if (previous[x][y + 1] == 1) {
                count++;
            }
            // Check neighbor to the right
            if (previous[x + 1][y] == 1) {
                count++;
            }
            // check neighbor to right and bottom
            if (previous[x + 1][y + 1] == 1) {
                count++;

            }
            // condition checks if greater than zero
        } else if (x > 0 && x < previous.length - 1 && y < previous.length - 1 && y > 0) {
            // checks neighbor above
            if (previous[x][y - 1] == 1) {
                count++;
            }

            // checks neighbor to the left
            if (previous[x - 1][y] == 1) {
                count++;
            }
            // checks neighbor to the top left
            if (previous[x - 1][y - 1] == 1) {
                count++;
            }
            // checks neighbor to top right
            if(previous[x+1][y-1]==1){
                count++;
            }
            // checks to bottom right
            if(previous[x-1][y+1]==1){
                count++;
            }

        } else if (x - 1 <= 0 || x > previous.length - 1 || y > previous.length - 1 || y-1 <= 0) {
            // checks neighbor to left outside array count would not increment
            if (previous[x - 1][y] == 1) {
                count++;
            }
            //checks top left outside array count would no increment
            if (previous[x - 1][y - 1] == 1) {
                count++;
            }
            // check top outside array would not increment
            if (previous[x][y - 1] == 1) {
                count++;
            }
            // checks outside row to right count would not increment
            if (previous[x + 1][y] == 1) {
                count++;
            }
            // checks  upper right count would not increment
            if (previous[x + 1][y - 1] == 1) {
                count++;
            }
            // checks bottom outside array will not increment count
            if (previous[x][y + 1] == 1) {
                count++;
            }
            // checks bottom right count would not increment
            if (previous[x + 1][y + 1] == 1) {
                count++;
            }
        }

        return count;
    }

    // Evolution
    // Call method oneStep run n number of times
    // decrement until n =0.
    public int evolution(int n) {

        while (n != 0) {
            oneStep();
            n--;
        }
        return n;
    }
    //Print method to print out board
    // Using two for loops
    public  void printBoard() {

        for (int i = 0; i < previous.length; i++) {
            for (int j = 0; j < previous[i].length; j++) {
                board[i][j] = previous[i][j];
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}

