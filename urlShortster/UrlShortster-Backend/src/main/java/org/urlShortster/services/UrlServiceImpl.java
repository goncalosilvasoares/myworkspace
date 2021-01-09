package org.urlShortster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.urlShortster.generator.ShortUrlGenerator;
import org.urlShortster.persistence.jpa.UrlDao;
import org.urlShortster.persistence.model.Url;

import java.util.List;

@Service
@Transactional
public class UrlServiceImpl implements UrlService {

    private UrlDao urlDao;
    private ShortUrlGenerator urlGenerator;

    @Autowired
    public void setUrlGenerator(ShortUrlGenerator urlGenerator) {

        this.urlGenerator = urlGenerator;
    }

    @Autowired
    public void setUrlDao(UrlDao urlDao) {

        this.urlDao = urlDao;
    }

    @Override
    public Url getById(Integer id) {

        Url url = urlDao.findById(id);
        incrementAccessTime(url);

        return url;
    }

    @Override
    public Url getByLong(String urlLong) {

        Url url = urlDao.findByLong(urlLong);
        incrementAccessTime(url);

        return url;
    }

    @Override
    public Url getByShort(String urlShort) {

        Url url = urlDao.findByShort(urlShort);
        incrementAccessTime(url);

        return url;
    }

    @Override
    public Url save(Url url) {

        if (existsLong(url.getUrl_long())) {

            return null;
        }

        if (existsShort(url.getUrl_short())) {

            return null;
        }

        if (url.getUrl_short() == null) {

            String urlShort = urlGenerator.getNewShortUrl();

            while (existsShort(urlShort)) {

                urlShort = urlGenerator.getNewShortUrl();
            }

            url.setUrl_short(urlShort);
        }

        if (url.getAccessTimes() == null) {

            url.setAccessTimes(0);
        }

        return urlDao.save(url);
    }

    @Override
    public void delete(Integer id) {

        urlDao.delete(id);
    }

    @Override
    public List<Url> list() {

        return urlDao.findAll();
    }

    @Override
    public boolean existsLong(String urlLong) {

        return urlDao.findByLong(urlLong) != null;
    }

    @Override
    public boolean existsShort(String urlShort) {

        return urlDao.findByShort(urlShort) != null;
    }

    @Override
    public void incrementAccessTime(Url url) {

        if (url != null) {

            url.setAccessTimes(url.getAccessTimes() + 1);
            urlDao.save(url);
        }
    }
}
