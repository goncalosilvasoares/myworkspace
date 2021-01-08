package org.urlShortster.factories;

import org.urlShortster.persistence.model.Url;

public class UrlFactory {

    public Url createUrl() {

        return new Url();
    }
}
