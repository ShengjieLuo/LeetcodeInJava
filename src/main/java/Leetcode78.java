import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    private List<List<Integer>> results;
    private int n;
    private int[] nums;

    private void comb(int largest,List<Integer> list){
        if (largest>=n) return;
        results.add(new ArrayList<Integer>(list));
        for (int i=largest+1;i<n;i++){
            list.add(nums[i]);
            comb(i,list);
            list.remove(list.size()-1);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        results = new ArrayList<List<Integer>>();
        results.add(new ArrayList<Integer>());
        if (nums==null||nums.length==0) return results;
        n = nums.length;
        for (int i=0;i<n;i++){
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            comb(i,list);
        }
        return results;
    }
}
