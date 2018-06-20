import java.util.*;

public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<String, List<String>>();
        for (String str:strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (map.containsKey(key)){
                map.get(key).add(str);
            } else {
                List<String> value = new ArrayList<String>();
                value.add(str);
                map.put(key,value);
            }
        }
        return new ArrayList(map.values());
    }
}
