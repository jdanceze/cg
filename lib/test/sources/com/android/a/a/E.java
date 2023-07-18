package com.android.a.a;

import android.util.SparseArray;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class E {
    static final int A = 13;
    static final int B = 16;
    static final int C = 6;
    static final int D = 2;
    static final int E = 1;
    static final int F = 25;
    static final int a = 30;
    static final int b = 15;
    static final int c = 19;
    static final int d = 4;
    static final int e = 26;
    static final int f = 14;
    static final int g = 20;
    static final int h = 7;
    static final int i = 3;
    static final int j = 23;
    static final int k = 5;
    static final int l = 27;
    static final int m = 10;
    static final int n = 12;
    static final int o = 11;
    static final int p = 17;
    static final int q = 8;
    static final int r = 9;
    static final int s = 24;
    static final int t = 0;
    static final int u = 18;
    static final int v = 28;
    static final int w = 22;
    static final int x = 21;
    static final int y = 29;
    static final int z = 31;
    private SparseArray G;

    public E() {
        this.G = new SparseArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(E e2) {
        this.G = new SparseArray();
        this.G = e2.a().G;
    }

    private E a(int i2, Object obj) {
        E e2 = new E(this);
        if (i2 == c || i2 == w) {
            e2.l().G.put(i2, obj);
        } else {
            e2.G.put(i2, obj);
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static E a(E e2) {
        return !e2.j() ? new E().e(e2) : e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static E a(E e2, E e3) {
        return new E(new E().d(e2).e(e3));
    }

    private E d(E e2) {
        return a(g, e2);
    }

    private E e(E e2) {
        return a(x, e2);
    }

    private E l() {
        if (this.G.indexOfKey(c) >= 0) {
            E e2 = (E) this.G.get(c);
            return e2.l() == null ? e2 : e2.l();
        } else if (this.G.indexOfKey(w) >= 0) {
            E e3 = (E) this.G.get(w);
            return e3.l() != null ? e3.l() : e3;
        } else {
            return this;
        }
    }

    private boolean m() {
        int intValue = this.G.indexOfKey(9) >= 0 ? ((Integer) this.G.get(9)).intValue() : 0;
        int intValue2 = this.G.indexOfKey(j) >= 0 ? ((Integer) this.G.get(j)).intValue() : 0;
        if (intValue == intValue2) {
            return true;
        }
        if (intValue > intValue2) {
            this.G.put(j, Integer.valueOf(intValue2 + 1));
            return false;
        }
        return false;
    }

    protected E a() {
        E e2 = new E();
        e2.G = this.G.clone();
        if (g()) {
            e2.G.put(c, new E(b()));
        }
        if (i()) {
            e2.G.put(w, new E(e()));
        }
        if (j()) {
            e2.G.put(x, new E(f()));
        }
        return e2;
    }

    public E a(Class cls) {
        return a(4, cls.getName());
    }

    public E a(String str) {
        return a(4, str);
    }

    public E a(boolean z2) {
        return a(a, Boolean.valueOf(z2));
    }

    boolean a(int i2) {
        return ((Boolean) this.G.get(i2, false)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        int size = this.G.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = this.G.keyAt(i3);
            switch (keyAt) {
                case 1:
                    CharSequence text = accessibilityNodeInfo.getText();
                    if (text != null && text.toString().contentEquals(d(keyAt))) {
                        break;
                    } else {
                        return false;
                    }
                case 2:
                    CharSequence text2 = accessibilityNodeInfo.getText();
                    if (text2 != null && text2.toString().toLowerCase().startsWith(d(keyAt).toLowerCase())) {
                        break;
                    } else {
                        return false;
                    }
                case 3:
                    CharSequence text3 = accessibilityNodeInfo.getText();
                    if (text3 != null && text3.toString().toLowerCase().contains(d(keyAt).toLowerCase())) {
                        break;
                    } else {
                        return false;
                    }
                case 4:
                    CharSequence className = accessibilityNodeInfo.getClassName();
                    if (className != null && className.toString().contentEquals(d(keyAt))) {
                        break;
                    } else {
                        return false;
                    }
                case 5:
                    CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                    if (contentDescription != null && contentDescription.toString().contentEquals(d(keyAt))) {
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 6:
                    CharSequence contentDescription2 = accessibilityNodeInfo.getContentDescription();
                    if (contentDescription2 != null && contentDescription2.toString().toLowerCase().startsWith(d(keyAt).toLowerCase())) {
                        break;
                    } else {
                        return false;
                    }
                case 7:
                    CharSequence contentDescription3 = accessibilityNodeInfo.getContentDescription();
                    if (contentDescription3 != null && contentDescription3.toString().toLowerCase().contains(d(keyAt).toLowerCase())) {
                        break;
                    } else {
                        return false;
                    }
                case 8:
                    if (i2 == b(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case 10:
                    if (accessibilityNodeInfo.isEnabled() == a(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case 11:
                    if (accessibilityNodeInfo.isFocused() == a(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case 12:
                    if (accessibilityNodeInfo.isFocusable() == a(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case A /* 13 */:
                    if (accessibilityNodeInfo.isScrollable() == a(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case f /* 14 */:
                    if (accessibilityNodeInfo.isClickable() == a(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case b /* 15 */:
                    if (accessibilityNodeInfo.isChecked() == a(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case B /* 16 */:
                    if (accessibilityNodeInfo.isSelected() == a(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case u /* 18 */:
                    CharSequence packageName = accessibilityNodeInfo.getPackageName();
                    if (packageName != null && packageName.toString().contentEquals(d(keyAt))) {
                        break;
                    } else {
                        return false;
                    }
                case s /* 24 */:
                    if (accessibilityNodeInfo.isLongClickable() == a(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case F /* 25 */:
                    CharSequence text4 = accessibilityNodeInfo.getText();
                    if (text4 != null && c(keyAt).matcher(text4).matches()) {
                        break;
                    } else {
                        return false;
                    }
                    break;
                case e /* 26 */:
                    CharSequence className2 = accessibilityNodeInfo.getClassName();
                    if (className2 != null && c(keyAt).matcher(className2).matches()) {
                        break;
                    } else {
                        return false;
                    }
                    break;
                case l /* 27 */:
                    CharSequence contentDescription4 = accessibilityNodeInfo.getContentDescription();
                    if (contentDescription4 != null && c(keyAt).matcher(contentDescription4).matches()) {
                        break;
                    } else {
                        return false;
                    }
                case v /* 28 */:
                    CharSequence packageName2 = accessibilityNodeInfo.getPackageName();
                    if (packageName2 != null && c(keyAt).matcher(packageName2).matches()) {
                        break;
                    } else {
                        return false;
                    }
                    break;
                case y /* 29 */:
                    String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                    if (viewIdResourceName != null && viewIdResourceName.toString().contentEquals(d(keyAt))) {
                        break;
                    } else {
                        return false;
                    }
                case a /* 30 */:
                    if (accessibilityNodeInfo.isCheckable() == a(keyAt)) {
                        break;
                    } else {
                        return false;
                    }
                case z /* 31 */:
                    String viewIdResourceName2 = accessibilityNodeInfo.getViewIdResourceName();
                    if (viewIdResourceName2 != null && c(keyAt).matcher(viewIdResourceName2).matches()) {
                        break;
                    } else {
                        return false;
                    }
            }
        }
        return m();
    }

    int b(int i2) {
        return ((Integer) this.G.get(i2, 0)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public E b() {
        E e2 = (E) this.G.get(c, null);
        if (e2 != null) {
            return new E(e2);
        }
        return null;
    }

    public E b(E e2) {
        return a(c, e2);
    }

    public E b(String str) {
        return a(e, Pattern.compile(str));
    }

    public E b(boolean z2) {
        return a(b, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public E c() {
        E e2 = (E) this.G.get(g, null);
        if (e2 != null) {
            return new E(e2);
        }
        return null;
    }

    public E c(E e2) {
        return a(w, e2);
    }

    public E c(String str) {
        return a(5, str);
    }

    public E c(boolean z2) {
        return a(f, Boolean.valueOf(z2));
    }

    Pattern c(int i2) {
        return (Pattern) this.G.get(i2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return b(9);
    }

    public E d(String str) {
        return a(7, str);
    }

    String d(int i2) {
        return (String) this.G.get(i2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(E.class.getSimpleName() + "[");
        int size = this.G.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            int keyAt = this.G.keyAt(i2);
            switch (keyAt) {
                case 1:
                    sb.append("TEXT=").append(this.G.valueAt(i2));
                    break;
                case 2:
                    sb.append("START_TEXT=").append(this.G.valueAt(i2));
                    break;
                case 3:
                    sb.append("CONTAINS_TEXT=").append(this.G.valueAt(i2));
                    break;
                case 4:
                    sb.append("CLASS=").append(this.G.valueAt(i2));
                    break;
                case 5:
                    sb.append("DESCRIPTION=").append(this.G.valueAt(i2));
                    break;
                case 6:
                    sb.append("START_DESCRIPTION=").append(this.G.valueAt(i2));
                    break;
                case 7:
                    sb.append("CONTAINS_DESCRIPTION=").append(this.G.valueAt(i2));
                    break;
                case 8:
                    sb.append("INDEX=").append(this.G.valueAt(i2));
                    break;
                case 9:
                    sb.append("INSTANCE=").append(this.G.valueAt(i2));
                    break;
                case 10:
                    sb.append("ENABLED=").append(this.G.valueAt(i2));
                    break;
                case 11:
                    sb.append("FOCUSED=").append(this.G.valueAt(i2));
                    break;
                case 12:
                    sb.append("FOCUSABLE=").append(this.G.valueAt(i2));
                    break;
                case A /* 13 */:
                    sb.append("SCROLLABLE=").append(this.G.valueAt(i2));
                    break;
                case f /* 14 */:
                    sb.append("CLICKABLE=").append(this.G.valueAt(i2));
                    break;
                case b /* 15 */:
                    sb.append("CHECKED=").append(this.G.valueAt(i2));
                    break;
                case B /* 16 */:
                    sb.append("SELECTED=").append(this.G.valueAt(i2));
                    break;
                case p /* 17 */:
                    sb.append("ID=").append(this.G.valueAt(i2));
                    break;
                case u /* 18 */:
                    sb.append("PACKAGE NAME=").append(this.G.valueAt(i2));
                    break;
                case c /* 19 */:
                    if (z2) {
                        sb.append("CHILD=").append(this.G.valueAt(i2));
                        break;
                    } else {
                        sb.append("CHILD[..]");
                        break;
                    }
                case g /* 20 */:
                    if (z2) {
                        sb.append("CONTAINER=").append(this.G.valueAt(i2));
                        break;
                    } else {
                        sb.append("CONTAINER[..]");
                        break;
                    }
                case x /* 21 */:
                    if (z2) {
                        sb.append("PATTERN=").append(this.G.valueAt(i2));
                        break;
                    } else {
                        sb.append("PATTERN[..]");
                        break;
                    }
                case w /* 22 */:
                    if (z2) {
                        sb.append("PARENT=").append(this.G.valueAt(i2));
                        break;
                    } else {
                        sb.append("PARENT[..]");
                        break;
                    }
                case j /* 23 */:
                    sb.append("COUNT=").append(this.G.valueAt(i2));
                    break;
                case s /* 24 */:
                    sb.append("LONG_CLICKABLE=").append(this.G.valueAt(i2));
                    break;
                case F /* 25 */:
                    sb.append("TEXT_REGEX=").append(this.G.valueAt(i2));
                    break;
                case e /* 26 */:
                    sb.append("CLASS_REGEX=").append(this.G.valueAt(i2));
                    break;
                case l /* 27 */:
                    sb.append("DESCRIPTION_REGEX=").append(this.G.valueAt(i2));
                    break;
                case v /* 28 */:
                    sb.append("PACKAGE_NAME_REGEX=").append(this.G.valueAt(i2));
                    break;
                case y /* 29 */:
                    sb.append("RESOURCE_ID=").append(this.G.valueAt(i2));
                    break;
                case a /* 30 */:
                    sb.append("CHECKABLE=").append(this.G.valueAt(i2));
                    break;
                case z /* 31 */:
                    sb.append("RESOURCE_ID_REGEX=").append(this.G.valueAt(i2));
                    break;
                default:
                    sb.append("UNDEFINED=" + keyAt + " ").append(this.G.valueAt(i2));
                    break;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public E e() {
        E e2 = (E) this.G.get(w, null);
        if (e2 != null) {
            return new E(e2);
        }
        return null;
    }

    public E e(int i2) {
        return a(8, Integer.valueOf(i2));
    }

    public E e(String str) {
        return a(l, Pattern.compile(str));
    }

    public E e(boolean z2) {
        return a(10, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public E f() {
        E e2 = (E) this.G.get(x, null);
        if (e2 != null) {
            return new E(e2);
        }
        return null;
    }

    public E f(int i2) {
        return a(9, Integer.valueOf(i2));
    }

    public E f(String str) {
        return a(6, str);
    }

    public E f(boolean z2) {
        return a(12, Boolean.valueOf(z2));
    }

    public E g(String str) {
        return a(u, str);
    }

    public E g(boolean z2) {
        return a(11, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.G.indexOfKey(c) >= 0;
    }

    public E h(String str) {
        return a(v, Pattern.compile(str));
    }

    public E h(boolean z2) {
        return a(s, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.G.indexOfKey(g) >= 0;
    }

    public E i(String str) {
        return a(y, str);
    }

    public E i(boolean z2) {
        return a(A, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.G.indexOfKey(w) >= 0;
    }

    public E j(String str) {
        return a(z, Pattern.compile(str));
    }

    public E j(boolean z2) {
        return a(B, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.G.indexOfKey(x) >= 0;
    }

    public E k(String str) {
        return a(1, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.G.indexOfKey(c) < 0 && this.G.indexOfKey(w) < 0;
    }

    public E l(String str) {
        return a(3, str);
    }

    public E m(String str) {
        return a(F, Pattern.compile(str));
    }

    public E n(String str) {
        return a(2, str);
    }

    public String toString() {
        return d(true);
    }
}
