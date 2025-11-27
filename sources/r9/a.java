package r9;

import t9.d;
import t9.i;
import z9.b;

public abstract class a {
    public static final Class a(b bVar) {
        i.g(bVar, "<this>");
        Class a10 = ((d) bVar).a();
        if (!a10.isPrimitive()) {
            i.e(a10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return a10;
        }
        String name = a10.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    a10 = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    a10 = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    a10 = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    a10 = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    a10 = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    a10 = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    a10 = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    a10 = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    a10 = Short.class;
                    break;
                }
                break;
        }
        i.e(a10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return a10;
    }
}
