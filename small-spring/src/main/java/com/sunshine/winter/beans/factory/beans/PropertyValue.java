package com.sunshine.winter.beans.factory.beans;

public class PropertyValue {
    
    private final String name;
    
    private final String value;

    public PropertyValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
    
}
