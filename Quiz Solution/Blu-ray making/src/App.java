import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 ≤ n ≤ 100000
        int m = Integer.parseInt(st.nextToken()); // 1 ≤ m ≤ n
        st = new StringTokenizer(br.readLine());
        int[] lesson = new int[n];
        int start = 0, end = 0;
        for(int i=0; i<n; i++) {
            lesson[i] = Integer.parseInt(st.nextToken()); // 분 단위, 1~10000
            if(start < lesson[i]) start = lesson[i]; // 레슨 최댓값을 시작 인덱스로 저장
            end += lesson[i]; // 모든 레슨의 총합을 종료 인덱스로 저장
        }
        while(start <= end) {
            int middle = (start + end) / 2; // middle값으로 모든 레슨을 저장할 수 있는지 확인
            int sum = 0, count = 0;
            for(int i=0; i<n; i++) {
                if(sum + lesson[i] > middle) { // sum(레슨길이 합)과 lesson[i](현재 합쳐질 레슨길이)이 중앙값보다 크면
                    count++;
                    sum =0;
                }
                sum += lesson[i];
            }
            if(sum != 0) count++; // sum(레슨길이 합)이 0이 아니면
            if(count > m) start = middle + 1; // count(계산된 블루레이 개수)가 m(정해진 블루레이 개수)보다 크면
            else end = middle - 1; // count(계산된 블루레이 개수)가 m(정해진 블루레이 개수)보다 작으면
        }

        System.out.println(start);
    }
}
