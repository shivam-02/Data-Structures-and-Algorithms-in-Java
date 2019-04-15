public class IBExtraChar {
    static char findExtraCharcter(String strA,
                                  String strB)
    {
        // result store the result
        int res = 0, i;

        // traverse string A till
        // end and xor with res
        for (i = 0; i < strA.length(); i++)
        {
            // xor with res
            res ^= strA.charAt(i);
        }

        // traverse string B till end and
        // xor with res
        for (i = 0; i < strB.length(); i++)
        {
            // xor with res
            res ^= strB.charAt(i);
        }

        // print result at the end
        return ((char)(res));
    }

    // Driver code
    public static void main(String args[])
    {
        // given string
        String strA = "abcd";
        String strB = "cbdad";
        System.out.println(findExtraCharcter(strA, strB));
    }
}
