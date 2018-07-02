import java.util.HashMap;

public class Leetcode169 {

    private HashMap<Integer,Integer> map;

    public int majorityElement(int[] nums) {
        map = new HashMap<>();
        int len = nums.length;
        for (int num:nums){
            int count = map.getOrDefault(num,0)+1;
            if (count>len/2) return num;
        }
    }
}
