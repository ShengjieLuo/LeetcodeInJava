public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int result;
        for (int num:nums){
            result ^= num;
        }
        return result;
    }
}
