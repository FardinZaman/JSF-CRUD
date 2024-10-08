package org.example.wshop.bean;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import org.example.wshop.model.*;
import org.example.wshop.service.WeaponService;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
@ViewScoped
public class WeaponBean implements Serializable {

    @EJB
    private WeaponService weaponService;

    private Weapon weapon;

    private Integer weaponId;

    private byte[] weaponImage;

    @PostConstruct
    public void init() {
        this.weapon = new Weapon();
    }

    public void loadWeapon() {
        if(this.weaponId == null)
            return;

        this.weapon = weaponService.findWeaponById(this.weaponId);
    }

    public List<String> getCountries() {
        return Stream.of(Locale.getISOCountries())
                .map(countryCode -> new Locale("", countryCode).getDisplayCountry())
                .collect(Collectors.toList());
    }

    public List<String> completeCountry(String countryQuery) {
        return getCountries()
                .stream()
                .filter(c -> c.toLowerCase().contains(countryQuery.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void handleImageUpload(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        if (uploadedFile != null) {
            this.weaponImage = uploadedFile.getContent();
            this.weapon.setImage(this.weaponImage);
        }
    }

    public String addWeapon() {
        weaponService.add(this.weapon);
        return "weapon-list?faces-redirect=true";
    }

    public String updateWeapon() {
        weaponService.update(this.weapon);
        return "weapon-list?faces-redirect=true";
    }

    public String deleteWeapon() {
        weaponService.delete(this.weapon);
        return "weapon-list?faces-redirect=true";
    }

    public ActionType[] getActionTypes() {
        return ActionType.values();
    }

    public Category[] getCategories() {
        return Category.values();
    }

    public Caliber[] getCalibers() {
        return Caliber.values();
    }

    public Material[] getMaterials() {
        return Material.values();
    }

    public WeaponType[] getWeaponTypes() {
        return WeaponType.values();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Integer getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(Integer weaponId) {
        this.weaponId = weaponId;
    }

    public byte[] getWeaponImage() {
        return weaponImage;
    }

    public void setWeaponImage(byte[] weaponImage) {
        this.weaponImage = weaponImage;
    }
}
