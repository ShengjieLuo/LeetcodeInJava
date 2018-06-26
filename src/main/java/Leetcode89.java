import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Leetcode89 {
    public List<Integer> grayCode(int n) {
        if (n==0) return Arrays.asList(0);
        if (n==1) return Arrays.asList(0,1);
        List<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(1);
        int addi = 1;
        for (int i=1;i<n;i++){
            addi = addi<<1;
            int num = results.size();
            for (int k=1;k<=num;k++){
                int x = results.get(num-k)+addi;
                results.add(x);
            }
        }
        return results;
    }
}
