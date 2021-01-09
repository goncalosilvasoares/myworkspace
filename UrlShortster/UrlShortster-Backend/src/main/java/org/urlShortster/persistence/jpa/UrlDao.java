package org.urlShortster.persistence.jpa;

import org.urlShortster.persistence.model.Url;

import java.util.List;

public interface UrlDao {

    List<Url> findAll();
    Url findByLong(String urlLong);
    Url findByShort(String urlShort);
    Url findById(Integer id);
    Url save(Url url);
    void delete(Integer id);
}
