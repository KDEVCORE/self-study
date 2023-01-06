import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 10000
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0, zero = 0;
        for(int i=0; i<n; i++) {
            int data = Integer.parseInt(br.readLine()); // -10000 <= data <= 10000
            if(data > 1) plusPq.add(data);
            else if(data == 1) one++;
            else if(data == 0) zero++;
            else minusPq.add(data);
        }
        int sum = 0;
        // 양수 처리하기
        while(plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += first * second;
        }
        if(!plusPq.isEmpty()) sum += plusPq.remove();

        // 음수 처리하기
        while(minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += first * second;
        }
        if(!minusPq.isEmpty()) {
            if(zero == 0) sum += minusPq.remove();
        }
        
        // 1 처리하기
        sum += one;

        System.out.println(sum);
    }
}
