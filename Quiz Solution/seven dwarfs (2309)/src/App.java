import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    static int[] dwarfs, temp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarfs = new int[10];
        for(int i=1; i<=9; i++) dwarfs[i] = Integer.parseInt(br.readLine());
        mergeSort(1, 9);
        int sum = 0;
        int count = 0;
        while(count != 7) {
            if(sum == 100) break;
            for(int i=9; i>=1; i--) {
                if(sum + dwarfs[i] <= 100) {
                    sum += dwarfs[i];
                    count++;
                }
            }
        }
    }
    private static void mergeSort(int start, int end) {
        if(end - start < 1) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);
        temp = dwarfs.clone();
        int k = start;
        int index1 = start;
        int index2 = mid + 1;
        while(index1 <= mid && index2 <= end) {
            if(temp[index1] > temp[index2]) {
                dwarfs[k] = temp[index2];
                k++;
                index2++;
            } else {
                dwarfs[k] = temp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= mid) {
            dwarfs[k] = temp[index1];
            k++;
            index1++;
        }
        while(index2 <= end) {
            dwarfs[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
