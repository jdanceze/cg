package com.android.commands.motifcore;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.android.commands.motifcore.v  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0027v {
    public static final int a = 1;
    private C0031z b;
    private int c;
    private long d;

    public C0027v(int i, C0031z c0031z, long j) {
        this.c = i;
        this.b = c0031z;
        this.d = j;
    }

    public C0031z a() {
        switch (this.c) {
            case 1:
                try {
                    synchronized (W.class) {
                        W.class.wait(this.d);
                    }
                    break;
                } catch (InterruptedException e) {
                    Log.d("MonkeyStub", "Deferral interrupted: " + e.getMessage());
                    break;
                }
        }
        return this.b;
    }
}
