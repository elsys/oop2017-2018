package org.elsys.streams.practice;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.FilterCollection.*;
import static org.junit.Assert.assertEquals;

public class FilterCollectionTest {

    @Test
    public void transformKeepStringsShorterThant4Characters() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        assertEquals(expected, transform(collection));
    }

}
