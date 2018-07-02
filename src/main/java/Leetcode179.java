import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode179 {
    public String largestNumber(int[] nums) {
        if (nums==null||nums.length==0) return "";

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort(((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            int length = s1.length()<s2.length()?s1.length():s2.length();
            int count = 0;
            while (count<length){
                if (s1.charAt(count)>s2.charAt(count)){
                    return -1;
                } else if (s1.charAt(count)<s2.charAt(count)){
                    return 1;
                }
                count += 1;
            }
            if (s1.length()>s2.length()){
                return s1.charAt(count)>s1.charAt(0)?-1:1;
            } else if (s2.length()>s1.length()){
                return s2.charAt(count)>s2.charAt(0)?1:-1;
            } else {
                return 0;
            }
        }));

        String result = "";
        for (Integer num:list){
            result += String.valueOf(num);
        }
        for (int i=0;i<result.length();i++){
            if (result.charAt(i)!='0'){
                return result.substring(i);
            }
        }
        return "0";
    }
}
