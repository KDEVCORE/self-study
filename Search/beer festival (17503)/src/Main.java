import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int period = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int beers = Integer.parseInt(st.nextToken());
        Beer[] beerType = new Beer[beers];
        ArrayList<Index> indexList = new ArrayList<>();
        int maxLevel = Integer.MIN_VALUE;
        for(int i=0; i<beers; i++) {
            st = new StringTokenizer(br.readLine());
            beerType[i] = new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            maxLevel = Math.max(maxLevel, beerType[i].level);
        }

        int min = 1, max = maxLevel, result = Integer.MAX_VALUE;
        while(min <= max) {
            int mid = (min + max) / 2;
            int day = 0, k = 1;
            long sum = 0;
            for(int i=0; i<beers; i+=k) {
                if(beerType[i].level <= mid) {
                    sum += beerType[i].preference;
                    day++;
                    if(day == period) break;
                }
            }
            if(sum < target) {
                min = mid + 1;
            } else {
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
        if(this.preference == obj.preference) return this.level - obj.level;
        return this.preference - obj.preference;
    }
}