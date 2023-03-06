import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int period = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int beers = Integer.parseInt(st.nextToken());
        ArrayList<Beer> beerList = new ArrayList<>();
        for(int i=0; i<beers; i++) {
            st = new StringTokenizer(br.readLine());
            beerList.add(new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(beerList);
        
        PriorityQueue<Integer> beerQueue = new PriorityQueue<>();
        long sum = 0, result = -1;
        for(Beer beer: beerList) {
            beerQueue.offer(beer.preference);
            sum += beer.preference;
            if (beerQueue.size() > period) sum -= beerQueue.poll();
            if (beerQueue.size() == period && sum >= target) {
                result = beer.level;
                break;
            }
        }
        System.out.println(result);
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