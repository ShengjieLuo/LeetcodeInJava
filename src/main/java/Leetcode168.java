public class Leetcode168 {
    public String convertToTitle(int n) {
        String str = "";
        while (n>=0){
            n = n-1;
            int m = n%26;
            char c = (char)('A'+m);
            str = String.valueOf(c) + str;
            n = n/26;
            if (n==0) break;
        }
        return str;
    }
}
