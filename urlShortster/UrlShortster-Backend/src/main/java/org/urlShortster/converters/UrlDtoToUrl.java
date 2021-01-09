package org.urlShortster.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.urlShortster.command.UrlDto;
import org.urlShortster.persistence.model.Url;
import org.urlShortster.services.UrlService;

@Component
public class UrlDtoToUrl implements Converter<UrlDto, Url> {

    private UrlService urlService;

    @Autowired
    public void setUrlService(UrlService urlService) {
        this.urlService = urlService;
    }

    @Override
    public Url convert(UrlDto urlDto) {

        Url newUrl = (urlDto.getId() != null ? urlService.getById(urlDto.getId()) : new Url());

        newUrl.setUrl_short(urlDto.getUrl_short());
        newUrl.setUrl_long(urlDto.getUrl_long());
        newUrl.setAccessTimes(urlDto.getAccessTimes());
        newUrl.setUpdateDate(urlDto.getUpdateDate());
        newUrl.setCreateDate(urlDto.getCreateDate());

        return newUrl;
    }
}
