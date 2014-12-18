package com.compomics.pepshell.model.enums;

import java.util.EnumSet;

/**
 *
 * @author Davy Maddelein
 */
public enum ViewPropertyEnum implements PropertyEnum {

    PROTEINACCESSIONTYPE("view.preferredaccessiontype", "uniprot"),
    PREFERREDENZYME("protein.preferredenzyme", "trypsin"),
    PROTEINFASTALOCATION("protein.fastalocation", ""),
    PROTEININFOWEBSITE("protein.externaldatalocation", "www.uniprot.org/uniprot/"),
    LOADMASKINGFILEAUTOMATICALLY("protein.loadproteinmaskonstartup", "no"),
    PROTEINMASKLOCATION("protein.proteinmasklocation", System.getProperty("user.home") + ".compomics/pepshell/proteinmask.txt");
    private final String property;
    private final String defaultValue;

    private ViewPropertyEnum(String property, String defaultValue) {
        this.property = property;
        this.defaultValue = defaultValue;
    }

    @Override
    public String getKey() {
        return property;
    }

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }
    //TODO: make interface method reference implementing class?
    public static EnumSet allEnumValues = EnumSet.allOf(ViewPropertyEnum.class);
}
