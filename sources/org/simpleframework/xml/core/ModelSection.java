package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;

class ModelSection implements Section {
    private LabelMap attributes;
    private LabelMap elements;
    private Model model;
    private ModelMap models;

    public ModelSection(Model model2) {
        this.model = model2;
    }

    public String getAttribute(String str) {
        Expression expression = this.model.getExpression();
        if (expression == null) {
            return str;
        }
        return expression.getAttribute(str);
    }

    public LabelMap getAttributes() {
        if (this.attributes == null) {
            this.attributes = this.model.getAttributes();
        }
        return this.attributes;
    }

    public Label getElement(String str) {
        return getElements().getLabel(str);
    }

    public LabelMap getElements() {
        if (this.elements == null) {
            this.elements = this.model.getElements();
        }
        return this.elements;
    }

    public ModelMap getModels() {
        if (this.models == null) {
            this.models = this.model.getModels();
        }
        return this.models;
    }

    public String getName() {
        return this.model.getName();
    }

    public String getPath(String str) {
        Expression expression = this.model.getExpression();
        if (expression == null) {
            return str;
        }
        return expression.getElement(str);
    }

    public String getPrefix() {
        return this.model.getPrefix();
    }

    public Section getSection(String str) {
        Model take;
        ModelList modelList = (ModelList) getModels().get(str);
        if (modelList == null || (take = modelList.take()) == null) {
            return null;
        }
        return new ModelSection(take);
    }

    public Label getText() {
        return this.model.getText();
    }

    public boolean isSection(String str) {
        if (getModels().get(str) != null) {
            return true;
        }
        return false;
    }

    public Iterator<String> iterator() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.model) {
            arrayList.add(add);
        }
        return arrayList.iterator();
    }
}
