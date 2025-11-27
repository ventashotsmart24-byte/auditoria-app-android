package org.simpleframework.xml.core;

import java.util.List;

class SignatureCreator implements Creator {
    private final List<Parameter> list;
    private final Signature signature;
    private final Class type;

    public SignatureCreator(Signature signature2) {
        this.type = signature2.getType();
        this.list = signature2.getAll();
        this.signature = signature2;
    }

    private double getAdjustment(double d10) {
        double size = (double) this.list.size();
        Double.isNaN(size);
        double d11 = size / 1000.0d;
        if (d10 > 0.0d) {
            double size2 = (double) this.list.size();
            Double.isNaN(size2);
            return d11 + (d10 / size2);
        }
        double size3 = (double) this.list.size();
        Double.isNaN(size3);
        return d10 / size3;
    }

    private double getPercentage(Criteria criteria) {
        double d10 = 0.0d;
        for (Parameter next : this.list) {
            if (criteria.get(next.getKey()) != null) {
                d10 += 1.0d;
            } else if (next.isRequired() || next.isPrimitive()) {
                return -1.0d;
            }
        }
        return getAdjustment(d10);
    }

    private Object getVariable(Criteria criteria, int i10) {
        Variable remove = criteria.remove(this.list.get(i10).getKey());
        if (remove != null) {
            return remove.getValue();
        }
        return null;
    }

    public Object getInstance() {
        return this.signature.create();
    }

    public double getScore(Criteria criteria) {
        Signature copy = this.signature.copy();
        for (Object next : criteria) {
            Parameter parameter = copy.get(next);
            Variable variable = criteria.get(next);
            Contact contact = variable.getContact();
            if (parameter != null && !Support.isAssignable(variable.getValue().getClass(), parameter.getType())) {
                return -1.0d;
            }
            if (contact.isReadOnly() && parameter == null) {
                return -1.0d;
            }
        }
        return getPercentage(criteria);
    }

    public Signature getSignature() {
        return this.signature;
    }

    public Class getType() {
        return this.type;
    }

    public String toString() {
        return this.signature.toString();
    }

    public Object getInstance(Criteria criteria) {
        Object[] array = this.list.toArray();
        for (int i10 = 0; i10 < this.list.size(); i10++) {
            array[i10] = getVariable(criteria, i10);
        }
        return this.signature.create(array);
    }
}
