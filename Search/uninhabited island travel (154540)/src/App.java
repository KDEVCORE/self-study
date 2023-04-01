import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        Solution sol = new Solution();
        for(int item: sol.solution(maps)) System.out.print(item + " ");
    }
}
class Solution {
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    int[][] copyMap;
    boolean[][] visited;
    int row, col;
    public int[] solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        copyMap = new int[row][col];
        visited = new boolean[row][col];
        int check = 0;
        for(int i=0; i<copyMap.length; i++) {
            for(int j=0; j<copyMap[i].length; j++) {
                String temp = String.valueOf(maps[i].charAt(j));
                copyMap[i][j] = Integer.parseInt("X".equals(temp) ? "-1" : temp);
                if(copyMap[i][j] < 0) check++;
            }
        }
        if(check == (row * col)) return new int[]{-1};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<copyMap.length; i++) {
            for(int j=0; j<copyMap[i].length; j++) {
                if(copyMap[i][j] > 0 && !visited[i][j]) {
                    pq.offer(bfs(new Coordinates(i, j)));
                }
            }
        }
        int[] answer = new int[pq.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
    private int bfs(Coordinates coord) {
        int count = 0;
        Queue<Coordinates> queue = new LinkedList<>();
        visited[coord.x][coord.y] = true;
        count += copyMap[coord.x][coord.y];
        queue.offer(coord);
        while(!queue.isEmpty()) {
            Coordinates now = queue.poll();
            for(int i=0; i<dx.length; i++) {
                int x1 = now.x + dx[i];
                int y1 = now.y + dy[i];
                if(x1 >= 0 && y1 >= 0 && x1 < row && y1 < col && !visited[x1][y1] && copyMap[x1][y1] > 0) {
                    count += copyMap[x1][y1];
                    queue.offer(new Coordinates(x1, y1));
                    visited[x1][y1] = true;
                }
            }
        }
        return count;
    }
}
class Coordinates {
    int x, y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}