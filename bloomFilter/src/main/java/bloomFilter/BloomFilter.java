package bloomFilter;

import javax.swing.*;

public abstract class BloomFilter {

    //attributes
    final int k;
    final int m;
    final double n;

    /**
     * Bloom filter constructor
     * @param k the number of hash functions
     * @param m the size of the array
     * @param n the number of elements in percent
     */
    public BloomFilter(int k, int m, double n) {
        this.k = k;
        this.m = m;
        this.n = n;
    }

    /**
     * A generic hash function
     * @param o the object to put into the bloom filter
     * @param i the iteration number
     * @return the index
     */
    public int hashfunction(Object o, int i){
        return ((o.hashCode() + i)<<2) % m;
    }

    /**
     * To add an object in the filter
     * @param o the object to add
     */
    public abstract void addElement(Object o);

    /**
     * Checks if an element in present in the filter
     * @param o the object
     * @return a boolean
     */
    public abstract boolean isPresent(Object o);

    /**
     * get n
     * @return n
     */
    public double getN(){
        return n;
    }


    /**
     * get m
     * @return m
     */
    public int getM(){
        return m;
    }

}
