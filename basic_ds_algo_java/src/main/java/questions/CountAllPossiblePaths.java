package questions;

/**
 * Count all possible paths from top left to bottom right of a mXn matrix can either move only to right or down
 *
 * Examples :
 *
 * Input :  m = 2, n = 2;
 * Output : 2
 * There are two paths
 * (0, 0) -> (0, 1) -> (1, 1)
 * (0, 0) -> (1, 0) -> (1, 1)
 *
 * Input :  m = 2, n = 3;
 * Output : 3
 * There are three paths
 * (0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
 * (0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
 * (0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
 */

public class CountAllPossiblePaths {

    public static int numberOfPaths(int m, int n){
        if(m == 1 || n == 1) return 1;
        return numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
    }

    public static void main(String[] args) {
        System.out.println(numberOfPaths(3, 3));
    }
}
