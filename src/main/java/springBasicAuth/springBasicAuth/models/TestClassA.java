package springBasicAuth.springBasicAuth.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestClassA {

    @Autowired
    TestClassB testClassB;

    public TestClassA() {
        System.out.println("TestClassA created");
    }

    public int getCountB(){
       return testClassB.getCount();
    }

    public void addCountOnB(){
        testClassB.addCount(1);
    }

    //run when application start
    //any method annotated with @Autowired is a config method
    //The arguments of the method are injected into the method on calling.
    @Autowired
    public void addCountOnBSetter(TestClassB testClassBSetter) {
        System.out.println("method level Autowired in Class A");
        testClassBSetter.addCount(1);
    }

    @Bean
    public TestClassC tryThis(){
        System.out.println("bean method");
        TestClassC c = new TestClassC();
        return c;
    }
}
