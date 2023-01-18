import bloomFilter.BloomFilterArrayList;
import bloomFilter.BloomFilterLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class BloomFilterLinkedListTest {

    @Test
    public void initArrayTest() {
        BloomFilterLinkedList bloom = new BloomFilterLinkedList(1,100,0.1);
        assertEquals(100, bloom.getArray().size());
        for (int i = 0; i < bloom.getArray().size(); i++){
            assertTrue(!bloom.getArray().get(i));
        }
    }

    @Test
    public void hashFunctionTest(){
        BloomFilterLinkedList bloom = new BloomFilterLinkedList(1,100,0.1);
        for (int i = 0; i < 200; i++){
            assertTrue(bloom.hashfunction(i, i) < bloom.getArray().size());
        }
    }

    @Test
    public void insertElements() {
        BloomFilterLinkedList bloom = new BloomFilterLinkedList(3,100,0.1);
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
    public void fillLinkedListTest(){
        int compteur = 0;
        BloomFilterLinkedList b = BloomFilterLinkedList.fillArray(3, 100,0.1, 0, 100);
        for (int i = 0; i < b.getArray().size(); i++){
            if (b.getArray().get(i)){
                compteur++;
            }
        }
        assertEquals(3, compteur);
    }

    @Test
    public void isPresentTest(){
        BloomFilterLinkedList bloom = new BloomFilterLinkedList(3,100,0.1);
        bloom.addElement(121);
        assertTrue(bloom.isPresent(121));
        assertFalse(bloom.isPresent(120));
    }

}