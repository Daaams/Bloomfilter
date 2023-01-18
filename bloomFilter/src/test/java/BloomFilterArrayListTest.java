import bloomFilter.BloomFilterArray;
import bloomFilter.BloomFilterArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

public class BloomFilterArrayListTest {

    @Test
    public void initArrayTest() {
        BloomFilterArrayList bloom = new BloomFilterArrayList(1,100,0.1);
        assertEquals(100, bloom.getArray().size());
        for (int i = 0; i < bloom.getArray().size(); i++){
            assertTrue(!bloom.getArray().get(i));
        }
    }

    @Test
    public void hashFunctionTest(){
        BloomFilterArrayList bloom = new BloomFilterArrayList(1,100,0.1);
        for (int i = 0; i < 200; i++){
            assertTrue(bloom.hashfunction(i, i) < bloom.getArray().size());
        }
    }

    @Test
    public void insertElements() {
        BloomFilterArrayList bloom = new BloomFilterArrayList(3,100,0.1);
        bloom.addElement(120);
        int compteur = 0;
        for (int i = 0; i < bloom.getArray().size(); i++){
            if (bloom.getArray().get(i)){
                compteur++;
            }
        }
        assertEquals(3, compteur);
    }

    @Test
    public void fillArrayListTest(){
        int compteur = 0;
        BloomFilterArrayList b = BloomFilterArrayList.fillArray(3, 100,0.1, 0, 100);
        for (int i = 0; i < b.getArray().size(); i++){
            if (b.getArray().get(i)){
                compteur++;
            }
        }
        assertEquals(3, compteur);
    }

    @Test
    public void isPresentTest(){
        BloomFilterArrayList bloom = new BloomFilterArrayList(3,100,0.1);
        bloom.addElement(121);
        assertTrue(bloom.isPresent(121));
        assertFalse(bloom.isPresent(120));
        assertFalse(bloom.isPresent(242));
    }
}