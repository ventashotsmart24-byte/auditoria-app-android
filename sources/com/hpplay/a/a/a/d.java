package com.hpplay.a.a.a;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.a.a.a.d.a;
import com.hpplay.a.a.a.e;
import com.hpplay.a.a.a.f.b;
import com.hpplay.a.b.c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public abstract class d {
    public static final Pattern CONTENT_DISPOSITION_ATTRIBUTE_PATTERN = Pattern.compile(CONTENT_DISPOSITION_ATTRIBUTE_REGEX);
    public static final String CONTENT_DISPOSITION_ATTRIBUTE_REGEX = "[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]";
    public static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile(CONTENT_DISPOSITION_REGEX, 2);
    public static final String CONTENT_DISPOSITION_REGEX = "([ |\t]*Content-Disposition[ |\t]*:)(.*)";
    public static final Pattern CONTENT_TYPE_PATTERN = Pattern.compile(CONTENT_TYPE_REGEX, 2);
    public static final String CONTENT_TYPE_REGEX = "([ |\t]*content-type[ |\t]*:)(.*)";
    public static final Logger LOG = Logger.getLogger(TAG);
    public static final String MIME_HTML = "text/html";
    public static final String MIME_PLAINTEXT = "text/plain";
    protected static Map<String, String> MIME_TYPES = null;
    private static final String QUERY_STRING_PARAMETER = "NanoHttpd.QUERY_STRING";
    public static final int SOCKET_READ_TIMEOUT = 5000;
    private static final String TAG = "NanoHTTPD";
    protected b asyncRunner;
    public final String hostname;
    private c<c, com.hpplay.a.a.a.c.c> httpHandler;
    protected List<c<c, com.hpplay.a.a.a.c.c>> interceptors;
    e.a mServerListener;
    public final int myPort;
    /* access modifiers changed from: private */
    public volatile ServerSocket myServerSocket;
    /* access modifiers changed from: private */
    public Thread myThread;
    private com.hpplay.a.b.b<ServerSocket, IOException> serverSocketFactory;
    private com.hpplay.a.b.a<com.hpplay.a.a.a.e.e> tempFileManagerFactory;

    public d(int i10) {
        this((String) null, i10);
    }

    public static Map<String, List<String>> decodeParameters(Map<String, String> map) {
        return decodeParameters(map.get(QUERY_STRING_PARAMETER));
    }

    public static String decodePercent(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e10) {
            LOG.log(Level.WARNING, "Encoding not supported, ignored", e10);
            return null;
        }
    }

    public static String getMimeTypeForFile(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            str2 = mimeTypes().get(str.substring(lastIndexOf + 1).toLowerCase());
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return "application/octet-stream";
        }
        return str2;
    }

    private static void loadMimeTypes(Map<String, String> map, String str) {
        InputStream inputStream;
        try {
            Enumeration<URL> resources = d.class.getClassLoader().getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                Properties properties = new Properties();
                inputStream = null;
                try {
                    inputStream = nextElement.openStream();
                    properties.load(inputStream);
                } catch (IOException e10) {
                    Logger logger = LOG;
                    Level level = Level.SEVERE;
                    logger.log(level, "could not load mimetypes from " + nextElement, e10);
                }
                safeClose(inputStream);
                map.putAll(properties);
            }
        } catch (IOException unused) {
            Logger logger2 = LOG;
            Level level2 = Level.INFO;
            logger2.log(level2, "no mime types available at " + str);
        } catch (Throwable th) {
            safeClose(inputStream);
            throw th;
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManager[] keyManagerArr) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(keyStore);
            SSLContext instance2 = SSLContext.getInstance("TLS");
            instance2.init(keyManagerArr, instance.getTrustManagers(), (SecureRandom) null);
            return instance2.getServerSocketFactory();
        } catch (Exception e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public static Map<String, String> mimeTypes() {
        if (MIME_TYPES == null) {
            HashMap hashMap = new HashMap();
            MIME_TYPES = hashMap;
            loadMimeTypes(hashMap, "META-INF/nanohttpd/default-mimetypes.properties");
            loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/mimetypes.properties");
            if (MIME_TYPES.isEmpty()) {
                LOG.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
            }
        }
        return MIME_TYPES;
    }

    public static final void safeClose(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (obj instanceof ServerSocket) {
                    ((ServerSocket) obj).close();
                } else {
                    throw new IllegalArgumentException("Unknown object to close");
                }
            } catch (IOException e10) {
                LOG.log(Level.SEVERE, "Could not close", e10);
            }
        }
    }

    public void addHTTPInterceptor(c<c, com.hpplay.a.a.a.c.c> cVar) {
        this.interceptors.add(cVar);
    }

    public synchronized void closeAllConnections() {
        stop();
    }

    public a createClientHandler(Socket socket, InputStream inputStream) {
        return new a(this, inputStream, socket);
    }

    public e createServerRunnable(int i10) {
        return new e(this, i10);
    }

    public String getHostname() {
        return this.hostname;
    }

    public final int getListeningPort() {
        if (this.myServerSocket == null) {
            return -1;
        }
        return this.myServerSocket.getLocalPort();
    }

    public ServerSocket getMyServerSocket() {
        return this.myServerSocket;
    }

    public com.hpplay.a.b.b<ServerSocket, IOException> getServerSocketFactory() {
        return this.serverSocketFactory;
    }

    public com.hpplay.a.b.a<com.hpplay.a.a.a.e.e> getTempFileManagerFactory() {
        return this.tempFileManagerFactory;
    }

    public com.hpplay.a.a.a.c.c handle(c cVar) {
        for (c<c, com.hpplay.a.a.a.c.c> a10 : this.interceptors) {
            com.hpplay.a.a.a.c.c cVar2 = (com.hpplay.a.a.a.c.c) a10.a(cVar);
            if (cVar2 != null) {
                return cVar2;
            }
        }
        return this.httpHandler.a(cVar);
    }

    public final boolean isAlive() {
        if (!wasStarted() || this.myServerSocket.isClosed() || !this.myThread.isAlive()) {
            return false;
        }
        return true;
    }

    public void makeSecure(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        this.serverSocketFactory = new com.hpplay.a.a.a.d.b(sSLServerSocketFactory, strArr);
    }

    @Deprecated
    public com.hpplay.a.a.a.c.c serve(c cVar) {
        return com.hpplay.a.a.a.c.c.a((com.hpplay.a.a.a.c.b) com.hpplay.a.a.a.c.d.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
    }

    public void setAsyncRunner(b bVar) {
        this.asyncRunner = bVar;
    }

    public void setHTTPHandler(c<c, com.hpplay.a.a.a.c.c> cVar) {
        this.httpHandler = cVar;
    }

    public void setServerSocketFactory(com.hpplay.a.b.b<ServerSocket, IOException> bVar) {
        this.serverSocketFactory = bVar;
    }

    public void setTempFileManagerFactory(com.hpplay.a.b.a<com.hpplay.a.a.a.e.e> aVar) {
        this.tempFileManagerFactory = aVar;
    }

    public void start() {
        start(SOCKET_READ_TIMEOUT);
    }

    public void stop() {
        try {
            safeClose(this.myServerSocket);
            this.asyncRunner.b();
            Thread thread = this.myThread;
            if (thread != null) {
                thread.interrupt();
            }
        } catch (Exception e10) {
            LOG.log(Level.SEVERE, "Could not stop all connections", e10);
        }
    }

    public final boolean wasStarted() {
        if (this.myServerSocket == null || this.myThread == null) {
            return false;
        }
        return true;
    }

    public static final class a extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private static final long f10516a = 6569838532917408380L;

        /* renamed from: b  reason: collision with root package name */
        private final com.hpplay.a.a.a.c.d f10517b;

        public a(com.hpplay.a.a.a.c.d dVar, String str) {
            super(str);
            this.f10517b = dVar;
        }

        public com.hpplay.a.a.a.c.d a() {
            return this.f10517b;
        }

        public a(com.hpplay.a.a.a.c.d dVar, String str, Exception exc) {
            super(str, exc);
            this.f10517b = dVar;
        }
    }

    public d(String str, int i10) {
        this.serverSocketFactory = new a();
        this.interceptors = new ArrayList(4);
        this.mServerListener = new e.a() {
            public void a() {
                d.LOG.log(Level.INFO, "server is started");
            }

            public void b() {
                Logger logger = d.LOG;
                logger.log(Level.INFO, "server is stoped");
                d.this.stop();
                ServerSocket unused = d.this.myServerSocket = null;
                Thread unused2 = d.this.myThread = null;
                logger.log(Level.INFO, "clear obj");
            }
        };
        this.hostname = str;
        this.myPort = i10;
        setTempFileManagerFactory(new com.hpplay.a.a.a.e.c());
        setAsyncRunner(new com.hpplay.a.a.a.f.a());
        this.httpHandler = new c<c, com.hpplay.a.a.a.c.c>() {
            public com.hpplay.a.a.a.c.c a(c cVar) {
                return d.this.serve(cVar);
            }
        };
    }

    public static Map<String, List<String>> decodeParameters(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, DispatchConstants.SIGN_SPLIT_SYMBOL);
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                String trim = (indexOf >= 0 ? decodePercent(nextToken.substring(0, indexOf)) : decodePercent(nextToken)).trim();
                if (!hashMap.containsKey(trim)) {
                    hashMap.put(trim, new ArrayList());
                }
                String decodePercent = indexOf >= 0 ? decodePercent(nextToken.substring(indexOf + 1)) : null;
                if (decodePercent != null) {
                    ((List) hashMap.get(trim)).add(decodePercent);
                }
            }
        }
        return hashMap;
    }

    public void start(int i10) {
        start(i10, true);
    }

    public void start(int i10, boolean z10) {
        this.myServerSocket = getServerSocketFactory().b();
        this.myServerSocket.setReuseAddress(true);
        e createServerRunnable = createServerRunnable(i10);
        createServerRunnable.a(this.mServerListener);
        Thread thread = new Thread(createServerRunnable);
        this.myThread = thread;
        thread.setDaemon(z10);
        this.myThread.setName("NanoHttpd Main Listener");
        this.myThread.start();
        while (!createServerRunnable.b() && createServerRunnable.a() == null) {
            try {
                Thread.sleep(10);
            } catch (Throwable unused) {
            }
        }
        if (createServerRunnable.a() != null) {
            throw createServerRunnable.a();
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManagerFactory keyManagerFactory) {
        try {
            return makeSSLSocketFactory(keyStore, keyManagerFactory.getKeyManagers());
        } catch (Exception e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(String str, char[] cArr) {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = d.class.getResourceAsStream(str);
            if (resourceAsStream != null) {
                instance.load(resourceAsStream, cArr);
                KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                instance2.init(instance, cArr);
                return makeSSLSocketFactory(instance, instance2);
            }
            throw new IOException("Unable to load keystore from classpath: " + str);
        } catch (Exception e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
