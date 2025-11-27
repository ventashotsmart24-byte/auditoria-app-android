package org.simpleframework.xml.core;

import com.hpplay.cybergarage.xml.XML;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeBuilder;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.Matcher;

public class Persister implements Serializer {
    private final Format format;
    private final SessionManager manager;
    private final Strategy strategy;
    private final Support support;

    public Persister() {
        this((Map) new HashMap());
    }

    public <T> T read(Class<? extends T> cls, String str) {
        return read(cls, str, true);
    }

    public boolean validate(Class cls, String str) {
        return validate(cls, str, true);
    }

    public void write(Object obj, OutputNode outputNode) {
        try {
            write(obj, outputNode, this.manager.open());
        } finally {
            this.manager.close();
        }
    }

    public Persister(Format format2) {
        this((Strategy) new TreeStrategy(), format2);
    }

    public <T> T read(Class<? extends T> cls, File file) {
        return read(cls, file, true);
    }

    public boolean validate(Class cls, File file) {
        return validate(cls, file, true);
    }

    public Persister(Map map) {
        this((Filter) new PlatformFilter(map));
    }

    public <T> T read(Class<? extends T> cls, InputStream inputStream) {
        return read(cls, inputStream, true);
    }

    public boolean validate(Class cls, InputStream inputStream) {
        return validate(cls, inputStream, true);
    }

    public Persister(Map map, Format format2) {
        this((Filter) new PlatformFilter(map));
    }

    private void write(Object obj, OutputNode outputNode, Session session) {
        write(obj, outputNode, (Context) new Source(this.strategy, this.support, session));
    }

    public <T> T read(Class<? extends T> cls, Reader reader) {
        return read(cls, reader, true);
    }

    public boolean validate(Class cls, Reader reader) {
        return validate(cls, reader, true);
    }

    public Persister(Filter filter) {
        this((Strategy) new TreeStrategy(), filter);
    }

    private void write(Object obj, OutputNode outputNode, Context context) {
        new Traverser(context).write(outputNode, obj);
    }

    public <T> T read(Class<? extends T> cls, InputNode inputNode) {
        return read(cls, inputNode, true);
    }

    public boolean validate(Class cls, InputNode inputNode) {
        return validate(cls, inputNode, true);
    }

    public Persister(Filter filter, Format format2) {
        this((Strategy) new TreeStrategy(), filter, format2);
    }

    public <T> T read(Class<? extends T> cls, String str, boolean z10) {
        return read(cls, (Reader) new StringReader(str), z10);
    }

    public boolean validate(Class cls, String str, boolean z10) {
        return validate(cls, (Reader) new StringReader(str), z10);
    }

    public void write(Object obj, File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            write(obj, (OutputStream) fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    public Persister(Matcher matcher) {
        this((Strategy) new TreeStrategy(), matcher);
    }

    public <T> T read(Class<? extends T> cls, File file, boolean z10) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return read(cls, (InputStream) fileInputStream, z10);
        } finally {
            fileInputStream.close();
        }
    }

    public boolean validate(Class cls, File file, boolean z10) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return validate(cls, (InputStream) fileInputStream, z10);
        } finally {
            fileInputStream.close();
        }
    }

    public Persister(Matcher matcher, Format format2) {
        this((Strategy) new TreeStrategy(), matcher, format2);
    }

    public Persister(Strategy strategy2) {
        this(strategy2, (Map) new HashMap());
    }

    public void write(Object obj, OutputStream outputStream) {
        write(obj, outputStream, XML.CHARSET_UTF8);
    }

    public Persister(Strategy strategy2, Format format2) {
        this(strategy2, (Map) new HashMap(), format2);
    }

    public <T> T read(Class<? extends T> cls, InputStream inputStream, boolean z10) {
        return read(cls, NodeBuilder.read(inputStream), z10);
    }

    public boolean validate(Class cls, InputStream inputStream, boolean z10) {
        return validate(cls, NodeBuilder.read(inputStream), z10);
    }

    public void write(Object obj, OutputStream outputStream, String str) {
        write(obj, (Writer) new OutputStreamWriter(outputStream, str));
    }

    public Persister(Filter filter, Matcher matcher) {
        this((Strategy) new TreeStrategy(), filter, matcher);
    }

    public <T> T read(Class<? extends T> cls, Reader reader, boolean z10) {
        return read(cls, NodeBuilder.read(reader), z10);
    }

    public boolean validate(Class cls, Reader reader, boolean z10) {
        return validate(cls, NodeBuilder.read(reader), z10);
    }

    public void write(Object obj, Writer writer) {
        write(obj, NodeBuilder.write(writer, this.format));
    }

    public Persister(Filter filter, Matcher matcher, Format format2) {
        this(new TreeStrategy(), filter, matcher, format2);
    }

    public <T> T read(Class<? extends T> cls, InputNode inputNode, boolean z10) {
        try {
            return read(cls, inputNode, this.manager.open(z10));
        } finally {
            this.manager.close();
        }
    }

    public boolean validate(Class cls, InputNode inputNode, boolean z10) {
        try {
            return validate(cls, inputNode, this.manager.open(z10));
        } finally {
            this.manager.close();
        }
    }

    public Persister(Strategy strategy2, Map map) {
        this(strategy2, (Filter) new PlatformFilter(map));
    }

    public Persister(Strategy strategy2, Map map, Format format2) {
        this(strategy2, (Filter) new PlatformFilter(map), format2);
    }

    public Persister(Strategy strategy2, Filter filter) {
        this(strategy2, filter, new Format());
    }

    private <T> T read(Class<? extends T> cls, InputNode inputNode, Session session) {
        return read(cls, inputNode, (Context) new Source(this.strategy, this.support, session));
    }

    private boolean validate(Class cls, InputNode inputNode, Session session) {
        return validate(cls, inputNode, (Context) new Source(this.strategy, this.support, session));
    }

    public Persister(Strategy strategy2, Filter filter, Format format2) {
        this(strategy2, filter, new EmptyMatcher(), format2);
    }

    private <T> T read(Class<? extends T> cls, InputNode inputNode, Context context) {
        return new Traverser(context).read(inputNode, (Class) cls);
    }

    private boolean validate(Class cls, InputNode inputNode, Context context) {
        return new Traverser(context).validate(inputNode, cls);
    }

    public Persister(Strategy strategy2, Matcher matcher) {
        this(strategy2, (Filter) new PlatformFilter(), matcher);
    }

    public <T> T read(T t10, String str) {
        return read(t10, str, true);
    }

    public Persister(Strategy strategy2, Matcher matcher, Format format2) {
        this(strategy2, new PlatformFilter(), matcher, format2);
    }

    public <T> T read(T t10, File file) {
        return read(t10, file, true);
    }

    public Persister(Strategy strategy2, Filter filter, Matcher matcher) {
        this(strategy2, filter, matcher, new Format());
    }

    public <T> T read(T t10, InputStream inputStream) {
        return read(t10, inputStream, true);
    }

    public Persister(Strategy strategy2, Filter filter, Matcher matcher, Format format2) {
        this.support = new Support(filter, matcher, format2);
        this.manager = new SessionManager();
        this.strategy = strategy2;
        this.format = format2;
    }

    public <T> T read(T t10, Reader reader) {
        return read(t10, reader, true);
    }

    public <T> T read(T t10, InputNode inputNode) {
        return read(t10, inputNode, true);
    }

    public <T> T read(T t10, String str, boolean z10) {
        return read(t10, (Reader) new StringReader(str), z10);
    }

    public <T> T read(T t10, File file, boolean z10) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return read(t10, (InputStream) fileInputStream, z10);
        } finally {
            fileInputStream.close();
        }
    }

    public <T> T read(T t10, InputStream inputStream, boolean z10) {
        return read(t10, NodeBuilder.read(inputStream), z10);
    }

    public <T> T read(T t10, Reader reader, boolean z10) {
        return read(t10, NodeBuilder.read(reader), z10);
    }

    public <T> T read(T t10, InputNode inputNode, boolean z10) {
        try {
            return read(t10, inputNode, this.manager.open(z10));
        } finally {
            this.manager.close();
        }
    }

    private <T> T read(T t10, InputNode inputNode, Session session) {
        return read(t10, inputNode, (Context) new Source(this.strategy, this.support, session));
    }

    private <T> T read(T t10, InputNode inputNode, Context context) {
        return new Traverser(context).read(inputNode, (Object) t10);
    }
}
