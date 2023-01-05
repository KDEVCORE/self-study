import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class App {
    // 상하좌우를 탐색하기 위한 배열 선언하기
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] maze;
    static boolean[][] visited;
    static int row, col;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()); // 2 ≤ row, col ≤ 100
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        maze = new int[row][col];
        visited = new boolean[row][col];
        for(int i=0; i<row; i++) {
            String temp = br.readLine();
            for(int j=0; j<temp.length(); j++) {
                maze[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
        bfs(0, 0);
        System.out.println(maze[row-1][col-1]);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            for(int k=0; k<4; k++) {
                int x = now[0] + dx[k], y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < row && y < col) { // 좌표 유효성 검사
                    if(maze[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        maze[x][y] = maze[now[0]][now[1]] + 1; // 깊이 증가(depth count)
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
