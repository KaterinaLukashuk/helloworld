import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

public class HashMapTest  {
    Map<Double,Double> hashMap = new HashMap<>();
    public long startTime;
    public long finishTime;

    @Test
    public void testPut()
    {
        startTime = System.currentTimeMillis();
        for (double i = 0; i < 100000; i++) {
            hashMap.put(i,i);
        }
        finishTime = System.currentTimeMillis();
        System.out.println("add 10000 elements took: " + (finishTime - startTime) + " ms");
    }



    @Test
    public void test()
    {
        startTime = System.currentTimeMillis();
     //   hashMap.
        finishTime = System.currentTimeMillis();
        System.out.println("add 10000 elements took: " + (finishTime - startTime) + " ms");
    }

}
