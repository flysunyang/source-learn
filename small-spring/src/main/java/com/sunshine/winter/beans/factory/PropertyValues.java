package com.sunshine.winter.beans.factory;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
    
    private List<PropertyValue> propertyValueList;

    public PropertyValues() {
        propertyValueList = new ArrayList<>();
    }

    public PropertyValues(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
    
    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }
}
