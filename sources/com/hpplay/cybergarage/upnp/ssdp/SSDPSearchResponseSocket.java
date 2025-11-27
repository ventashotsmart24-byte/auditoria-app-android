package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.ControlPoint;
import java.net.DatagramSocket;

public class SSDPSearchResponseSocket extends HTTPUSocket implements Runnable {
    private ControlPoint controlPoint = null;
    private Thread deviceSearchResponseThread = null;

    public SSDPSearchResponseSocket() {
        setControlPoint((ControlPoint) null);
    }

    public ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    public boolean post(String str, int i10, SSDPSearchResponse sSDPSearchResponse) {
        return post(str, i10, sSDPSearchResponse.getHeader());
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        ControlPoint controlPoint2 = getControlPoint();
        while (this.deviceSearchResponseThread == currentThread) {
            Thread.yield();
            SSDPPacket receive = receive();
            if (receive != null) {
                if (controlPoint2 != null) {
                    controlPoint2.searchResponseReceived(receive);
                }
            } else {
                return;
            }
        }
    }

    public void setControlPoint(ControlPoint controlPoint2) {
        this.controlPoint = controlPoint2;
    }

    public void start() {
        StringBuffer stringBuffer = new StringBuffer("SSDPSearchResponseSocket/");
        DatagramSocket datagramSocket = getDatagramSocket();
        if (datagramSocket.getLocalAddress() != null) {
            stringBuffer.append(datagramSocket.getLocalAddress());
            stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            stringBuffer.append(datagramSocket.getLocalPort());
        }
        Thread thread = new Thread(this, stringBuffer.toString());
        this.deviceSearchResponseThread = thread;
        thread.start();
    }

    public void stop() {
        this.deviceSearchResponseThread = null;
    }

    public boolean post(String str, int i10, SSDPSearchRequest sSDPSearchRequest) {
        return post(str, i10, sSDPSearchRequest.toString());
    }

    public SSDPSearchResponseSocket(String str, int i10) {
        super(str, i10);
        setControlPoint((ControlPoint) null);
    }
}
