package org.urlShortster.persistence.jpa;

import org.springframework.stereotype.Repository;
import org.urlShortster.persistence.model.Url;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class JpaUrlDao implements UrlDao {

    @PersistenceContext
    protected EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Url> findAll() {

        CriteriaQuery<Url> criteriaQuery = em.getCriteriaBuilder().createQuery(Url.class);
        Root<Url> root = criteriaQuery.from(Url.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Url findByLong(String urlLong) {

        try {

            return (Url) em.createQuery("SELECT u FROM Url u WHERE u.url_long like :findUrlLong")
                    .setParameter("findUrlLong", urlLong)
                    .getSingleResult();

        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public Url findByShort(String urlShort) {

        try {

            return (Url) em.createQuery("SELECT u FROM Url u WHERE u.url_short like :findUrlShort")
                    .setParameter("findUrlShort", urlShort)
                    .getSingleResult();

        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public Url findById(Integer id) {
        return em.find(Url.class, id);
    }

    @Override
    public Url save(Url url) {
        return em.merge(url);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(Url.class, id));
    }
}
