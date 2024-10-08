package org.example.wshop.model;

public enum Material {
    STEEL("Steel"),
    WOOD_AND_STEEL("Wood and Steel"),
    POLYMER("Polymer");

    private final String materialValue;

    Material(String materialValue) {
        this.materialValue = materialValue;
    }

    public String getMaterialValue() {
        return materialValue;
    }

    @Override
    public String toString() {
        return materialValue;
    }
}
