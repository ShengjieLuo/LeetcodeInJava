import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode139 {

    private int maxlength;
    private HashSet<String> set;
    private HashMap<String,Boolean> map;

    private boolean findBreak(String s){
        if (map.containsKey(s)) return map.get(s);
        if (s.length()==0) return true;
        int len = s.length()<maxlength?s.length():maxlength;
        for (int i=1;i<len+1;i++){
            if (set.contains(s.substring(0,i))){
                if(findBreak(s.substring(i))) {
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        //Build the Hashset
        maxlength = -1;
        set = new HashSet<String>();
        map = new HashMap<String, Boolean>();
        for (String word:wordDict){
            set.add(word);
            if (word.length()>maxlength){
                maxlength = word.length();
            }
        }

        return findBreak(s);
    }
}
