import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode542 {

    class Point{
        public int x;
        public int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    private int[][] matrix;
    private int xlen,ylen;
    private HashMap<List<Integer>,Integer> pointDistanceMap;


    private void addPoint(int px, int py, HashSet<List<Integer>> visited, List<Point> queue){
        List<Integer> coor = new ArrayList<Integer>();
        coor.add(px);
        coor.add(py);
        if (!visited.contains(coor)){
            queue.add(new Point(px,py));
            visited.add(coor);
        }
    }

    private int bfs(Point p){
        List<Integer> coor = new ArrayList<Integer>();
        coor.add(p.x);
        coor.add(p.y);
        if (pointDistanceMap.containsKey(coor)){
            return pointDistanceMap.get(coor);
        }
        List<Point> queue = new ArrayList<Point>();
        HashSet<List<Integer>> visited= new HashSet<List<Integer>>();
        queue.add(p);
        int count = 0 ;
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int num = queue.size();
            for (int i=0;i<num;i++){
                Point po = queue.remove(0);
                if (matrix[po.x][po.y]==0) {
                    result = count<result?count:result;
                    break;
                }

                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(po.x);tmp.add(po.y);
                if (pointDistanceMap.containsKey(tmp)){
                    int dist = pointDistanceMap.get(tmp)+count;
                    result = dist<result?dist:result;
                    continue;
                }

                if (po.x>0) addPoint(po.x-1,po.y,visited,queue);
                if (po.y>0) addPoint(po.x,po.y-1,visited,queue);
                if (po.x<xlen-1) addPoint(po.x+1,po.y,visited,queue);
                if (po.y<ylen-1) addPoint(po.x,po.y+1,visited,queue);
            }
            if (++count>=result) break;
        }
        pointDistanceMap.put(coor,result);
        return result;
    }

    public int[][] updateMatrix(int[][] matrix){
        pointDistanceMap = new HashMap<List<Integer>, Integer>();
        this.matrix = matrix;
        xlen = matrix.length;
        if (xlen==0) return null;
        ylen = matrix[0].length;
        if (ylen==0) return null;
        int[][] result = new int[xlen][ylen];


        for (int i=0;i<xlen;i++){
            for (int j=0;j<ylen;j++){
                result[i][j] = bfs(new Point(i,j));
            }
        }

        return result;
    }
}
