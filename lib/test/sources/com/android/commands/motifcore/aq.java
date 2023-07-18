package com.android.commands.motifcore;

import android.content.ComponentName;
import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Random;
/* loaded from: classes.dex */
public class aq implements InterfaceC0010e {
    private static final String A = "UserWait";
    private static final String B = "WriteLog";
    private static final String C = "count=";
    private static final String D = "linebyline";
    private static final String E = "speed=";
    private static int F = 2000;
    private static final int G = 100;
    private static final long H = 16;
    private static final String I = "start data >>";
    private static final boolean J = false;
    private static final String d = "GUIGen";
    private static final String e = "LaunchActivity";
    private static final String f = "DeviceWakeUp";
    private static final String g = "Drag";
    private static final String h = "EndCaptureAppFramerate";
    private static final String i = "EndCaptureFramerate";
    private static final String j = "DispatchFlip";
    private static final String k = "DispatchString";
    private static final String l = "LaunchInstrumentation";
    private static final String m = "DispatchKey";
    private static final String n = "DispatchPress";
    private static final String o = "LongPress";
    private static final String p = "PinchZoom";
    private static final String q = "DispatchPointer";
    private static final String r = "PowerLog";
    private static final String s = "PressAndHold";
    private static final String t = "ProfileWait";
    private static final String u = "RotateScreen";
    private static final String v = "RunCmd";
    private static final String w = "StartCaptureAppFramerate";
    private static final String x = "StartCaptureFramerate";
    private static final String y = "Tap";
    private static final String z = "DispatchTrackball";
    private long K;
    private long W;
    private C0009d X;
    private String Z;
    BufferedReader a;
    FileInputStream b;
    DataInputStream c;
    private int L = 0;
    private int ac = 0;
    private double ab = 1.0d;
    private long Q = 0;
    private long R = 0;
    private long N = 0;
    private long O = 0;
    private long P = -1;
    private long S = -1;
    private boolean Y = J;
    private boolean M = J;
    private float[] T = new float[2];
    private float[] U = new float[2];
    private long aa = -1;
    private long V = -1;

    public aq(Random random, String str, long j2, boolean z2, long j3, long j4) {
        this.W = 5000L;
        this.K = 30000L;
        this.Z = str;
        this.X = new C0009d(random, j2, z2);
        this.W = j3;
        this.K = j4;
    }

    private void a(long j2) {
        if (j2 < 1) {
            return;
        }
        try {
            Thread.sleep(j2);
        } catch (InterruptedException e2) {
        }
    }

    private void a(C0016k c0016k) {
        long f2;
        long g2;
        if (c0016k.g() < 0) {
            return;
        }
        if (this.S <= 0) {
            g2 = SystemClock.uptimeMillis();
            f2 = g2;
        } else {
            f2 = c0016k.f() != this.Q ? c0016k.f() : this.N;
            g2 = ((long) ((c0016k.g() - this.S) * this.ab)) + this.P;
        }
        this.Q = c0016k.f();
        this.S = c0016k.g();
        c0016k.a(f2);
        c0016k.b(g2);
        this.N = f2;
        this.P = g2;
    }

    private void a(AbstractC0017l abstractC0017l) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long f2 = abstractC0017l.f();
        if (f2 == this.R) {
            abstractC0017l.a(this.O);
        } else {
            this.R = f2;
            abstractC0017l.a(uptimeMillis);
            this.O = uptimeMillis;
        }
        abstractC0017l.b(uptimeMillis);
    }

    private void a(String str) {
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(41);
        if (indexOf < 0 || indexOf2 < 0) {
            return;
        }
        String[] split = str.substring(indexOf + 1, indexOf2).split(",");
        for (int i2 = 0; i2 < split.length; i2++) {
            split[i2] = split[i2].trim();
        }
        a(str, split);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v93 */
    private void a(String str, String[] strArr) {
        at atVar;
        if (str.indexOf(m) >= 0 && strArr.length == 8) {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.X.addLast(new C0016k(uptimeMillis, uptimeMillis, Integer.parseInt(strArr[2]), Integer.parseInt(strArr[3]), Integer.parseInt(strArr[4]), Integer.parseInt(strArr[5]), Integer.parseInt(strArr[6]), Integer.parseInt(strArr[7])));
            } catch (NumberFormatException e2) {
            }
        } else if ((str.indexOf(q) >= 0 || str.indexOf(z) >= 0) && strArr.length == 12) {
            try {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                int parseInt = Integer.parseInt(strArr[2]);
                float parseFloat = Float.parseFloat(strArr[3]);
                float parseFloat2 = Float.parseFloat(strArr[4]);
                float parseFloat3 = Float.parseFloat(strArr[5]);
                float parseFloat4 = Float.parseFloat(strArr[6]);
                int parseInt2 = Integer.parseInt(strArr[7]);
                float parseFloat5 = Float.parseFloat(strArr[8]);
                float parseFloat6 = Float.parseFloat(strArr[9]);
                int parseInt3 = Integer.parseInt(strArr[10]);
                int parseInt4 = Integer.parseInt(strArr[11]);
                AbstractC0017l asVar = str.indexOf("Pointer") > 0 ? new as(parseInt) : new at(parseInt);
                asVar.a(uptimeMillis2).b(uptimeMillis2).d(parseInt2).a(parseFloat5, parseFloat6).b(parseInt3).c(parseInt4).a(0, parseFloat, parseFloat2, parseFloat3, parseFloat4);
                this.X.addLast(asVar);
            } catch (NumberFormatException e3) {
            }
        } else if ((str.indexOf(q) >= 0 || str.indexOf(z) >= 0) && strArr.length == 13) {
            try {
                long uptimeMillis3 = SystemClock.uptimeMillis();
                int parseInt5 = Integer.parseInt(strArr[2]);
                float parseFloat7 = Float.parseFloat(strArr[3]);
                float parseFloat8 = Float.parseFloat(strArr[4]);
                float parseFloat9 = Float.parseFloat(strArr[5]);
                float parseFloat10 = Float.parseFloat(strArr[6]);
                int parseInt6 = Integer.parseInt(strArr[7]);
                float parseFloat11 = Float.parseFloat(strArr[8]);
                float parseFloat12 = Float.parseFloat(strArr[9]);
                int parseInt7 = Integer.parseInt(strArr[10]);
                int parseInt8 = Integer.parseInt(strArr[11]);
                int parseInt9 = Integer.parseInt(strArr[12]);
                if (str.indexOf("Pointer") > 0) {
                    AbstractC0017l a = parseInt5 == 5 ? new as((parseInt9 << 8) | 5).a(true) : new as(parseInt5);
                    if (this.aa < 0) {
                        this.V = SystemClock.uptimeMillis();
                        this.aa = uptimeMillis3;
                        atVar = a;
                    } else {
                        atVar = a;
                    }
                } else {
                    atVar = new at(parseInt5);
                }
                if (parseInt9 == 1) {
                    atVar.a(uptimeMillis3).b(uptimeMillis3).d(parseInt6).a(parseFloat11, parseFloat12).b(parseInt7).c(parseInt8).a(0, this.T[0], this.U[0], parseFloat9, parseFloat10).a(1, parseFloat7, parseFloat8, parseFloat9, parseFloat10);
                    this.T[1] = parseFloat7;
                    this.U[1] = parseFloat8;
                } else if (parseInt9 == 0) {
                    atVar.a(uptimeMillis3).b(uptimeMillis3).d(parseInt6).a(parseFloat11, parseFloat12).b(parseInt7).c(parseInt8).a(0, parseFloat7, parseFloat8, parseFloat9, parseFloat10);
                    if (parseInt5 == 6) {
                        atVar.a(1, this.T[1], this.U[1]);
                    }
                    this.T[0] = parseFloat7;
                    this.U[0] = parseFloat8;
                }
                if (this.Y) {
                    long uptimeMillis4 = SystemClock.uptimeMillis() - this.V;
                    long j2 = uptimeMillis3 - this.aa;
                    if (uptimeMillis4 < j2) {
                        this.X.addLast(new aw(j2 - uptimeMillis4));
                    }
                }
                this.X.addLast(atVar);
            } catch (NumberFormatException e4) {
            }
        } else if (str.indexOf(u) >= 0 && strArr.length == 2) {
            try {
                int parseInt10 = Integer.parseInt(strArr[0]);
                int parseInt11 = Integer.parseInt(strArr[1]);
                if (parseInt10 == 0 || parseInt10 == 1 || parseInt10 == 2 || parseInt10 == 3) {
                    this.X.addLast(new C0021p(parseInt10, parseInt11 != 0 ? true : J));
                }
            } catch (NumberFormatException e5) {
            }
        } else if (str.indexOf(y) >= 0 && strArr.length >= 2) {
            try {
                float parseFloat13 = Float.parseFloat(strArr[0]);
                float parseFloat14 = Float.parseFloat(strArr[1]);
                long parseLong = strArr.length == 3 ? Long.parseLong(strArr[2]) : 0L;
                long uptimeMillis5 = SystemClock.uptimeMillis();
                this.X.addLast(new as(0).a(uptimeMillis5).b(uptimeMillis5).a(0, parseFloat13, parseFloat14, 1.0f, 5.0f));
                if (parseLong > 0) {
                    this.X.addLast(new aw(parseLong));
                }
                this.X.addLast(new as(1).a(uptimeMillis5).b(uptimeMillis5).a(0, parseFloat13, parseFloat14, 1.0f, 5.0f));
            } catch (NumberFormatException e6) {
                System.err.println("// " + e6.toString());
            }
        } else if (str.indexOf(s) >= 0 && strArr.length == 3) {
            try {
                float parseFloat15 = Float.parseFloat(strArr[0]);
                float parseFloat16 = Float.parseFloat(strArr[1]);
                long parseLong2 = Long.parseLong(strArr[2]);
                long uptimeMillis6 = SystemClock.uptimeMillis();
                AbstractC0017l a2 = new as(0).a(uptimeMillis6).b(uptimeMillis6).a(0, parseFloat15, parseFloat16, 1.0f, 5.0f);
                aw awVar = new aw(parseLong2);
                new as(1).a(uptimeMillis6 + parseLong2).b(uptimeMillis6 + parseLong2).a(0, parseFloat15, parseFloat16, 1.0f, 5.0f);
                this.X.addLast(a2);
                this.X.addLast(awVar);
                this.X.addLast(awVar);
            } catch (NumberFormatException e7) {
                System.err.println("// " + e7.toString());
            }
        } else {
            if (str.indexOf(g) >= 0 && strArr.length == 5) {
                float parseFloat17 = Float.parseFloat(strArr[0]);
                float parseFloat18 = Float.parseFloat(strArr[1]);
                float parseFloat19 = Float.parseFloat(strArr[2]);
                float parseFloat20 = Float.parseFloat(strArr[3]);
                int parseInt12 = Integer.parseInt(strArr[4]);
                long uptimeMillis7 = SystemClock.uptimeMillis();
                long uptimeMillis8 = SystemClock.uptimeMillis();
                if (parseInt12 > 0) {
                    float f2 = (parseFloat19 - parseFloat17) / parseInt12;
                    float f3 = (parseFloat20 - parseFloat18) / parseInt12;
                    this.X.addLast(new as(0).a(uptimeMillis7).b(uptimeMillis8).a(0, parseFloat17, parseFloat18, 1.0f, 5.0f));
                    for (int i2 = 0; i2 < parseInt12; i2++) {
                        parseFloat17 += f2;
                        parseFloat18 += f3;
                        this.X.addLast(new as(2).a(uptimeMillis7).b(SystemClock.uptimeMillis()).a(0, parseFloat17, parseFloat18, 1.0f, 5.0f));
                    }
                    this.X.addLast(new as(1).a(uptimeMillis7).b(SystemClock.uptimeMillis()).a(0, parseFloat17, parseFloat18, 1.0f, 5.0f));
                }
            }
            if (str.indexOf(p) >= 0 && strArr.length == 9) {
                float parseFloat21 = Float.parseFloat(strArr[0]);
                float parseFloat22 = Float.parseFloat(strArr[1]);
                float parseFloat23 = Float.parseFloat(strArr[2]);
                float parseFloat24 = Float.parseFloat(strArr[3]);
                float parseFloat25 = Float.parseFloat(strArr[4]);
                float parseFloat26 = Float.parseFloat(strArr[5]);
                float parseFloat27 = Float.parseFloat(strArr[6]);
                float parseFloat28 = Float.parseFloat(strArr[7]);
                int parseInt13 = Integer.parseInt(strArr[8]);
                long uptimeMillis9 = SystemClock.uptimeMillis();
                long uptimeMillis10 = SystemClock.uptimeMillis();
                if (parseInt13 > 0) {
                    float f4 = (parseFloat23 - parseFloat21) / parseInt13;
                    float f5 = (parseFloat24 - parseFloat22) / parseInt13;
                    float f6 = (parseFloat27 - parseFloat25) / parseInt13;
                    float f7 = (parseFloat28 - parseFloat26) / parseInt13;
                    this.X.addLast(new as(0).a(uptimeMillis9).b(uptimeMillis10).a(0, parseFloat21, parseFloat22, 1.0f, 5.0f));
                    this.X.addLast(new as(261).a(uptimeMillis9).a(0, parseFloat21, parseFloat22).a(1, parseFloat25, parseFloat26).a(true));
                    for (int i3 = 0; i3 < parseInt13; i3++) {
                        parseFloat21 += f4;
                        parseFloat22 += f5;
                        parseFloat25 += f6;
                        parseFloat26 += f7;
                        this.X.addLast(new as(2).a(uptimeMillis9).b(SystemClock.uptimeMillis()).a(0, parseFloat21, parseFloat22, 1.0f, 5.0f).a(1, parseFloat25, parseFloat26, 1.0f, 5.0f));
                    }
                    this.X.addLast(new as(6).a(uptimeMillis9).b(SystemClock.uptimeMillis()).a(0, parseFloat21, parseFloat22).a(1, parseFloat25, parseFloat26));
                }
            }
            if (str.indexOf(j) >= 0 && strArr.length == 1) {
                this.X.addLast(new C0011f(Boolean.parseBoolean(strArr[0])));
            }
            if (str.indexOf(d) >= 0) {
                this.X.addLast(new C0012g());
            }
            if (str.indexOf(e) >= 0 && strArr.length >= 2) {
                long j3 = 0;
                ComponentName componentName = new ComponentName(strArr[0], strArr[1]);
                if (strArr.length > 2) {
                    try {
                        j3 = Long.parseLong(strArr[2]);
                    } catch (NumberFormatException e8) {
                        System.err.println("// " + e8.toString());
                        return;
                    }
                }
                if (strArr.length == 2) {
                    this.X.addLast(new C0006a(componentName));
                } else {
                    this.X.addLast(new C0006a(componentName, j3));
                }
            } else if (str.indexOf(f) >= 0) {
                long j4 = this.K;
                this.X.addLast(new C0006a(new ComponentName("com.google.android.powerutil", "com.google.android.powerutil.WakeUpScreen"), j4));
                this.X.addLast(new C0016k(0, 7));
                this.X.addLast(new C0016k(1, 7));
                this.X.addLast(new aw(j4 + 3000));
                this.X.addLast(new C0016k(0, 82));
                this.X.addLast(new C0016k(1, 82));
                this.X.addLast(new C0016k(0, 4));
                this.X.addLast(new C0016k(1, 4));
            } else if (str.indexOf(l) >= 0 && strArr.length == 2) {
                this.X.addLast(new C0015j(strArr[0], strArr[1]));
            } else if (str.indexOf(A) >= 0 && strArr.length == 1) {
                try {
                    this.X.addLast(new aw(Integer.parseInt(strArr[0])));
                } catch (NumberFormatException e9) {
                }
            } else if (str.indexOf(t) >= 0) {
                this.X.addLast(new aw(this.W));
            } else if (str.indexOf(n) >= 0 && strArr.length == 1) {
                int a3 = ao.a(strArr[0]);
                if (a3 != 0) {
                    this.X.addLast(new C0016k(0, a3));
                    this.X.addLast(new C0016k(1, a3));
                }
            } else {
                if (str.indexOf(o) >= 0) {
                    this.X.addLast(new C0016k(0, 23));
                    this.X.addLast(new aw(F));
                    this.X.addLast(new C0016k(1, 23));
                }
                if (str.indexOf(r) >= 0 && strArr.length > 0) {
                    String str2 = strArr[0];
                    if (strArr.length == 1) {
                        this.X.addLast(new C0020o(str2));
                    } else if (strArr.length == 2) {
                        this.X.addLast(new C0020o(str2, strArr[1]));
                    }
                }
                if (str.indexOf(B) >= 0) {
                    this.X.addLast(new C0020o());
                }
                if (str.indexOf(v) >= 0 && strArr.length == 1) {
                    this.X.addLast(new C0007b(strArr[0]));
                }
                if (str.indexOf(k) >= 0 && strArr.length == 1) {
                    this.X.addLast(new C0007b("input text " + strArr[0]));
                } else if (str.indexOf(x) >= 0) {
                    this.X.addLast(new C0014i("start"));
                } else if (str.indexOf(i) >= 0 && strArr.length == 1) {
                    this.X.addLast(new C0014i("end", strArr[0]));
                } else if (str.indexOf(w) >= 0 && strArr.length == 1) {
                    this.X.addLast(new C0013h("start", strArr[0]));
                } else if (str.indexOf(h) >= 0 && strArr.length == 2) {
                    this.X.addLast(new C0013h("end", strArr[0], strArr[1]));
                }
            }
        }
    }

    private void c() {
        this.M = J;
        try {
            this.b.close();
            this.c.close();
        } catch (NullPointerException e2) {
        }
    }

    private boolean d() {
        this.M = true;
        this.b = new FileInputStream(this.Z);
        this.c = new DataInputStream(this.b);
        this.a = new BufferedReader(new InputStreamReader(this.c));
        while (true) {
            String readLine = this.a.readLine();
            if (readLine == null) {
                return J;
            }
            String trim = readLine.trim();
            if (trim.indexOf(C) >= 0) {
                try {
                    this.L = Integer.parseInt(trim.substring(C.length() + 1).trim());
                } catch (NumberFormatException e2) {
                    System.err.println(e2);
                    return J;
                }
            } else if (trim.indexOf(E) >= 0) {
                try {
                    this.ab = Double.parseDouble(trim.substring(C.length() + 1).trim());
                } catch (NumberFormatException e3) {
                    System.err.println(e3);
                    return J;
                }
            } else if (trim.indexOf(D) >= 0) {
                this.Y = true;
            } else if (trim.indexOf(I) >= 0) {
                return true;
            }
        }
    }

    private int e() {
        for (int i2 = 0; i2 < G; i2++) {
            String readLine = this.a.readLine();
            if (readLine == null) {
                return i2;
            }
            readLine.trim();
            a(readLine);
        }
        return G;
    }

    private void f() {
        if (!this.M) {
            h();
            d();
        }
        if ((this.Y ? g() : e()) == 0) {
            c();
        }
    }

    private int g() {
        String readLine = this.a.readLine();
        if (readLine == null) {
            return 0;
        }
        readLine.trim();
        a(readLine);
        return 1;
    }

    private void h() {
        this.Q = 0L;
        this.R = 0L;
        this.S = -1L;
        this.N = 0L;
        this.O = 0L;
        this.P = -1L;
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public AbstractC0008c a() {
        if (this.X.isEmpty()) {
            try {
                f();
            } catch (IOException e2) {
                return null;
            }
        }
        try {
            AbstractC0008c abstractC0008c = (AbstractC0008c) this.X.getFirst();
            this.X.removeFirst();
            if (abstractC0008c.b() == 0) {
                a((C0016k) abstractC0008c);
                return abstractC0008c;
            } else if (abstractC0008c.b() == 1 || abstractC0008c.b() == 2) {
                a((AbstractC0017l) abstractC0008c);
                return abstractC0008c;
            } else {
                return abstractC0008c;
            }
        } catch (NoSuchElementException e3) {
            return null;
        }
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public void a(int i2) {
        this.ac = i2;
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public boolean b() {
        try {
            boolean d2 = d();
            c();
            if (this.ac > 0) {
                System.out.println("Replaying " + this.L + " events with speed " + this.ab);
                return d2;
            }
            return d2;
        } catch (IOException e2) {
            return J;
        }
    }
}
