public class Leetcode190 {
    public int reverseBits(int n) {
        Long num = Long.valueOf(n);
        String str = Long.toString(n, 2);
        str = new StringBuilder(str).reverse().toString();
        return Integer.valueOf(str,2);
    }
}
