package org.urlShortster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.urlShortster.command.UrlDto;
import org.urlShortster.converters.UrlDtoToUrl;
import org.urlShortster.converters.UrlToUrlDto;
import org.urlShortster.persistence.model.Url;
import org.urlShortster.services.UrlService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class RestUrlController {


    private UrlService urlService;
    private UrlDtoToUrl urlDtoToUrl;
    private UrlToUrlDto urlToUrlDto;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @Autowired
    public void setUrlToUrlDto(UrlToUrlDto urlToUrlDto) {

        this.urlToUrlDto = urlToUrlDto;
    }

    @Autowired
    public void setUrlDtoToUrl(UrlDtoToUrl urlDtoToUrl) {

        this.urlDtoToUrl = urlDtoToUrl;
    }

    @Autowired
    public void setUrlService(UrlService urlService) {

        this.urlService = urlService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getById/{id}")
    public ResponseEntity<?> getId(@PathVariable Integer id) {

        Url url = urlService.getById(id);

        if (url == null) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(urlToUrlDto.convert(url), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getByLong/{urlLong}")
    public ResponseEntity<?> getLongUrl(@PathVariable String urlLong) {

        Url url = urlService.getByLong(urlLong);

        if (url == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(urlToUrlDto.convert(url), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getByShort/{urlShort}")
    public ResponseEntity<?> getShortUrl(@PathVariable String urlShort) {

        Url url = urlService.getByShort(urlShort);

        if (url == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(urlToUrlDto.convert(url), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addUrl")
    public ResponseEntity<?> addUrl(@RequestBody UrlDto urlDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Url savedUrl = urlService.save(urlDtoToUrl.convert(urlDto));

        if (savedUrl == null) {
            return new ResponseEntity<>("Not_Valid", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(savedUrl, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{urlShort}")
    public ResponseEntity<?> openLongUrl(@PathVariable String urlShort) {

        Url url = urlService.getByShort(urlShort);

        if (url == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(url.getUrl_long(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<UrlDto>> urlList() {

        List<UrlDto> urlDtos = urlService.list().stream()
                .map(url -> urlToUrlDto.convert(url))
                .collect(Collectors.toList());

        return new ResponseEntity<>(urlDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deleteUrl(@PathVariable Integer id) {

        urlService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
