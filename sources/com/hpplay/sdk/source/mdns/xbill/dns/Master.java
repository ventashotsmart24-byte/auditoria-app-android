package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Master {
    private int currentDClass;
    private long currentTTL;
    private int currentType;
    private long defaultTTL;
    private File file;
    private Generator generator;
    private List generators;
    private Master included;
    private Record last;
    private boolean needSOATTL;
    private boolean noExpandGenerate;
    private Name origin;
    private Tokenizer st;

    public Master(File file2, Name name, long j10) {
        this.last = null;
        this.included = null;
        if (name == null || name.isAbsolute()) {
            this.file = file2;
            this.st = new Tokenizer(file2);
            this.origin = name;
            this.defaultTTL = j10;
        }
    }

    private void endGenerate() {
        this.st.getEOL();
        this.generator = null;
    }

    private Record nextGenerated() {
        try {
            return this.generator.nextRecord();
        } catch (Tokenizer.TokenizerException e10) {
            Tokenizer tokenizer = this.st;
            throw tokenizer.exception("Parsing $GENERATE: " + e10.getBaseMessage());
        } catch (Exception e11) {
            Tokenizer tokenizer2 = this.st;
            throw tokenizer2.exception("Parsing $GENERATE: " + e11.getMessage());
        }
    }

    private Name parseName(String str, Name name) {
        try {
            return Name.fromString(str, name);
        } catch (Exception e10) {
            throw this.st.exception(e10.getMessage());
        }
    }

    private void parseTTLClassAndType() {
        boolean z10;
        String string = this.st.getString();
        int value = DClass.value(string);
        this.currentDClass = value;
        if (value >= 0) {
            string = this.st.getString();
            z10 = true;
        } else {
            z10 = false;
        }
        this.currentTTL = -1;
        try {
            this.currentTTL = TTL.parseTTL(string);
            string = this.st.getString();
        } catch (NumberFormatException unused) {
            long j10 = this.defaultTTL;
            if (j10 >= 0) {
                this.currentTTL = j10;
            } else {
                Record record = this.last;
                if (record != null) {
                    this.currentTTL = record.getTTL();
                }
            }
        }
        if (!z10) {
            int value2 = DClass.value(string);
            this.currentDClass = value2;
            if (value2 >= 0) {
                string = this.st.getString();
            } else {
                this.currentDClass = 1;
            }
        }
        int value3 = Type.value(string);
        this.currentType = value3;
        if (value3 < 0) {
            Tokenizer tokenizer = this.st;
            throw tokenizer.exception("Invalid type '" + string + "'");
        } else if (this.currentTTL >= 0) {
        } else {
            if (value3 == 6) {
                this.needSOATTL = true;
                this.currentTTL = 0;
                return;
            }
            throw this.st.exception("missing TTL");
        }
    }

    private long parseUInt32(String str) {
        if (!Character.isDigit(str.charAt(0))) {
            return -1;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong < 0 || parseLong > 4294967295L) {
                return -1;
            }
            return parseLong;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private void startGenerate() {
        String str;
        long j10;
        String identifier = this.st.getIdentifier();
        int indexOf = identifier.indexOf(Operator.Operation.MINUS);
        if (indexOf >= 0) {
            String substring = identifier.substring(0, indexOf);
            String substring2 = identifier.substring(indexOf + 1);
            int indexOf2 = substring2.indexOf(Operator.Operation.DIVISION);
            if (indexOf2 >= 0) {
                str = substring2.substring(indexOf2 + 1);
                substring2 = substring2.substring(0, indexOf2);
            } else {
                str = null;
            }
            long parseUInt32 = parseUInt32(substring);
            long parseUInt322 = parseUInt32(substring2);
            if (str != null) {
                j10 = parseUInt32(str);
            } else {
                j10 = 1;
            }
            long j11 = j10;
            if (parseUInt32 < 0 || parseUInt322 < 0 || parseUInt32 > parseUInt322 || j11 <= 0) {
                Tokenizer tokenizer = this.st;
                throw tokenizer.exception("Invalid $GENERATE range specifier: " + identifier);
            }
            String identifier2 = this.st.getIdentifier();
            parseTTLClassAndType();
            if (Generator.supportedType(this.currentType)) {
                String identifier3 = this.st.getIdentifier();
                this.st.getEOL();
                this.st.unget();
                this.generator = new Generator(parseUInt32, parseUInt322, j11, identifier2, this.currentType, this.currentDClass, this.currentTTL, identifier3, this.origin);
                if (this.generators == null) {
                    this.generators = new ArrayList(1);
                }
                this.generators.add(this.generator);
                return;
            }
            Tokenizer tokenizer2 = this.st;
            throw tokenizer2.exception("$GENERATE does not support " + Type.string(this.currentType) + " records");
        }
        Tokenizer tokenizer3 = this.st;
        throw tokenizer3.exception("Invalid $GENERATE range specifier: " + identifier);
    }

    public Record _nextRecord() {
        Name name;
        File file2;
        Master master = this.included;
        if (master != null) {
            Record nextRecord = master.nextRecord();
            if (nextRecord != null) {
                return nextRecord;
            }
            this.included = null;
        }
        if (this.generator != null) {
            Record nextGenerated = nextGenerated();
            if (nextGenerated != null) {
                return nextGenerated;
            }
            endGenerate();
        }
        while (true) {
            Tokenizer.Token token = this.st.get(true, false);
            int i10 = token.type;
            if (i10 == 2) {
                int i11 = this.st.get().type;
                if (i11 != 1) {
                    if (i11 == 0) {
                        return null;
                    }
                    this.st.unget();
                    Record record = this.last;
                    if (record != null) {
                        name = record.getName();
                    } else {
                        throw this.st.exception("no owner");
                    }
                }
            } else if (i10 == 1) {
                continue;
            } else if (i10 == 0) {
                return null;
            } else {
                if (token.value.charAt(0) != '$') {
                    name = parseName(token.value, this.origin);
                    Record record2 = this.last;
                    if (record2 != null && name.equals(record2.getName())) {
                        name = this.last.getName();
                    }
                } else {
                    String str = token.value;
                    if (str.equalsIgnoreCase("$ORIGIN")) {
                        this.origin = this.st.getName(Name.root);
                        this.st.getEOL();
                    } else if (str.equalsIgnoreCase("$TTL")) {
                        this.defaultTTL = this.st.getTTL();
                        this.st.getEOL();
                    } else if (str.equalsIgnoreCase("$INCLUDE")) {
                        String string = this.st.getString();
                        File file3 = this.file;
                        if (file3 != null) {
                            file2 = new File(file3.getParent(), string);
                        } else {
                            file2 = new File(string);
                        }
                        Name name2 = this.origin;
                        Tokenizer.Token token2 = this.st.get();
                        if (token2.isString()) {
                            name2 = parseName(token2.value, Name.root);
                            this.st.getEOL();
                        }
                        this.included = new Master(file2, name2, this.defaultTTL);
                        return nextRecord();
                    } else if (!str.equalsIgnoreCase("$GENERATE")) {
                        Tokenizer tokenizer = this.st;
                        throw tokenizer.exception("Invalid directive: " + str);
                    } else if (this.generator == null) {
                        startGenerate();
                        if (!this.noExpandGenerate) {
                            return nextGenerated();
                        }
                        endGenerate();
                    } else {
                        throw new IllegalStateException("cannot nest $GENERATE");
                    }
                }
            }
        }
        parseTTLClassAndType();
        Record fromString = Record.fromString(name, this.currentType, this.currentDClass, this.currentTTL, this.st, this.origin);
        this.last = fromString;
        if (this.needSOATTL) {
            long minimum = ((SOARecord) fromString).getMinimum();
            this.last.setTTL(minimum);
            this.defaultTTL = minimum;
            this.needSOATTL = false;
        }
        return this.last;
    }

    public void expandGenerate(boolean z10) {
        this.noExpandGenerate = !z10;
    }

    public void finalize() {
        Tokenizer tokenizer = this.st;
        if (tokenizer != null) {
            tokenizer.close();
        }
    }

    public Iterator generators() {
        List list;
        List list2 = this.generators;
        if (list2 != null) {
            list = Collections.unmodifiableList(list2);
        } else {
            list = Collections.EMPTY_LIST;
        }
        return list.iterator();
    }

    public Record nextRecord() {
        try {
            Record _nextRecord = _nextRecord();
            if (_nextRecord == null) {
            }
            return _nextRecord;
        } finally {
            this.st.close();
        }
    }

    public Master(String str, Name name, long j10) {
        this(new File(str), name, j10);
    }

    public Master(String str, Name name) {
        this(new File(str), name, -1);
    }

    public Master(String str) {
        this(new File(str), (Name) null, -1);
    }

    public Master(InputStream inputStream, Name name, long j10) {
        this.last = null;
        this.included = null;
        if (name == null || name.isAbsolute()) {
            this.st = new Tokenizer(inputStream);
            this.origin = name;
            this.defaultTTL = j10;
            return;
        }
        throw new RelativeNameException(name);
    }

    public Master(InputStream inputStream, Name name) {
        this(inputStream, name, -1);
    }

    public Master(InputStream inputStream) {
        this(inputStream, (Name) null, -1);
    }
}
