package com.loopj.android.http;

import android.text.TextUtils;
import com.loopj.android.http.RequestParams;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonStreamerEntity implements HttpEntity {
    private static final int BUFFER_SIZE = 4096;
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
    private static final byte[] JSON_FALSE = "false".getBytes();
    private static final byte[] JSON_NULL = "null".getBytes();
    private static final byte[] JSON_TRUE = "true".getBytes();
    private static final String LOG_TAG = "JsonStreamerEntity";
    private static final byte[] STREAM_CONTENTS = escape("contents");
    private static final byte[] STREAM_NAME = escape("name");
    private static final byte[] STREAM_TYPE = escape("type");
    private final byte[] buffer = new byte[4096];
    private final Header contentEncoding;
    private final byte[] elapsedField;
    private final Map<String, Object> jsonParams = new HashMap();
    private final ResponseHandlerInterface progressHandler;

    public JsonStreamerEntity(ResponseHandlerInterface responseHandlerInterface, boolean z10, String str) {
        Header header;
        this.progressHandler = responseHandlerInterface;
        byte[] bArr = null;
        if (z10) {
            header = HEADER_GZIP_ENCODING;
        } else {
            header = null;
        }
        this.contentEncoding = header;
        this.elapsedField = !TextUtils.isEmpty(str) ? escape(str) : bArr;
    }

    private void endMetaData(OutputStream outputStream) {
        outputStream.write(34);
    }

    public static byte[] escape(String str) {
        if (str == null) {
            return JSON_NULL;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append('\"');
        int length = str.length();
        int i10 = -1;
        while (true) {
            i10++;
            if (i10 < length) {
                char charAt = str.charAt(i10);
                if (charAt == 12) {
                    sb.append("\\f");
                } else if (charAt == 13) {
                    sb.append("\\r");
                } else if (charAt == '\"') {
                    sb.append("\\\"");
                } else if (charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            sb.append("\\b");
                            break;
                        case 9:
                            sb.append("\\t");
                            break;
                        case 10:
                            sb.append("\\n");
                            break;
                        default:
                            if (charAt > 31 && ((charAt < 127 || charAt > 159) && (charAt < 8192 || charAt > 8447))) {
                                sb.append(charAt);
                                break;
                            } else {
                                String hexString = Integer.toHexString(charAt);
                                sb.append("\\u");
                                int length2 = 4 - hexString.length();
                                for (int i11 = 0; i11 < length2; i11++) {
                                    sb.append('0');
                                }
                                sb.append(hexString.toUpperCase(Locale.US));
                                break;
                            }
                            break;
                    }
                } else {
                    sb.append("\\\\");
                }
            } else {
                sb.append('\"');
                return sb.toString().getBytes();
            }
        }
    }

    private void writeMetaData(OutputStream outputStream, String str, String str2) {
        outputStream.write(STREAM_NAME);
        outputStream.write(58);
        outputStream.write(escape(str));
        outputStream.write(44);
        outputStream.write(STREAM_TYPE);
        outputStream.write(58);
        outputStream.write(escape(str2));
        outputStream.write(44);
        outputStream.write(STREAM_CONTENTS);
        outputStream.write(58);
        outputStream.write(34);
    }

    private void writeToFromFile(OutputStream outputStream, RequestParams.FileWrapper fileWrapper) {
        writeMetaData(outputStream, fileWrapper.file.getName(), fileWrapper.contentType);
        long length = fileWrapper.file.length();
        FileInputStream fileInputStream = new FileInputStream(fileWrapper.file);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        long j10 = 0;
        while (true) {
            int read = fileInputStream.read(this.buffer);
            if (read != -1) {
                base64OutputStream.write(this.buffer, 0, read);
                j10 += (long) read;
                this.progressHandler.sendProgressMessage(j10, length);
            } else {
                AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
                endMetaData(outputStream);
                AsyncHttpClient.silentCloseInputStream(fileInputStream);
                return;
            }
        }
    }

    private void writeToFromStream(OutputStream outputStream, RequestParams.StreamWrapper streamWrapper) {
        writeMetaData(outputStream, streamWrapper.name, streamWrapper.contentType);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        while (true) {
            int read = streamWrapper.inputStream.read(this.buffer);
            if (read == -1) {
                break;
            }
            base64OutputStream.write(this.buffer, 0, read);
        }
        AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
        endMetaData(outputStream);
        if (streamWrapper.autoClose) {
            AsyncHttpClient.silentCloseInputStream(streamWrapper.inputStream);
        }
    }

    public void addPart(String str, Object obj) {
        this.jsonParams.put(str, obj);
    }

    public void consumeContent() {
    }

    public InputStream getContent() {
        throw ERR_UNSUPPORTED;
    }

    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    public long getContentLength() {
        return -1;
    }

    public Header getContentType() {
        return HEADER_JSON_CONTENT;
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        byte[] bArr;
        if (outputStream != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.contentEncoding != null) {
                outputStream = new GZIPOutputStream(outputStream, 4096);
            }
            outputStream.write(123);
            Set<String> keySet = this.jsonParams.keySet();
            int size = keySet.size();
            if (size > 0) {
                int i10 = 0;
                for (String next : keySet) {
                    i10++;
                    try {
                        Object obj = this.jsonParams.get(next);
                        outputStream.write(escape(next));
                        outputStream.write(58);
                        if (obj == null) {
                            outputStream.write(JSON_NULL);
                        } else {
                            boolean z10 = obj instanceof RequestParams.FileWrapper;
                            if (!z10) {
                                if (!(obj instanceof RequestParams.StreamWrapper)) {
                                    if (obj instanceof JsonValueInterface) {
                                        outputStream.write(((JsonValueInterface) obj).getEscapedJsonValue());
                                    } else if (obj instanceof JSONObject) {
                                        outputStream.write(obj.toString().getBytes());
                                    } else if (obj instanceof JSONArray) {
                                        outputStream.write(obj.toString().getBytes());
                                    } else if (obj instanceof Boolean) {
                                        if (((Boolean) obj).booleanValue()) {
                                            bArr = JSON_TRUE;
                                        } else {
                                            bArr = JSON_FALSE;
                                        }
                                        outputStream.write(bArr);
                                    } else if (obj instanceof Long) {
                                        outputStream.write((((Number) obj).longValue() + "").getBytes());
                                    } else if (obj instanceof Double) {
                                        outputStream.write((((Number) obj).doubleValue() + "").getBytes());
                                    } else if (obj instanceof Float) {
                                        outputStream.write((((Number) obj).floatValue() + "").getBytes());
                                    } else if (obj instanceof Integer) {
                                        outputStream.write((((Number) obj).intValue() + "").getBytes());
                                    } else {
                                        outputStream.write(escape(obj.toString()));
                                    }
                                }
                            }
                            outputStream.write(123);
                            if (z10) {
                                writeToFromFile(outputStream, (RequestParams.FileWrapper) obj);
                            } else {
                                writeToFromStream(outputStream, (RequestParams.StreamWrapper) obj);
                            }
                            outputStream.write(125);
                        }
                    } finally {
                        if (this.elapsedField != null || i10 < size) {
                            outputStream.write(44);
                        }
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                byte[] bArr2 = this.elapsedField;
                if (bArr2 != null) {
                    outputStream.write(bArr2);
                    outputStream.write(58);
                    outputStream.write((currentTimeMillis2 + "").getBytes());
                }
                LogInterface logInterface = AsyncHttpClient.log;
                logInterface.i(LOG_TAG, "Uploaded JSON in " + Math.floor((double) (currentTimeMillis2 / 1000)) + " seconds");
            }
            outputStream.write(125);
            outputStream.flush();
            AsyncHttpClient.silentCloseOutputStream(outputStream);
            return;
        }
        throw new IllegalStateException("Output stream cannot be null.");
    }
}
