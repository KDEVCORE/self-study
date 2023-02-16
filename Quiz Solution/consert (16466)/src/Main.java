import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tickets, temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int soldout = Integer.parseInt(br.readLine());
        tickets = new int[soldout];
        temp = new int[soldout];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < soldout; i++)
            tickets[i] = Integer.parseInt(st.nextToken());
        mergeSort(0, soldout - 1);
        int result = 1;
        for (int i = 0; i < soldout; i++) {
            if (result != tickets[i])
                break;
            result++;
        }
        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        for (int i = start; i <= end; i++)
            temp[i] = tickets[i];
        int k = start;
        int index1 = start;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= end) {
            if (temp[index1] > temp[index2])
                tickets[k++] = temp[index2++];
            else
                tickets[k++] = temp[index1++];
        }
        while (index1 <= mid)
            tickets[k++] = temp[index1++];
        while (index2 <= end)
            tickets[k++] = temp[index2++];
    }
}
