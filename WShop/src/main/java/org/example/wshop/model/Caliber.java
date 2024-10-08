package org.example.wshop.model;

public enum Caliber {
    CAL_9MM("9mm"),
    CAL_45ACP(".45 ACP"),
    CAL_40SW(".40 S&W"),
    CAL_357MAG(".357 Magnum"),
    CAL_38SPECIAL(".38 Special"),
    CAL_44MAG(".44 Magnum"),
    CAL_22LR(".22 LR"),
    CAL_556NATO("5.56 NATO"),
    CAL_762NATO("7.62 NATO"),
    CAL_50BMG(".50 BMG"),
    CAL_12GAUGE("12 Gauge"),
    CAL_20GAUGE("20 Gauge");

    private final String caliberValue;

    Caliber(String caliberValue) {
        this.caliberValue = caliberValue;
    }

    public String getCaliberValue() {
        return caliberValue;
    }

    @Override
    public String toString() {
        return caliberValue;
    }
}
