package org.urlShortster.services;

import org.springframework.stereotype.Service;
import org.urlShortster.persistence.model.Url;

import java.util.List;

@Service
public interface UrlService {

    Url getById(Integer id);
    Url getByLong(String urlLong);
    Url getByShort(String urlShort);
    Url save(Url url);
    void delete(Integer id);
    List<Url> list();
    boolean existsLong(String urlLong);
    boolean existsShort(String urlShort);
    void incrementAccessTime(Url url);
}

