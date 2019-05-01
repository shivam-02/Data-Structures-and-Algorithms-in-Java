package DP;

public class LCS2 {

    static int LCS(char X[], char Y[], int m, int n) {
        int l[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    l[i][j] = 1 + l[i - 1][j - 1];
                } else {
                    l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
                }
            }
        }
        return l[m][n];
    }

    public static void main(String[] args) {
        LCS2 lcs = new LCS2();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.LCS(X, Y, m, n));
    }
}
