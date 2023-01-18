import java.util.Arrays;

public class BloomFilterArray extends BloomFilter{

    boolean [] array;
    public BloomFilterArray(int k, float m, int n) {
        super(k, m, n);
        array = new boolean[optimalM(m)];
        initArray();
    }

    private void initArray(){
        Arrays.fill(array, false);
    }
    @Override
    public void addElement(Object o) {
        for (int i = 0; i < k; i ++){
            array[hashfunction(o, i)] = true;
        }
    }

    @Override
    public boolean isPresent(Object o) {
        boolean present = true;
        for (int i = 0; i < k; i ++){
            present = present && (array[hashfunction(o, i)]);
        }
        return present;
    }
}
