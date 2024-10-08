package org.example.wshop.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.wshop.model.Weapon;

import java.util.List;

@Stateless
public class WeaponService {

    @PersistenceContext
    EntityManager em;

    public List<Weapon> findAllWeapons() {
        return em.createQuery("SELECT w FROM Weapon w ORDER BY w.id", Weapon.class)
                .getResultList();
    }

    public Weapon findWeaponById(Integer id) {
        return em.find(Weapon.class, id);
    }

    public void add(Weapon weapon) {
        em.persist(weapon);
    }

    public void update(Weapon weapon) {
        em.merge(weapon);
    }

    public void delete(Weapon weapon) {
        if(em.contains(weapon)){
            em.remove(weapon);
        }
        else {
            Weapon managedWeapon = findWeaponById(weapon.getId());
            if(managedWeapon != null) {
                em.remove(managedWeapon);
            }
        }
    }
}
