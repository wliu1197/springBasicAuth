package springBasicAuth.springBasicAuth.model;

public class TestClassC {
    private int count = 100;
    public TestClassC() {
        System.out.println("C created");
    }

    public int getCount() {
        return count;
    }

    public void minCount(int i){
        this.count -= i;
    }

}
