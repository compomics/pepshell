/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compomics.pepshell.model.DAS;

/**
 *
 * @author Davy Maddelein
 */
class DasType {
    private String id;
    private String typeMessage;
    
    public DasType(String id, String typeMessage){
        this.id = id;
        this.typeMessage = typeMessage;
    }

    public String getTypId() {
        return id;
    }

    public String getTypeMessage() {
        return typeMessage;
    }
}