import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pay = Integer.parseInt(br.readLine());
        int[] changes = {500, 100, 50, 10, 5, 1};
        int change = 1000 - pay;
        int index = 0, count = 0;
        while(change >= 1) {
            if(change >= changes[index]) {
                change -= changes[index];
                count++;
            } else {
                index++;
            }
        }
        System.out.println(count);
    }
}
