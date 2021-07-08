package springBasicAuth.springBasicAuth.models;

import org.springframework.stereotype.Component;

@Component
public class TestClassB {
    private int count = 0;
    public TestClassB() {
        System.out.println("B created");
    }

    public int getCount() {
        return count;
    }

    public void addCount(int i){
        this.count += i;
    }

}
