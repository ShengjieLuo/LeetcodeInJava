import java.util.HashMap;
import java.util.Map;

public class Leetcode137 {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int num:nums) map.put(num, map.getOrDefault(num, 0)+1);
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()!=3) return entry.getKey();
        }
    }
}
