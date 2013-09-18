package com.compomics.peppi.model;

import com.compomics.peppi.model.enums.PropertyEnum;

/**
 *
 * @author Davy
 */
public final class Property {
    
    private PropertyEnum nameEnum;
    private String value;
    
    public Property(PropertyEnum aName, String aValue) {
        this.nameEnum = aName;
        this.value = aValue;
    }

    final public PropertyEnum getName() {
        return nameEnum;
    }

    final public String getValue() {
        return value;
    }
    
}
