import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static int[] a;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        radixSort(a, 5);
        StringBuilder sb = new StringBuilder();
        for(int item: a) sb.append(item).append("\n");
        
        System.out.println(sb);
    }

    public static void radixSort(int[] a, int maxSize) {
        int[] output = new int[a.length];
        int digit = 1, count = 0;
        while(count != maxSize) { // 최대 자릿수만큼 반복
            int[] bucket = new int [10]; // 자릿수만큼 담겨질 배열
            for(int i=0; i<a.length; i++) {
                bucket[(a[i] / digit) % 10]++; // 일의 자리부터 시작
            }
            for(int i=1; i<10; i++) {
                bucket[i] += bucket[i-1]; // 합 배열을 이용해 index 계산
            }
            for(int i=a.length-1; i>=0; i--) { // 현재 자릿수를 기준으로 정렬
                output[bucket[(a[i] / digit % 10)] - 1] = a[i];
                bucket[(a[i] / digit) % 10]--;
            }
            for(int i=0; i<a.length; i++) {
                // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장
                a[i] = output[i];
            }
            digit *= 10; // 자릿수 증가시키기
            count++;
        }
    }
}
