package ErrorRate;

import bloomFilter.BloomFilter;
import bloomFilter.BloomFilterArray;

import java.util.ArrayList;

public class Error {
    public Error() {
    }
    public double errorRate(BloomFilter b){
        int errorCount = 0;
        int bound = (int)(b.getM()*b.getN());

        ArrayList<Integer> arrayListadd = new ArrayList<Integer>();
        ArrayList<Integer> arrayPresent = new ArrayList<Integer>();

        for (int i = 0; i < bound; i++) {
            int rand = (1 + (int)(Math.random() * ((bound*3- 1) + 1)));
            while (arrayListadd.contains(rand)) {
                rand = (1 + (int)(Math.random() * ((bound*3 - 1) + 1)));
            }
            arrayListadd.add(rand);
            b.addElement(rand);
        }
        for (int i = 0; i < bound; i++) {
            int rand2 = (bound*3 + (int)(Math.random() * ((bound*6 - bound*3) + bound*3)));
            while (arrayPresent.contains(rand2)){
                rand2 = (bound*3 + (int)(Math.random() * ((bound*6 - bound*3) + bound*3)));
            }
            arrayPresent.add(rand2);
            if (b.isPresent(rand2)) {
                errorCount ++;
            }
        }

        return (double)errorCount/b.getM();
    }
}
