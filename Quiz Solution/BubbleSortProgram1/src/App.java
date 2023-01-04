import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 배열의 크기 (1 ≤ n ≤ 500000)
        // int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        mData[] a = new mData[n];
        for(int i=0; i<n; i++) {
            a[i] = new mData(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(a);
        int max = 0;
        for(int i=0; i<n; i++) {
            if(max < a[i].index - i) max = a[i].index - i;
        }
        System.out.println(max + 1);
    }
}

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return this.value - o.value;
    }
}
