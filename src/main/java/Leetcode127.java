import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode127 {

    private boolean isNear(String w1,String w2,int len){
        int count = 0;
        for (int i=0;i<len;i++){
            if (w1.charAt(i)!=w2.charAt(i)) count++;
            if (count>1) return false;
        }
        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<String>();
        List<String> queue = new ArrayList<String>();
        queue.add(beginWord);
        int wordlen = beginWord.length();
        int count = 1;
        while (!queue.isEmpty()){
            int num = queue.size();
            for (int i=0;i<num;i++){
                String str = queue.remove(0);
                for (String dest:wordList){
                    if (visited.contains(dest)||dest.equals(str)) continue;
                    if (isNear(str,dest,wordlen)) {
                        if (dest.equals(endWord)) return count+1;
                        queue.add(dest);
                        visited.add(dest);
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
