package com.mobile.brasiltv.utils;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.raizlabs.android.dbflow.sql.language.Operator;

public abstract class d0 {
    public static String a(String str, String str2) {
        try {
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                return "";
            }
            int indexOf2 = str.indexOf(Operator.Operation.EQUALS, indexOf);
            int indexOf3 = str.indexOf(DispatchConstants.SIGN_SPLIT_SYMBOL, indexOf);
            if (indexOf2 == -1) {
                return "";
            }
            if (indexOf3 == -1) {
                return str.substring(indexOf2 + 1);
            }
            return str.substring(indexOf2 + 1, indexOf3);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
