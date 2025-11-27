package com.hpplay.cybergarage.util;

public class ThreadCore implements Runnable {
    private Thread mThreadObject = null;

    public Thread getThreadObject() {
        return this.mThreadObject;
    }

    public boolean isRunnable() {
        if (Thread.currentThread() == getThreadObject()) {
            return true;
        }
        return false;
    }

    public void restart() {
        stop();
        start();
    }

    public void run() {
    }

    public void setThreadObject(Thread thread) {
        this.mThreadObject = thread;
    }

    public void start() {
        if (getThreadObject() == null) {
            Thread thread = new Thread(this, "Cyber.ThreadCore");
            setThreadObject(thread);
            thread.start();
        }
    }

    public void stop() {
        Thread threadObject = getThreadObject();
        if (threadObject != null) {
            threadObject.interrupt();
            setThreadObject((Thread) null);
        }
    }
}
