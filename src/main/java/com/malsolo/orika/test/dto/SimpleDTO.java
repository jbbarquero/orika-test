/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malsolo.orika.test.dto;

import com.google.common.base.MoreObjects;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
public class SimpleDTO {
    
    private Integer id;
    private String name;
    private String noName;

    public SimpleDTO() {
    }
    
    public SimpleDTO(Integer id, String name, String noName) {
        this.id = id;
        this.name = name;
        this.noName = noName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                .add("id", this.getId())
                .add("name", this.getName())
                .add("noName", this.getNoName())
                .toString();
    }

}
