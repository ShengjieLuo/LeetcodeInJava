public class Leetcode172 {
    public int trailingZeroes(int n) {
        int result = 0;
        long k = 5;
        while (k<=n){
            result += n/k;
            k *= 5;
        }
        return result;
    }
}
