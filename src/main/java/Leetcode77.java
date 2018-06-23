import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode77 {

    private List<List<Integer>> results;

    private void comb(int n,int k, int largest,List<Integer> list){
        if (k<0||largest>n) return;
        if (k==0) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=largest+1;i<=n;i++){
            list.add(i);
            comb(n,k-1,i,list);
            list.remove(list.size()-1);
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        if (k==0||n==0) return new ArrayList<>();
        results = new ArrayList<List<Integer>>();
        for (int i=1;i<=n;i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            comb(n,k-1,i,list);
        }
        return results;
    }
}
