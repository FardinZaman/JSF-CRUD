package org.example.wshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.wshop.ConvertibleEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Objects;

@Entity
public class Weapon implements Serializable, ConvertibleEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private WeaponType weaponType;

    private Caliber caliber;

    private String serialNumber;

    private String manufacturer;

    private String countryOfOrigin;

    private Integer price;

    private Integer stockQuantity;

    private Double weightInKg;

    private Double barrelLengthInCm;

    private ActionType actionType;

    private Integer ammoCapacity;

    private Material material;

    private boolean isNew;

    private Category category;

    private LocalDate purchaseDate;

    private String supplier;

    private byte[] image;

    public Weapon() {
    }

    public Weapon(String name, WeaponType weaponType, String serialNumber) {
        this.name = name;
        this.weaponType = weaponType;
        this.serialNumber = serialNumber;
    }

    public String getImageAsBase64() {
        if (this.image == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(this.image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return isNew == weapon.isNew && Objects.equals(id, weapon.id) && Objects.equals(name, weapon.name) && weaponType == weapon.weaponType && caliber == weapon.caliber && Objects.equals(serialNumber, weapon.serialNumber) && Objects.equals(manufacturer, weapon.manufacturer) && Objects.equals(countryOfOrigin, weapon.countryOfOrigin) && Objects.equals(price, weapon.price) && Objects.equals(stockQuantity, weapon.stockQuantity) && Objects.equals(weightInKg, weapon.weightInKg) && Objects.equals(barrelLengthInCm, weapon.barrelLengthInCm) && actionType == weapon.actionType && Objects.equals(ammoCapacity, weapon.ammoCapacity) && material == weapon.material && category == weapon.category && Objects.equals(purchaseDate, weapon.purchaseDate) && Objects.equals(supplier, weapon.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weaponType, caliber, serialNumber, manufacturer, countryOfOrigin, price, stockQuantity, weightInKg, barrelLengthInCm, actionType, ammoCapacity, material, isNew, category, purchaseDate, supplier);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weaponType=" + weaponType +
                ", caliber=" + caliber +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", weightInKg=" + weightInKg +
                ", barrelLengthInCm=" + barrelLengthInCm +
                ", actionType=" + actionType +
                ", ammoCapacity=" + ammoCapacity +
                ", material=" + material +
                ", isNew=" + isNew +
                ", category=" + category +
                ", purchaseDate=" + purchaseDate +
                ", supplier='" + supplier + '\'' +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public Caliber getCaliber() {
        return caliber;
    }

    public void setCaliber(Caliber caliber) {
        this.caliber = caliber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(Double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public Double getBarrelLengthInCm() {
        return barrelLengthInCm;
    }

    public void setBarrelLengthInCm(Double barrelLengthInCm) {
        this.barrelLengthInCm = barrelLengthInCm;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Integer getAmmoCapacity() {
        return ammoCapacity;
    }

    public void setAmmoCapacity(Integer ammoCapacity) {
        this.ammoCapacity = ammoCapacity;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}


