package com.udacity.firebase.shoppinglistplusplus.utils;

import com.udacity.firebase.shoppinglistplusplus.BuildConfig;

/**
 * Constants class store most important strings and paths of the app
 */
public final class Constants {

    /**
     * Constants related to locations in Firebase, such as the name of the node
     * where active lists are stored (ie "activeLists")
     */
    public static final String FIREBASE_LOCATION_ACTIVE_LISTS = "activeLists";
    public static final String FIREBASE_LOCATION_SHOPPING_LIST_ITEMS = "shoppingListItems";


    // shoppingList model instance variables
    public static final String SHOPPING_LIST_MODEL_LIST_NAME = "listName";
    public static final String SHOPPING_LIST_MODEL_OWNER = "owner";
    public static final String SHOPPING_LIST_MODEL_CREATION_DATE = "creationDate";

    // firebase URLs
    public static final String FIREBASE_URL = BuildConfig.UNIQUE_FIREBASE_ROOT_URL;
    public static final String FIREBASE_URL_ACTIVE_LISTS = FIREBASE_URL + FIREBASE_LOCATION_ACTIVE_LISTS;
    public static final String FIREBASE_URL_SHOPPING_LIST_ITEMS = FIREBASE_URL + FIREBASE_LOCATION_SHOPPING_LIST_ITEMS;

    // constants for bundles, extras and shared preferences keys
    public static final String KEY_LIST_NAME = "listName";
    public static final String KEY_LIST_PUSH_ID = "pushId";

    // constants for firebase login
    public static final String PASSWORD_PROVIDER = "password";

}
