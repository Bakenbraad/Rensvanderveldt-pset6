package com.example.rens.rensvanderveldt_pset6;

/**
 * Created by Rens on 09/12/2016.
 */

public class Regio {

    String code = null;
    String name = null;
    boolean selected = false;

    public Regio(String name, boolean selected) {
        super();
        this.name = name;
        this.selected = selected;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}