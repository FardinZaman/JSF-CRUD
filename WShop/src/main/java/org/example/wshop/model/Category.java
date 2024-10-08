package org.example.wshop.model;

public enum Category {
    MILITARY("Military Grade"),
    LAW_ENFORCEMENT("Law Enforcement"),
    CIVILIAN("Civilian");

    private final String categoryValue;

    Category(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    @Override
    public String toString() {
        return categoryValue;
    }
}
