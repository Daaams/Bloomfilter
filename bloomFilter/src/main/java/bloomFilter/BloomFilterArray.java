package bloomFilter;

import bloomFilter.BloomFilter;

import java.util.Arrays;

public class BloomFilterArray extends BloomFilter {

    private boolean [] array;
    public BloomFilterArray(int k, int m, double n) {
        super(k, m, n);
        initArray(m);
    }

    /**
     * Get the array
     * @return the array
     */
    public boolean[] getArray(){
        return array;
    }

    /**
     * To initialise the array
     * @param size the size of the array
     */
    private void initArray(int size){
        array = new boolean[size];
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

    /**
     * Creates a new filled array
     * @param k the number of hash function
     * @param m the percentage of n
     * @param n the number of elements to insert
     * @param min the min random bound
     * @param max the max random bound
     * @return a new BloomFilterArray objects with n elements inserted
     */
    public static BloomFilterArray fillArray(int k, int m, double n, int min, int max){
        BloomFilterArray ba = new BloomFilterArray(k,m,n);
        for (int i = 0; i < (int)(m*n); i++) {
            ba.addElement((min + (int)(Math.random() * ((max - min) + 1))));
        }
        return ba;
    }


}
