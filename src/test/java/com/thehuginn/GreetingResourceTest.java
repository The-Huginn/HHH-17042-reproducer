package com.thehuginn;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.thehuginn.Action.ActionPOJO;
import com.thehuginn.Action.Action_;

@QuarkusTest
public class GreetingResourceTest {

    @Inject
    EntityManager entityManager;
    
    @Test
    @Transactional
    public void testHelloEndpoint() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
		Root<Action> from = query.from(Action.class);
		from.join(Action_.LOCATION, JoinType.LEFT);
		from.join(Action_.LEAD, JoinType.LEFT);

        TypedQuery<Tuple> result = entityManager.createQuery(query);
        List<Tuple> resultList = result.getResultList();

        Assertions.assertEquals(resultList.size(), 0);
    }

}