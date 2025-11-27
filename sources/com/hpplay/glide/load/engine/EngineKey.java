package com.hpplay.glide.load.engine;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.Transformation;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class EngineKey implements Key {
    private static final String EMPTY_LOG_STRING = "";
    private final ResourceDecoder cacheDecoder;
    private final ResourceDecoder decoder;
    private final ResourceEncoder encoder;
    private int hashCode;
    private final int height;
    private final String id;
    private Key originalKey;
    private final Key signature;
    private final Encoder sourceEncoder;
    private String stringKey;
    private final ResourceTranscoder transcoder;
    private final Transformation transformation;
    private final int width;

    public EngineKey(String str, Key key, int i10, int i11, ResourceDecoder resourceDecoder, ResourceDecoder resourceDecoder2, Transformation transformation2, ResourceEncoder resourceEncoder, ResourceTranscoder resourceTranscoder, Encoder encoder2) {
        this.id = str;
        this.signature = key;
        this.width = i10;
        this.height = i11;
        this.cacheDecoder = resourceDecoder;
        this.decoder = resourceDecoder2;
        this.transformation = transformation2;
        this.encoder = resourceEncoder;
        this.transcoder = resourceTranscoder;
        this.sourceEncoder = encoder2;
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (!this.id.equals(engineKey.id) || !this.signature.equals(engineKey.signature) || this.height != engineKey.height || this.width != engineKey.width) {
            return false;
        }
        Transformation transformation2 = this.transformation;
        if (transformation2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (engineKey.transformation == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (transformation2 != null && !transformation2.getId().equals(engineKey.transformation.getId())) {
            return false;
        }
        ResourceDecoder resourceDecoder = this.decoder;
        if (resourceDecoder == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (engineKey.decoder == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (resourceDecoder != null && !resourceDecoder.getId().equals(engineKey.decoder.getId())) {
            return false;
        }
        ResourceDecoder resourceDecoder2 = this.cacheDecoder;
        if (resourceDecoder2 == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (engineKey.cacheDecoder == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (resourceDecoder2 != null && !resourceDecoder2.getId().equals(engineKey.cacheDecoder.getId())) {
            return false;
        }
        ResourceEncoder resourceEncoder = this.encoder;
        if (resourceEncoder == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (engineKey.encoder == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (resourceEncoder != null && !resourceEncoder.getId().equals(engineKey.encoder.getId())) {
            return false;
        }
        ResourceTranscoder resourceTranscoder = this.transcoder;
        if (resourceTranscoder == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (engineKey.transcoder == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (resourceTranscoder != null && !resourceTranscoder.getId().equals(engineKey.transcoder.getId())) {
            return false;
        }
        Encoder encoder2 = this.sourceEncoder;
        if (encoder2 == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (engineKey.sourceEncoder == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (encoder2 == null || encoder2.getId().equals(engineKey.sourceEncoder.getId())) {
            return true;
        }
        return false;
    }

    public Key getOriginalKey() {
        if (this.originalKey == null) {
            this.originalKey = new OriginalKey(this.id, this.signature);
        }
        return this.originalKey;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (this.hashCode == 0) {
            int hashCode2 = this.id.hashCode();
            this.hashCode = hashCode2;
            int hashCode3 = (((((hashCode2 * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
            this.hashCode = hashCode3;
            int i15 = hashCode3 * 31;
            ResourceDecoder resourceDecoder = this.cacheDecoder;
            int i16 = 0;
            if (resourceDecoder != null) {
                i10 = resourceDecoder.getId().hashCode();
            } else {
                i10 = 0;
            }
            int i17 = i15 + i10;
            this.hashCode = i17;
            int i18 = i17 * 31;
            ResourceDecoder resourceDecoder2 = this.decoder;
            if (resourceDecoder2 != null) {
                i11 = resourceDecoder2.getId().hashCode();
            } else {
                i11 = 0;
            }
            int i19 = i18 + i11;
            this.hashCode = i19;
            int i20 = i19 * 31;
            Transformation transformation2 = this.transformation;
            if (transformation2 != null) {
                i12 = transformation2.getId().hashCode();
            } else {
                i12 = 0;
            }
            int i21 = i20 + i12;
            this.hashCode = i21;
            int i22 = i21 * 31;
            ResourceEncoder resourceEncoder = this.encoder;
            if (resourceEncoder != null) {
                i13 = resourceEncoder.getId().hashCode();
            } else {
                i13 = 0;
            }
            int i23 = i22 + i13;
            this.hashCode = i23;
            int i24 = i23 * 31;
            ResourceTranscoder resourceTranscoder = this.transcoder;
            if (resourceTranscoder != null) {
                i14 = resourceTranscoder.getId().hashCode();
            } else {
                i14 = 0;
            }
            int i25 = i24 + i14;
            this.hashCode = i25;
            int i26 = i25 * 31;
            Encoder encoder2 = this.sourceEncoder;
            if (encoder2 != null) {
                i16 = encoder2.getId().hashCode();
            }
            this.hashCode = i26 + i16;
        }
        return this.hashCode;
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (this.stringKey == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.id);
            sb.append('+');
            sb.append(this.signature);
            sb.append("+[");
            sb.append(this.width);
            sb.append('x');
            sb.append(this.height);
            sb.append("]+");
            sb.append('\'');
            ResourceDecoder resourceDecoder = this.cacheDecoder;
            String str6 = "";
            if (resourceDecoder != null) {
                str = resourceDecoder.getId();
            } else {
                str = str6;
            }
            sb.append(str);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            ResourceDecoder resourceDecoder2 = this.decoder;
            if (resourceDecoder2 != null) {
                str2 = resourceDecoder2.getId();
            } else {
                str2 = str6;
            }
            sb.append(str2);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            Transformation transformation2 = this.transformation;
            if (transformation2 != null) {
                str3 = transformation2.getId();
            } else {
                str3 = str6;
            }
            sb.append(str3);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            ResourceEncoder resourceEncoder = this.encoder;
            if (resourceEncoder != null) {
                str4 = resourceEncoder.getId();
            } else {
                str4 = str6;
            }
            sb.append(str4);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            ResourceTranscoder resourceTranscoder = this.transcoder;
            if (resourceTranscoder != null) {
                str5 = resourceTranscoder.getId();
            } else {
                str5 = str6;
            }
            sb.append(str5);
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            Encoder encoder2 = this.sourceEncoder;
            if (encoder2 != null) {
                str6 = encoder2.getId();
            }
            sb.append(str6);
            sb.append('\'');
            sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
            this.stringKey = sb.toString();
        }
        return this.stringKey;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        String str;
        String str2;
        String str3;
        String str4;
        byte[] array = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        messageDigest.update(this.id.getBytes("UTF-8"));
        messageDigest.update(array);
        ResourceDecoder resourceDecoder = this.cacheDecoder;
        String str5 = "";
        if (resourceDecoder != null) {
            str = resourceDecoder.getId();
        } else {
            str = str5;
        }
        messageDigest.update(str.getBytes("UTF-8"));
        ResourceDecoder resourceDecoder2 = this.decoder;
        if (resourceDecoder2 != null) {
            str2 = resourceDecoder2.getId();
        } else {
            str2 = str5;
        }
        messageDigest.update(str2.getBytes("UTF-8"));
        Transformation transformation2 = this.transformation;
        if (transformation2 != null) {
            str3 = transformation2.getId();
        } else {
            str3 = str5;
        }
        messageDigest.update(str3.getBytes("UTF-8"));
        ResourceEncoder resourceEncoder = this.encoder;
        if (resourceEncoder != null) {
            str4 = resourceEncoder.getId();
        } else {
            str4 = str5;
        }
        messageDigest.update(str4.getBytes("UTF-8"));
        Encoder encoder2 = this.sourceEncoder;
        if (encoder2 != null) {
            str5 = encoder2.getId();
        }
        messageDigest.update(str5.getBytes("UTF-8"));
    }
}
