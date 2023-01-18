package ErrorRate;

import bloomFilter.BloomFilter;
import bloomFilter.BloomFilterArray;

public class RunError {
    public static void main(String[] args) {
        Error error = new Error();
        BloomFilterArray array = new BloomFilterArray(5, 1000, 0.1);
        for (int i = 0; i < 20 ; i++) {
            System.out.println(error.errorRate(array));
        }
    }
}
