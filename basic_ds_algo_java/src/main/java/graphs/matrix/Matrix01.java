package graphs.matrix;

/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Ref:
https://leetcode.com/problems/01-matrix/description/

*/

/*

calculate distance from each squere
1.

Optimization:
put it in a map


 */

public class Matrix01 {
    final int[] rowNbr = new int[] {-1,  0, 0,  1};
    final int[] colNbr = new int[] { 0, -1, 1,  0};

    int[][] inputMat;
    int maxR = 0;
    int maxC = 0;
    int max = 0;

    boolean[][] visited;
    int[][] result;

    public Matrix01(int[][] inputMat) {
        this.inputMat = inputMat;
        maxR = inputMat.length;
        if(maxR>0) maxC = inputMat[0].length;
        max = (maxR + maxC) + 2;
        visited = new boolean[maxR][maxC];
        result = new int[maxR][maxC];
    }

    void solveWithDFS() {
        for(int i = 0; i<maxR; i++) {
            for(int j = 0; j<maxC; j++) {
                DFS(i, j, max, max);
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public int DFS(int posX, int posY, int preX, int preY) {
        if(!visited[posX][posY]) {
            visited[posX][posY] = true;
            result[posX][posY] = max;
            int dMin = max;


            if (inputMat[posX][posY] == 0) {
                dMin = 0;
            }
            else {
                for (int i = 0; i < 4; i++) {
                    int x = posX + rowNbr[i];
                    int y = posY + colNbr[i];

                    if (x >= 0 && y >= 0 && x < maxR && y < maxC) {
                        if(x == preX && y == preY) visited[posX][posY] = false;
                        else {
                            int d = 1 + DFS(x, y, posX, posY);
                            if(d == 1) {
                                dMin = d;
                                break;
                            }
                            else if (d < dMin) {
                                dMin = d;
                            }
                        }
                    }
                }
            }

            result[posX][posY] = dMin;
        }

        return result[posX][posY];
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        Matrix01 soln1 = new Matrix01(mat);
        //soln1.solve();

        int[][] mat2 = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 } };

        Matrix01 soln2 = new Matrix01(mat2);
        //soln2.solve();

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
}


