import java.util.*;

public class Leetcode40 {
    private List<List<Integer>> combs;
    private HashSet<List<Integer>> set;
    private List<Integer> candidates;

    private void addSum(int target,List<List<Integer>> lists){
        //System.out.printf("target:%s\n",target);
        if (target==0) {
            for (List<Integer> list:lists){
                List<Integer> tmp = new ArrayList<Integer>(list);
                Collections.sort(tmp);
                if (!set.contains(tmp)){
                    combs.add(tmp);
                    set.add(tmp);
                }
            }
        }
        for (int i=0;i<candidates.size();i++){
            int candidate = candidates.get(i);
            if (candidate<=target){
                List<Integer> tmpCan = new ArrayList<Integer>(candidates);
                candidates.remove(i);
                if (lists.size()==0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(candidate);
                    lists.add(tmp);
                    addSum(target-candidate,lists);
                    lists.remove(lists.size()-1);
                } else {
                    for (List<Integer> list:lists){
                        list.add(candidate);
                    }
                    addSum(target-candidate,lists);
                    for (List<Integer> list:lists){
                        list.remove(list.size()-1);
                    }
                }
                candidates = tmpCan;
            }
        }
    }

    public List<List<Integer>> combinationSum2w2(int[] candidates, int target) {
        combs = new ArrayList<>();
        set = new HashSet<>();
        this.candidates = new ArrayList<Integer>();
        for (int i=0;i<candidates.length;i++){
            this.candidates.add(candidates[i]);
        }
        addSum(target,new ArrayList<List<Integer>>());
        return combs;
    }
}
