package org.urlShortster.generator;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component("newShortUrl")
public class ShortUrlGenerator {

    public String getNewShortUrl() {

        int initLimit = 48;
        int endLimit = 122;
        int maxLength = 6;

        Random random = new Random();

        return random.ints(initLimit, endLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(maxLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
