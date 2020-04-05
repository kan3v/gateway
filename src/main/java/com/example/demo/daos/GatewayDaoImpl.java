package com.example.demo.daos;


import com.example.demo.models.Gateway;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class GatewayDaoImpl
{
    public interface GatewayI
    {
        List<Gateway>find(Long id, String serialNumber);
    }

    @Autowired
    EntityManager em;

    public List< Gateway>find(Long id, String serialNumber)
    {
        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery< Gateway> query = criteria.createQuery( Gateway.class);
        Root< Gateway> root = query.from( Gateway.class);

        Predicate pm = criteria.and();

        if (null != serialNumber && serialNumber.length() > 0)
        {
            Predicate p1 = criteria.and((criteria.equal(root.get("serialNumber"), serialNumber)));
            pm.getExpressions().add(p1);
        }

        if (null != id && id > 0)
        {
            Predicate p2 = criteria.and((criteria.equal(root.get("id"), id)));
            pm.getExpressions().add(p2);
        }

        if (pm.isNotNull() != null)
        {
            query.where(pm).orderBy(criteria.desc(root.get("serialNumber")));
        }
        List<Gateway> gatewayList = new ArrayList<>();
        if (null != id || null != serialNumber)
        {
            gatewayList = em.createQuery(query.select(root)).getResultList();
        }

        return gatewayList;
    }
}
