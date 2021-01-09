package org.urlShortster.factories;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class UrlFactoryTest {

    @Test
    public void testCreateUrl() {

        UrlFactory fakeFactory = spy(new UrlFactory());

        fakeFactory.createUrl();

        verify(fakeFactory, times(1)).createUrl();
        assertNotNull(fakeFactory.createUrl());
    }
}
