package org.urlShortster.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.urlShortster.command.UrlDto;
import org.urlShortster.persistence.model.Url;

@Component
public class UrlToUrlDto implements Converter<Url, UrlDto> {

    @Override
    public UrlDto convert(Url url) {

        UrlDto newUrlDto =  new UrlDto();
        newUrlDto.setId(url.getId());
        newUrlDto.setUrl_short(url.getUrl_short());
        newUrlDto.setUrl_long(url.getUrl_long());
        newUrlDto.setAccessTimes(url.getAccessTimes());
        newUrlDto.setUpdateDate(url.getUpdateDate());
        newUrlDto.setCreateDate(url.getCreateDate());

        return newUrlDto;
    }
}
