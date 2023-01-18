public abstract class BloomFilter {

    boolean present = false;
    final int k;
    final float m;
    final int n;

    public BloomFilter(int k, float m, int n) {
        this.k = k;
        this.m = m;
        this.n = n;
    }

    public int hashfunction(Object o, int i){
        return (o.hashCode() + i) % optimalM(m);
    }

    public void addElement(Object o){}
    public boolean isPresent(Object o){return present;}

    public int optimalM(float m){
        return (int) ((-n*Math.log(m)) / Math.pow(Math.log(2), 2));
    }

}
