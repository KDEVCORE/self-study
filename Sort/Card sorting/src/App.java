import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 100000
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            int data = Integer.parseInt(br.readLine()); // 1 <= data <= 1000
            pq.add(data);
        }
        int data1 = 0, data2 = 0, sum=0;
        while(pq.size() != 1) {
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);
    }
}
