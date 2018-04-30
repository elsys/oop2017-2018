package org.elsys.streams.practice;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.ToUpperCase.transform;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ToUpperCaseTest {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
        assertEquals(expected, transform(collection));
    }

}
