package org.elsys.streams.practice;

import org.elsys.streams.practice.Person;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.Joining.namesToString;
import static org.junit.Assert.assertEquals;

public class JoiningTest {

    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        assertEquals("Names: Sara, Viktor, Eva.", namesToString(collection));
    }

}
