import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] numerals, temp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        numerals = new int[number];
        temp = new int[number];
        for(int i=0; i<number; i++) numerals[i] = Integer.parseInt(br.readLine());
        Arrays.sort(numerals);
        // mergeSort(0, number-1);
        StringBuilder sb = new StringBuilder();
        for(int item: numerals) sb.append(item + "\n");
        System.out.print(sb);
    }
    public static void mergeSort(int start, int end) {
        if(end - start < 1) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);
        temp = numerals.clone();
        int k = start;
        int index1 = start;
        int index2 = mid + 1;
        while(index1 <= mid && index2 <= end) {
            if(temp[index1] > temp[index2]) {
                numerals[k] = temp[index2];
                k++;
                index2++;
            } else {
                numerals[k] = temp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= mid) {
            numerals[k] = temp[index1];
            k++;
            index1++;
        }
        while(index2 <= end) {
            numerals[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
