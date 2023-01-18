import bloomFilter.BloomFilter;
import bloomFilter.BloomFilterArray;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class BloomFilterArrayTest {

    @Test
    public void initArrayTest() {
        BloomFilterArray bloom = new BloomFilterArray(1,100,0.1);
        assertEquals(100, bloom.getArray().length);
        for (int i = 0; i < bloom.getArray().length; i++){
            assertTrue(!bloom.getArray()[i]);
        }
    }

    @Test
    public void hashFunctionTest(){
        BloomFilterArray bloom = new BloomFilterArray(1,10,0.1);
        for (int i = 0; i < 200; i++){
            assertTrue(bloom.hashfunction(i, i) < bloom.getArray().length);
        }
    }

    @Test
    public void insertElements() {
        BloomFilterArray bloom = new BloomFilterArray(3,100,0.1);
        bloom.addElement(120);
        int compteur = 0;
        for (int i = 0; i < bloom.getArray().length; i++){
            if (bloom.getArray()[i]){
                compteur++;
            }
        }
        assertEquals(3, compteur);
    }
    @Test
    public void fillArrayTest(){
        int compteur = 0;
        BloomFilterArray b = BloomFilterArray.fillArray(3, 100,0.1, 0, 100);
        for (int i = 0; i < b.getArray().length; i++){
            if (b.getArray()[i]){
                compteur++;
            }
        }
        assertEquals(3, compteur);
    }
    @Test
    public void isPresentTest(){
        BloomFilterArray bloom = new BloomFilterArray(3,100,0.1);
        bloom.addElement(121);
        assertTrue(bloom.isPresent(121));
        assertFalse(bloom.isPresent(120));
    }
}