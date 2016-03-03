package com.udacity.firebase.shoppinglistplusplus.model;

/**
 * Created by ilyarudyak on 3/3/16.
 */
public class ShoppingListItem {

    private String itemName;
    private String owner;

    public ShoppingListItem() {
    }

    public ShoppingListItem(String itemName) {
        this.itemName = itemName;
        this.owner = "Anonymous Owner";
    }

    public String getItemName() { return itemName; }
    public String getOwner() {
        return owner;
    }
}
