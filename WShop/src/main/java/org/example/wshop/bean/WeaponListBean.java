package org.example.wshop.bean;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
import org.example.wshop.model.*;
import org.example.wshop.service.WeaponService;

import java.io.Serializable;
import java.util.List;

@Model
public class WeaponListBean implements Serializable {

    @EJB
    private WeaponService weaponService;

    private List<Weapon> weaponList;

    @PostConstruct
    public void init() {
        weaponList = weaponService.findAllWeapons();
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }
}
