import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            res.add(1);
            for (int j = i - 1; j > 0; --j) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }

    public static void main(String gg[]){
        PascalTriangle2 ps=new PascalTriangle2();
        System.out.println(ps.getRow(3));
    }

}
