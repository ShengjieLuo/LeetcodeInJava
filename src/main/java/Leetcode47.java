import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> visited = new HashSet<List<Integer>>();
        if (nums==null||nums.length==0) return new ArrayList<List<Integer>>();
        int len = nums.length;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        //Add the initial points into results
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        results.add(first);

        for (int i=1;i<len;i++){
            int itemLen = results.size();
            int newItem = nums[i];
            for (int j=0;j<itemLen;j++){
                List<Integer> prev = results.remove(0);
                for (int k=0;k<=prev.size();k++){
                    List<Integer> addi = new ArrayList<Integer>(prev);
                    addi.add(k,newItem);
                    if (!visited.contains(addi)) {
                        results.add(addi);
                        visited.add(addi);
                    }
                }
            }
        }

        return results;
    }
}