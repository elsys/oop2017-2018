package org.elsys.streams.practice;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.Sum.calculate;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/*
Sum all elements of a collection
 */
public class SumTest {

    @Test
    public void calculateShouldReturnSumOfAllIntegersInCollection() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        assertEquals(1 + 2 + 3 + 4 + 5, calculate(numbers));
    }

}
