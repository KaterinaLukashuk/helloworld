import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HashSetTest {
    Set<Double> hashSet = new HashSet<>();
    Set<Double> innerSet = new HashSet<>();
    public long startTime;
    public long finishTime;
    public Iterator <Double> iterator;

    @Test
    public void testAdd()
    {
        startTime = System.currentTimeMillis();
        for (double i = 0; i < 100000; i++) {
            hashSet.add(i);
        }
        finishTime = System.currentTimeMillis();
        System.out.println("add 10000 elements took: " + (finishTime - startTime) + " ms");
    }

    @Test
    public void testIterator()
    {
        testAdd();
        iterator = hashSet.iterator();
        startTime = System.currentTimeMillis();
        while (iterator.hasNext())
        {
            iterator.next();
        }
        finishTime = System.currentTimeMillis();
        System.out.println("run hashSet with iterator took: " + (finishTime - startTime) + " ms" +  " size: " + hashSet.size());
    }


    @Test
    public void testContains()
    {
        testAdd();
        hashSet.add(0.0);
        startTime = System.currentTimeMillis();
        assertEquals(hashSet.contains(0.0), true);
        finishTime = System.currentTimeMillis();
        System.out.println("Contains took: " + (finishTime - startTime) + " ms");
    }

    @Test
    public void testContainsAll()
    {
        // innerList.addAll(testList);
        for (double i = 0; i <  5; i++)
        {
            innerSet.add(i);
            hashSet.add(i);
        }

        //     startTime = System.currentTimeMillis();
        assertTrue(hashSet.containsAll(innerSet));
        //     finishTime = System.currentTimeMillis();
        //     System.out.println("ContainsAll took: " + (finishTime - startTime) + " ms");
    }
    @Test
    public void testStream()
    {
      //  Predicate <Double> predicate =
        testAdd();
        Stream<Double> stream = hashSet.stream();
        System.out.println(stream = stream.filter((Double o)-> { return o > 100; }));
        System.out.println(stream = stream.sorted());

        Function<Object, Object> function = (y)->{
            return null;
        };

        Set set = stream.map(function).collect(Collectors.toSet());


       // System.out.println(stream.map(function).count());
    }
}
