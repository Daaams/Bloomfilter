package bloomFilter;

import bloomFilter.BloomFilter;

import java.util.ArrayList;

public class BloomFilterArrayList extends BloomFilter {
    private ArrayList<Boolean> arrayList;
    public BloomFilterArrayList(int k, int m, double n) {
        super(k, m, n);
        arrayList = new ArrayList<>();
        initArrayList(m);
    }

    /**
     * Get the arraylist
     * @return the attribute arrayList
     */
    public ArrayList<Boolean> getArray(){
        return arrayList;
    }

    /**
     * To initialise the arraylist
     * @param size the size of the arrayList
     */
    private void initArrayList(int size){
        for (int i = 0; i < size; i ++){
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

    /**
     * Creates a new filled ArrayList
     * @param k the number of hash function
     * @param m the percentage of n
     * @param n the number of elements to insert
     * @param min the min random bound
     * @param max the max random bound
     * @return a new BloomFilterArrayList objects with n elements inserted
     */
    public static BloomFilterArrayList fillArray(int k, int m, double n, int min, int max){
        BloomFilterArrayList bal = new BloomFilterArrayList(k,m,n);
        for (int i = 0; i < (int)(m*n); i++) {
            bal.addElement((min + (int)(Math.random() * ((max - min) + 1))));
        }
        return bal;
    }
}
