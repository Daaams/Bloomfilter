import java.util.LinkedList;

public class BloomFilterLinkedList extends BloomFilter{
    LinkedList<Boolean> linkedList;
    public BloomFilterLinkedList(int k, float m, int n) {
        super(k, m, n);
        linkedList = new LinkedList<>();
        initLinkedList();
    }

    private void initLinkedList(){
        for (int i = 0; i < optimalM(m); i ++){
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
}
