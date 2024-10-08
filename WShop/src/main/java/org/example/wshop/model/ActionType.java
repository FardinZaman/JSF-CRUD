package org.example.wshop.model;

public enum ActionType {
    SEMI_AUTO("Semi Automatic"),
    FULL_AUTO("Full Automatic"),
    BOLT_ACTION("Bolt Action"),
    PUMP_ACTION("Pump Action");

    private final String actionTypeValue;

    ActionType(String actionTypeValue) {
        this.actionTypeValue = actionTypeValue;
    }

    public String getActionTypeValue() {
        return actionTypeValue;
    }

    @Override
    public String toString() {
        return actionTypeValue;
    }
}
