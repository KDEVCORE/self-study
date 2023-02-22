import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int use = Integer.parseInt(st.nextToken());
            int total = Integer.parseInt(st.nextToken());
            int holidays = Integer.parseInt(st.nextToken());
            if(use == 0 & total == 0 && holidays == 0) break;
            sb.append("Case " + testCase + ": " + useMaximum(use, total, holidays) + "\n");
            testCase++;
        }
        System.out.print(sb);
    }

    public static int useMaximum(int use, int total, int holidays) {
        int useDays = 0; // 이용 누적 일수
        long stack = 0; // 소비된 일수
        while(holidays > stack) {
            if(holidays - stack < use) {
                useDays += holidays - stack;
                break;
            }
            useDays += use;
            stack += total;
        }
        return useDays;
    }
}
