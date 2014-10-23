/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malsolo.orika.test.domain;

import com.google.common.base.MoreObjects;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
public class Simple {
    
    private Integer number;
    private String name;
    private String noName;

    public Simple() {
    }
    
    public Simple(Integer number, String name, String noName) {
        this.number = number;
        this.name = name;
        this.noName = noName;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getNoName() {
        return noName;
    }

    public void setNoName(String noName) {
        this.noName = noName;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("number", this.getNumber())
                .add("name", this.getName())
                .add("noName", this.getNoName())
                .toString();
    }
    
}
