package com.wandercosta.jacoco2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author rwander
 */
public class ExampleClassTest {

    @Test
    public void testAdd() {
        assertEquals(11, new ExampleClass().add(5, 6));
    }

}
