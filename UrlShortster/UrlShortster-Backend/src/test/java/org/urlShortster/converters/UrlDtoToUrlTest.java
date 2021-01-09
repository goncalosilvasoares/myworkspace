package org.urlShortster.converters;

import org.junit.Before;
import org.junit.Test;
import org.urlShortster.command.UrlDto;
import org.urlShortster.persistence.model.Url;
import org.urlShortster.services.UrlService;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class UrlDtoToUrlTest {

    private UrlDtoToUrl urlDtoToUrl;
    private UrlService urlService;

    @Before
    public void setup() {
        urlService = mock(UrlService.class);

        urlDtoToUrl = new UrlDtoToUrl();
        urlDtoToUrl.setUrlService(urlService);
    }

    @Test
    public void testConvert() {

        Integer fakeId = 999;
        String urlLong = "fakeLongUrl";
        String urlShort = "fakeShortUrl";
        Integer accessTimes = 2;

        Url fakeUrl = spy(Url.class);
        fakeUrl.setId(fakeId);

        UrlDto fakeUrlDto = new UrlDto();
        fakeUrlDto.setId(fakeId);
        fakeUrlDto.setUrl_long(urlLong);
        fakeUrlDto.setUrl_short(urlShort);
        fakeUrlDto.setAccessTimes(accessTimes);

        when(urlService.getById(fakeId)).thenReturn(fakeUrl);

        Url url = urlDtoToUrl.convert(fakeUrlDto);

        verify(urlService, times(1)).getById(fakeId);
        verify(fakeUrl, times(1)).setUrl_long(urlLong);
        verify(fakeUrl, times(1)).setUrl_short(urlShort);
        verify(fakeUrl, times(1)).setAccessTimes(accessTimes);

        assertEquals(url.getId(), fakeId);
        assertEquals(url.getUrl_long(), urlLong);
        assertEquals(url.getUrl_short(), urlShort);
        assertEquals(url.getAccessTimes(), accessTimes);
    }

}
