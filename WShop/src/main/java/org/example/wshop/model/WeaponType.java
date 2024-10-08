package org.example.wshop.model;

public enum WeaponType {
    ASSAULT_RIFLE("Assault Rifle"),
    SNIPER_RIFLE("Sniper Rifle"),
    HANDGUN("Handgun"),
    REVOLVER("Revolver"),
    SHOTGUN("Shotgun"),
    SMG("SMG"),
    LMG("LMG");

    private final String weaponTypeValue;

    WeaponType(String weaponTypeValue) {
        this.weaponTypeValue = weaponTypeValue;
    }

    public String getWeaponTypeValue() {
        return weaponTypeValue;
    }

    @Override
    public String toString() {
        return weaponTypeValue;
    }
}
