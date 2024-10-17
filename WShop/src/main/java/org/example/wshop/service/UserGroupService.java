package org.example.wshop.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.wshop.model.GroupType;
import org.example.wshop.model.UserGroup;

import java.util.List;

@Stateless
public class UserGroupService {

    @PersistenceContext
    EntityManager em;

    public UserGroup findChair() {
        return em.createQuery("SELECT u FROM UserGroup u WHERE u.groupType = :type", UserGroup.class)
                .setParameter("type", GroupType.CHAIRMAN)
                .getSingleResult();
    }

    public List<UserGroup> findChildren(UserGroup parent) {
        return em.createQuery("SELECT u FROM UserGroup u WHERE u.parent = :parent", UserGroup.class)
                .setParameter("parent", parent)
                .getResultList();
    }

    public List<UserGroup> findAllUserGroups() {
        return em.createQuery("SELECT u FROM UserGroup u ORDER BY u.id", UserGroup.class)
                .getResultList();
    }

    public UserGroup findById(Integer id) {
        return em.find(UserGroup.class, id);
    }

    public void add(UserGroup userGroup) {
        em.persist(userGroup);
    }

    public void update(UserGroup userGroup) {
        em.merge(userGroup);
    }
}
