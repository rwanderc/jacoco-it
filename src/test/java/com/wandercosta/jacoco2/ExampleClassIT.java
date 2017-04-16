package com.wandercosta.jacoco2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author rwander
 */
public class ExampleClassIT {

    @Test
    public void testMultiply() {
        assertEquals(30, new ExampleClass().multiply(5, 6));
    }

}
