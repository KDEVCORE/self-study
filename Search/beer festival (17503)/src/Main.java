import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int period = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int beers = Integer.parseInt(st.nextToken());
        Beer[] beerType = new Beer[beers];
        int maxLevel = Integer.MIN_VALUE;
        for(int i=0; i<beers; i++) {
            st = new StringTokenizer(br.readLine());
            beerType[i] = new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            maxLevel = Math.max(maxLevel, beerType[i].level);
        }
        Arrays.sort(beerType);

        int min = 1, max = maxLevel, result = Integer.MAX_VALUE;
        while(min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<beers; i++) {
                if(beerType[i].level <= mid) {
                    temp.add(beerType[i].preference);
                } else {
                    break;
                }
            }
            if(temp.size() < period) {
                min = mid + 1;
                continue;
            }
            Collections.sort(temp, Collections.reverseOrder());
            for(int i=0; i<period; i++) sum += temp.get(i);
            if(sum < target) min = mid + 1;
            else {
                result = Math.min(result, mid);
                max = mid - 1;
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? "-1" : result);
    }
}
class Beer implements Comparable<Beer> {
    int preference, level;

    public Beer(int preference, int level) {
        this.preference = preference;
        this.level = level;
    }

    @Override
    public int compareTo(Beer obj) {
        return this.level == obj.level ? obj.preference - this.preference : this.level - obj.level;
    }
}