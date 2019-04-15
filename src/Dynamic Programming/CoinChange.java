package DP;

public class CoinChange {

    static int count(int s[], int m, int n) {
        int table[] = new int[n + 1];
        table[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = s[i]; j <= n; j++) {
                table[j] = table[j] + table[j - s[i]];
            }
        }
        return table[n];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(count(arr, m, n));
    }
}
