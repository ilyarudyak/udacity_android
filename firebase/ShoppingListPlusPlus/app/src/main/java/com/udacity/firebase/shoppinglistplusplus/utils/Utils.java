package com.udacity.firebase.shoppinglistplusplus.utils;

import android.content.Context;

import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class
 */
public class Utils {
    /**
     * Format the date with SimpleDateFormat
     */
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private Context mContext = null;

    public static String formatShoppingListDate(ShoppingList shoppingList) {
        return SIMPLE_DATE_FORMAT.format(new Date((long)shoppingList
                .getDateCreated().get(Constants.FIREBASE_PROPERTY_TIMESTAMP)));
    }

    /**
     * Public constructor that takes mContext for later use
     */
    public Utils(Context context) {
        mContext = context;
    }

}
