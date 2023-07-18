package com.android.a.a;

import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes.dex */
class k {
    private final w k;
    private static final String b = k.class.getSimpleName();
    private static final boolean a = Log.isLoggable(b, 3);
    private static final boolean c = Log.isLoggable(b, 2);
    private final Object f = new Object();
    private String d = null;
    private int i = 0;
    private int j = 0;
    private int g = 0;
    private int h = 0;
    private String e = "";

    public k(w wVar) {
        this.k = wVar;
        wVar.a(new l(this));
    }

    private AccessibilityNodeInfo a(E e, AccessibilityNodeInfo accessibilityNodeInfo) {
        return a(e, accessibilityNodeInfo, 0);
    }

    private AccessibilityNodeInfo a(E e, AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        if (e.a(accessibilityNodeInfo, i)) {
            if (a) {
                Log.d(b, a(String.format("%s", e.d(false))));
            }
            if (e.k()) {
                return accessibilityNodeInfo;
            }
            if (e.g()) {
                this.g++;
                e = e.b();
                if (e == null) {
                    Log.e(b, "Error: A child selector without content");
                    return null;
                }
            } else if (e.i()) {
                this.g++;
                e = e.e();
                if (e == null) {
                    Log.e(b, "Error: A parent selector without content");
                    return null;
                }
                accessibilityNodeInfo = accessibilityNodeInfo.getParent();
                if (accessibilityNodeInfo == null) {
                    return null;
                }
            }
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
            if (child == null) {
                Log.w(b, String.format("AccessibilityNodeInfo returned a null child (%d of %d)", Integer.valueOf(i2), Integer.valueOf(childCount)));
                if (!z) {
                    Log.w(b, String.format("parent = %s", accessibilityNodeInfo.toString()));
                }
                z = true;
            } else if (child.isVisibleToUser()) {
                AccessibilityNodeInfo a2 = a(e, child, i2);
                if (a2 != null) {
                    return a2;
                }
            } else if (c) {
                Log.v(b, String.format("Skipping invisible child: %s", child.toString()));
            }
        }
        return null;
    }

    private AccessibilityNodeInfo a(E e, AccessibilityNodeInfo accessibilityNodeInfo, int i, E e2) {
        if (e.a(accessibilityNodeInfo, i)) {
            if (!e.k()) {
                if (a) {
                    Log.d(b, a(String.format("%s", e.d(false))));
                }
                if (e.g()) {
                    this.g++;
                    e = e.b();
                    if (e == null) {
                        Log.e(b, "Error: A child selector without content");
                        return null;
                    }
                } else if (e.i()) {
                    this.g++;
                    e = e.e();
                    if (e == null) {
                        Log.e(b, "Error: A parent selector without content");
                        return null;
                    }
                    accessibilityNodeInfo = accessibilityNodeInfo.getParent();
                    if (accessibilityNodeInfo == null) {
                        return null;
                    }
                }
            } else if (this.j == 0) {
                if (a) {
                    Log.d(b, a(String.format("%s", e.d(false))));
                    return accessibilityNodeInfo;
                }
                return accessibilityNodeInfo;
            } else {
                if (a) {
                    Log.d(b, a(String.format("%s", e.d(false))));
                }
                this.i++;
                this.j--;
                this.g = this.h;
                e = e2;
            }
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
            if (child == null) {
                Log.w(b, String.format("AccessibilityNodeInfo returned a null child (%d of %d)", Integer.valueOf(i2), Integer.valueOf(childCount)));
                if (!z) {
                    Log.w(b, String.format("parent = %s", accessibilityNodeInfo.toString()));
                }
                z = true;
            } else if (child.isVisibleToUser()) {
                AccessibilityNodeInfo a2 = a(e, child, i2, e2);
                if (a2 != null) {
                    return a2;
                }
            } else if (a) {
                Log.d(b, String.format("Skipping invisible child: %s", child.toString()));
            }
        }
        return null;
    }

    private AccessibilityNodeInfo a(E e, AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        AccessibilityNodeInfo a2;
        if (!e.h()) {
            a2 = a(e, accessibilityNodeInfo);
        } else if (e.c().h()) {
            a2 = a(e.c(), accessibilityNodeInfo, false);
            i();
        } else {
            a2 = a(e.c(), accessibilityNodeInfo);
        }
        if (a2 != null) {
            if (e.j()) {
                a2 = b(e.f(), a2, z);
                if (z) {
                    Log.i(b, String.format("Counted %d instances of: %s", Integer.valueOf(this.i), e));
                    return null;
                } else if (a2 == null) {
                    if (a) {
                        Log.d(b, "Pattern selector not found: " + e.d(false));
                        return null;
                    }
                }
            }
            if ((e.h() || e.j()) && (e.g() || e.i())) {
                a2 = a(e, a2);
            }
            if (a2 != null) {
                Log.i(b, String.format("Matched selector: %s <<==>> [%s]", e, a2));
                return a2;
            } else if (a) {
                Log.d(b, "Object Not Found for selector " + e);
                return null;
            }
        } else if (a) {
            Log.d(b, "Container selector not found: " + e.d(false));
        }
        return null;
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.g; i++) {
            sb.append(". . ");
        }
        if (this.g > 0) {
            sb.append(String.format(". . [%d]: %s", Integer.valueOf(this.i), str));
        } else {
            sb.append(String.format(". . [%d]: %s", Integer.valueOf(this.i), str));
        }
        return sb.toString();
    }

    private AccessibilityNodeInfo b(E e, AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        if (!e.j()) {
            Log.e(b, "Selector must have a pattern selector defined");
            return null;
        }
        if (z) {
            this.j = -1;
        } else {
            this.j = e.d();
        }
        E f = e.f();
        if (f == null) {
            Log.e(b, "Pattern portion of the selector is null or not defined");
            return null;
        }
        int i = this.g + 1;
        this.g = i;
        this.h = i;
        return a(f, accessibilityNodeInfo, 0, f);
    }

    private void i() {
        this.i = 0;
        this.j = 0;
        this.g = 0;
        this.h = 0;
    }

    public AccessibilityNodeInfo a(E e) {
        return a(e, false);
    }

    protected AccessibilityNodeInfo a(E e, boolean z) {
        this.k.h();
        i();
        if (a) {
            Log.d(b, "Searching: " + e);
        }
        synchronized (this.f) {
            AccessibilityNodeInfo h = h();
            if (h == null) {
                Log.e(b, "Cannot proceed when root node is null. Aborted search");
                return null;
            }
            return a(new E(e), h, z);
        }
    }

    public int b(E e) {
        a(e, true);
        return this.i;
    }

    public void c() {
        this.k.h();
        synchronized (this.f) {
            this.e = "";
        }
    }

    public AccessibilityNodeInfo d() {
        return this.k.g();
    }

    public String e() {
        String str;
        this.k.h();
        synchronized (this.f) {
            str = this.d;
        }
        return str;
    }

    public String f() {
        this.k.h();
        AccessibilityNodeInfo h = h();
        if (h == null || h.getPackageName() == null) {
            return null;
        }
        return h.getPackageName().toString();
    }

    public String g() {
        this.k.h();
        synchronized (this.f) {
            if (this.e.length() > 0) {
                return this.e;
            }
            return null;
        }
    }

    protected AccessibilityNodeInfo h() {
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        for (int i = 0; i < 4 && (accessibilityNodeInfo = this.k.g()) == null; i++) {
            if (i < 3) {
                Log.e(b, "Got null root node from accessibility - Retrying...");
                SystemClock.sleep(250L);
            }
        }
        return accessibilityNodeInfo;
    }
}
