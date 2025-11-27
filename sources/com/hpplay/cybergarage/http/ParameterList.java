package com.hpplay.cybergarage.http;

import java.util.Vector;

public class ParameterList extends Vector {
    public Parameter at(int i10) {
        return (Parameter) get(i10);
    }

    public Parameter getParameter(int i10) {
        return (Parameter) get(i10);
    }

    public String getValue(String str) {
        Parameter parameter = getParameter(str);
        if (parameter == null) {
            return "";
        }
        return parameter.getValue();
    }

    public Parameter getParameter(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            Parameter at = at(i10);
            if (str.compareTo(at.getName()) == 0) {
                return at;
            }
        }
        return null;
    }
}
