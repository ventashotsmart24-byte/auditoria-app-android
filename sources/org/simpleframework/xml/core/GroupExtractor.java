package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

class GroupExtractor implements Group {
    private final LabelMap elements;
    private final ExtractorFactory factory;
    private final Annotation label;
    private final Registry registry;

    public static class Registry extends LinkedHashMap<Class, Label> implements Iterable<Label> {
        private LabelMap elements;
        private Label text;

        public Registry(LabelMap labelMap) {
            this.elements = labelMap;
        }

        private void registerElement(Class cls, Label label) {
            String name = label.getName();
            if (!this.elements.containsKey(name)) {
                this.elements.put(name, label);
            }
            if (!containsKey(cls)) {
                put(cls, label);
            }
        }

        private void registerText(Label label) {
            Text text2 = (Text) label.getContact().getAnnotation(Text.class);
            if (text2 != null) {
                this.text = new TextListLabel(label, text2);
            }
        }

        private Label resolveElement(Class cls) {
            while (cls != null) {
                Label label = (Label) get(cls);
                if (label != null) {
                    return label;
                }
                cls = cls.getSuperclass();
            }
            return null;
        }

        public boolean isText() {
            if (this.text != null) {
                return true;
            }
            return false;
        }

        public Iterator<Label> iterator() {
            return values().iterator();
        }

        public void register(Class cls, Label label) {
            CacheLabel cacheLabel = new CacheLabel(label);
            registerElement(cls, cacheLabel);
            registerText(cacheLabel);
        }

        public Label resolve(Class cls) {
            Label resolveText = resolveText(cls);
            if (resolveText == null) {
                return resolveElement(cls);
            }
            return resolveText;
        }

        public Label resolveText() {
            return resolveText(String.class);
        }

        private Label resolveText(Class cls) {
            Label label = this.text;
            if (label == null || cls != String.class) {
                return null;
            }
            return label;
        }
    }

    public GroupExtractor(Contact contact, Annotation annotation, Format format) {
        this.factory = new ExtractorFactory(contact, annotation, format);
        LabelMap labelMap = new LabelMap();
        this.elements = labelMap;
        this.registry = new Registry(labelMap);
        this.label = annotation;
        extract();
    }

    private void extract() {
        Extractor instance = this.factory.getInstance();
        if (instance != null) {
            extract(instance);
        }
    }

    public LabelMap getElements() {
        return this.elements.getLabels();
    }

    public Label getLabel(Class cls) {
        return this.registry.resolve(cls);
    }

    public String[] getNames() {
        return this.elements.getKeys();
    }

    public String[] getPaths() {
        return this.elements.getPaths();
    }

    public Label getText() {
        return this.registry.resolveText();
    }

    public boolean isDeclared(Class cls) {
        return this.registry.containsKey(cls);
    }

    public boolean isInline() {
        Iterator<Label> it = this.registry.iterator();
        while (it.hasNext()) {
            if (!it.next().isInline()) {
                return false;
            }
        }
        return !this.registry.isEmpty();
    }

    public boolean isTextList() {
        return this.registry.isText();
    }

    public boolean isValid(Class cls) {
        if (this.registry.resolve(cls) != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.label.toString();
    }

    private void extract(Extractor extractor) {
        for (Annotation extract : extractor.getAnnotations()) {
            extract(extractor, extract);
        }
    }

    private void extract(Extractor extractor, Annotation annotation) {
        Label label2 = extractor.getLabel(annotation);
        Class type = extractor.getType(annotation);
        Registry registry2 = this.registry;
        if (registry2 != null) {
            registry2.register(type, label2);
        }
    }
}
