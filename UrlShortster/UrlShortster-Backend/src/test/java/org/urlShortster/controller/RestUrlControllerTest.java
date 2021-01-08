package org.urlShortster.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.urlShortster.command.UrlDto;
import org.urlShortster.controllers.RestUrlController;
import org.urlShortster.converters.UrlDtoToUrl;
import org.urlShortster.converters.UrlToUrlDto;
import org.urlShortster.persistence.model.Url;
import org.urlShortster.services.UrlService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RestUrlControllerTest {


    @Mock
    private UrlService urlService;

    @Mock
    private UrlToUrlDto urlToUrlDto;

    @Mock
    private UrlDtoToUrl urlDtoToUrl;

    @InjectMocks
    private RestUrlController restUrlController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restUrlController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetById() throws Exception {

        Integer fakeID = 999;
        String urlLong = "fakeLongUrl";
        String urlShort = "fakeShortUrl";
        Integer accessTimes = 2;

        Url url = new Url();
        url.setId(fakeID);
        url.setUrl_long(urlLong);
        url.setUrl_short(urlShort);
        url.setAccessTimes(accessTimes);

        UrlDto urlDto = new UrlDto();
        urlDto.setId(fakeID);
        urlDto.setUrl_long(urlLong);
        urlDto.setUrl_short(urlShort);
        urlDto.setAccessTimes(accessTimes);


        when(urlService.getById(fakeID)).thenReturn(url);
        when(urlToUrlDto.convert(url)).thenReturn(urlDto);

        mockMvc.perform(get("/api/getById/{id}", url.getId()))
                .andExpect(jsonPath("$.id").value(fakeID))
                .andExpect(jsonPath("$.url_long").value(urlLong))
                .andExpect(jsonPath("$.url_short").value(urlShort))
                .andExpect(jsonPath("$.accessTimes").value(accessTimes))
                .andExpect(status().isOk());

        verify(urlService, times(1)).getById(fakeID);
        verify(urlToUrlDto, times(1)).convert(url);
    }


    @Test
    public void testInvalidGetById() throws Exception {

        int invalidId = 888;
        int fakeID = 999;
        Url url = new Url();
        url.setId(fakeID);

        when(urlService.getById(invalidId)).thenReturn(null);

        mockMvc.perform(get("/api/getById/{id}", invalidId))
                .andExpect(status().isNotFound());

        verify(urlService, times(1)).getById(invalidId);
    }

    @Test
    public void testGetByLong() throws Exception {

        Integer fakeID = 999;
        String urlLong = "fakeLongUrl";
        String urlShort = "fakeShortUrl";
        Integer accessTimes = 2;

        Url url = new Url();
        url.setId(fakeID);
        url.setUrl_long(urlLong);
        url.setUrl_short(urlShort);
        url.setAccessTimes(accessTimes);

        UrlDto urlDto = new UrlDto();
        urlDto.setId(fakeID);
        urlDto.setUrl_long(urlLong);
        urlDto.setUrl_short(urlShort);
        urlDto.setAccessTimes(accessTimes);

        when(urlService.getByLong(urlLong)).thenReturn(url);
        when(urlToUrlDto.convert(url)).thenReturn(urlDto);

        mockMvc.perform(get("/api/getByLong/{urlLong}", url.getUrl_long()))
                .andExpect(jsonPath("$.id").value(fakeID))
                .andExpect(jsonPath("$.url_long").value(urlLong))
                .andExpect(jsonPath("$.url_short").value(urlShort))
                .andExpect(jsonPath("$.accessTimes").value(accessTimes))
                .andExpect(status().isOk());

        verify(urlService, times(1)).getByLong(urlLong);
        verify(urlToUrlDto, times(1)).convert(url);
    }

    @Test
    public void testInvalidGetByLong() throws Exception {

        String invalidUrlLong = "Invalid";
        String fakeUrlLong = "fakeUrl";
        Url url = new Url();
        url.setUrl_long(fakeUrlLong);

        when(urlService.getByLong(invalidUrlLong)).thenReturn(null);

        mockMvc.perform(get("/api/getByLong/{urlLong}", invalidUrlLong))
                .andExpect(status().isNotFound());

        verify(urlService, times(1)).getByLong(invalidUrlLong);
    }

    @Test
    public void testGetByShort() throws Exception {

        Integer fakeID = 999;
        String urlLong = "fakeLongUrl";
        String urlShort = "fakeShortUrl";
        Integer accessTimes = 2;

        Url url = new Url();
        url.setId(fakeID);
        url.setUrl_long(urlLong);
        url.setUrl_short(urlShort);
        url.setAccessTimes(accessTimes);

        UrlDto urlDto = new UrlDto();
        urlDto.setId(fakeID);
        urlDto.setUrl_long(urlLong);
        urlDto.setUrl_short(urlShort);
        urlDto.setAccessTimes(accessTimes);

        when(urlService.getByShort(urlShort)).thenReturn(url);
        when(urlToUrlDto.convert(url)).thenReturn(urlDto);

        mockMvc.perform(get("/api/getByShort/{urlShort}", url.getUrl_short()))
                .andExpect(jsonPath("$.id").value(fakeID))
                .andExpect(jsonPath("$.url_long").value(urlLong))
                .andExpect(jsonPath("$.url_short").value(urlShort))
                .andExpect(jsonPath("$.accessTimes").value(accessTimes))
                .andExpect(status().isOk());

        verify(urlService, times(1)).getByShort(urlShort);
        verify(urlToUrlDto, times(1)).convert(url);
    }

    @Test
    public void testInvalidGetByShort() throws Exception {

        String invalidUrlShort = "Invalid";
        String fakeUrlShort = "fakeUrl";
        Url url = new Url();
        url.setUrl_short(fakeUrlShort);

        when(urlService.getByLong(invalidUrlShort)).thenReturn(null);

        mockMvc.perform(get("/api/getByShort/{urlShort}", invalidUrlShort))
                .andExpect(status().isNotFound());

        verify(urlService, times(1)).getByShort(invalidUrlShort);
    }

    @Test
    public void testOpenLongUrl() throws Exception {

        Integer fakeID = 999;
        String urlLong = "fakeLongUrl";
        String urlShort = "fakeShortUrl";

        Url url = new Url();
        url.setId(fakeID);
        url.setUrl_long(urlLong);
        url.setUrl_short(urlShort);

        when(urlService.getByShort(urlShort)).thenReturn(url);

        mockMvc.perform(get("/api/{urlShort}", url.getUrl_short()))
                .andExpect(content().string(containsString(urlLong)))
                .andExpect(status().isOk());

        verify(urlService, times(1)).getByShort(urlShort);
    }

    @Test
    public void testInvalidOpenLongUrl() throws Exception {

        String invalidUrlShort = "Invalid";
        String fakeUrlShort = "fakeUrlShort";

        Url url = new Url();
        url.setUrl_short(fakeUrlShort);

        when(urlService.getByShort(invalidUrlShort)).thenReturn(null);

        mockMvc.perform(get("/api/{urlShort}", invalidUrlShort))
                .andExpect(status().isNotFound());

        verify(urlService, times(1)).getByShort(invalidUrlShort);
    }


    @Test
    public void testAddUrl() throws Exception {

        Integer fakeID = 999;
        String urlLong = "fakeLongUrl";
        String urlShort = "fakeShortUrl";
        Integer accessTimes = 2;

        Url url = new Url();
        url.setId(fakeID);
        url.setUrl_long(urlLong);
        url.setUrl_short(urlShort);
        url.setAccessTimes(accessTimes);

        UrlDto urlDto = new UrlDto();
        urlDto.setUrl_long(urlLong);
        urlDto.setUrl_short(urlShort);
        urlDto.setAccessTimes(accessTimes);

        when(urlDtoToUrl.convert(ArgumentMatchers.any(UrlDto.class))).thenReturn(url);
        when(urlService.save(url)).thenReturn(url);

        mockMvc.perform(post("/api/addUrl")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(urlDto)))
                .andExpect(status().isCreated());

        ArgumentCaptor<UrlDto> boundCustomer = ArgumentCaptor.forClass(UrlDto.class);

        verify(urlDtoToUrl, times(1)).convert(boundCustomer.capture());
        verify(urlService, times(1)).save(url);

        assertEquals(null, boundCustomer.getValue().getId());
        assertEquals(urlLong, boundCustomer.getValue().getUrl_long());
        assertEquals(urlShort, boundCustomer.getValue().getUrl_short());
        assertEquals(accessTimes, boundCustomer.getValue().getAccessTimes());
    }

    @Test
    public void testAddUrlWithBadRequest() throws Exception {

        mockMvc.perform(post("/api/addUrl"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testListUrls() throws Exception {

        Integer fakeID = 999;
        String urlLong = "fakeLongUrl";
        String urlShort = "fakeShortUrl";
        Integer accessTimes = 2;

        Url url = new Url();
        url.setId(fakeID);
        url.setUrl_long(urlLong);
        url.setUrl_short(urlShort);
        url.setAccessTimes(accessTimes);

        UrlDto urlDto = new UrlDto();
        urlDto.setId(fakeID);
        urlDto.setUrl_long(urlLong);
        urlDto.setUrl_short(urlShort);
        urlDto.setAccessTimes(accessTimes);

        List<Url> urlList = new ArrayList<>();
        urlList.add(url);

        when(urlService.list()).thenReturn(urlList);
        when(urlToUrlDto.convert(url)).thenReturn(urlDto);

        mockMvc.perform(get("/api/"))
                .andExpect(jsonPath("$[0].id").value(fakeID))
                .andExpect(jsonPath("$[0].url_long").value(urlLong))
                .andExpect(jsonPath("$[0].url_short").value(urlShort))
                .andExpect(jsonPath("$[0].accessTimes").value(accessTimes))
                .andExpect(status().isOk());

        verify(urlService, times(1)).list();
        verify(urlToUrlDto, times(1)).convert(url);
    }

    @Test
    public void testDeleteUrl() throws Exception {

        testAddUrl();

        Integer fakeId = 999;

        mockMvc.perform(delete("/api/{id}", fakeId))
                .andExpect(status().isNoContent());

        verify(urlService, times(1)).delete(fakeId);
    }
}
