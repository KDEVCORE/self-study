import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int items = Integer.parseInt(st.nextToken());
        int[] weightLimit = new int[Integer.parseInt(st.nextToken()) + 1];
        ArrayList<Item> itemList = new ArrayList<>();
        for(int i=0; i<items; i++) {
            st = new StringTokenizer(br.readLine());
            itemList.add(new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(Item item: itemList) {
            for(int kg=weightLimit.length-1; kg>=item.weight; kg--) {
                weightLimit[kg] = Math.max(weightLimit[kg], weightLimit[kg - item.weight] + item.value);
            }
        }
        System.out.println(weightLimit[weightLimit.length-1]);
    }
}
class Item {
    int weight, value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}