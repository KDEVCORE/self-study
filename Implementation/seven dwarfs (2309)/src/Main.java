import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dwarfs, temp;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarfs = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }
        mergeSort(0, dwarfs.length-1);
        int exclude = sum - 100;
        for(int i = 8; i >= 1; i--)  {
            for(int j = i - 1; j >= 0; j--) {
                if(dwarfs[i] + dwarfs[j] == exclude) {
                    for(int k = 0; k < 9; k++) {
                        if(k != i && k != j) System.out.println(dwarfs[k]);
                    }
                    return;
                }
            }
        }
    }
    private static void mergeSort(int start, int end) {
        if(start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);
        temp = dwarfs.clone();
        int k = start, index1 = start, index2 = mid + 1;
        while(index1 <= mid && index2 <= end) {
            if(temp[index1] > temp[index2]) dwarfs[k++] = temp[index2++];
            else dwarfs[k++] = temp[index1++];
        }
        while(index1 <= mid) dwarfs[k++] = temp[index1++];
        while(index2 <= end) dwarfs[k++] = temp[index2++];
    }
}