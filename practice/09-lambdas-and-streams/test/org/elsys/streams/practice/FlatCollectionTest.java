package org.elsys.streams.practice;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.FlatCollection.*;
import static org.junit.Assert.assertEquals;

public class FlatCollectionTest {

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertEquals(expected, transform(collection));
    }

}
