package org.urlShortster.persistence.jpa;

import org.junit.Before;
import org.junit.Test;
import org.urlShortster.persistence.model.Url;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class JpaUrlDaoTest {

    private JpaUrlDao jpaUrlDao;
    private EntityManager em;

    @Before
    public void setup() {

        em = mock(EntityManager.class);

        jpaUrlDao = new JpaUrlDao();
        jpaUrlDao.setEm(em);
    }

    @Test
    public void testFindAll() {

        List<Url> mockUrls = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);
        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Url.class)).thenReturn(criteriaQuery);
        when(em.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(em.createQuery(anyString(), any(Class.class))).thenReturn(typedQuery);
        when(em.createQuery(any(CriteriaQuery.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockUrls);

        List<Url> urls = jpaUrlDao.findAll();

        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockUrls, urls);
    }

    @Test
    public void testFindById() {

        Integer fakeId = 999;

        Url fakeUrl = new Url();
        fakeUrl.setId(fakeId);

        when(em.find(Url.class, fakeId)).thenReturn(fakeUrl);

        Url url = jpaUrlDao.findById(fakeId);

        verify(em, times(1)).find(Url.class, fakeId);
        assertEquals(fakeUrl, url);
    }

    @Test
    public void testSave() {

        Url fakeUrl = new Url();

        when(em.merge((any(Url.class)))).thenReturn(fakeUrl);

        Url url = jpaUrlDao.save(fakeUrl);

        verify(em, times(1)).merge(any(Url.class));
        assertEquals(fakeUrl, url);
    }

    @Test
    public void testDelete() {

        Integer fakeId = 999;

        Url fakeUrl = new Url();
        fakeUrl.setId(fakeId);

        when(em.find(Url.class, fakeId)).thenReturn(fakeUrl);

        jpaUrlDao.delete(fakeId);

        verify(em, times(1)).remove(fakeUrl);
    }
}
