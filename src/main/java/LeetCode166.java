import java.util.HashMap;

public class LeetCode166 {

    public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Integer,Integer> map = new HashMap<>();
        String largePart = "";
        String smallPart = "";
        int count = 0;
        boolean flag = (numerator>=0&&denominator>=0)||(numerator<=0&&denominator<=0);
        numerator = numerator>=0?numerator:-1*numerator;
        denominator = denominator>=0?denominator:-1*denominator;
        while (numerator!=0){
            //System.out.printf("nu:%d de:%d \n",numerator,denominator);
            if (numerator<denominator){
                numerator *= 10;
                int val = numerator/denominator;
                if (map.containsKey(numerator)){
                    int firstloc = map.get(numerator);
                    int lastloc  = count+1;
                    smallPart = new StringBuilder(smallPart)
                            .insert(firstloc, "(")
                            .insert(lastloc,")")
                            .toString();
                    break;
                }
                smallPart += String.valueOf(val);
                map.put(numerator,count);
                count += 1;
            } else {
                int val = numerator/denominator;
                largePart += String.valueOf(val);
            }
            numerator = numerator - (numerator/denominator)*denominator;
        }
        largePart = largePart.length()>0?largePart:"0";
        largePart = flag?largePart:"-"+largePart;
        smallPart = smallPart.length()>0?"."+smallPart:smallPart;
        return largePart+smallPart;
    }
}
