package com.worldofthings.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/* Make Vitual Object for absstracting Persistance layer*/

public class VirtualObjectVO  {

    @JsonProperty
    private String name;
    @NotNull(message = "value field cannot be null.")
    @Size(min = 1, max = 128, message = "Field cannot be empty. The length of value should not be more than " +
            "128 symbols.")
    @JsonProperty
    private String value;
    @JsonProperty
    private long entityVersion;

    public VirtualObjectVO() {
    }

    public VirtualObjectVO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    @JsonIgnore
    public void setValue(long value) {
        this.value = Long.toString(value);
    }

    @JsonIgnore
    public void setValue(boolean value) {
        this.value = Boolean.toString(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getEntityVersion() {
        return entityVersion;
    }

    public void setEntityVersion(long entityVersion) {
        this.entityVersion = entityVersion;
    }
}
