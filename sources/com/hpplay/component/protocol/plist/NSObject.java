package com.hpplay.component.protocol.plist;

import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import com.umeng.analytics.pro.bt;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class NSObject implements Cloneable {
    static final int ASCII_LINE_LENGTH = 80;
    private static final String INDENT = "\t";
    static final String NEWLINE = System.getProperty("line.separator");

    private Object[] deserializeArray() {
        NSObject[] array = ((NSArray) this).getArray();
        Object[] objArr = new Object[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            objArr[i10] = array[i10].toJavaObject();
        }
        return objArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object deserializeCollection(com.hpplay.component.protocol.plist.NSObject r6, java.lang.Class<?> r7, java.lang.reflect.Type[] r8) {
        /*
            r5 = this;
            boolean r0 = r7.isInterface()
            if (r0 != 0) goto L_0x0018
            int r0 = r7.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
            if (r0 == 0) goto L_0x0011
            goto L_0x0018
        L_0x0011:
            java.lang.Object r7 = getInstance(r7)
            java.util.Collection r7 = (java.util.Collection) r7
            goto L_0x0033
        L_0x0018:
            java.lang.Class<java.util.List> r0 = java.util.List.class
            boolean r0 = r0.isAssignableFrom(r7)
            if (r0 == 0) goto L_0x0026
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            goto L_0x0033
        L_0x0026:
            java.lang.Class<java.util.Set> r0 = java.util.Set.class
            boolean r0 = r0.isAssignableFrom(r7)
            if (r0 == 0) goto L_0x00c1
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>()
        L_0x0033:
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L_0x0060
            int r2 = r8.length
            if (r2 <= 0) goto L_0x0060
            r2 = r8[r0]
            boolean r3 = r2 instanceof java.lang.reflect.ParameterizedType
            if (r3 == 0) goto L_0x0057
            java.lang.reflect.ParameterizedType r2 = (java.lang.reflect.ParameterizedType) r2
            java.lang.reflect.Type r1 = r2.getRawType()
            java.lang.String r1 = r1.toString()
            java.lang.Class r1 = getClassForName(r1)
            r8 = r8[r0]
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8
            java.lang.reflect.Type[] r8 = r8.getActualTypeArguments()
            goto L_0x0065
        L_0x0057:
            java.lang.String r8 = r2.toString()
            java.lang.Class r8 = getClassForName(r8)
            goto L_0x0062
        L_0x0060:
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
        L_0x0062:
            r4 = r1
            r1 = r8
            r8 = r4
        L_0x0065:
            boolean r2 = r6 instanceof com.hpplay.component.protocol.plist.NSArray
            if (r2 == 0) goto L_0x007f
            com.hpplay.component.protocol.plist.NSArray r6 = (com.hpplay.component.protocol.plist.NSArray) r6
            com.hpplay.component.protocol.plist.NSObject[] r6 = r6.getArray()
            int r2 = r6.length
        L_0x0070:
            if (r0 >= r2) goto L_0x007e
            r3 = r6[r0]
            java.lang.Object r3 = r5.toJavaObject(r3, r1, r8)
            r7.add(r3)
            int r0 = r0 + 1
            goto L_0x0070
        L_0x007e:
            return r7
        L_0x007f:
            boolean r0 = r6 instanceof com.hpplay.component.protocol.plist.NSSet
            if (r0 == 0) goto L_0x00a2
            com.hpplay.component.protocol.plist.NSSet r6 = (com.hpplay.component.protocol.plist.NSSet) r6
            java.util.Set r6 = r6.getSet()
            java.util.Iterator r6 = r6.iterator()
        L_0x008d:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x00a1
            java.lang.Object r0 = r6.next()
            com.hpplay.component.protocol.plist.NSObject r0 = (com.hpplay.component.protocol.plist.NSObject) r0
            java.lang.Object r0 = r5.toJavaObject(r0, r1, r8)
            r7.add(r0)
            goto L_0x008d
        L_0x00a1:
            return r7
        L_0x00a2:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unknown NS* type "
            r8.append(r0)
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getSimpleName()
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L_0x00c1:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Could not find a proper implementation for "
            r8.append(r0)
            java.lang.String r7 = r7.getSimpleName()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            goto L_0x00dd
        L_0x00dc:
            throw r6
        L_0x00dd:
            goto L_0x00dc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.plist.NSObject.deserializeCollection(com.hpplay.component.protocol.plist.NSObject, java.lang.Class, java.lang.reflect.Type[]):java.lang.Object");
    }

    private static Object deserializeData(NSData nSData, Class<?> cls) {
        if (cls == Byte.TYPE) {
            return nSData.bytes();
        }
        if (cls == Byte.class) {
            byte[] bytes = nSData.bytes();
            Object newInstance = Array.newInstance(cls, bytes.length);
            for (int i10 = 0; i10 < bytes.length; i10++) {
                Array.set(newInstance, i10, Byte.valueOf(bytes[i10]));
            }
            return newInstance;
        }
        throw new IllegalArgumentException("NSData can only be mapped to byte[] or Byte[].");
    }

    private static Date deserializeDate(NSDate nSDate, Class<?> cls) {
        if (cls == Date.class) {
            return nSDate.getDate();
        }
        if (cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
            return nSDate.getDate();
        }
        Date date = (Date) getInstance(cls);
        date.setTime(nSDate.getDate().getTime());
        return date;
    }

    private HashMap<String, Object> deserializeMap() {
        HashMap<String, NSObject> hashMap = ((NSDictionary) this).getHashMap();
        HashMap<String, Object> hashMap2 = new HashMap<>(hashMap.size());
        for (String next : hashMap.keySet()) {
            hashMap2.put(next, hashMap.get(next).toJavaObject());
        }
        return hashMap2;
    }

    private Object deserializeNumber() {
        NSNumber nSNumber = (NSNumber) this;
        int type = nSNumber.type();
        if (type == 0) {
            long longValue = nSNumber.longValue();
            if (longValue > TTL.MAX_VALUE || longValue < -2147483648L) {
                return Long.valueOf(longValue);
            }
            return Integer.valueOf(nSNumber.intValue());
        } else if (type == 1) {
            return Double.valueOf(nSNumber.doubleValue());
        } else {
            if (type != 2) {
                return Double.valueOf(nSNumber.doubleValue());
            }
            return Boolean.valueOf(nSNumber.boolValue());
        }
    }

    private Object deserializeObject(NSDictionary nSDictionary, Class<?> cls, Type[] typeArr) {
        Type[] typeArr2;
        HashMap<String, NSObject> hashMap = nSDictionary.getHashMap();
        if (Map.class.isAssignableFrom(cls)) {
            return deserializeMap(cls, typeArr, hashMap);
        }
        Object instance = getInstance(cls);
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (name.startsWith("get")) {
                hashMap2.put(makeFirstCharLowercase(name.substring(3)), method);
            } else if (name.startsWith("set")) {
                hashMap3.put(makeFirstCharLowercase(name.substring(3)), method);
            } else if (name.startsWith(bt.ae)) {
                hashMap2.put(makeFirstCharLowercase(name.substring(2)), method);
            }
        }
        for (Map.Entry next : hashMap.entrySet()) {
            Method method2 = (Method) hashMap3.get(makeFirstCharLowercase((String) next.getKey()));
            Method method3 = (Method) hashMap2.get(makeFirstCharLowercase((String) next.getKey()));
            if (!(method2 == null || method3 == null)) {
                Class<?> returnType = method3.getReturnType();
                Type genericReturnType = method3.getGenericReturnType();
                if (genericReturnType instanceof ParameterizedType) {
                    typeArr2 = ((ParameterizedType) genericReturnType).getActualTypeArguments();
                } else {
                    typeArr2 = null;
                }
                try {
                    method2.invoke(instance, new Object[]{toJavaObject((NSObject) next.getValue(), returnType, typeArr2)});
                } catch (IllegalAccessException unused) {
                    throw new IllegalArgumentException("Could not access setter " + method2);
                } catch (InvocationTargetException unused2) {
                    throw new IllegalArgumentException("Could not invoke setter " + method2);
                }
            }
        }
        return instance;
    }

    private Set<Object> deserializeSet() {
        Set<Object> set;
        Set<NSObject> set2 = ((NSSet) this).getSet();
        if (set2 instanceof LinkedHashSet) {
            set = new LinkedHashSet<>(set2.size());
        } else {
            set = new TreeSet<>();
        }
        for (NSObject javaObject : set2) {
            set.add(javaObject.toJavaObject());
        }
        return set;
    }

    private static Object deserializeSimple(NSObject nSObject, Class<?> cls) {
        if (nSObject instanceof NSNumber) {
            return deserializeNumber((NSNumber) nSObject, cls);
        }
        if (nSObject instanceof NSDate) {
            return deserializeDate((NSDate) nSObject, cls);
        }
        if (nSObject instanceof NSString) {
            return ((NSString) nSObject).getContent();
        }
        throw new IllegalArgumentException("Cannot map " + nSObject.getClass().getSimpleName() + " to " + cls.getSimpleName());
    }

    private static NSObject fromArray(Object obj, Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType == Byte.TYPE || componentType == Byte.class) {
            return fromData(obj);
        }
        int length = Array.getLength(obj);
        NSObject[] nSObjectArr = new NSObject[length];
        for (int i10 = 0; i10 < length; i10++) {
            nSObjectArr[i10] = fromJavaObject(Array.get(obj, i10));
        }
        return new NSArray(nSObjectArr);
    }

    private static NSArray fromCollection(Collection<?> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object fromJavaObject : collection) {
            arrayList.add(fromJavaObject(fromJavaObject));
        }
        return new NSArray((NSObject[]) arrayList.toArray(new NSObject[arrayList.size()]));
    }

    private static NSData fromData(Object obj) {
        int length = Array.getLength(obj);
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = ((Byte) Array.get(obj, i10)).byteValue();
        }
        return new NSData(bArr);
    }

    public static NSObject fromJavaObject(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof NSObject) {
            return (NSObject) obj;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            return fromArray(obj, cls);
        }
        if (isSimple(cls)) {
            return fromSimple(obj, cls);
        }
        if (Set.class.isAssignableFrom(cls)) {
            return fromSet((Set) obj);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return fromMap((Map) obj);
        }
        if (Collection.class.isAssignableFrom(cls)) {
            return fromCollection((Collection) obj);
        }
        return fromPojo(obj, cls);
    }

    private static NSDictionary fromMap(Map<?, ?> map) {
        NSDictionary nSDictionary = new NSDictionary();
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() instanceof String) {
                nSDictionary.put((String) next.getKey(), fromJavaObject(next.getValue()));
            } else {
                throw new IllegalArgumentException("Maps need a String key for mapping to NSDictionary.");
            }
        }
        return nSDictionary;
    }

    private static NSDictionary fromPojo(Object obj, Class<?> cls) {
        String str;
        NSDictionary nSDictionary = new NSDictionary();
        for (Method method : cls.getMethods()) {
            if (!Modifier.isNative(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length == 0) {
                String name = method.getName();
                if (name.startsWith("get")) {
                    str = makeFirstCharLowercase(name.substring(3));
                } else if (name.startsWith(bt.ae)) {
                    str = makeFirstCharLowercase(name.substring(2));
                }
                try {
                    nSDictionary.put(str, fromJavaObject(method.invoke(obj, new Object[0])));
                } catch (IllegalAccessException unused) {
                    throw new IllegalArgumentException("Could not access getter " + method.getName());
                } catch (InvocationTargetException unused2) {
                    throw new IllegalArgumentException("Could not invoke getter " + method.getName());
                }
            }
        }
        for (Field field : cls.getFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                try {
                    nSDictionary.put(field.getName(), fromJavaObject(field.get(obj)));
                } catch (IllegalAccessException unused3) {
                    throw new IllegalArgumentException("Could not access field " + field.getName());
                }
            }
        }
        return nSDictionary;
    }

    private static NSSet fromSet(Set<?> set) {
        NSSet nSSet = new NSSet();
        for (Object fromJavaObject : set) {
            nSSet.addObject(fromJavaObject(fromJavaObject));
        }
        return nSSet;
    }

    private static NSObject fromSimple(Object obj, Class<?> cls) {
        if ((obj instanceof Long) || cls == Long.TYPE) {
            return new NSNumber(((Long) obj).longValue());
        }
        if ((obj instanceof Integer) || cls == Integer.TYPE) {
            return new NSNumber(((Integer) obj).intValue());
        }
        if ((obj instanceof Short) || cls == Short.TYPE) {
            return new NSNumber((int) ((Short) obj).shortValue());
        }
        if ((obj instanceof Byte) || cls == Byte.TYPE) {
            return new NSNumber((int) ((Byte) obj).byteValue());
        }
        if ((obj instanceof Double) || cls == Double.TYPE) {
            return new NSNumber(((Double) obj).doubleValue());
        }
        if ((obj instanceof Float) || cls == Float.TYPE) {
            return new NSNumber((double) ((Float) obj).floatValue());
        }
        if ((obj instanceof Boolean) || cls == Boolean.TYPE) {
            return new NSNumber(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Date) {
            return new NSDate((Date) obj);
        }
        if (cls == String.class) {
            return new NSString((String) obj);
        }
        throw new IllegalArgumentException("Cannot map " + cls.getSimpleName() + " as a simple type.");
    }

    private static Class<?> getClassForName(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            str = str.substring(indexOf + 1);
        }
        if ("double".equals(str)) {
            return Double.TYPE;
        }
        if ("float".equals(str)) {
            return Float.TYPE;
        }
        if ("int".equals(str)) {
            return Integer.TYPE;
        }
        if ("long".equals(str)) {
            return Long.TYPE;
        }
        if ("short".equals(str)) {
            return Short.TYPE;
        }
        if ("boolean".equals(str)) {
            return Boolean.TYPE;
        }
        if ("byte".equals(str)) {
            return Byte.TYPE;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new IllegalArgumentException("Could not load class " + str, e10);
        }
    }

    private static Object getInstance(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException unused) {
            throw new IllegalArgumentException("Could not instantiate class " + cls.getSimpleName());
        } catch (IllegalAccessException unused2) {
            throw new IllegalArgumentException("Could not instantiate class " + cls.getSimpleName());
        }
    }

    private static boolean isSimple(Class<?> cls) {
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls) || cls == String.class || Date.class.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    private static String makeFirstCharLowercase(String str) {
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public void assignIDs(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.assignID(this);
    }

    public abstract NSObject clone();

    public void indent(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append("\t");
        }
    }

    public abstract void toASCII(StringBuilder sb, int i10);

    public abstract void toASCIIGnuStep(StringBuilder sb, int i10);

    public abstract void toBinary(BinaryPropertyListWriter binaryPropertyListWriter);

    public Object toJavaObject() {
        if (this instanceof NSArray) {
            return deserializeArray();
        }
        if (this instanceof NSDictionary) {
            return deserializeMap();
        }
        if (this instanceof NSSet) {
            return deserializeSet();
        }
        if (this instanceof NSNumber) {
            return deserializeNumber();
        }
        if (this instanceof NSString) {
            return ((NSString) this).getContent();
        }
        if (this instanceof NSData) {
            return ((NSData) this).bytes();
        }
        if (this instanceof NSDate) {
            return ((NSDate) this).getDate();
        }
        return this instanceof UID ? ((UID) this).getBytes() : this;
    }

    public abstract void toXML(StringBuilder sb, int i10);

    public String toXMLPropertyList() {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        String str = NEWLINE;
        sb.append(str);
        sb.append("<!DOCTYPE plist PUBLIC \"-//Lebo//DTD PLIST 1.0//EN\" \"https://www.lebo.cn/DTDs/PropertyList-1.0.dtd\">");
        sb.append(str);
        sb.append("<plist version=\"1.0\">");
        sb.append(str);
        toXML(sb, 0);
        sb.append(str);
        sb.append("</plist>");
        return sb.toString();
    }

    private Object deserializeArray(NSObject nSObject, Class<?> cls) {
        Class<?> classForName = getClassForName(cls.getComponentType().getName());
        int i10 = 0;
        if (nSObject instanceof NSArray) {
            NSObject[] array = ((NSArray) nSObject).getArray();
            Object newInstance = Array.newInstance(classForName, array.length);
            while (i10 < array.length) {
                Array.set(newInstance, i10, toJavaObject(array[i10], classForName, (Type[]) null));
                i10++;
            }
            return newInstance;
        } else if (nSObject instanceof NSSet) {
            Set<NSObject> set = ((NSSet) nSObject).getSet();
            Object newInstance2 = Array.newInstance(classForName, set.size());
            for (NSObject javaObject : set) {
                Array.set(newInstance2, i10, toJavaObject(javaObject, classForName, (Type[]) null));
                i10++;
            }
            return newInstance2;
        } else if (nSObject instanceof NSData) {
            return deserializeData((NSData) nSObject, classForName);
        } else {
            throw new IllegalArgumentException("Unable to map " + nSObject.getClass().getSimpleName() + " to " + cls.getName());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059 A[LOOP:0: B:17:0x0053->B:19:0x0059, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object deserializeMap(java.lang.Class<?> r5, java.lang.reflect.Type[] r6, java.util.Map<java.lang.String, com.hpplay.component.protocol.plist.NSObject> r7) {
        /*
            r4 = this;
            boolean r0 = r5.isInterface()
            if (r0 != 0) goto L_0x0018
            int r0 = r5.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
            if (r0 == 0) goto L_0x0011
            goto L_0x0018
        L_0x0011:
            java.lang.Object r5 = getInstance(r5)
            java.util.Map r5 = (java.util.Map) r5
            goto L_0x001d
        L_0x0018:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
        L_0x001d:
            r0 = 0
            if (r6 == 0) goto L_0x0046
            int r1 = r6.length
            r2 = 1
            if (r1 <= r2) goto L_0x0046
            r6 = r6[r2]
            boolean r1 = r6 instanceof java.lang.reflect.ParameterizedType
            if (r1 == 0) goto L_0x003d
            java.lang.reflect.ParameterizedType r6 = (java.lang.reflect.ParameterizedType) r6
            java.lang.reflect.Type r0 = r6.getRawType()
            java.lang.String r0 = r0.toString()
            java.lang.Class r0 = getClassForName(r0)
            java.lang.reflect.Type[] r6 = r6.getActualTypeArguments()
            goto L_0x004b
        L_0x003d:
            java.lang.String r6 = r6.toString()
            java.lang.Class r6 = getClassForName(r6)
            goto L_0x0048
        L_0x0046:
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
        L_0x0048:
            r3 = r0
            r0 = r6
            r6 = r3
        L_0x004b:
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0053:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0071
            java.lang.Object r1 = r7.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            com.hpplay.component.protocol.plist.NSObject r1 = (com.hpplay.component.protocol.plist.NSObject) r1
            java.lang.Object r1 = r4.toJavaObject(r1, r0, r6)
            r5.put(r2, r1)
            goto L_0x0053
        L_0x0071:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.plist.NSObject.deserializeMap(java.lang.Class, java.lang.reflect.Type[], java.util.Map):java.lang.Object");
    }

    private static Object deserializeNumber(NSNumber nSNumber, Class<?> cls) {
        if (nSNumber.isInteger()) {
            if (cls == Long.TYPE || cls == Long.class) {
                return Long.valueOf(nSNumber.longValue());
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return Integer.valueOf(nSNumber.intValue());
            }
            if (cls == Short.TYPE || cls == Short.class) {
                return Short.valueOf((short) nSNumber.intValue());
            }
            if (cls == Byte.TYPE || cls == Byte.class) {
                return Byte.valueOf((byte) nSNumber.intValue());
            }
        }
        if (nSNumber.isInteger() || nSNumber.isReal()) {
            if (cls == Double.TYPE || cls == Double.class) {
                return Double.valueOf(nSNumber.doubleValue());
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return Float.valueOf(nSNumber.floatValue());
            }
        }
        if (nSNumber.isBoolean() && (cls == Boolean.TYPE || cls == Boolean.class)) {
            return Boolean.valueOf(nSNumber.boolValue());
        }
        throw new IllegalArgumentException("Cannot map NSNumber to " + cls.getSimpleName());
    }

    public <T> T toJavaObject(Class<T> cls) {
        return toJavaObject(this, cls, (Type[]) null);
    }

    private Object toJavaObject(NSObject nSObject, Class<?> cls, Type[] typeArr) {
        if (cls.isArray()) {
            return deserializeArray(nSObject, cls);
        }
        if (isSimple(cls)) {
            return deserializeSimple(nSObject, cls);
        }
        if (cls == Object.class && !(nSObject instanceof NSSet) && !(nSObject instanceof NSArray)) {
            return deserializeSimple(nSObject, cls);
        }
        Class<Collection> cls2 = Collection.class;
        if ((nSObject instanceof NSSet) && cls2.isAssignableFrom(cls)) {
            return deserializeCollection(nSObject, cls, typeArr);
        }
        if ((nSObject instanceof NSArray) && cls2.isAssignableFrom(cls)) {
            return deserializeCollection(nSObject, cls, typeArr);
        }
        if (nSObject instanceof NSDictionary) {
            return deserializeObject((NSDictionary) nSObject, cls, typeArr);
        }
        throw new IllegalArgumentException("Cannot process " + cls.getSimpleName());
    }
}
