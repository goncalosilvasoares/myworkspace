package org.urlShortster.converters;

import org.junit.Before;
import org.junit.Test;
import org.urlShortster.command.UrlDto;
import org.urlShortster.persistence.model.Url;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class UrlToUrlDtoTest {

    private UrlToUrlDto urlToUrlDto;

    @Before
    public void setup() {

        urlToUrlDto = new UrlToUrlDto();
    }

    @Test
    public void testConvert() {

        Integer fakeId = 999;
        String urlLong = "fakeLongUrl";
        String urlShort = "fakeShortUrl";
        Integer accessTimes = 2;

        Url fakeUrl = spy(Url.class);
        fakeUrl.setId(fakeId);
        fakeUrl.setUrl_long(urlLong);
        fakeUrl.setUrl_short(urlShort);
        fakeUrl.setAccessTimes(accessTimes);

        UrlDto urlDto = urlToUrlDto.convert(fakeUrl);

        verify(fakeUrl, times(1)).getId();
        verify(fakeUrl, times(1)).getUrl_long();
        verify(fakeUrl, times(1)).getUrl_short();
        verify(fakeUrl, times(1)).getAccessTimes();

        assertEquals(urlDto.getId(), fakeId);
        assertEquals(urlDto.getUrl_long(), urlLong);
        assertEquals(urlDto.getUrl_short(), urlShort);
        assertEquals(urlDto.getAccessTimes(), accessTimes);
    }
}
