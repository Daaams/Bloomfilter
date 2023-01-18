import java.util.ArrayList;
import java.util.Arrays;

public class BloomFilterArrayList extends BloomFilter{
    ArrayList<Boolean> arrayList;
    public BloomFilterArrayList(int k, float m, int n) {
        super(k, m, n);
        arrayList = new ArrayList<>();
        initArrayList();
    }

    private void initArrayList(){
        for (int i = 0; i < optimalM(m); i ++){
            arrayList.add(false);
        }
    }
    @Override
    public void addElement(Object o) {
        for (int i = 0; i < k; i ++){
            arrayList.set(hashfunction(o, i), true);
        }
    }

    @Override
    public boolean isPresent(Object o) {
        boolean present = true;
        for (int i = 0; i < k; i ++){
            present = present && (arrayList.get(hashfunction(o, i)));
        }
        return present;
    }
}
