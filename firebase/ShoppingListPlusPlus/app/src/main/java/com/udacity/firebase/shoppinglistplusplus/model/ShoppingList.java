package com.udacity.firebase.shoppinglistplusplus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firebase.client.ServerValue;

import java.util.Map;

/**
 * Created by ilyarudyak on 3/1/16.
 */
public class ShoppingList {

    private String listName;
    private String owner;
    private Long creationDate;

    public ShoppingList() {
    }

    public ShoppingList(String listName, String owner) {
        this.listName = listName;
        this.owner = owner;
    }

    public String getListName() {
        return listName;
    }
    public String getOwner() {
        return owner;
    }
    public Map<String, String> getCreationDate() {
        return ServerValue.TIMESTAMP;
    }

    @JsonIgnore
    public Long getCreationDateLong() {
        return creationDate;
    }

}













