package b3;

public enum p0 {
    TRUE,
    FALSE,
    DEFAULT;

    public static boolean b(Boolean bool, Boolean bool2) {
        if (bool != null) {
            return bool.equals(bool2);
        }
        if (bool2 == null) {
            return true;
        }
        return false;
    }

    public Boolean a() {
        if (this == DEFAULT) {
            return null;
        }
        if (this == TRUE) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
