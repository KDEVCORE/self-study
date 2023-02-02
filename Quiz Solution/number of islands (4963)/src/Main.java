import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}, dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            if(row == 0 && col == 0) break;
            map = new int[row][col];
            visited = new boolean[row][col];
            for(int i=0; i<row; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<col; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }
            int group = 0;
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        ++group;
                        bfs(new MapInfo(i, j, group));
                    }
                }
            }
            sb.append(group + "\n");
        }
        System.out.print(sb);
        br.close();
    }
    public static void bfs(MapInfo start) {
        Queue<MapInfo> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        while(!queue.isEmpty()) {
            MapInfo now = queue.poll();
            for(int i=0; i<8; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(x >= 0 && y >= 0 && x < row && y < col && map[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new MapInfo(x, y, now.group));
                }
            }
        }
    }
}
class MapInfo {
    int x, y, group;
    public MapInfo(int x, int y, int group) {
        this.x = x;
        this.y = y;
        this.group = group;
    }
}