package com.android.a.a;

import android.app.UiAutomation;
import android.graphics.Point;
import android.os.SystemClock;
import android.util.Log;
import android.view.InputEvent;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;
/* renamed from: com.android.a.a.d  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0003d {
    private static final int c = 5;
    private static final long d = 100;
    private long e;
    private final KeyCharacterMap f = KeyCharacterMap.load(-1);
    private final w g;
    private static final String b = C0003d.class.getSimpleName();
    private static final boolean a = Log.isLoggable(b, 3);

    public C0003d(w wVar) {
        this.g = wVar;
    }

    private AccessibilityEvent a(Runnable runnable, UiAutomation.AccessibilityEventFilter accessibilityEventFilter, long j) {
        try {
            return this.g.a(runnable, accessibilityEventFilter, j);
        } catch (TimeoutException e) {
            Log.w(b, "runAndwaitForEvent timedout waiting for events");
            return null;
        } catch (Exception e2) {
            Log.e(b, "exception from executeCommandAndWaitForAccessibilityEvent", e2);
            return null;
        }
    }

    private AccessibilityEvent a(List list, int i) {
        for (int size = list.size(); size > 0; size--) {
            AccessibilityEvent accessibilityEvent = (AccessibilityEvent) list.get(size - 1);
            if (accessibilityEvent.getEventType() == i) {
                return accessibilityEvent;
            }
        }
        return null;
    }

    private void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((AccessibilityEvent) it.next()).recycle();
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(InputEvent inputEvent) {
        return this.g.a(inputEvent, true);
    }

    private Runnable d(int i, int i2) {
        return new RunnableC0005f(this, i, i2);
    }

    private int e(int i, int i2) {
        return (i2 << 8) + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(int i, int i2) {
        if (a) {
            Log.d(b, "touchDown (" + i + ", " + i2 + ")");
        }
        this.e = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(this.e, this.e, 0, i, i2, 1);
        obtain.setSource(4098);
        return a(obtain);
    }

    private boolean g(int i, int i2) {
        if (a) {
            Log.d(b, "touchMove (" + i + ", " + i2 + ")");
        }
        MotionEvent obtain = MotionEvent.obtain(this.e, SystemClock.uptimeMillis(), 2, i, i2, 1);
        obtain.setSource(4098);
        return a(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(int i, int i2) {
        if (a) {
            Log.d(b, "touchUp (" + i + ", " + i2 + ")");
        }
        MotionEvent obtain = MotionEvent.obtain(this.e, SystemClock.uptimeMillis(), 1, i, i2, 1);
        obtain.setSource(4098);
        this.e = 0L;
        return a(obtain);
    }

    public void a() {
        this.g.b(-1);
    }

    public boolean a(int i, int i2) {
        Log.d(b, "clickNoSync (" + i + ", " + i2 + ")");
        if (f(i, i2)) {
            SystemClock.sleep(d);
            if (h(i, i2)) {
                return true;
            }
        }
        return a;
    }

    public boolean a(int i, int i2, int i3, int i4, int i5) {
        Log.d(b, "scrollSwipe (" + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ")");
        g gVar = new g(this, i, i2, i3, i4, i5);
        ArrayList arrayList = new ArrayList();
        a(gVar, new h(this, 4096, arrayList), C0002c.a().d());
        AccessibilityEvent a2 = a(arrayList, 4096);
        if (a2 == null) {
            a(arrayList);
            return a;
        }
        boolean z = a;
        if (a2.getFromIndex() != -1 && a2.getToIndex() != -1 && a2.getItemCount() != -1) {
            z = (a2.getFromIndex() == 0 || a2.getItemCount() + (-1) == a2.getToIndex()) ? true : a;
            Log.d(b, "scrollSwipe reached scroll end: " + z);
        } else if (a2.getScrollX() != -1 && a2.getScrollY() != -1) {
            if (i == i3) {
                z = (a2.getScrollY() == 0 || a2.getScrollY() == a2.getMaxScrollY()) ? true : a;
                Log.d(b, "Vertical scrollSwipe reached scroll end: " + z);
            } else if (i2 == i4) {
                z = (a2.getScrollX() == 0 || a2.getScrollX() == a2.getMaxScrollX()) ? true : a;
                Log.d(b, "Horizontal scrollSwipe reached scroll end: " + z);
            }
        }
        a(arrayList);
        if (z) {
            return a;
        }
        return true;
    }

    public boolean a(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (i5 == 0) {
            i5 = 1;
        }
        double d2 = (i3 - i) / i5;
        double d3 = (i4 - i2) / i5;
        boolean f = f(i, i2);
        if (z) {
            SystemClock.sleep(this.g.c());
        }
        for (int i6 = 1; i6 < i5; i6++) {
            f &= g(((int) (i6 * d2)) + i, ((int) (i6 * d3)) + i2);
            if (!f) {
                break;
            }
            SystemClock.sleep(5L);
        }
        if (z) {
            SystemClock.sleep(d);
        }
        return f & h(i3, i4);
    }

    public boolean a(int i, int i2, int i3, long j) {
        if (a(new RunnableC0004e(this, i, i2), new j(this, i3), j) != null) {
            return true;
        }
        return a;
    }

    public boolean a(int i, int i2, long j) {
        Log.d(b, String.format("clickAndSync(%d, %d)", Integer.valueOf(i), Integer.valueOf(i2)));
        if (a(d(i, i2), new j(this, 2052), j) != null) {
            return true;
        }
        return a;
    }

    public boolean a(String str) {
        if (a) {
            Log.d(b, "sendText (" + str + ")");
        }
        KeyEvent[] events = this.f.getEvents(str.toCharArray());
        if (events != null) {
            long c2 = C0002c.a().c();
            for (KeyEvent keyEvent : events) {
                if (!a(KeyEvent.changeTimeRepeat(keyEvent, SystemClock.uptimeMillis(), 0))) {
                    return a;
                }
                SystemClock.sleep(c2);
            }
        }
        return true;
    }

    public boolean a(Point[] pointArr, int i) {
        int i2 = i == 0 ? 1 : i;
        if (pointArr.length == 0) {
            return a;
        }
        boolean f = f(pointArr[0].x, pointArr[0].y);
        for (int i3 = 0; i3 < pointArr.length; i3++) {
            if (i3 + 1 < pointArr.length) {
                double d2 = (pointArr[i3 + 1].x - pointArr[i3].x) / i2;
                double d3 = (pointArr[i3 + 1].y - pointArr[i3].y) / i2;
                for (int i4 = 1; i4 < i; i4++) {
                    f &= g(pointArr[i3].x + ((int) (i4 * d2)), pointArr[i3].y + ((int) (i4 * d3)));
                    if (!f) {
                        break;
                    }
                    SystemClock.sleep(5L);
                }
            }
        }
        return f & h(pointArr[pointArr.length - 1].x, pointArr[pointArr.length - 1].y);
    }

    public boolean a(MotionEvent.PointerCoords[]... pointerCoordsArr) {
        int i;
        boolean z;
        if (pointerCoordsArr.length < 2) {
            throw new IllegalArgumentException("Must provide coordinates for at least 2 pointers");
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i2;
            if (i3 >= pointerCoordsArr.length) {
                break;
            }
            i2 = i < pointerCoordsArr[i3].length ? pointerCoordsArr[i3].length : i;
            i3++;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCoordsArr.length];
        MotionEvent.PointerCoords[] pointerCoordsArr2 = new MotionEvent.PointerCoords[pointerCoordsArr.length];
        for (int i4 = 0; i4 < pointerCoordsArr.length; i4++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = i4;
            pointerProperties.toolType = 1;
            pointerPropertiesArr[i4] = pointerProperties;
            pointerCoordsArr2[i4] = pointerCoordsArr[i4][0];
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean a2 = a(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 0, 1, pointerPropertiesArr, pointerCoordsArr2, 0, 0, 1.0f, 1.0f, 0, 0, 4098, 0)) & true;
        int i5 = 1;
        while (true) {
            int i6 = i5;
            z = a2;
            if (i6 >= pointerCoordsArr.length) {
                break;
            }
            a2 = z & a(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), e(5, i6), i6 + 1, pointerPropertiesArr, pointerCoordsArr2, 0, 0, 1.0f, 1.0f, 0, 0, 4098, 0));
            i5 = i6 + 1;
        }
        int i7 = 1;
        boolean z2 = z;
        while (true) {
            int i8 = i7;
            if (i8 >= i - 1) {
                break;
            }
            for (int i9 = 0; i9 < pointerCoordsArr.length; i9++) {
                if (pointerCoordsArr[i9].length > i8) {
                    pointerCoordsArr2[i9] = pointerCoordsArr[i9][i8];
                } else {
                    pointerCoordsArr2[i9] = pointerCoordsArr[i9][pointerCoordsArr[i9].length - 1];
                }
            }
            z2 &= a(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 2, pointerCoordsArr.length, pointerPropertiesArr, pointerCoordsArr2, 0, 0, 1.0f, 1.0f, 0, 0, 4098, 0));
            SystemClock.sleep(5L);
            i7 = i8 + 1;
        }
        for (int i10 = 0; i10 < pointerCoordsArr.length; i10++) {
            pointerCoordsArr2[i10] = pointerCoordsArr[i10][pointerCoordsArr[i10].length - 1];
        }
        int i11 = 1;
        while (i11 < pointerCoordsArr.length) {
            boolean a3 = z2 & a(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), e(6, i11), i11 + 1, pointerPropertiesArr, pointerCoordsArr2, 0, 0, 1.0f, 1.0f, 0, 0, 4098, 0));
            i11++;
            z2 = a3;
        }
        Log.i(b, "x " + pointerCoordsArr2[0].x);
        return a(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 1, 1, pointerPropertiesArr, pointerCoordsArr2, 0, 0, 1.0f, 1.0f, 0, 0, 4098, 0)) & z2;
    }

    public boolean b() {
        return this.g.d();
    }

    public boolean b(int i, int i2) {
        if (a) {
            Log.d(b, "longTapNoSync (" + i + ", " + i2 + ")");
        }
        if (f(i, i2)) {
            SystemClock.sleep(this.g.c());
            if (h(i, i2)) {
                return true;
            }
        }
        return a;
    }

    public boolean b(int i, int i2, int i3, int i4, int i5) {
        return a(i, i2, i3, i4, i5, a);
    }

    public boolean b(int i, int i2, long j) {
        Log.d(b, String.format("clickAndWaitForNewWindow(%d, %d)", Integer.valueOf(i), Integer.valueOf(i2)));
        if (a(d(i, i2), new i(this, 2080), j) != null) {
            return true;
        }
        return a;
    }

    public boolean c() {
        return this.g.a(4);
    }

    public boolean c(int i, int i2) {
        if (a) {
            Log.d(b, "sendKey (" + i + ", " + i2 + ")");
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (a(new KeyEvent(uptimeMillis, uptimeMillis, 0, i, 0, i2, -1, 0, 0, 257)) && a(new KeyEvent(uptimeMillis, uptimeMillis, 1, i, 0, i2, -1, 0, 0, 257))) {
            return true;
        }
        return a;
    }

    public boolean d() {
        return this.g.a(5);
    }

    public void e() {
        this.g.b(1);
    }

    public void f() {
        this.g.b(0);
    }

    public void g() {
        this.g.b(3);
    }

    public boolean h() {
        if (b()) {
            c(26, 0);
            return true;
        }
        return a;
    }

    public boolean i() {
        return this.g.a(3);
    }

    public void j() {
        this.g.b(-2);
    }

    public boolean k() {
        if (b()) {
            return a;
        }
        c(26, 0);
        return true;
    }
}
