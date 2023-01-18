package bloomFilter;

import bloomFilter.BloomFilter;

import java.util.LinkedList;

public class BloomFilterLinkedList extends BloomFilter {
    private LinkedList<Boolean> linkedList;
    public BloomFilterLinkedList(int k, int m, double n) {
        super(k, m, n);
        linkedList = new LinkedList<>();
        initLinkedList(m);
    }
    /**
     * Get the Linkedlist
     * @return the attribute linkedList
     */
    public LinkedList<Boolean> getArray(){
        return linkedList;
    }

    /**
     * To initialise the likedList
     * @param size the size of the LinkedList
     */
    private void initLinkedList(int size){
        for (int i = 0; i < size; i ++){
            linkedList.add(false);
        }
    }
    @Override
    public void addElement(Object o) {
        for (int i = 0; i < k; i ++){
            linkedList.set(hashfunction(o, i), true);
        }
    }

    @Override
    public boolean isPresent(Object o) {
        boolean present = true;
        for (int i = 0; i < k; i ++){
            present = present && (linkedList.get(hashfunction(o, i)));
        }
        return present;
    }

    /**
     * Creates a new filled LinkedList
     * @param k the number of hash function
     * @param m the percentage of n
     * @param n the number of elements to insert
     * @param min the min random bound
     * @param max the max random bound
     * @return a new BloomFilterLinkedList objects with n elements inserted
     */
    public static BloomFilterLinkedList fillArray(int k, int m, double n, int min, int max){
        BloomFilterLinkedList bll = new BloomFilterLinkedList(k,m,n);
        for (int i = 0; i < (int)(m*n); i++) {
            bll.addElement((min + (int)(Math.random() * ((max - min) + 1))));
        }
        return bll;
    }
}
