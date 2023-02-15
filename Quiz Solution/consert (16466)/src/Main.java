import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tickets, temp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int soldout = Integer.parseInt(br.readLine());
        tickets = new int[soldout + 1];
        temp = new int[soldout + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=soldout; i++) tickets[i] = Integer.parseInt(st.nextToken());
        mergeSort(1, soldout);
        for(int i=0; i<soldout; i++) {
            if((i+1) != tickets[i]) {
                System.out.println(i+1);
                return;
            }
        }
    }
    private static void mergeSort(int start, int end) {
        if(end - start < 1) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);
        // temp = tickets.clone();
        for(int i=start; i<=end; i++) temp[i] = tickets[i];
        int k = start;
        int index1 = start;
        int index2 = mid + 1;
        while(index1 <= mid && index2 <= end) {
            if(temp[index1] > temp[index2]) {
                tickets[k] = temp[index2];
                k++;
                index2++;
            } else {
                tickets[k] = temp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= mid) {
            tickets[k] = temp[index1];
            k++;
            index1++;
        }
        while(index2 <= end) {
            tickets[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
