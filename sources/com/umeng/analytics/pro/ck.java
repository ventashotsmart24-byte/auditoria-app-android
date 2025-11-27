package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import java.nio.ByteBuffer;

public class ck {

    /* renamed from: a  reason: collision with root package name */
    private final dg f14049a;

    /* renamed from: b  reason: collision with root package name */
    private final dt f14050b;

    public ck() {
        this(new da.a());
    }

    private db j(byte[] bArr, co coVar, co... coVarArr) {
        this.f14050b.a(bArr);
        int length = coVarArr.length + 1;
        co[] coVarArr2 = new co[length];
        int i10 = 0;
        coVarArr2[0] = coVar;
        int i11 = 0;
        while (i11 < coVarArr.length) {
            int i12 = i11 + 1;
            coVarArr2[i12] = coVarArr[i11];
            i11 = i12;
        }
        this.f14049a.j();
        db dbVar = null;
        while (i10 < length) {
            dbVar = this.f14049a.l();
            if (dbVar.f14130b == 0 || dbVar.f14131c > coVarArr2[i10].a()) {
                return null;
            }
            if (dbVar.f14131c != coVarArr2[i10].a()) {
                dj.a(this.f14049a, dbVar.f14130b);
                this.f14049a.m();
            } else {
                i10++;
                if (i10 < length) {
                    this.f14049a.j();
                }
            }
        }
        return dbVar;
    }

    public void a(ch chVar, byte[] bArr) {
        try {
            this.f14050b.a(bArr);
            chVar.read(this.f14049a);
        } finally {
            this.f14050b.e();
            this.f14049a.B();
        }
    }

    public Byte b(byte[] bArr, co coVar, co... coVarArr) {
        return (Byte) a((byte) 3, bArr, coVar, coVarArr);
    }

    public Double c(byte[] bArr, co coVar, co... coVarArr) {
        return (Double) a((byte) 4, bArr, coVar, coVarArr);
    }

    public Short d(byte[] bArr, co coVar, co... coVarArr) {
        return (Short) a((byte) 6, bArr, coVar, coVarArr);
    }

    public Integer e(byte[] bArr, co coVar, co... coVarArr) {
        return (Integer) a((byte) 8, bArr, coVar, coVarArr);
    }

    public Long f(byte[] bArr, co coVar, co... coVarArr) {
        return (Long) a((byte) 10, bArr, coVar, coVarArr);
    }

    public String g(byte[] bArr, co coVar, co... coVarArr) {
        return (String) a((byte) 11, bArr, coVar, coVarArr);
    }

    public ByteBuffer h(byte[] bArr, co coVar, co... coVarArr) {
        return (ByteBuffer) a((byte) 100, bArr, coVar, coVarArr);
    }

    public Short i(byte[] bArr, co coVar, co... coVarArr) {
        try {
            if (j(bArr, coVar, coVarArr) != null) {
                this.f14049a.j();
                Short valueOf = Short.valueOf(this.f14049a.l().f14131c);
                this.f14050b.e();
                this.f14049a.B();
                return valueOf;
            }
            this.f14050b.e();
            this.f14049a.B();
            return null;
        } catch (Exception e10) {
            throw new cn((Throwable) e10);
        } catch (Throwable th) {
            this.f14050b.e();
            this.f14049a.B();
            throw th;
        }
    }

    public ck(di diVar) {
        dt dtVar = new dt();
        this.f14050b = dtVar;
        this.f14049a = diVar.a(dtVar);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:5|6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0025, code lost:
        throw new com.umeng.analytics.pro.cn("JVM DOES NOT SUPPORT ENCODING: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r1.f14049a.B();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.umeng.analytics.pro.ch r2, java.lang.String r3, java.lang.String r4) {
        /*
            r1 = this;
            byte[] r3 = r3.getBytes(r4)     // Catch:{ UnsupportedEncodingException -> 0x000f }
            r1.a((com.umeng.analytics.pro.ch) r2, (byte[]) r3)     // Catch:{ UnsupportedEncodingException -> 0x000f }
            com.umeng.analytics.pro.dg r2 = r1.f14049a
            r2.B()
            return
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            com.umeng.analytics.pro.cn r2 = new com.umeng.analytics.pro.cn     // Catch:{ all -> 0x000d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x000d }
            r3.<init>()     // Catch:{ all -> 0x000d }
            java.lang.String r0 = "JVM DOES NOT SUPPORT ENCODING: "
            r3.append(r0)     // Catch:{ all -> 0x000d }
            r3.append(r4)     // Catch:{ all -> 0x000d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x000d }
            r2.<init>((java.lang.String) r3)     // Catch:{ all -> 0x000d }
            throw r2     // Catch:{ all -> 0x000d }
        L_0x0026:
            com.umeng.analytics.pro.dg r3 = r1.f14049a
            r3.B()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.ck.a(com.umeng.analytics.pro.ch, java.lang.String, java.lang.String):void");
    }

    public void a(ch chVar, byte[] bArr, co coVar, co... coVarArr) {
        try {
            if (j(bArr, coVar, coVarArr) != null) {
                chVar.read(this.f14049a);
            }
            this.f14050b.e();
            this.f14049a.B();
        } catch (Exception e10) {
            throw new cn((Throwable) e10);
        } catch (Throwable th) {
            this.f14050b.e();
            this.f14049a.B();
            throw th;
        }
    }

    public Boolean a(byte[] bArr, co coVar, co... coVarArr) {
        return (Boolean) a((byte) 2, bArr, coVar, coVarArr);
    }

    private Object a(byte b10, byte[] bArr, co coVar, co... coVarArr) {
        try {
            db j10 = j(bArr, coVar, coVarArr);
            if (j10 != null) {
                if (b10 != 2) {
                    if (b10 != 3) {
                        if (b10 != 4) {
                            if (b10 != 6) {
                                if (b10 != 8) {
                                    if (b10 != 100) {
                                        if (b10 != 10) {
                                            if (b10 == 11) {
                                                if (j10.f14130b == 11) {
                                                    String z10 = this.f14049a.z();
                                                    this.f14050b.e();
                                                    this.f14049a.B();
                                                    return z10;
                                                }
                                            }
                                        } else if (j10.f14130b == 10) {
                                            Long valueOf = Long.valueOf(this.f14049a.x());
                                            this.f14050b.e();
                                            this.f14049a.B();
                                            return valueOf;
                                        }
                                    } else if (j10.f14130b == 11) {
                                        ByteBuffer A = this.f14049a.A();
                                        this.f14050b.e();
                                        this.f14049a.B();
                                        return A;
                                    }
                                } else if (j10.f14130b == 8) {
                                    Integer valueOf2 = Integer.valueOf(this.f14049a.w());
                                    this.f14050b.e();
                                    this.f14049a.B();
                                    return valueOf2;
                                }
                            } else if (j10.f14130b == 6) {
                                Short valueOf3 = Short.valueOf(this.f14049a.v());
                                this.f14050b.e();
                                this.f14049a.B();
                                return valueOf3;
                            }
                        } else if (j10.f14130b == 4) {
                            Double valueOf4 = Double.valueOf(this.f14049a.y());
                            this.f14050b.e();
                            this.f14049a.B();
                            return valueOf4;
                        }
                    } else if (j10.f14130b == 3) {
                        Byte valueOf5 = Byte.valueOf(this.f14049a.u());
                        this.f14050b.e();
                        this.f14049a.B();
                        return valueOf5;
                    }
                } else if (j10.f14130b == 2) {
                    Boolean valueOf6 = Boolean.valueOf(this.f14049a.t());
                    this.f14050b.e();
                    this.f14049a.B();
                    return valueOf6;
                }
            }
            this.f14050b.e();
            this.f14049a.B();
            return null;
        } catch (Exception e10) {
            throw new cn((Throwable) e10);
        } catch (Throwable th) {
            this.f14050b.e();
            this.f14049a.B();
            throw th;
        }
    }

    public void a(ch chVar, String str) {
        a(chVar, str.getBytes());
    }
}
