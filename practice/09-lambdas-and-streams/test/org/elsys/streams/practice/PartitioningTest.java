package org.elsys.streams.practice;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.Partitioning.partitionAdults;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class PartitioningTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Map<Boolean, List<Person>> result = partitionAdults(collection);
        assertTrue(result.get(true).containsAll(asList(viktor, eva)));
        assertFalse(result.get(true).containsAll(asList(sara)));
        assertTrue(result.get(false).containsAll(asList(sara)));
        assertFalse(result.get(false).containsAll(asList(viktor, eva)));
    }

}
