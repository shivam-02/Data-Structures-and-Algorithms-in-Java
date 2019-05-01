package DP;

public class ED2 {

    static int editDistance(String str1, String str2, int m, int n) {
        int ed[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    ed[i][j] = j;
                } else if (j == 0) {
                    ed[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    ed[i][j] = ed[i - 1][j - 1];
                } else {
                    ed[i][j] = 1 + Math.min(Math.min(ed[i - 1][j], ed[i][j - 1]), ed[i - 1][j - 1]);
                }
            }
        }
        return ed[m][n];
    }

    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistance(str1, str2, str1.length(), str2.length()));
    }
}
