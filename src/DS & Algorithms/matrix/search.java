package matrix;

public class search {

    public static void search(int m[][], int n, int x) {
        int i = 0, j = n - 1;

        while (i < n && j >= 0) {
            if (m[i][j] == x) {
                System.out.println("Element found at " + i + " " + j);
                return;
            } else if (m[i][j] > x) {
                j--;
            } else {
                i++;
            }

        }
    }

    public static void main(String[] args) {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        search(mat, 4, 29);
    }

}
