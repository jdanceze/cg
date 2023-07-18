package com.android.commands.motifcore;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.IActivityController;
import android.app.IActivityManager;
import android.app.IThumbnailReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.IPackageManager;
import android.content.pm.ResolveInfo;
import android.os.Debug;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Log;
import android.view.IWindowManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class Motifcore {
    private static final int C = 0;
    private static final int D = 0;
    public static Intent c;
    public static String d;
    public static List j;
    private boolean G;
    private IActivityManager H;
    private String[] I;
    private String L;
    private boolean M;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean T;
    private boolean V;
    private int X;
    private String Y;
    private String Z;
    private IPackageManager aa;
    private String ab;
    private boolean al;
    private int aq;
    private IWindowManager as;
    InterfaceC0010e t;
    static HashSet l = new HashSet();
    static ArrayList i = new ArrayList();
    private static final File E = new File("/data/tombstones");
    public static BufferedWriter e = null;
    public static boolean g = false;
    public static String b = null;
    static String f = "/mnt/sdcard";
    public static com.android.a.a.y h = null;
    public static HashSet a = new HashSet();
    public static boolean k = false;
    private boolean K = true;
    private boolean ad = false;
    private boolean ag = false;
    private boolean ac = false;
    private boolean aj = false;
    private boolean ar = false;
    private boolean ae = false;
    private boolean N = false;
    private boolean ah = false;
    private long J = 10;
    private boolean ai = false;
    private HashSet S = new HashSet();
    private ArrayList U = new ArrayList();
    long B = 0;
    boolean y = false;
    int m = 1000;
    long A = 0;
    Random w = null;
    long p = 0;
    long q = 0;
    long s = 0;
    long o = 0;
    long r = 0;
    long v = 5000;
    long n = 30000;
    boolean x = false;
    boolean z = false;
    private boolean af = false;
    private String an = null;
    private ArrayList ak = new ArrayList();
    private int am = -1;
    private HashSet ap = null;
    float[] u = new float[12];
    private C0018m W = new C0018m();
    private HashSet at = new HashSet();
    private HashSet F = new HashSet();
    private String ao = null;

    private int a(String[] strArr) {
        int i2;
        for (String str : strArr) {
            if ("--wait-dbg".equals(str)) {
                Debug.waitForDebugger();
            }
        }
        this.aq = 0;
        this.m = 1000;
        this.A = 0L;
        this.B = 0L;
        this.I = strArr;
        this.X = 0;
        for (int i3 = 0; i3 < 12; i3++) {
            this.u[i3] = 1.0f;
        }
        if (i() && e()) {
            if (this.U.size() == 0) {
                this.U.add("android.intent.category.LAUNCHER");
                this.U.add("android.intent.category.MONKEY");
            }
            if (this.A == 0) {
                this.A = System.currentTimeMillis() + System.identityHashCode(this);
            }
            if (k) {
                try {
                    j = au.b(au.c(this.ao));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.aq > 0) {
                System.out.println(":Monkey: seed=" + this.A + " count=" + this.m);
                if (l.size() > 0) {
                    Iterator it = l.iterator();
                    while (it.hasNext()) {
                        System.out.println(":AllowPackage: " + ((String) it.next()));
                    }
                }
                if (this.S.size() > 0) {
                    Iterator it2 = this.S.iterator();
                    while (it2.hasNext()) {
                        System.out.println(":DisallowPackage: " + ((String) it2.next()));
                    }
                }
                if (this.U.size() != 0) {
                    Iterator it3 = this.U.iterator();
                    while (it3.hasNext()) {
                        System.out.println(":IncludeCategory: " + ((String) it3.next()));
                    }
                }
            }
            if (a()) {
                if (d()) {
                    if (c()) {
                        this.w = new Random(this.A);
                        if (this.ak != null && this.ak.size() == 1) {
                            this.t = new aq(this.w, (String) this.ak.get(0), this.B, this.y, this.v, this.n);
                            this.t.a(this.aq);
                            this.K = false;
                        } else if (this.ak != null && this.ak.size() > 1) {
                            if (this.an != null) {
                                this.t = new ap(this.an, this.ak, this.B, this.y, this.w, this.v, this.n, this.x);
                                this.m++;
                            } else {
                                this.t = new ap(this.ak, this.B, this.y, this.w, this.v, this.n, this.x);
                            }
                            this.t.a(this.aq);
                            this.K = false;
                        } else if (this.am != -1) {
                            try {
                                this.t = new C0022q(this.am);
                                this.m = Integer.MAX_VALUE;
                            } catch (IOException e3) {
                                System.out.println("Error binding to network socket.");
                                return -5;
                            }
                        } else {
                            if (this.aq >= 2) {
                                System.out.println("// Seeded: " + this.A);
                            }
                            this.t = new ao(this.w, i, this.B, this.y);
                            this.t.a(this.aq);
                            for (int i4 = 0; i4 < 12; i4++) {
                                if (this.u[i4] <= 0.0f) {
                                    ((ao) this.t).a(i4, this.u[i4]);
                                }
                            }
                            ((ao) this.t).c();
                        }
                        if (this.t.b()) {
                            if (this.M) {
                                o();
                            }
                            this.W.b();
                            try {
                                try {
                                    int m = m();
                                    new C0021p(0, false).a(this.as, this.H, this.aq);
                                    i2 = m;
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    new C0021p(0, false).a(this.as, this.H, this.aq);
                                    i2 = 0;
                                }
                                this.W.c();
                                synchronized (this) {
                                    File file = new File(f, "skin.coverage");
                                    try {
                                        file.createNewFile();
                                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                                        Iterator it4 = this.at.iterator();
                                        while (it4.hasNext()) {
                                            bufferedWriter.write(((String) it4.next()) + "\n");
                                        }
                                        bufferedWriter.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                    File file2 = new File(f, "activity.coverage");
                                    try {
                                        file2.createNewFile();
                                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
                                        Iterator it5 = this.F.iterator();
                                        while (it5.hasNext()) {
                                            bufferedWriter2.write(((String) it5.next()) + "\n");
                                        }
                                        bufferedWriter2.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                    if (this.ad) {
                                        j();
                                        this.ad = false;
                                    }
                                    if (this.ac) {
                                        System.out.println("Print the anr report");
                                        b("anr_" + this.ab + "_");
                                        this.ac = false;
                                    }
                                    if (this.aj) {
                                        System.out.println("Print the watchdog report");
                                        b("anr_watchdog_");
                                        this.aj = false;
                                    }
                                    if (this.ae) {
                                        b("app_crash" + this.ab + "_");
                                        this.ae = false;
                                    }
                                    if (this.ag) {
                                        k();
                                        this.ag = false;
                                    }
                                    if (this.ah) {
                                        b("Bugreport_");
                                        this.ah = false;
                                    }
                                    if (this.ar) {
                                        this.ar = false;
                                        notifyAll();
                                    }
                                }
                                if (this.M) {
                                    o();
                                    if (this.aq > 0) {
                                        System.out.println("// Generated profiling reports in /data/misc");
                                    }
                                }
                                try {
                                    this.H.setActivityController((IActivityController) null);
                                    this.W.b(this.H);
                                } catch (RemoteException e7) {
                                    if (i2 >= this.m) {
                                        i2 = this.m - 1;
                                    }
                                }
                                if (this.aq > 0) {
                                    System.out.print(":Dropped: keys=");
                                    System.out.print(this.p);
                                    System.out.print(" pointers=");
                                    System.out.print(this.q);
                                    System.out.print(" trackballs=");
                                    System.out.print(this.s);
                                    System.out.print(" flips=");
                                    System.out.print(this.o);
                                    System.out.print(" rotations=");
                                    System.out.println(this.r);
                                }
                                this.W.a();
                                if (i2 < this.m - 1) {
                                    System.err.println("** System appears to have crashed at event " + i2 + " of " + this.m + " using seed " + this.A);
                                    return i2;
                                }
                                if (this.aq > 0) {
                                    System.out.println("// Monkey finished");
                                }
                                return 0;
                            } catch (Throwable th) {
                                new C0021p(0, false).a(this.as, this.H, this.aq);
                                throw th;
                            }
                        }
                        return -5;
                    }
                    return -4;
                }
                return -3;
            }
            return -2;
        }
        return -1;
    }

    private void a(int i2) {
    }

    private void a(String str, String str2) {
        System.err.println(str + ":");
        Runtime.getRuntime();
        try {
            Process exec = Runtime.getRuntime().exec(str2);
            BufferedWriter bufferedWriter = this.af ? new BufferedWriter(new FileWriter(new File(f, str), true)) : null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (this.af) {
                    bufferedWriter.write(readLine);
                    bufferedWriter.write("\n");
                } else {
                    System.err.println(readLine);
                }
            }
            System.err.println("// " + str + " status was " + exec.waitFor());
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (Exception e2) {
            System.err.println("// Exception from " + str + ":");
            System.err.println(e2.toString());
        }
    }

    private boolean a() {
        return true;
    }

    public boolean a(String str) {
        return this.S.size() <= 0 ? l.size() <= 0 || l.contains(str) : !this.S.contains(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(java.lang.String r4, java.util.HashSet r5) {
        /*
            r2 = 0
            r3 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L5a
            java.io.FileReader r0 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L5a
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L5a
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L5a
        Lc:
            java.lang.String r0 = r1.readLine()     // Catch: java.io.IOException -> L28 java.lang.Throwable -> L5d
            if (r0 == 0) goto L35
            java.lang.String r0 = r0.trim()     // Catch: java.io.IOException -> L28 java.lang.Throwable -> L5d
            int r2 = r0.length()     // Catch: java.io.IOException -> L28 java.lang.Throwable -> L5d
            if (r2 <= 0) goto Lc
            java.lang.String r2 = "#"
            boolean r2 = r0.startsWith(r2)     // Catch: java.io.IOException -> L28 java.lang.Throwable -> L5d
            if (r2 != 0) goto Lc
            r5.add(r0)     // Catch: java.io.IOException -> L28 java.lang.Throwable -> L5d
            goto Lc
        L28:
            r0 = move-exception
        L29:
            java.io.PrintStream r2 = java.lang.System.err     // Catch: java.lang.Throwable -> L5f
            r2.println(r0)     // Catch: java.lang.Throwable -> L5f
            if (r1 == 0) goto L33
            r1.close()     // Catch: java.io.IOException -> L43
        L33:
            r0 = r3
        L34:
            return r0
        L35:
            if (r1 == 0) goto L3a
            r1.close()     // Catch: java.io.IOException -> L3c
        L3a:
            r0 = 1
            goto L34
        L3c:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.err
            r1.println(r0)
            goto L3a
        L43:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.err
            r1.println(r0)
            r0 = r3
            goto L34
        L4b:
            r0 = move-exception
        L4c:
            r1 = r2
        L4d:
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.io.IOException -> L53
        L52:
            throw r0
        L53:
            r1 = move-exception
            java.io.PrintStream r2 = java.lang.System.err
            r2.println(r1)
            goto L52
        L5a:
            r0 = move-exception
            r1 = r2
            goto L29
        L5d:
            r0 = move-exception
            goto L4d
        L5f:
            r0 = move-exception
            r2 = r1
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.commands.motifcore.Motifcore.a(java.lang.String, java.util.HashSet):boolean");
    }

    private void b(String str) {
    }

    private boolean b() {
        boolean z = false;
        String[] list = E.list();
        if (list == null || list.length == 0) {
            this.ap = null;
        } else {
            HashSet hashSet = new HashSet();
            for (String str : list) {
                hashSet.add(str);
            }
            z = (this.ap == null || !this.ap.containsAll(hashSet)) ? true : true;
            this.ap = hashSet;
        }
        return z;
    }

    private long c(String str) {
        try {
            return Long.parseLong(h());
        } catch (NumberFormatException e2) {
            System.err.println("** Error: " + str + " is not a number");
            throw e2;
        }
    }

    private boolean c() {
        try {
            int size = this.U.size();
            for (int i2 = 0; i2 < size; i2++) {
                Intent intent = new Intent("android.intent.action.MAIN");
                String str = (String) this.U.get(i2);
                if (str.length() > 0) {
                    intent.addCategory(str);
                }
                List queryIntentActivities = this.aa.queryIntentActivities(intent, (String) null, 0, UserHandle.myUserId());
                if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                    System.err.println("// Warning: no activities found for category " + str);
                } else {
                    if (this.aq >= 2) {
                        System.out.println("// Selecting main activities from category " + str);
                    }
                    int size2 = queryIntentActivities.size();
                    System.out.println("### Number of Activities in mainApps: " + size2);
                    for (int i3 = 0; i3 < size2; i3++) {
                        ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i3);
                        String str2 = resolveInfo.activityInfo.applicationInfo.packageName;
                        if (a(str2)) {
                            if (this.aq >= 2) {
                                System.out.println("//   + Using main activity " + resolveInfo.activityInfo.name + " (from package " + str2 + ")");
                            }
                            i.add(new ComponentName(str2, resolveInfo.activityInfo.name));
                        } else if (this.aq >= 3) {
                            System.out.println("//   - NOT USING main activity " + resolveInfo.activityInfo.name + " (from package " + str2 + ")");
                        }
                    }
                }
            }
            if (i.size() == 0) {
                System.out.println("** No activities found to run, monkey aborted.");
                return false;
            }
            return true;
        } catch (RemoteException e2) {
            System.err.println("** Failed talking with package manager!");
            return false;
        }
    }

    private boolean d() {
        this.H = ActivityManagerNative.getDefault();
        if (this.H == null) {
            System.err.println("** Error: Unable to connect to activity manager; is the system running?");
            return false;
        }
        this.as = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        if (this.as == null) {
            System.err.println("** Error: Unable to connect to window manager; is the system running?");
            return false;
        }
        this.aa = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
        if (this.aa == null) {
            System.err.println("** Error: Unable to connect to package manager; is the system running?");
            return false;
        }
        try {
            this.H.setActivityController(new ay(this));
            this.W.a(this.H);
            return true;
        } catch (RemoteException e2) {
            System.err.println("** Failed talking with activity manager!");
            return false;
        }
    }

    private boolean e() {
        if ((this.Z != null || l.size() > 0) && this.Y != null) {
            System.err.println("** Error: you can not specify a package blacklist together with a whitelist or individual packages (via -p).");
        } else if ((this.Z == null || a(this.Z, l)) && (this.Y == null || a(this.Y, this.S))) {
            return true;
        }
        return false;
    }

    private String f() {
        if (this.X >= this.I.length) {
            return null;
        }
        String str = this.I[this.X];
        this.X++;
        return str;
    }

    private String g() {
        if (this.X >= this.I.length) {
            return null;
        }
        String str = this.I[this.X];
        if (str.startsWith("-")) {
            this.X++;
            if (str.equals("--")) {
                return null;
            }
            if (str.length() <= 1 || str.charAt(1) == '-') {
                this.L = null;
                return str;
            } else if (str.length() > 2) {
                this.L = str.substring(2);
                return str.substring(0, 2);
            } else {
                this.L = null;
                return str;
            }
        }
        return null;
    }

    private String h() {
        if (this.L != null) {
            return this.L;
        }
        if (this.X >= this.I.length) {
            return null;
        }
        String str = this.I[this.X];
        this.X++;
        return str;
    }

    private boolean i() {
        if (this.I.length < 1) {
            n();
            return false;
        }
        while (true) {
            try {
                String g2 = g();
                if (g2 == null) {
                    if (this.am == -1) {
                        String f2 = f();
                        if (f2 == null) {
                            System.err.println("** Error: Count not specified");
                            n();
                            return false;
                        }
                        try {
                            this.m = Integer.parseInt(f2);
                        } catch (NumberFormatException e2) {
                            System.err.println("** Error: Count is not a number");
                            n();
                            return false;
                        }
                    }
                    if (!g) {
                        try {
                            System.out.println("\n### Path:" + f + "/motifcore.script");
                            File file = new File(f, "motifcore.script");
                            Log.v("MotifcoreScript", f + "/motifcore.script");
                            e = new BufferedWriter(new FileWriter(file));
                            e.write("type= raw events\ncount= -1\nspeed= 1.0\nstart data >>\n");
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return true;
                } else if (g2.equals("-s")) {
                    this.A = c("Seed");
                } else if (g2.equals("-p")) {
                    String h2 = h();
                    b = h2;
                    l.add(h2);
                } else if (g2.equals("-c")) {
                    this.U.add(h());
                } else if (g2.equals("-v")) {
                    this.aq++;
                } else if (g2.equals("--ignore-crashes")) {
                    this.O = true;
                } else if (g2.equals("--ignore-timeouts")) {
                    this.R = true;
                } else if (g2.equals("--ignore-security-exceptions")) {
                    this.Q = true;
                } else if (g2.equals("--monitor-native-crashes")) {
                    this.V = true;
                } else if (g2.equals("--ignore-native-crashes")) {
                    this.P = true;
                } else if (g2.equals("--kill-process-after-error")) {
                    this.T = true;
                } else if (g2.equals("--hprof")) {
                    this.M = true;
                } else if (g2.equals("--pct-touch")) {
                    this.u[0] = (float) (-c("touch events percentage"));
                } else if (g2.equals("--pct-motion")) {
                    this.u[1] = (float) (-c("motion events percentage"));
                } else if (g2.equals("--pct-trackball")) {
                    this.u[3] = (float) (-c("trackball events percentage"));
                } else if (g2.equals("--pct-rotation")) {
                    this.u[4] = (float) (-c("screen rotation events percentage"));
                } else if (g2.equals("--pct-syskeys")) {
                    this.u[7] = (float) (-c("system (key) operations percentage"));
                } else if (g2.equals("--pct-nav")) {
                    this.u[5] = (float) (-c("nav events percentage"));
                } else if (g2.equals("--pct-majornav")) {
                    this.u[6] = (float) (-c("major nav events percentage"));
                } else if (g2.equals("--pct-appswitch")) {
                    this.u[8] = (float) (-c("app switch events percentage"));
                } else if (g2.equals("--pct-flip")) {
                    this.u[9] = (float) (-c("keyboard flip percentage"));
                } else if (g2.equals("--pct-anyevent")) {
                    this.u[11] = (float) (-c("any events percentage"));
                } else if (g2.equals("--pct-pinchzoom")) {
                    this.u[2] = (float) (-c("pinch zoom events percentage"));
                } else if (g2.equals("--pkg-blacklist-file")) {
                    this.Y = h();
                } else if (g2.equals("--pkg-whitelist-file")) {
                    this.Z = h();
                } else if (g2.equals("--throttle")) {
                    this.B = c("delay (in milliseconds) to wait between events");
                } else if (g2.equals("--randomize-throttle")) {
                    this.y = true;
                } else if (g2.equals("--wait-dbg")) {
                    continue;
                } else if (g2.equals("--dbg-no-events")) {
                    this.al = true;
                } else if (g2.equals("--port")) {
                    this.am = (int) c("Server port to listen on for commands");
                } else if (g2.equals("--setup")) {
                    this.an = h();
                } else if (g2.equals("--string-seeding")) {
                    this.ao = h();
                    k = true;
                } else if (g2.equals("-f")) {
                    this.ak.add(h());
                    g = true;
                } else if (g2.equals("--profile-wait")) {
                    this.v = c("Profile delay (in milliseconds) to wait between user action");
                } else if (g2.equals("--device-sleep-time")) {
                    this.n = c("Device sleep time(in milliseconds)");
                } else if (g2.equals("--randomize-script")) {
                    this.x = true;
                } else if (g2.equals("--script-log")) {
                    this.z = true;
                } else if (g2.equals("--bugreport")) {
                    this.af = true;
                } else if (!g2.equals("--periodic-bugreport")) {
                    if (g2.equals("-h")) {
                        n();
                        return false;
                    }
                    System.err.println("** Error: Unknown option: " + g2);
                    n();
                    return false;
                } else {
                    this.N = true;
                    this.J = c("Number of iterations");
                }
            } catch (RuntimeException e4) {
                System.err.println("** Error: " + e4.toString());
                n();
                return false;
            }
        }
    }

    private void j() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e2) {
        }
        a("anr traces", "cat /data/anr/traces.txt");
    }

    private void k() {
        a("meminfo", "dumpsys meminfo");
    }

    private void l() {
        a("procrank", "procrank");
    }

    private int m() {
        boolean z;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i3 = 0;
        while (!z5 && i3 < this.m) {
            synchronized (this) {
                if (this.ai) {
                    l();
                    this.ai = false;
                }
                if (this.ad) {
                    this.ad = false;
                    z2 = true;
                }
                if (this.ac) {
                    b("anr_" + this.ab + "_");
                    this.ac = false;
                }
                if (this.aj) {
                    System.out.println("Print the watchdog report");
                    b("anr_watchdog_");
                    this.aj = false;
                }
                if (this.ae) {
                    b("app_crash" + this.ab + "_");
                    this.ae = false;
                }
                if (this.ah) {
                    b("Bugreport_");
                    this.ah = false;
                }
                if (this.ag) {
                    this.ag = false;
                    z3 = true;
                }
                if (this.V && b() && i2 > 0) {
                    System.out.println("** New native crash detected.");
                    if (this.af) {
                        b("native_crash_");
                    }
                    this.G = this.G || !this.P || this.T;
                }
                if (this.G) {
                    z4 = true;
                }
                if (this.ar) {
                    this.ar = false;
                    notifyAll();
                }
            }
            if (z2) {
                j();
                z2 = false;
            }
            if (z3) {
                k();
                z3 = false;
            }
            if (!z4) {
                if (!this.al) {
                    if (this.aq > 0 && i2 % 100 == 0 && i2 != 0) {
                        System.out.println("    //[calendar_time:" + au.a(System.currentTimeMillis()) + " system_uptime:" + SystemClock.elapsedRealtime() + "]");
                        System.out.println("    // Sending event #" + i2);
                    }
                    AbstractC0008c a2 = this.t.a();
                    if (a2 == null) {
                        if (this.K) {
                            break;
                        }
                        int i4 = i3 + 1;
                        a(i4);
                        if (this.N && i4 % this.J == 0) {
                            this.ah = true;
                            i3 = i4;
                        } else {
                            i3 = i4;
                        }
                    } else {
                        int a3 = a2.a(this.as, this.H, this.aq);
                        if (a3 == 0) {
                            if (a2 instanceof C0016k) {
                                this.p++;
                                z = z5;
                            } else if (a2 instanceof AbstractC0017l) {
                                this.q++;
                                z = z5;
                            } else if (a2 instanceof C0011f) {
                                this.o++;
                                z = z5;
                            } else if (a2 instanceof C0021p) {
                                this.r++;
                                z = z5;
                            } else {
                                z = z5;
                            }
                        } else if (a3 == -1) {
                            z = true;
                            System.err.println("** Error: RemoteException while injecting event.");
                        } else if (a3 == -2) {
                            z = !this.Q;
                            if (z) {
                                System.err.println("** Error: SecurityException while injecting event.");
                            }
                        } else {
                            try {
                                this.F.add(((ActivityManager.RunningTaskInfo) this.H.getTasks(1, 0, (IThumbnailReceiver) null).get(0)).topActivity.getClassName());
                                z = z5;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                z = z5;
                            }
                        }
                        if (!(a2 instanceof ar)) {
                            i2++;
                            if (this.K) {
                                i3++;
                                z5 = z;
                            }
                        }
                        z5 = z;
                    }
                } else {
                    i2++;
                    i3++;
                }
            } else {
                System.out.println("** Monkey aborted due to error.");
                System.out.println("Events injected: " + i2);
                return i2;
            }
        }
        System.out.println("Events injected: " + i2);
        return i2;
    }

    public static void main(String[] strArr) {
        new File(f, "bugreport.crash").delete();
        new File(f, "skin.coverage").delete();
        new File(f, "activity.coverage").delete();
        com.android.a.a.t tVar = new com.android.a.a.t();
        System.out.println("### Connecting to Motif Core ...");
        tVar.a();
        h = com.android.a.a.y.a();
        h.a(new com.android.a.a.m(tVar.c()));
        Process.setArgV0("com.android.commands.motifcore");
        int a2 = new Motifcore().a(strArr);
        if (e != null) {
            try {
                e.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        tVar.b();
        System.exit(a2);
    }

    private void n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("oops.");
        System.err.println(stringBuffer.toString());
    }

    private void o() {
        try {
            this.H.signalPersistentProcesses(10);
            synchronized (this) {
                wait(2000L);
            }
        } catch (RemoteException e2) {
            System.err.println("** Failed talking with activity manager!");
        } catch (InterruptedException e3) {
        }
    }
}
