package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.hardware.input.InputManager;
import android.os.SystemClock;
import android.view.IWindowManager;
import android.view.KeyEvent;
import java.io.IOException;
/* renamed from: com.android.commands.motifcore.k  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0016k extends AbstractC0008c {
    private int a;
    private int o;
    private long p;
    private long q;
    private int r;
    private KeyEvent s;
    private int t;
    private int u;
    private int v;

    public C0016k(int i, int i2) {
        this(-1L, -1L, i, i2, 0, 0, -1, 0);
    }

    public C0016k(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6) {
        super(0);
        this.p = j;
        this.q = j2;
        this.a = i;
        this.r = i2;
        this.u = i3;
        this.t = i4;
        this.o = i5;
        this.v = i6;
    }

    public C0016k(KeyEvent keyEvent) {
        super(0);
        this.s = keyEvent;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        if (i > 1) {
            String str = this.a == 1 ? "ACTION_UP" : "ACTION_DOWN";
            try {
                System.out.println(":Sending Key (" + str + "): " + this.r + "    // " + ao.b(this.r));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(":Sending Key (" + str + "): " + this.r + "    // Unknown key event");
            }
        }
        KeyEvent keyEvent = this.s;
        if (keyEvent == null) {
            long j = this.q;
            if (j <= 0) {
                j = SystemClock.uptimeMillis();
            }
            long j2 = this.p;
            if (j2 <= 0) {
                j2 = j;
            }
            keyEvent = new KeyEvent(j2, j, this.a, this.r, this.u, this.t, this.o, this.v, 8, 257);
        }
        if (InputManager.getInstance().injectInputEvent(keyEvent, 1)) {
            if (!Motifcore.g) {
                try {
                    a(keyEvent);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return 1;
        }
        return 0;
    }

    public void a(long j) {
        if (this.s != null) {
            throw new IllegalStateException("Cannot modify down time of this key event.");
        }
        this.p = j;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public void a(KeyEvent keyEvent) {
        long downTime = keyEvent.getDownTime();
        long eventTime = keyEvent.getEventTime();
        int action = keyEvent.getAction();
        int keyCode = keyEvent.getKeyCode();
        int repeatCount = keyEvent.getRepeatCount();
        int metaState = keyEvent.getMetaState();
        int deviceId = keyEvent.getDeviceId();
        int scanCode = keyEvent.getScanCode();
        int b = super.b();
        StringBuffer stringBuffer = new StringBuffer();
        if (b == 0) {
            stringBuffer.append("DispatchKey(");
        }
        stringBuffer.append(String.valueOf(downTime) + ",");
        stringBuffer.append(String.valueOf(eventTime) + ",");
        stringBuffer.append(String.valueOf(action) + ",");
        stringBuffer.append(String.valueOf(keyCode) + ",");
        stringBuffer.append(String.valueOf(repeatCount) + ",");
        stringBuffer.append(String.valueOf(metaState) + ",");
        stringBuffer.append(String.valueOf(deviceId) + ",");
        stringBuffer.append(String.valueOf(scanCode) + ")\n");
        Motifcore.e.write(stringBuffer.toString());
    }

    public void b(long j) {
        if (this.s != null) {
            throw new IllegalStateException("Cannot modify event time of this key event.");
        }
        this.q = j;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public boolean d() {
        return e() == 1;
    }

    public int e() {
        return this.s != null ? this.s.getAction() : this.a;
    }

    public long f() {
        return this.s != null ? this.s.getDownTime() : this.p;
    }

    public long g() {
        return this.s != null ? this.s.getEventTime() : this.q;
    }

    public int h() {
        return this.s != null ? this.s.getKeyCode() : this.r;
    }
}
