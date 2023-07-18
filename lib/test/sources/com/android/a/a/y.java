package com.android.a.a;

import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class y {
    private static final long a = 1000;
    private static final String b = y.class.getSimpleName();
    private static y c;
    private w e;
    private final HashMap f = new HashMap();
    private final List g = new ArrayList();
    private boolean d = false;

    private y() {
    }

    public static y a() {
        if (c == null) {
            c = new y();
        }
        return c;
    }

    private void d(String str) {
        n.a(str);
        if (b(str)) {
            return;
        }
        this.g.add(str);
    }

    public boolean A() {
        n.a(new Object[0]);
        L();
        return d().e().a(3, 0, 2048, a);
    }

    public boolean B() {
        n.a(new Object[0]);
        L();
        return d().e().a(82, 0, 2048, a);
    }

    public boolean C() {
        n.a(new Object[0]);
        L();
        return d().e().i();
    }

    public boolean D() {
        n.a(new Object[0]);
        return a(84);
    }

    public void E() {
        n.a(new Object[0]);
        this.g.clear();
    }

    public void F() {
        n.a(new Object[0]);
        if (this.d) {
            return;
        }
        for (String str : this.f.keySet()) {
            F f = (F) this.f.get(str);
            if (f != null) {
                try {
                    this.d = true;
                    if (f.a()) {
                        d(str);
                    }
                } catch (Exception e) {
                    Log.e(b, "Exceuting watcher: " + str, e);
                } finally {
                    this.d = false;
                }
            }
        }
    }

    public void G() {
        n.a(new Object[0]);
        d().e().e();
        L();
    }

    public void H() {
        n.a(new Object[0]);
        d().e().f();
        L();
    }

    public void I() {
        n.a(new Object[0]);
        d().e().g();
        L();
    }

    public void J() {
        n.a(new Object[0]);
        d().e().h();
    }

    public void K() {
        n.a(new Object[0]);
        d().e().j();
    }

    public void L() {
        n.a(new Object[0]);
        a(C0002c.a().e());
    }

    public void M() {
        n.a(new Object[0]);
        if (d().e().k()) {
            SystemClock.sleep(500L);
        }
    }

    public void a(long j) {
        n.a(Long.valueOf(j));
        d().a(j);
    }

    public void a(w wVar) {
        this.e = wVar;
    }

    public void a(String str) {
        n.a(str);
        AccessibilityNodeInfo d = d().f().d();
        if (d != null) {
            Display a2 = d().a();
            Point point = new Point();
            a2.getSize(point);
            C0000a.a(d, new File(new File(Environment.getDataDirectory(), "local/tmp"), str), a2.getRotation(), point.x, point.y);
        }
    }

    public void a(String str, F f) {
        n.a(str, f);
        if (this.d) {
            throw new IllegalStateException("Cannot register new watcher from within another");
        }
        this.f.put(str, f);
    }

    public void a(boolean z) {
        d().a(z);
    }

    public boolean a(int i) {
        n.a(Integer.valueOf(i));
        L();
        return d().e().c(i, 0);
    }

    public boolean a(int i, int i2) {
        n.a(Integer.valueOf(i), Integer.valueOf(i2));
        if (i >= j() || i2 >= g()) {
            return false;
        }
        return d().e().a(i, i2);
    }

    public boolean a(int i, int i2, int i3, int i4, int i5) {
        n.a(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        return d().e().a(i, i2, i3, i4, i5, true);
    }

    public boolean a(File file) {
        n.a(file);
        return a(file, 1.0f, 90);
    }

    public boolean a(File file, float f, int i) {
        n.a(file, Float.valueOf(f), Integer.valueOf(i));
        return d().a(file, i);
    }

    public boolean a(String str, long j) {
        n.a(str, Long.valueOf(j));
        if (str == null || str.equals(f())) {
            try {
                d().a(new z(this), new A(this, str), j);
                return true;
            } catch (TimeoutException e) {
                return false;
            } catch (Exception e2) {
                Log.e(b, "waitForWindowUpdate: general exception from bridge", e2);
                return false;
            }
        }
        return false;
    }

    public boolean a(Point[] pointArr, int i) {
        n.a(pointArr, Integer.valueOf(i));
        return d().e().a(pointArr, i);
    }

    public void b() {
        n.a(new Object[0]);
        d().f().c();
    }

    public boolean b(int i, int i2) {
        n.a(Integer.valueOf(i), Integer.valueOf(i2));
        L();
        return d().e().c(i, i2);
    }

    public boolean b(int i, int i2, int i3, int i4, int i5) {
        n.a(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        return d().e().b(i, i2, i3, i4, i5);
    }

    public boolean b(String str) {
        n.a(str);
        return this.g.contains(str);
    }

    public void c() {
        n.a(new Object[0]);
        d().e().a();
    }

    public void c(String str) {
        n.a(str);
        if (this.d) {
            throw new IllegalStateException("Cannot remove a watcher from within another");
        }
        this.f.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w d() {
        if (this.e == null) {
            throw new RuntimeException("UiDevice not initialized");
        }
        return this.e;
    }

    public String e() {
        n.a(new Object[0]);
        return d().f().e();
    }

    public String f() {
        n.a(new Object[0]);
        return d().f().f();
    }

    public int g() {
        n.a(new Object[0]);
        Display a2 = d().a();
        Point point = new Point();
        a2.getSize(point);
        return point.y;
    }

    public int h() {
        n.a(new Object[0]);
        L();
        return d().b();
    }

    public Point i() {
        n.a(new Object[0]);
        Display a2 = d().a();
        Point point = new Point();
        a2.getRealSize(point);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        a2.getRealMetrics(displayMetrics);
        point.x = Math.round(point.x / displayMetrics.density);
        point.y = Math.round(point.y / displayMetrics.density);
        return point;
    }

    public int j() {
        n.a(new Object[0]);
        Display a2 = d().a();
        Point point = new Point();
        a2.getSize(point);
        return point.x;
    }

    public String k() {
        n.a(new Object[0]);
        return d().f().g();
    }

    public String l() {
        n.a(new Object[0]);
        return Build.PRODUCT;
    }

    public boolean m() {
        n.a(new Object[0]);
        return this.g.size() > 0;
    }

    boolean n() {
        return this.d;
    }

    public boolean o() {
        n.a(new Object[0]);
        L();
        int b2 = d().b();
        return b2 == 0 || b2 == 2;
    }

    public boolean p() {
        n.a(new Object[0]);
        return d().e().b();
    }

    public boolean q() {
        n.a(new Object[0]);
        L();
        return d().e().c();
    }

    public boolean r() {
        n.a(new Object[0]);
        L();
        return d().e().d();
    }

    public boolean s() {
        n.a(new Object[0]);
        L();
        return d().e().a(4, 0, 2048, a);
    }

    public boolean t() {
        n.a(new Object[0]);
        return a(23);
    }

    public boolean u() {
        n.a(new Object[0]);
        return a(20);
    }

    public boolean v() {
        n.a(new Object[0]);
        return a(21);
    }

    public boolean w() {
        n.a(new Object[0]);
        return a(22);
    }

    public boolean x() {
        n.a(new Object[0]);
        return a(19);
    }

    public boolean y() {
        n.a(new Object[0]);
        return a(67);
    }

    public boolean z() {
        n.a(new Object[0]);
        return a(66);
    }
}
