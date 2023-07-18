package com.android.a.a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ActivityManagerNative;
import android.app.IActivityController;
import android.app.IActivityManager;
import android.app.UiAutomation;
import android.app.UiAutomationConnection;
import android.os.HandlerThread;
import android.os.RemoteException;
/* loaded from: classes.dex */
public class t {
    private static final String a = "UiAutomatorHandlerThread";
    private final HandlerThread b = new HandlerThread(a);
    private UiAutomation c;

    public void a() {
        if (this.b.isAlive()) {
            throw new IllegalStateException("Already connected!");
        }
        this.b.start();
        this.c = new UiAutomation(this.b.getLooper(), new UiAutomationConnection());
        this.c.connect();
    }

    public void a(boolean z) {
        AccessibilityServiceInfo serviceInfo = this.c.getServiceInfo();
        if (z) {
            serviceInfo.flags &= -3;
        } else {
            serviceInfo.flags |= 2;
        }
        this.c.setServiceInfo(serviceInfo);
    }

    public void b() {
        if (!this.b.isAlive()) {
            throw new IllegalStateException("Already disconnected!");
        }
        this.c.disconnect();
        this.b.quit();
    }

    public void b(boolean z) {
        IActivityManager iActivityManager = ActivityManagerNative.getDefault();
        if (iActivityManager == null) {
            throw new RuntimeException("Can't manage monkey status; is the system running?");
        }
        try {
            if (z) {
                iActivityManager.setActivityController(new v(this));
            } else {
                iActivityManager.setActivityController((IActivityController) null);
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public UiAutomation c() {
        return this.c;
    }
}
