/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malsolo.orika.test.dto;

import com.google.common.base.MoreObjects;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
public class CustomerDTO {

    private static final DateTimeFormatter FORMATTER = 
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private Long id;
    private String name;
    private String address;
    private Date date;
    private LocalDateTime localDateTime;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        localDateTime = LocalDateTime.ofInstant(this.date.toInstant()
                , ZoneId.systemDefault());
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.getId())
                .add("name", this.getName())
                .add("address", this.getAddress())
                .add("date", localDateTime != null ? FORMATTER.format(localDateTime) : "null")
                .toString();
    }
    
}
