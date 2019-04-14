import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;


public class ListTest  {
    public List<Double> testList = new ArrayList<>();
    public List<Double> innerList = new ArrayList<>();
    public Iterator <Double> iterator;
    public long startTime;
    public long finishTime;



    @Test
    public void testAdd()
    {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            testList.add(new Random().nextDouble());
        }
        finishTime = System.currentTimeMillis();
        System.out.println("adding in list "  + testList.size() + " took: " + (finishTime - startTime) + " ms");
    }

    @Test
    public void testContains()
    {
        testList.add(0.0);
        startTime = System.currentTimeMillis();
        assertEquals(testList.contains(0.0), true);
        finishTime = System.currentTimeMillis();
        System.out.println("Contains took: " + (finishTime - startTime) + " ms");
    }
    @Test
    public void testContainsAll()
    {
       // innerList.addAll(testList);
        for (double i = 0; i <  5; i++)
        {
            innerList.add(i);
            testList.add(i);
        }

   //     startTime = System.currentTimeMillis();
        assertTrue(testList.containsAll(innerList));
   //     finishTime = System.currentTimeMillis();
   //     System.out.println("ContainsAll took: " + (finishTime - startTime) + " ms");
    }

    @Test
    public void testSort()
    {
        testList.clear();
        for (double i = 5; i > 0 ; i--)
        {
            testList.add(i);
        }
       Double sortedArr[] = new Double[]{1.0,2.0,3.0,4.0,5.0};
        testList.sort(Double::compareTo);
       assertArrayEquals(testList.toArray() , sortedArr);
    }

    @Test
    public void testIterator()
    {
        testAdd();
        iterator = testList.iterator();
        startTime = System.currentTimeMillis();
        while (iterator.hasNext()){
            iterator.next();

        }
        finishTime = System.currentTimeMillis();
        System.out.println("run with iterator took: " + (finishTime - startTime) + " ms" +  " size: " + testList.size());
    }

//    @Test
//    public void testRetain(){
//        for (double i = -7; i <  0; i++)
//        {
//            innerList.add(i);
//  //        testList.add(i);
//        }
//        assertEquals(testList.retainAll(innerList) , true);
//    }
}
