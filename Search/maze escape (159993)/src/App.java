import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        // String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        // String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        String[] maps = {"XXXL","XXOO","XXXO","OOSE"};
        System.out.println(new Solution().solution(maps));
    }
}

class Solution {
    int[] dx = {0, 1, 0, -1}, dy ={1, 0, -1, 0};
    String[][] copyMap;
    boolean[][] visited;
    Coordinates start, exit, lever;
    int row, col, answer = Integer.MAX_VALUE;
    boolean startLeverCheck;
    public int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        copyMap = new String[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                copyMap[i][j] = String.valueOf(maps[i].charAt(j));
                switch(copyMap[i][j]) {
                    case "S":
                    start = new Coordinates(i, j, 0);
                    break;
                    case "E":
                    exit = new Coordinates(i, j, 0);
                    break;
                    case "L":
                    lever = new Coordinates(i, j, 0);
                    break;
                }
            }
        }
        visited = new boolean[row][col];
        int startResult = bfs(start, lever);
        visited = new boolean[row][col];
        int leverResult = bfs(lever, exit);
        if(startResult == -1 || leverResult == -1) return -1;
        else return startResult + leverResult;
    }
    private int bfs(Coordinates from, Coordinates to) {
        int result = Integer.MAX_VALUE;
        Queue<Coordinates> queue = new LinkedList<>();
        queue.offer(from);
        visited[from.x][from.y] = true;
        while(!queue.isEmpty()) {
            Coordinates now = queue.poll();
            if(now.equals(to)) result = Math.min(result, now.z);
            for(int i=0; i<dx.length; i++) {
                int x1 = now.x + dx[i];
                int y1 = now.y + dy[i];
                if(x1 >=0 && y1 >= 0 && x1 < row && y1 < col && !"X".equals(copyMap[x1][y1]) && !visited[x1][y1]) {
                    visited[x1][y1] = true;
                    queue.offer(new Coordinates(x1, y1, now.z+1));
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
class Coordinates {
    int x, y, z;
    public Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Coordinates other = (Coordinates) obj;
        if (x != other.x) return false;
        if (y != other.y) return false;
        return true;
    }
}