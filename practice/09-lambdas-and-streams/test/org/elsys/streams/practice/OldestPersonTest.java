package org.elsys.streams.practice;

import static java.util.Arrays.asList;
import static org.elsys.streams.practice.OldestPerson.getOldestPerson;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.elsys.streams.practice.Person;
import org.junit.Test;

public class OldestPersonTest {

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        assertEquals(eva, getOldestPerson(collection));
    }

}
