package graphs.questions;

public class FindTheNumberOfIslands {
    int ROW = 5, COL = 5;

    void DFS(int[][] M, int row, int col, boolean[][] visited){
        int[] rowNbr = { -1, -1, -1,  0,  0,  1,  1, 1 };
        int[] colNbr = { -1,  0,  1, -1,  1, -1,  0, 1 };

        // mark as visited
        visited[row][col] = true;

        for(int i=0; i<8; i++){
            int cRow = row + rowNbr[i];
            int cCol = col + colNbr[i];
            if(isSafe(M, cRow, cCol, visited)) {
                DFS(M,cRow, cCol, visited);
            }
        }
    }

    Boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL)
                && (M[row][col] == 1)
                && !visited[row][col];
    }

    int countIslands(int[][] M){
        int count = 0;
        boolean[][] visited = new boolean[ROW][COL];

        for (int i=0; i<ROW; i++){
            for (int j=0; j<COL; j++){
                if(M[i][j] == 1 && !visited[i][j]){
                    count++;
                    DFS(M, i, j, visited);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] M = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        FindTheNumberOfIslands I = new FindTheNumberOfIslands();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }
}
