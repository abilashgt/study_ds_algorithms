package graphs.matrix;

import org.junit.jupiter.api.Test;

class Matrix01Test {

    @Test
    void updateMatrixRun() {
        int[][] mat = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 } };

        Matrix01 soln1 = new Matrix01(mat);
        soln1.solveWithDFS();

        int[][] mat2 = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 } };

        Matrix01 soln2 = new Matrix01(mat2);
        soln2.solveWithDFS();
    }

    @Test
    void updateMatrixDifficult() {
        int[][] mat3 = new int[][] {
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}
        };

        Matrix01 soln3 = new Matrix01(mat3);
        soln3.solveWithDFS();
    }

    @Test
    void updateMatrixPerformance() {
        int[][] mat4 = new int[][] {
                {0,0,1,0,1,1,1,0,1,1},
                {1,1,1,1,0,1,1,1,1,1},
                {1,1,1,1,1,0,0,0,1,1},
                {1,0,1,0,1,1,1,0,1,1},
                {0,0,1,1,1,0,1,1,1,1},
                {1,0,1,1,1,1,1,1,1,1},
                {1,1,1,1,0,1,0,1,0,1},
                {0,1,0,0,0,1,0,0,1,1},
                {1,1,1,0,1,1,0,1,0,1},
                {1,0,1,1,1,0,1,1,1,0}
        };

        Matrix01 soln4 = new Matrix01(mat4);
        soln4.solveWithDFS();
    }

    @Test
    void updateMatrixPerformance_leetcodeCase46() {
        int[][] mat4 = new int[][] {
                {0,1,1,1,1,0,1,0,0,1,1,0,0,1,1,1,0,1,1,1,0,0,0,0,1,0,1,1,0,1,1,1,0,0,0,0,1,1,0,1,0,1,1,0,0,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,1,1,1,1,1,0,0,0,0,1,1,0,1,1,1,1,1,0,1,0,0,1,0,1,0,1,1,1,1,1,1,1}, 
                {1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,0,0,1,1,0,1,1,1,1,1,0,0,0,1,1,1,0,0,1,1,1,1,1,1,0,0,0,1,0,1,1,0,1,1},
                {1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,0,1,1,0,0,1,1,0,1,0,1,1,0,0,1,1},
                {1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,0,1,0,0,1,1,1,1,1,1,0,1,0,0,0,0,1,1,1,1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,0,1,1,1,0,1,0,0,0,0,0,1,0,1,1,0,0,0,1,0,1,1,1,0,1,1,0,0,1,0,1,0,1,1,0},
                {0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,0,0,1,1,1,1,1,0,1,1,0,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
                {0,0,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,0,0,1,1,1,0,1,0,0,0,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,0,1,1,0,1,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,0,1,0,0,1,0,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0},
                {0,1,0,1,0,1,1,1,1,1,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,0,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,0,0,1,1,0,0,1,1,1,1,1,1,0,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,0,0,1,1},
                {0,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,0,1,1,1,0,1,0,1,0,0,0,1,0,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1},
                {1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1,0,0,1,1,1,1,1,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,1,0,0,1},
                {1,1,1,1,1,1,1,1,0,1,1,1,0,0,1,0,0,1,0,1,1,1,0,0,1,1,0,1,0,1,0,1,1,0,1,1,1,1,1,0,1,1,0,0,1,0,0,1,1,0,1,1,1,1,1,1,0,1,0,1,1,0,1,0,0,1,1,1,0,1,1,0,1,1,1,0,0,0,0,1,1,1,0,1,0,1,0,1,1,1,1,1,1,0,0,0,1,1,0,1},
                {0,0,0,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,1,0,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,0,1,0,1,0,1,1,0},
                {1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1},
                {0,1,1,0,0,1,1,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,1,1,1,1,0,0,1,1,0,0,1,1,1,0,0,1,1,1,0,1,0,0,0,1,1,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,0,1,1,0,1,1,1,1,0,0,1,0,1,0,0,1,0,1,1,1,0,1,1,1,1},
                {1,1,1,1,1,0,0,1,1,0,1,1,0,1,0,1,1,1,1,1,0,1,1,0,0,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,0,1,0,0,1,1,1,1,1,0,1,1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,0,1,0,0,1,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,0,1,1,0,0,1,1,1,0,1,1,1,1,0,1,1,1,1,0,0,1,1},
                {1,0,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1,0,1,1,0,1,1,1,0,0,1,1,0,0,1,1,1,0,0,0,1,1,0,0,1,0,1,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,0,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,0},
                {1,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,0,0,0,1,0,0,1,1,0,1,1,0,0,0,1,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,0,0,1,1,0,1,1,1,0,0,1,1,1,1,0},
                {0,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,0,1,1,1,1,0,1,1,0,1,1,0,1,1,1,0,1,0,0,1,1,0,0,1,0,1,1,0,0,1,0,0,1,1,1,1,1,1,0,1,1,1,0,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,1,0,1,0,0,1,1,0,1,1,1,1,1,1,0,1},
                {0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,1,0,0,1,0,1,1,1,1,1,1,0,1,1,0,1,0,0,1,0,1,1,0,1,1,1,0,1},
                {0,1,1,1,0,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,0},
                {1,0,1,1,0,0,1,0,1,0,1,1,1,1,0,1,1,0,0,0,1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,0,0,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,0,1,0,1,0,1,1,0,1,0,1,0,0,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,1,0,1,1,0,0,1,0,1},
                {1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,0,0,1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,1,0,0,1,1,1,1,1},
                {0,1,1,1,1,0,0,1,0,0,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,1,1,1,0,0,1,1,1,1,1,0,1,0,1,1,1,0,0,1,1,1,0,1,1,1,0,1,1,0},
                {1,1,1,1,0,1,1,0,0,1,0,0,0,1,0,1,1,1,1,0,0,0,1,1,1,1,0,0,1,0,0,1,1,0,0,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,0,0,1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,0,0,0,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,1,0,1,0,1,1,1,1,1,1,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,0,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0},
                {1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,0,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,1,1,0,1,1,0,1,1,1,0,0,0,1,0,0,0,1,1,1,0,0,1,1,0,0,1,1,1,1,0,1,1,1,0,1,0,1,0,1,0,0,0,1,0,0,0,0,1,1,0},
                {1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,0,1,0,1,1,1,0,1,0,0,1,0,1,0,1,0,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,0,0,0,1,0,1,1},
                {0,1,1,0,1,0,1,1,1,0,0,0,1,0,1,1,1,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,0,1,0,0,0,0,1,0,1,1,0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,0,1,1,1,0,1,0,1,1,1,0,1,0,1,1,0,1,0,1,0,1,1,1,1,1,1},
                {0,1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,1,1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0},
                {1,1,1,0,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1,1,0,1,1,1,1,1,0,1,1,0,1,0,1,1,1,1,0,0,1,1,0,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,0,1,0,1,1,1,0,1,0,0,0,0,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,0,1,1,0,0,1,1},
                {0,1,1,1,0,0,1,1,0,1,1,1,1,1,0,0,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,0,1,0,1,1,1,0,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,1,1,1,0,1,0,0,0,0,1,0,1},
                {1,1,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,1,0,1,1,1,0,1,0,0,1,1,1,0,1,1,1,0,1,1,0,0,1,0,1,1,0,1,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,0,1,1,0,0,1,1,0,0,1,1},
                {1,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,0,1,0,0,1,1,0,1,0,0,1,1,1,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1,1,0,1},
                {1,1,1,0,0,0,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1,1,0,0,1,1,1,0,0,0,0,1,1,1,0,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,0,1,0,1,1,1,1,1,0,0,1,1,0,0,1,0,1,1,1,0,0,0,0,0,0,1,1,1,1,1,0,0,1,0,0,0,1,1,1,1,1,0,1,0},
                {1,1,1,0,1,1,1,1,1,1,0,1,0,0,1,1,1,0,1,0,1,0,0,1,1,1,1,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,1,1,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,0,1,1,0,0,1,1,1,1,1,1,1,0,1,0,0,1,1,1,1,1},
                {1,0,1,1,1,1,0,1,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,0,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,0,0,1},
                {1,1,0,0,1,0,1,0,1,1,1,1,1,1,1,0,1,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,1,1,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,1,0,1,1,0,1,1,0,0,1,0,1,0,0,1,1,0,1,1,0,1,0,1,0,1,1,1,0,1,1,1,1,0,0,1,0},
                {1,0,1,1,1,1,1,1,1,0,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1},
                {1,1,1,0,0,1,0,1,1,1,1,1,1,1,0,0,1,1,0,0,1,0,1,1,1,1,1,1,1,0,1,0,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,0,1,0,0,0,0,1,0,1,1,0,1,0,1,1,0,1},
                {1,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,0,0,1,0,0,1,1,1,0,0,1,1,1,1,1,1,1,0,1,0,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,0,1,0,1,0,1,0,1,1,1,1,1,1,0,0,1,0,1,0},
                {0,1,1,0,0,1,0,0,1,1,0,1,0,1,1,0,0,0,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,1,1,0,0,1,1,1,0,0,1,1,1,1,0,1,1},
                {0,1,1,1,0,1,0,0,0,1,0,0,1,1,1,1,0,1,0,0,0,0,1,0,1,0,1,1,1,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,0,1,0,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,0,1,1,0,0,1,0,0,1,1,0,0,0,0,0,1,1,1,0,1},
                {1,0,0,1,1,1,1,0,0,1,1,1,0,1,0,0,0,1,1,1,1,1,0,1,1,0,1,1,0,0,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,0,1,1,0,0,0,1,1,1,0,0,1,1,0,0,0,1,1,0,0,1,0,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,0,0,0,0,1,0,1,1,1,1,1,1,1},
                {1,1,1,1,1,0,1,1,0,1,1,0,0,1,1,0,1,1,1,1,1,1,0,0,1,0,0,1,1,0,1,1,0,0,1,0,1,1,1,1,1,1,0,0,1,0,1,1,1,0,1,1,1,1,0,1,0,0,0,1,1,1,0,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1},
                {0,0,0,1,0,0,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,0,1,0,0,1,1,0,0,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,0,1,0,0,1,1,0,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,1,0,0,1,1,0,0,1},
                {0,1,1,1,0,1,0,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,0,0,1,1,1,0,1,1,0,0,1,1,1,1,1,1,0,0,0,1,0,1,1,1,1,0,0,1,1,1,0,1,1,0,0,0,1,0,1,1,1,0,0,1,0},
                {1,0,1,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,0,0,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,0,0,1,1,1,1,1,0},
                {0,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,0,1,1,0,0,1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,1,1,0,1,1,0,1,0,1,1,1,0,1,1,0,0,1,1,0,0,1,1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0,1,1,0,1,1,1,1,1,0,0,1,1,1,0,0,1,1,0,1,1,0,1},
                {1,1,1,1,1,1,1,1,1,0,1,0,0,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1,0,1,1,0,0,0,1,1,0,1,0,1,1,0,1,0,0,1,1,1,1,0,0,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1},
                {1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,1,1,1,1,0,0,1,1,0,0,0,1,1,0,1,0,1,1,1,1,1,0,1,1,0,1,1,0,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,0,1,0,0,0,0,0,1,0,1,1,1,1,1,0,1,1},
                {1,0,1,1,1,1,1,1,0,1,0,1,1,1,0,0,1,0,1,1,1,1,0,1,1,0,1,1,1,0,0,1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,1,0,1},
                {1,1,1,1,1,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,0,0,1,1,0,0,0,0,1,1,0,0,0,1,1,1,0,1,0,1,0,0,0,0,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,1,1},
                {0,0,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,0,1,0,1,0,0,0,0,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,0,0,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,1,1,0,0,0,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,0,1,0,0,0,1,1,1,0,1,1,1,1,1,1,0,1,0,0,1,1,1,0,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,0,1,1},
                {1,1,0,1,0,1,1,0,0,1,1,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,1,0,1,0,0,0,0,1,1,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,1,1,0,1,1,0,1,0,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,0,0,1,0,1,0,0},
                {1,0,0,1,1,1,1,0,1,1,1,0,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,1,0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,1,1,0,1,1,1,0,0,0,1,0,0,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,0},
                {0,0,1,1,1,0,0,1,1,1,1,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,0,1,1,1,0,0,0,1,0,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,1,0,0,0},
                {1,1,1,1,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,0,0,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,0,1,0,0,1,0,1,1,1,1,0,1,0,1,1,0,1,1,0,1,1,1},
                {0,0,1,0,0,1,1,1,1,1,0,1,0,0,1,1,0,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,1,0,0,0,0,1,1,1,0,0,0,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,1,1,1,0,0,1,1,1,1,0,0},
                {0,1,1,1,1,0,1,1,0,0,1,1,0,1,1,0,0,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1,0,0,0,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1},
                {1,0,1,1,1,1,0,1,0,0,0,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,0,1,1,0,0,0,0,0,1,1,1,1,0,1,0,1,1,0,0,1,1,0,1,0,1,0,1,1,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1,1,0},
                {1,1,1,0,0,1,0,1,1,1,0,0,1,1,0,1,1,0,1,1,0,0,0,1,1,1,0,1,0,0,0,1,0,1,1,0,1,1,1,1,0,1,1,0,0,0,0,1,1,1,1,0,1,1,1,1,0,0,1,0,1,0,0,1,0,0,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,0,1,1,0,0},
                {1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,0,0,1,1,1,1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1,1,1,0,0,1,0,1,1,1,1,1,0,1,1,0,1,0,1,1,0,0,1,0,0,1,1,0,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1},
                {1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,0,0,1,0,0,0,1,1,0,0,1,0,1,1,0,1,0,1,1,1,0,0,1,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,0,1,1},
                {1,0,1,1,1,0,0,0,0,0,1,0,1,0,1,0,0,1,0,1,1,0,1,1,1,1,0,0,1,1,0,1,0,0,1,0,0,1,1,0,1,0,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,1,0,1,0,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,1,1,0,0,0,1,1,0},
                {1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,0,0,0,1,1,0,0,1,1,1,0,1,1,0,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,0,0,1,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1},
                {0,0,1,0,1,1,1,0,0,0,1,1,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,0,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1,0,0,1,1,1,0,1,1,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,0,1},
                {0,1,1,1,0,1,0,0,0,1,1,1,1,1,0,0,1,0,0,1,1,1,1,1,1,0,1,0,0,1,0,1,1,1,1,1,0,1,1,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,0,0,0},
                {1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,1,0,1,1,0,1,1,0,1,0,0,0,1,0,1,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,1,1,1,0,0,1,1,0,1,1,0,0,1,0,1,1},
                {1,1,1,1,1,1,1,0,0,0,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,1,1,1,0,1,0,0,1,1,1,1,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,0,1,1,1,0,1,1,0,1,1,0,0,1,1,1,0,1,0,0,1,0,1,1,0,1,1,1,1,0,0,1,1,0,0,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,1,1,1,1,1},
                {1,0,1,1,1,0,1,0,0,1,0,1,1,0,0,1,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,1,0,0,1,1,1,0,1,1,0,0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,0,0,1,1,1,0,1,0,0,1,0,1,0,1,1,1,1,0,1,0,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1,1,1},
                {0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,0,0,1,1,1,1,0,1,1,0,0,0,1,0,0,1,1,0,1,1,1,1,0,1,0,1,1,1,0,0,0,1,1,0,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,0,0,0,0,1,1,0,1,1,1,0,0,1,1,1,0,0,0,1,0},
                {0,1,1,1,0,1,1,1,0,1,1,0,0,1,0,0,1,1,1,0,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,0,1,1,0,0,1,1,1,0,0,1,1,1,1,0,1,1,1,1,0,1,1,1,0,0,1,0,1,1,1,1,0,1,1,0,1,0,1,1,1,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1,0,1},
                {1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,0,0,1,1,0,1,0,1,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,1,1,1,0,1,0,1,1,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,0,1,1,1,1,1,1},
                {1,0,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,1,1,0,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,1,0,1,1,0,1,1,1,1,1,0,1,0,1,0,0,1,0,0,1,1,1,1,1,0,1,1,0,1,1,0,1},
                {1,0,1,0,1,0,1,1,0,1,1,0,0,1,0,1,1,1,0,1,1,0,0,1,1,1,1,0,1,1,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,1,0,0,1,0,1,1,0,0,0,1,1,1,0,1,0,1,0,0,1,1,0,1,1,0,1,0,1},
                {0,1,1,1,1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,0,0,0,1,1,1,0,1,0,1,0,1,1,1,1,0,0,1,1,1,0,1,0,0,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,1,0,0,1,0,1,1,0,1,0,0,0,1,1,1,1,1,1,1,1,0,1,1},
                {1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,1,1,1,0,1,1,1,0,1,0,1,1,0,0,1,1,1,0,1,1,0,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,1,0,0,1,0,0,1,0,1,1,0,1,1,0,0,0,0,1,0,1,1,1},
                {1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,0,0,0,0,1,0,1,1,0,0,1,1,1,1,0,0,1,0,0,1,1,0,0,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,0,0,0,1,1,1,0,0,1,0,1,1,0,1,0,1,1,0,1,0,0,1,1,0,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,0,1,1},
                {1,0,1,1,1,0,1,0,1,1,1,0,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,0,0,1,1,1,1,0,1,1,0,1,1,0,1,0,0,0,0,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,0,1,1,1},
                {1,1,1,0,1,1,0,0,1,0,1,1,1,1,1,1,0,0,1,1,0,0,1,0,0,1,1,1,0,0,1,0,0,1,1,1,0,1,1,0,1,0,1,0,1,1,1,1,1,1,0,0,1,0,0,0,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,0,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,0,1,0,1,1,1,0,0},
                {0,0,0,1,1,1,0,1,0,0,0,0,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,0,0,1,0,1,1,0,0,1,1,1,0,0,1,0,0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,0,1,0,0,0,1,0,1,0,0,1,1,0},
                {1,1,1,1,1,1,1,1,0,0,0,1,1,1,0,1,1,1,0,0,1,1,1,0,1,1,1,1,0,0,1,1,1,0,0,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,1,1,1,0,0,0,1,1,1,1,1,1,0,0,1,1,0,1,1,1,0,0,0,1,1,1,0,1,0,1,1,1,0,0,0,1,0,0,1,1,1,0},
                {0,1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,0,1,0,1,1,1,0,1,1,0,0,1,1,1,1,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,0,1,1,1,0,1,1,1,1,0,1,0,1,0,0,1,0,1,1,1,1,1,1},
                {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,0,1,0,0,0,1,0,1,1,0,1,0,1,1,0,1,1,1,0,0,0,1,0,1,1,0,1,1,0,1,1,1,0,1,0,0,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,1,1},
                {1,1,1,1,1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,0,0,1,1,1,0,1,0,1,0,1,0,1,1,1,0,0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0,0,1,1,1,0,0,1,0,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1},
                {1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,0,1,0,0,1,1,0,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,0,0,0,0,1,1,1,1,0,1,0,0,0,1,0,0,1,1,1,1,0,0,1,1,1,0,0,1,0,1,1,1,1,0,1,0,1,1,1,0,1,1,0,1,1,0,0,1,0,0,1,1,1},
                {0,1,0,0,1,1,1,0,1,0,1,1,0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,1,1,0,1,1,0,0,0,0,1,0,1,1,0,1,0,1,1,1,1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,0,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,0},
                {0,1,0,1,0,1,0,1,1,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,0,1,1,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,0,0,1,1,1,1,0,1,1,1,1,1,0,0,0,1,0,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1},
                {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1,1,0,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,1,0,0,1,0},
                {1,1,0,0,0,1,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,0,0,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,0,0,0,1,1,0,1,1,1,1,1,0,0,0,1,1,0},
                {0,1,1,1,1,1,0,1,0,0,1,0,1,1,1,1,0,0,1,0,1,1,0,1,0,1,1,0,0,1,1,0,0,1,1,1,1,0,0,0,1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,0,1,0,1,0,0,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1,0},
                {1,1,1,1,1,0,0,1,0,0,1,1,1,1,0,1,0,0,1,1,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,1,1,1,1,1,0,0,0,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,1,1,0,0,1,1,1,1,1,1,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0},
                {1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1,0,1,0,0,0,1,0,1,0,1,1,0,1,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,1,1,1,0,0,0,0,1,1,1,0,1,0,1,1,1,1,1,0,1,0,0,0,1,0,1,1,1},
                {1,1,0,1,1,1,0,1,1,0,1,0,1,0,0,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,0,1,0,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,0,0,1,1,0,1,1,1,0,1,1,1,1,0,1,0,0,1,1,1,1,0,1,0,1,0,0,0,0,1,1,1,0,1,1}
        };

        Matrix01 soln4 = new Matrix01(mat4);
        soln4.solveWithDFS();
    }
}