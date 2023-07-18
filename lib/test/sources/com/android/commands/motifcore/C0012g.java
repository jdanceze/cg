package com.android.commands.motifcore;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.app.IThumbnailReceiver;
import android.os.RemoteException;
import android.view.IWindowManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/* renamed from: com.android.commands.motifcore.g  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0012g extends AbstractC0008c {
    private String a;

    public C0012g() {
        super(4);
        this.a = "uiautomator runtest GUIGen.jar -c org.crowddev.android.test.Guigen -e aut_package " + Motifcore.b;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public int a(IWindowManager iWindowManager, IActivityManager iActivityManager, int i) {
        int i2;
        String str;
        int i3;
        com.android.a.a.B b;
        int size;
        int i4 = 0;
        if (this.a != null) {
            try {
                str = ((ActivityManager.RunningTaskInfo) iActivityManager.getTasks(1, 0, (IThumbnailReceiver) null).get(0)).topActivity.getClassName();
            } catch (RemoteException e) {
                e.printStackTrace();
                str = null;
            }
            if (str == null) {
                return 0;
            }
            com.android.a.a.E a = new com.android.a.a.E().a("android.widget.TextView");
            if (!new com.android.a.a.B(a).f()) {
            }
            int i5 = 2;
            com.android.a.a.E f = a.f(1);
            int i6 = 1;
            while (new com.android.a.a.B(f).f()) {
                int i7 = i5 * 2;
                f = f.f(i7 - 1);
                int i8 = i5;
                i5 = i7;
                i6 = i8;
            }
            com.android.a.a.E e2 = f;
            int i9 = i6;
            while (i5 > i9 + 1) {
                int i10 = (i9 + i5) / 2;
                e2 = e2.f(i10 - 1);
                if (new com.android.a.a.B(e2).f()) {
                    i9 = i10;
                } else {
                    i5 = i10;
                }
            }
            System.out.println("### Number of instances: " + i9);
            String str2 = str + " | " + i9;
            if (Motifcore.a.contains(str2)) {
                return 0;
            }
            Motifcore.a.add(str2);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < i9; i11++) {
                arrayList.add(Integer.valueOf(i11));
            }
            Collections.shuffle(arrayList, new Random(System.nanoTime()));
            try {
                com.android.a.a.B b2 = new com.android.a.a.B(e2.f(((Integer) arrayList.get(0)).intValue()));
                if (b2.f()) {
                    System.out.println("### Longcliked an element.");
                    b2.z();
                }
            } catch (com.android.a.a.C e3) {
                e3.printStackTrace();
            }
            com.android.a.a.E c = new com.android.a.a.E().c(true);
            if (!new com.android.a.a.B(c).f()) {
            }
            int i12 = 2;
            com.android.a.a.E f2 = c.f(1);
            int i13 = 1;
            while (new com.android.a.a.B(f2).f()) {
                int i14 = i12 * 2;
                f2 = f2.f(i14 - 1);
                i13 = i12;
                i12 = i14;
            }
            com.android.a.a.E e4 = f2;
            int i15 = i13;
            while (i12 > i15 + 1) {
                int i16 = (i15 + i12) / 2;
                com.android.a.a.E f3 = e4.f(i16 - 1);
                if (new com.android.a.a.B(f3).f()) {
                    i15 = i16;
                    e4 = f3;
                } else {
                    i12 = i16;
                    e4 = f3;
                }
            }
            System.out.println("### Number of instances: " + i15);
            String str3 = str + " | " + i15;
            if (Motifcore.a.contains(str3)) {
                return 0;
            }
            Motifcore.a.add(str3);
            ArrayList arrayList2 = new ArrayList();
            for (int i17 = 0; i17 < i15; i17++) {
                arrayList2.add(Integer.valueOf(i17));
            }
            Collections.shuffle(arrayList2, new Random(System.nanoTime()));
            int i18 = 0;
            int i19 = 0;
            while (i4 < i15) {
                try {
                    b = new com.android.a.a.B(e4.f(((Integer) arrayList2.get(i4)).intValue()));
                } catch (com.android.a.a.C e5) {
                    i3 = i18;
                    e5.printStackTrace();
                }
                if (!b.f()) {
                    break;
                }
                if (b.i().equalsIgnoreCase("android.view.View")) {
                    i3 = i18;
                } else if (b.i().equalsIgnoreCase("android.widget.RelativeLayout")) {
                    i3 = i18;
                } else {
                    int i20 = i18 + 1;
                    if (i20 > 30) {
                        i2 = i19;
                        break;
                    } else if (b.i().equalsIgnoreCase("android.widget.EditText")) {
                        String str4 = "0";
                        if (Motifcore.k && (size = Motifcore.j.size()) != 0) {
                            str4 = (String) Motifcore.j.get(new Random().nextInt(size));
                        }
                        if ("0".equals(str4)) {
                            b.b();
                            Motifcore.h.a(7);
                        } else {
                            b.a(str4);
                        }
                        i19 += 2;
                        System.out.println("### Seed an string to EditText: " + str4);
                        i3 = i20;
                    } else if (b.w()) {
                        System.out.println("### Longcliked2 an element.");
                        b.z();
                        i19++;
                        i3 = i20;
                    } else {
                        System.out.println("### Cliked an element.");
                        b.b();
                        i19++;
                        i3 = i20;
                    }
                }
                i4++;
                i18 = i3;
            }
            i2 = i19;
        } else {
            i2 = 0;
        }
        if (!Motifcore.g) {
            try {
                a(i2);
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        return 1;
    }

    @Override // com.android.commands.motifcore.AbstractC0008c
    public void a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GUIGen(" + i);
        Motifcore.e.write(stringBuffer.toString() + ")\n");
    }
}
