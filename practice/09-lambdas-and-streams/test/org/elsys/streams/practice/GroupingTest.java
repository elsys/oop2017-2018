package org.elsys.streams.practice;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.Grouping.*;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GroupingTest {

    @Test
    public void partitionShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> collection = asList(sara, eva, viktor);
        Map<String, List<Person>> result = groupByNationality(collection);
        assertEquals(asList(sara, eva), result.get("Norwegian"));
        assertEquals(asList(viktor), result.get("Serbian"));
    }

    @Test
    public void partitionNamesShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> collection = asList(sara, eva, viktor);
        Map<String, List<String>> result = groupNamesByNationality(collection);
        assertEquals(asList("Sara", "Eva"), result.get("Norwegian"));
        assertEquals(asList("Viktor"), result.get("Serbian"));
    }

}
