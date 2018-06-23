import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix==null) return new ArrayList<Integer>();
        int xlen = matrix.length;
        if (xlen==0) return new ArrayList<Integer>();
        int ylen = matrix[0].length;
        if (ylen==0) return new ArrayList<Integer>();

        int direction = 0;
        int count = 0;
        List<Integer> result = new ArrayList<Integer>();
        HashSet<List<Integer>> visited = new HashSet<List<Integer>>();
        result.add(matrix[0][0]);
        visited.add(Arrays.asList(0,0));
        int x=0,y=0;
        while (count<xlen*ylen){
            if (direction==0){
                if (y==ylen-1||visited.contains(Arrays.asList(x,y+1))){
                    direction = 1;
                    if
                }
            }
        }
        return result;
    }
}
