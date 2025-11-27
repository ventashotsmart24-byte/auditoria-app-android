package io.jsonwebtoken.io;

class Base64UrlEncoder extends Base64Encoder {
    public Base64UrlEncoder() {
        super(Base64.URL_SAFE);
    }
}
