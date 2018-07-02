import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode149 {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    private List<Double> getLine(Point p1, Point p2){
        if (p1.x==p2.x) return Arrays.asList(Double.POSITIVE_INFINITY,p1.x+0.0);
        double k = (p1.y-p2.y+0.0)/(p1.x-p2.x);
        double b = (p1.x*p2.y-p2.x*p1.y+0.0)/(p1.x-p2.x);
        return Arrays.asList(k,b);
    }

    private HashMap<List<Double>,Integer> map;

    public int maxPoints(Point[] points) {
        int max = Integer.MIN_VALUE;
        map = new HashMap<>();
        int len = points.length;
        for (int i=0;i<len;i++){
            Point p1 = points[i];
            for (int j=i+1;j<len;j++){
                Point p2 = points[j];
                List<Double> line = getLine(p1,p2);
                map.put(line,map.getOrDefault(line,0)+1);
            }
        }
        for (Integer value: map.values()){
            if (value>max) max = value;
        }
        return max;
    }
}
