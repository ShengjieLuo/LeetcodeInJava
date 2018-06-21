import java.util.ArrayList;
import java.util.List;

public class Leetcode43 {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];
        for (int i=0;i<len1;i++){
            int dig1 = num1.charAt(len1-i-1)-'0';
            for (int j=0;j<len2;j++){
                int dig2      = num2.charAt(len2-j-1)-'0';
                int tmp       = dig1*dig2 + result[i+j];
                //System.out.printf("%d*%d+%d=%d(%d)\n",dig1,dig2,result[i+j],tmp,tmp/10);
                result[i+j]   = tmp%10;
                int addi      = 1;
                int add       = tmp/10;
                while (true) {
                    result[i + j + addi] += add;
                    //System.out.printf("**%d: plus %d to %d\n",i+j+addi,add,result[i + j + addi]);
                    if (result[i + j + addi] >= 10) {
                        result[i + j + addi] %= 10;
                        add = 1;
                        addi++;
                    } else {
                        break;
                    }
                }
            }
        }

        String res = "";
        int i = 1;
        while (len1+len2>=i){
            if (result[len1+len2-i]==0){
                i++;
                continue;
            } else {
                break;
            }
        }
        if (len1+len2<i) return "0";
        for (int j=len1+len2-i;j>=0;j--) res+=String.valueOf(result[j]);
        return res;
    }
}
