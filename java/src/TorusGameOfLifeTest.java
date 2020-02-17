import static org.junit.Assert.*;

class TorusGameOfLifeTest extends gameOfLife {
    // test the number of times one step will execute with negative integer and empty 3x3 array.
    // Expected output for this test will be infinite loop any negative values used in Evolution
    @org.junit.jupiter.api.Test
    void oneStep1() {
        int[][] bob = new int[3][3];

        TorusGameOfLife one1 = new TorusGameOfLife(bob);
        String b = "Infinite Loop";
        assertEquals(b, one1.evolution(-1));


    }

    @org.junit.jupiter.api.Test
        // Expect error  the array size has to be squared
        // Array has to be squared array in order to function.
        // current array passed in bob is not squared error expected
        // Expectations were met
    void oneStep2() {
        int[][] bob = {{1, 1}, {0, 0, 0}};

        TorusGameOfLife one1 = new TorusGameOfLife(bob);
        one1.oneStep();

        one1.printBoard();
        assertNotSame(one1.board, one1.size);
    }

    @org.junit.jupiter.api.Test
        // create a 3 x3 array no assigned elements
        // expect zeros
        // Test passed
        // result was one 1 on board
        // modification to neighbor needs to be made
    void oneStep3() {

        int[][] bob = new int[3][3];

        TorusGameOfLife one1 = new TorusGameOfLife(bob);
        one1.oneStep();

        one1.printBoard();
    }

    @org.junit.jupiter.api.Test
        // give bob array with dimensions that negative in value
        // use one step to travese array
        // print array expect error
        // error array size Exception
    void oneStep4() {
        int[][] bob = new int[-1][-1];

        TorusGameOfLife one1 = new TorusGameOfLife(bob);
        one1.oneStep();

        one1.printBoard();
    }

    @org.junit.jupiter.api.Test
        // test the bounds of size that will work with one step
        // expect to function
        // expectaton met
        // test the limit of the size of the squared matrix.
    void oneStep5() {
        int[][] bob = new int[5000][5000];

        TorusGameOfLife one1 = new TorusGameOfLife(bob);
        one1.oneStep();

        one1.printBoard();
    }


    // test with a 2x2 matrix
    // passing integer with matrix elements are equal one
    // Expect matrix to return same no as long as integer value of n is less 5 digits(10000)
    // Expectation met
    @org.junit.jupiter.api.Test
    void evolution1() {
        int[][] exam = {{1, 1},
                {1, 1}};
        TorusGameOfLife test1 = new TorusGameOfLife(exam);
        test1.oneStep();
        test1.printBoard();
        assertEquals(0, test1.evolution(10));
    }

    // Testing with negative value
    // Expect infinite loop
    // Test went into infinite loop
    // Result was met.
    @org.junit.jupiter.api.Test
    void evolution2() {
        int[][] exam = {{1, 1},
                {1, 1}};
        TorusGameOfLife test1 = new TorusGameOfLife();
        int[][] outcome = {{1, 1, 1, 1}};
        assertEquals(0, test1.evolution(-1));
    }

    // Testing with value of zero
    // Expectation evolution not function or enter while loop to conduct checks
    // result Expectation met.
    // proof that value of n has to be greater -1 less than 6 digit number
    @org.junit.jupiter.api.Test
    void evolution3() {
        int[][] exam = {{1, 1},
                {1, 1}};
        TorusGameOfLife test1 = new TorusGameOfLife();

        assertEquals(0, test1.evolution(0));
    }

    //Test Evolution after initial run
    // expect matrix 11
    //                11
    // Result expectation met
    @org.junit.jupiter.api.Test
    void evolution4() {
        int[][] exam = {{1, 1},
                {1, 0}};

        TorusGameOfLife test1 = new TorusGameOfLife(exam);
        test1.oneStep();
        test1.printBoard();
        assertEquals(0, test1.evolution(1));
    }
    //
    @org.junit.jupiter.api.Test
    // Testing wit very large 2d array matrix
    // Expect error
    // Test Passed
    // Result Expectations were wrong.

    void evolution5() {
        int[][] exam = {{1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},};

        TorusGameOfLife test1 = new TorusGameOfLife(exam);
        test1.oneStep();

        assertEquals(0, test1.evolution(10));
    }


    @org.junit.jupiter.api.Test
        // Pass integers to neighbors to verify method is functioning
        // Expect 3
        // Results were met
    void neighbors1() {

        int[][] board = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        TorusGameOfLife next = new TorusGameOfLife(board);


        assertEquals(3, next.neighbors(1, 1));


    }

    @org.junit.jupiter.api.Test
        // Testing with negative values
        // Expect negative one or error
        //Test failed
        // Expectation met
    void neighbors2() {

        int[][] board = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        TorusGameOfLife next = new TorusGameOfLife(board);


        assertEquals(-1, next.neighbors(-1, -1));


    }

    @org.junit.jupiter.api.Test
        // give higher value to x and y
        // expect error
        // result expectation met
    void neighbors3() {

        int[][] board = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        TorusGameOfLife next = new TorusGameOfLife(board);


        assertEquals(-1, next.neighbors(2, 2));


    }

    @org.junit.jupiter.api.Test
        // Testing with all zeros in the board
        // Expect return of zero
        // Result expectation met
    void neighbors4() {

        int[][] board = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        TorusGameOfLife next = new TorusGameOfLife(board);


        assertEquals(0, next.neighbors(0, 0));


    }

    @org.junit.jupiter.api.Test
        // give values to x and y excessive
        // expect value  result in error
        // Test failed
        // result met.
    void neighbors5() {

        int[][] board = {{-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}};
        TorusGameOfLife next = new TorusGameOfLife(board);


        assertEquals(0, next.neighbors(10000000, 1000000000));


    }
}
