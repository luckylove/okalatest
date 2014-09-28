package com.marinabay.cruise.model;

/**
 * User: son.nguyen
 * Date: 9/21/14
 * Time: 9:19 PM
 */
public class UserGroup extends GenericModel{

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
