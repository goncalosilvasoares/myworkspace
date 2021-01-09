package org.urlShortster.services;

import org.junit.Before;
import org.junit.Test;
import org.urlShortster.generator.ShortUrlGenerator;
import org.urlShortster.persistence.jpa.UrlDao;
import org.urlShortster.persistence.model.Url;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UrlServiceTest {

    private static final double DOUBLE_PRECISION = 0.1;

    private UrlDao urlDao;
    private UrlServiceImpl urlService;

    @Before
    public void setup() {

        urlDao = mock(UrlDao.class);

        urlService = new UrlServiceImpl();
        urlService.setUrlDao(urlDao);
        urlService.setUrlGenerator(new ShortUrlGenerator());
    }

    @Test
    public void testGetById() {

        Integer fakeId = 999;

        Url fakeUrl = new Url();
        fakeUrl.setId(fakeId);
        when(urlDao.findById(fakeId)).thenReturn(fakeUrl);

        Url url = urlService.getById(fakeId);

        assertEquals(fakeUrl, url);
    }


    @Test
    public void testGetByLong() {

        String fakeLong = "Fake Long Url";

        Url fakeUrl = new Url();
        fakeUrl.setUrl_long(fakeLong);
        when(urlDao.findByLong(fakeLong)).thenReturn(fakeUrl);

        Url url = urlService.getByLong(fakeLong);

        assertEquals(fakeUrl, url);
    }

    @Test
    public void testGetByShort() {

        String fakeShort = "Fake Short Url";

        Url fakeUrl = new Url();
        fakeUrl.setUrl_short(fakeShort);
        when(urlDao.findByShort(fakeShort)).thenReturn(fakeUrl);

        Url url = urlService.getByShort(fakeShort);

        assertEquals(fakeUrl, url);
    }

    @Test
    public void testSave() {

        Url fakeUrl = mock(Url.class);

        when(urlDao.save(fakeUrl)).thenReturn(fakeUrl);


        Url url = urlService.save(fakeUrl);

        assertNotNull(url);
        verify(urlDao, times(1)).save(fakeUrl);
    }

    @Test
    public void testDelete() {

        Integer fakeId = 999;
        Url fakeUrl = new Url();
        fakeUrl.setId(fakeId);

        when(urlDao.findById(fakeId)).thenReturn(fakeUrl);

        urlService.delete(fakeId);

        verify(urlDao, times(1)).delete(fakeId);
    }

    @Test
    public void testList() {

        List<Url> fakeList = mock(ArrayList.class);

        when(urlDao.findAll()).thenReturn(fakeList);

        List<Url> list = urlService.list();

        assertNotNull(list);
        verify(urlDao, times(1)).findAll();
    }

    @Test
    public void testExistsLong() {

        String falseLong = "False Url Long";

        Integer fakeId = 999;
        String fakeLong = "Url Long";
        Url fakeUrl = new Url();
        fakeUrl.setId(fakeId);
        fakeUrl.setUrl_long(fakeLong);

        when(urlDao.findByLong(fakeLong)).thenReturn(fakeUrl);

        assertTrue(urlService.existsLong(fakeLong));
        assertFalse(urlService.existsLong(falseLong));

        verify(urlDao, times(1)).findByLong(fakeLong);
    }

    @Test
    public void testExistsShort() {

        String falseShort = "False Url Short";

        Integer fakeId = 999;
        String fakeShort = "Url Short";
        Url fakeUrl = new Url();
        fakeUrl.setId(fakeId);
        fakeUrl.setUrl_short(fakeShort);

        when(urlDao.findByShort(fakeShort)).thenReturn(fakeUrl);

        assertTrue(urlService.existsShort(fakeShort));
        assertFalse(urlService.existsShort(falseShort));

        verify(urlDao, times(1)).findByShort(fakeShort);
    }

    @Test
    public void testIncrementAccess() {

        Integer fakeId = 999;
        Integer fakeAccess = 58;
        Url fakeUrl = new Url();
        fakeUrl.setId(fakeId);
        fakeUrl.setAccessTimes(fakeAccess);

        urlService.incrementAccessTime(fakeUrl);

        assertEquals(fakeUrl.getAccessTimes(), (fakeAccess + 1), 0.01);
        assertNotEquals(fakeUrl.getAccessTimes(), fakeAccess, 0.01);

        verify(urlDao,times(1)).save(fakeUrl);
    }
}
