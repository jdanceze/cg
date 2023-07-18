package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.app.IApplicationThread;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
/* renamed from: com.android.commands.motifcore.m  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0018m extends IIntentReceiver.Stub {
    private static final boolean a = false;
    private long c;
    private long e;
    private final IntentFilter b = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    private int f = -1;
    private long h = 0;
    private long g = 0;
    private long d = 0;

    private void d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.e;
        switch (this.f) {
            case 0:
                this.g = j + this.g;
                break;
            case 1:
                this.h = j + this.h;
                break;
        }
        this.d = elapsedRealtime - this.c;
    }

    public void a() {
        System.out.println("## Network stats: elapsed time=" + this.d + "ms (" + this.g + "ms mobile, " + this.h + "ms wifi, " + ((this.d - this.g) - this.h) + "ms not connected)");
    }

    public void a(IActivityManager iActivityManager) {
        iActivityManager.registerReceiver((IApplicationThread) null, (String) null, this, this.b, (String) null, -1);
    }

    public void b() {
        this.h = 0L;
        this.g = 0L;
        this.d = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.c = elapsedRealtime;
        this.e = elapsedRealtime;
    }

    public void b(IActivityManager iActivityManager) {
        iActivityManager.unregisterReceiver(this);
    }

    public void c() {
        d();
    }

    public void performReceive(Intent intent, int i, String str, Bundle bundle, boolean z, boolean z2, int i2) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        d();
        if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
            this.f = networkInfo.getType();
        } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
            this.f = -1;
        }
        this.e = SystemClock.elapsedRealtime();
    }
}
