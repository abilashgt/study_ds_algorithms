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

    boolean[][] visited;
    int[][] result;

    public int findDistance(int posX, int posY) {
        int max = (maxR + maxC) + 2;
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
                        int d = 1 + findDistance(x, y);
                        if (d < dMin) dMin = d;
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
        soln1.solve();

        int[][] mat2 = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 } };

        Matrix01 soln2 = new Matrix01(mat2);
        soln2.solve();
    }

    public Matrix01(int[][] inputMat) {
        this.inputMat = inputMat;
        maxR = inputMat.length;
        if(maxR>0) maxC = inputMat[0].length;
        visited = new boolean[maxR][maxC];
        result = new int[maxR][maxC];
    }

    void solve() {
        for(int i = 0; i<maxR; i++) {
            for(int j = 0; j<maxC; j++) {
                findDistance(i, j);
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}


