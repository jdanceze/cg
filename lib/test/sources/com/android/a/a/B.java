package com.android.a.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes.dex */
public class B {
    protected static final int a = 20;
    protected static final int b = 5;
    protected static final long c = 3000;
    protected static final long d = 1000;
    protected static final long e = 10000;
    protected static final long f = 5500;
    private static final String g = B.class.getSimpleName();
    private final C0002c h = C0002c.a();
    private final E i;

    public B(E e2) {
        this.i = e2;
    }

    private AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
        while (accessibilityNodeInfo2 != null) {
            accessibilityNodeInfo2 = accessibilityNodeInfo2.getParent();
            if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.isScrollable()) {
                return accessibilityNodeInfo2;
            }
        }
        return null;
    }

    private String a(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    private Rect b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        int j = y.a().j();
        int g2 = y.a().g();
        Rect a2 = C0001b.a(accessibilityNodeInfo, j, g2);
        AccessibilityNodeInfo a3 = a(accessibilityNodeInfo);
        if (a3 != null) {
            a2.intersect(C0001b.a(a3, j, g2));
            return a2;
        }
        return a2;
    }

    public boolean A() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        return k().b(b3.right - 5, b3.bottom - 5);
    }

    public boolean B() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        return k().b(b3.left + 5, b3.top + 5);
    }

    public void a() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        k().b(b3.left + a, b3.centerY());
        B b4 = new B(new E().d("Select all"));
        if (b4.c(50L)) {
            b4.b();
        }
        SystemClock.sleep(250L);
        k().c(67, 0);
    }

    public boolean a(int i) {
        n.a(Integer.valueOf(i));
        Rect p = p();
        if (p.height() <= 10) {
            return false;
        }
        return k().b(p.centerX(), p.top + 5, p.centerX(), p.bottom - 5, i);
    }

    public boolean a(int i, int i2) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        float f2 = i / 100.0f;
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        if (b3.width() <= 40) {
            throw new IllegalStateException("Object width is too small for operation");
        }
        return a(new Point(b3.centerX() - ((int) ((b3.width() / 2) * f2)), b3.centerY()), new Point(((int) (f2 * (b3.width() / 2))) + b3.centerX(), b3.centerY()), new Point(b3.centerX() - 20, b3.centerY()), new Point(b3.centerX() + a, b3.centerY()), i2);
    }

    public boolean a(int i, int i2, int i3) {
        Rect p = p();
        return k().a(p.centerX(), p.centerY(), i, i2, i3, true);
    }

    public boolean a(long j) {
        n.a(Long.valueOf(j));
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        return k().b(b3.centerX(), b3.centerY(), this.h.b());
    }

    public boolean a(Point point, Point point2, Point point3, Point point4, int i) {
        if (i == 0) {
            i = 1;
        }
        float f2 = (point3.x - point.x) / i;
        float f3 = (point3.y - point.y) / i;
        float f4 = (point4.x - point2.x) / i;
        float f5 = (point4.y - point2.y) / i;
        int i2 = point.x;
        int i3 = point.y;
        int i4 = point2.x;
        int i5 = point2.y;
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[i + 2];
        MotionEvent.PointerCoords[] pointerCoordsArr2 = new MotionEvent.PointerCoords[i + 2];
        for (int i6 = 0; i6 < i + 1; i6++) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.x = i2;
            pointerCoords.y = i3;
            pointerCoords.pressure = 1.0f;
            pointerCoords.size = 1.0f;
            pointerCoordsArr[i6] = pointerCoords;
            MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords();
            pointerCoords2.x = i4;
            pointerCoords2.y = i5;
            pointerCoords2.pressure = 1.0f;
            pointerCoords2.size = 1.0f;
            pointerCoordsArr2[i6] = pointerCoords2;
            i2 = (int) (i2 + f2);
            i3 = (int) (i3 + f3);
            i4 = (int) (i4 + f4);
            i5 = (int) (i5 + f5);
        }
        MotionEvent.PointerCoords pointerCoords3 = new MotionEvent.PointerCoords();
        pointerCoords3.x = point3.x;
        pointerCoords3.y = point3.y;
        pointerCoords3.pressure = 1.0f;
        pointerCoords3.size = 1.0f;
        pointerCoordsArr[i + 1] = pointerCoords3;
        MotionEvent.PointerCoords pointerCoords4 = new MotionEvent.PointerCoords();
        pointerCoords4.x = point4.x;
        pointerCoords4.y = point4.y;
        pointerCoords4.pressure = 1.0f;
        pointerCoords4.size = 1.0f;
        pointerCoordsArr2[i + 1] = pointerCoords4;
        return a(pointerCoordsArr, pointerCoordsArr2);
    }

    public boolean a(B b2, int i) {
        Rect p = p();
        Rect p2 = b2.p();
        return k().a(p.centerX(), p.centerY(), p2.centerX(), p2.centerY(), i, true);
    }

    public boolean a(String str) {
        n.a(str);
        a();
        return k().a(str);
    }

    public boolean a(MotionEvent.PointerCoords[]... pointerCoordsArr) {
        return k().a(pointerCoordsArr);
    }

    public AccessibilityNodeInfo b(long j) {
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j2 = 0;
        while (j2 <= j && (accessibilityNodeInfo = m().a(n())) == null) {
            y.a().F();
            j2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (j > 0) {
                SystemClock.sleep(d);
            }
        }
        return accessibilityNodeInfo;
    }

    public B b(E e2) {
        n.a(e2);
        return new B(n().b(e2));
    }

    public boolean b() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        return k().a(b3.centerX(), b3.centerY(), this.h.b());
    }

    public boolean b(int i) {
        n.a(Integer.valueOf(i));
        Rect p = p();
        if (p.width() <= 10) {
            return false;
        }
        return k().b(p.right - 5, p.centerY(), p.left + 5, p.centerY(), i);
    }

    public boolean b(int i, int i2) {
        if (i < 0) {
            i = 1;
        } else if (i > 100) {
            i = 100;
        }
        float f2 = i / 100.0f;
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        if (b3.width() <= 40) {
            throw new IllegalStateException("Object width is too small for operation");
        }
        return a(new Point(b3.centerX() - 20, b3.centerY()), new Point(b3.centerX() + a, b3.centerY()), new Point(b3.centerX() - ((int) ((b3.width() / 2) * f2)), b3.centerY()), new Point(((int) (f2 * (b3.width() / 2))) + b3.centerX(), b3.centerY()), i2);
    }

    public B c(E e2) {
        n.a(e2);
        return new B(n().c(e2));
    }

    public boolean c() {
        n.a(new Object[0]);
        return a(f);
    }

    public boolean c(int i) {
        n.a(Integer.valueOf(i));
        Rect p = p();
        if (p.width() <= 10) {
            return false;
        }
        return k().b(p.left + 5, p.centerY(), p.right - 5, p.centerY(), i);
    }

    public boolean c(long j) {
        n.a(Long.valueOf(j));
        return b(j) != null;
    }

    public boolean d() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        return k().a(b3.right - 5, b3.bottom - 5);
    }

    public boolean d(int i) {
        n.a(Integer.valueOf(i));
        Rect p = p();
        if (p.height() <= 10) {
            return false;
        }
        return k().b(p.centerX(), p.bottom - 5, p.centerX(), p.top + 5, i);
    }

    public boolean d(long j) {
        n.a(Long.valueOf(j));
        long uptimeMillis = SystemClock.uptimeMillis();
        long j2 = 0;
        while (j2 <= j) {
            if (b(0L) == null) {
                return true;
            }
            j2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (j > 0) {
                SystemClock.sleep(d);
            }
        }
        return false;
    }

    public boolean e() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        return k().a(b3.left + 5, b3.top + 5);
    }

    public boolean f() {
        n.a(new Object[0]);
        return c(0L);
    }

    public Rect g() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect rect = new Rect();
        b2.getBoundsInScreen(rect);
        return rect;
    }

    public int h() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.getChildCount();
    }

    public String i() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        String a2 = a(b2.getClassName());
        Log.d(g, String.format("getClassName() = %s", a2));
        return a2;
    }

    public String j() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return a(b2.getContentDescription());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0003d k() {
        return y.a().d().e();
    }

    public String l() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return a(b2.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k m() {
        return y.a().d().f();
    }

    public final E n() {
        n.a(new Object[0]);
        return new E(this.i);
    }

    public String o() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        String a2 = a(b2.getText());
        Log.d(g, String.format("getText() = %s", a2));
        return a2;
    }

    public Rect p() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b(b2);
    }

    public boolean q() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.isCheckable();
    }

    public boolean r() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.isChecked();
    }

    public boolean s() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.isClickable();
    }

    public boolean t() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.isEnabled();
    }

    public boolean u() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.isFocusable();
    }

    public boolean v() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.isFocused();
    }

    public boolean w() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.isLongClickable();
    }

    public boolean x() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.isScrollable();
    }

    public boolean y() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        return b2.isSelected();
    }

    public boolean z() {
        n.a(new Object[0]);
        AccessibilityNodeInfo b2 = b(this.h.f());
        if (b2 == null) {
            throw new C(n().toString());
        }
        Rect b3 = b(b2);
        return k().b(b3.centerX(), b3.centerY());
    }
}
