import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class App {
    // 6가지 이동 케이스르 표현하기 위한 배열
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited; // A, B의 무게만 있으면, C의 무게가 고정되므로 2개만 체크
    static boolean[] answer;
    static int[] now;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        now = new int[3]; // A, B, C 물의 양을 저장하는 배열
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1 <= A, B, C <= 200
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[200][200];
        answer = new boolean[200];
        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<answer.length; i++) if(answer[i]) sb.append(i + " ");
        System.out.println(sb);
    }
    public static void bfs() {
        Queue<AmountAB> queue = new LinkedList<>();
        queue.add(new AmountAB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while(!queue.isEmpty()) {
            AmountAB p = queue.poll();
            int a = p.a;
            int b = p.b;
            int c = now[2] - a - b; // C는 전체 물의 양에서 A와 B를 뺀 것
            for(int k=0; k<sender.length; k++) { // A → B, A → C, B → A, B → C, C → A, C → B
                int[] next = {a, b, c};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;
                if(next[receiver[k]] > now[receiver[k]]) { // 물이 넘칠 때
                    //초과하는 만큼 다시 이전 물통에 넣기
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]];
                    next[receiver[k]] = now[receiver[k]]; // 대상 물통은 최대로 채우기
                }
                if(!visited[next[0]][next[1]]) { // A와 B 물의 양을 이용해 방문 배열 체크
                    visited[next[0]][next[1]] = true;
                    queue.add(new AmountAB(next[0], next[1]));
                    if(next[0] == 0) answer[next[2]] = true; // A 물의 양이 0일 때, C 물의 무게를 정답 변수에 저장
                }
            }
        }
    }
}
