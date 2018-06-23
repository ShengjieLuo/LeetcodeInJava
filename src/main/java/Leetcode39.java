import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Leetcode39 {

    private List<List<Integer>> combs;
    private HashSet<List<Integer>> set;

    private void addSum(int[] candidates,int target,List<List<Integer>> lists){
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
        for (int candidate:candidates){
            if (candidate<=target){
                if (lists.size()==0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(candidate);
                    lists.add(tmp);
                    addSum(candidates,target-candidate,lists);
                    lists.remove(lists.size()-1);
                } else {
                    for (List<Integer> list:lists){
                        list.add(candidate);
                    }
                    addSum(candidates,target-candidate,lists);
                    for (List<Integer> list:lists){
                        list.remove(list.size()-1);
                    }
                }

            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combs = new ArrayList<>();
        set = new HashSet<>();
        addSum(candidates,target,new ArrayList<List<Integer>>());
        return combs;
    }
}
