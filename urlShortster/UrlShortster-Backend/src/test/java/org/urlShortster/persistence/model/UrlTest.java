package org.urlShortster.persistence.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlTest {

    private Url urlTest;

    @Before
    public void setup() {
        urlTest = new Url();
    }

    @Test
    public void testInitialAccessTimes() {

        assertEquals(0, urlTest.getAccessTimes(), 0.1);
    }

    @Test
    public void testValidShortUrl() {

    }
}
