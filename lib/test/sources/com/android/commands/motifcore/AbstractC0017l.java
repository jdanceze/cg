package com.android.commands.motifcore;

import android.app.IActivityManager;
import android.hardware.input.InputManager;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.IWindowManager;
import android.view.MotionEvent;
import java.io.IOException;
/* renamed from: com.android.commands.motifcore.l  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0017l extends AbstractC0008c {
    private int a;
    private int o;
    private long p;
    private int q;
    private long r;
    private int s;
    private boolean t;
    private int u;
    private SparseArray v;
    private int w;
    private float x;
    private float y;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0017l(int i, int i2, int i3) {
        super(i);
        this.w = i2;
        this.p = -1L;
        this.r = -1L;
        this.a = i3;
        this.v = new SparseArray();
        this.x = 1.0f;
        this.y = 1.0f;
    }

    private MotionEvent j() {
        int size = this.v.size();
        int[] iArr = new int[size];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.v.keyAt(i);
            pointerCoordsArr[i] = (MotionEvent.PointerCoords) this.v.valueAt(i);
        }
        return MotionEvent.obtain(this.p, this.r < 0 ? SystemClock.uptimeMillis() : this.r, this.a, size, iArr, pointerCoordsArr, this.u, this.x, this.y, this.o, this.q, this.w, this.s);
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        MotionEvent j = j();
        if ((i > 0 && !this.t) || i > 1) {
            StringBuilder sb = new StringBuilder(":Sending ");
            sb.append(i()).append(" (");
            switch (j.getActionMasked()) {
                case 0:
                    sb.append("ACTION_DOWN");
                    break;
                case 1:
                    sb.append("ACTION_UP");
                    break;
                case 2:
                    sb.append("ACTION_MOVE");
                    break;
                case 3:
                    sb.append("ACTION_CANCEL");
                    break;
                case 4:
                default:
                    sb.append(j.getAction());
                    break;
                case 5:
                    sb.append("ACTION_POINTER_DOWN ");
                    break;
                case 6:
                    sb.append("ACTION_POINTER_UP ");
                    break;
            }
            sb.append("):");
            int pointerCount = j.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                sb.append(" ").append(j.getPointerId(i2));
                sb.append(":(").append(j.getX(i2)).append(",").append(j.getY(i2)).append(")");
            }
            System.out.println(sb.toString());
        }
        try {
            if (InputManager.getInstance().injectInputEvent(j, 1)) {
                if (!Motifcore.g) {
                    try {
                        a(j);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return 1;
            }
            return 0;
        } finally {
            j.recycle();
        }
    }

    public AbstractC0017l a(float f, float f2) {
        this.x = f;
        this.y = f2;
        return this;
    }

    public AbstractC0017l a(int i, float f, float f2) {
        return a(i, f, f2, 0.0f, 0.0f);
    }

    public AbstractC0017l a(int i, float f, float f2, float f3, float f4) {
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = f;
        pointerCoords.y = f2;
        pointerCoords.pressure = f3;
        pointerCoords.size = f4;
        this.v.append(i, pointerCoords);
        return this;
    }

    public AbstractC0017l a(long j) {
        this.p = j;
        return this;
    }

    public AbstractC0017l a(boolean z) {
        this.t = z;
        return this;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public void a(MotionEvent motionEvent) {
        long downTime = motionEvent.getDownTime();
        long eventTime = motionEvent.getEventTime();
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float pressure = motionEvent.getPressure();
        float size = motionEvent.getSize();
        int metaState = motionEvent.getMetaState();
        float xPrecision = motionEvent.getXPrecision();
        float yPrecision = motionEvent.getYPrecision();
        int deviceId = motionEvent.getDeviceId();
        int edgeFlags = motionEvent.getEdgeFlags();
        int b = super.b();
        StringBuffer stringBuffer = new StringBuffer();
        if (b == 1) {
            stringBuffer.append("DispatchPointer(");
        } else if (b == 2) {
            stringBuffer.append("DispatchTrackball(");
        }
        stringBuffer.append(String.valueOf(downTime) + ",");
        stringBuffer.append(String.valueOf(eventTime) + ",");
        stringBuffer.append(String.valueOf(action) + ",");
        stringBuffer.append(String.valueOf(x) + ",");
        stringBuffer.append(String.valueOf(y) + ",");
        stringBuffer.append(String.valueOf(pressure) + ",");
        stringBuffer.append(String.valueOf(size) + ",");
        stringBuffer.append(String.valueOf(metaState) + ",");
        stringBuffer.append(String.valueOf(xPrecision) + ",");
        stringBuffer.append(String.valueOf(yPrecision) + ",");
        stringBuffer.append(String.valueOf(deviceId) + ",");
        stringBuffer.append(String.valueOf(edgeFlags) + ")\n");
        Motifcore.e.write(stringBuffer.toString());
    }

    public AbstractC0017l b(int i) {
        this.o = i;
        return this;
    }

    public AbstractC0017l b(long j) {
        this.r = j;
        return this;
    }

    public AbstractC0017l c(int i) {
        this.q = i;
        return this;
    }

    public AbstractC0017l d(int i) {
        this.u = i;
        return this;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public boolean d() {
        return e() == 1;
    }

    public int e() {
        return this.a;
    }

    public long f() {
        return this.p;
    }

    public long g() {
        return this.r;
    }

    public boolean h() {
        return this.t;
    }

    protected abstract String i();
}
