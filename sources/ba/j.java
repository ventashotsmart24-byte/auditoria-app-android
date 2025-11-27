package ba;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import y9.c;
import y9.e;

public abstract class j {
    public static final g d(Matcher matcher, int i10, CharSequence charSequence) {
        if (!matcher.find(i10)) {
            return null;
        }
        return new h(matcher, charSequence);
    }

    public static final c e(MatchResult matchResult) {
        return e.f(matchResult.start(), matchResult.end());
    }

    public static final c f(MatchResult matchResult, int i10) {
        return e.f(matchResult.start(i10), matchResult.end(i10));
    }
}
