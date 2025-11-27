package com.hpplay.cybergarage.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;

public class HTTPSocket {
    private InputStream sockIn = null;
    private OutputStream sockOut = null;
    private Socket socket = null;

    public HTTPSocket(Socket socket2) {
        setSocket(socket2);
        open();
    }

    private OutputStream getOutputStream() {
        return this.sockOut;
    }

    private boolean post(HTTPResponse hTTPResponse, byte[] bArr, long j10, long j11, boolean z10) {
        hTTPResponse.setDate(Calendar.getInstance());
        OutputStream outputStream = getOutputStream();
        try {
            hTTPResponse.setContentLength(j11);
            outputStream.write(hTTPResponse.getHeader().getBytes());
            outputStream.write("\r\n".getBytes());
            if (z10) {
                outputStream.flush();
                return true;
            }
            boolean isChunked = hTTPResponse.isChunked();
            if (isChunked) {
                outputStream.write(Long.toHexString(j11).getBytes());
                outputStream.write("\r\n".getBytes());
            }
            outputStream.write(bArr, (int) j10, (int) j11);
            if (isChunked) {
                outputStream.write("\r\n".getBytes());
                outputStream.write("0".getBytes());
                outputStream.write("\r\n".getBytes());
            }
            outputStream.flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void setInputStream(InputStream inputStream) {
        this.sockIn = inputStream;
    }

    private void setOutputStream(OutputStream outputStream) {
        this.sockOut = outputStream;
    }

    private void setSocket(Socket socket2) {
        this.socket = socket2;
    }

    public boolean close() {
        try {
            InputStream inputStream = this.sockIn;
            if (inputStream != null) {
                inputStream.close();
            }
            OutputStream outputStream = this.sockOut;
            if (outputStream != null) {
                outputStream.close();
            }
            getSocket().close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void finalize() {
        close();
    }

    public InputStream getInputStream() {
        return this.sockIn;
    }

    public String getLocalAddress() {
        return getSocket().getLocalAddress().getHostAddress();
    }

    public int getLocalPort() {
        return getSocket().getLocalPort();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public boolean open() {
        Socket socket2 = getSocket();
        try {
            this.sockIn = socket2.getInputStream();
            this.sockOut = socket2.getOutputStream();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public HTTPSocket(HTTPSocket hTTPSocket) {
        setSocket(hTTPSocket.getSocket());
        setInputStream(hTTPSocket.getInputStream());
        setOutputStream(hTTPSocket.getOutputStream());
    }

    private boolean post(HTTPResponse hTTPResponse, InputStream inputStream, long j10, long j11, boolean z10) {
        HTTPResponse hTTPResponse2 = hTTPResponse;
        InputStream inputStream2 = inputStream;
        long j12 = j11;
        hTTPResponse2.setDate(Calendar.getInstance());
        OutputStream outputStream = getOutputStream();
        try {
            hTTPResponse2.setContentLength(j12);
            outputStream.write(hTTPResponse.getHeader().getBytes());
            outputStream.write("\r\n".getBytes());
            if (z10) {
                outputStream.flush();
                return true;
            }
            boolean isChunked = hTTPResponse.isChunked();
            long j13 = 0;
            if (0 < j10) {
                inputStream.skip(j10);
            }
            int chunkSize = HTTP.getChunkSize();
            byte[] bArr = new byte[chunkSize];
            long j14 = (long) chunkSize;
            int read = inputStream2.read(bArr, 0, (int) (j14 < j12 ? j14 : j12));
            while (read > 0 && j13 < j12) {
                if (isChunked) {
                    outputStream.write(Long.toHexString((long) read).getBytes());
                    outputStream.write("\r\n".getBytes());
                }
                outputStream.write(bArr, 0, read);
                if (isChunked) {
                    outputStream.write("\r\n".getBytes());
                }
                j13 += (long) read;
                long j15 = j12 - j13;
                if (j14 < j15) {
                    j15 = j14;
                }
                read = inputStream2.read(bArr, 0, (int) j15);
            }
            if (isChunked) {
                outputStream.write("0".getBytes());
                outputStream.write("\r\n".getBytes());
            }
            outputStream.flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean post(HTTPResponse hTTPResponse, long j10, long j11, boolean z10) {
        if (hTTPResponse.hasContentInputStream()) {
            return post(hTTPResponse, hTTPResponse.getContentInputStream(), j10, j11, z10);
        }
        return post(hTTPResponse, hTTPResponse.getContent(), j10, j11, z10);
    }
}
