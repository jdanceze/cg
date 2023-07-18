package com.android.commands.motifcore;

import android.os.IPowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
/* renamed from: com.android.commands.motifcore.q */
/* loaded from: classes.dex */
public class C0022q implements InterfaceC0010e {
    public static final int c = 2;
    private static final String f = "done";
    private static final String g = "ERROR";
    private static final String h = "OK";
    private static final String i = "quit";
    private static final String j = "MonkeyStub";
    private static C0027v k;
    private Socket l;
    private BufferedReader n;
    private PrintWriter o;
    private ServerSocket p;
    public static final C0031z d = new C0031z(true);
    public static final C0031z b = new C0031z(false);
    public static final C0031z a = new C0031z(false, "Invalid Argument");
    private static final Map e = new HashMap();
    private final C0025t m = new C0025t();
    private boolean q = false;

    static {
        e.put("flip", new C0028w());
        e.put("touch", new D());
        e.put("trackball", new E());
        e.put("key", new C0029x());
        e.put("sleep", new B());
        e.put("wake", new G());
        e.put("tap", new C());
        e.put("press", new A());
        e.put("type", new F());
        e.put("listvar", new T());
        e.put("getvar", new S());
        e.put("listviews", new aj());
        e.put("queryview", new ak());
        e.put("getrootview", new af());
        e.put("getviewswithtext", new ai());
        e.put("deferreturn", new C0026u());
    }

    public C0022q(int i2) {
        this.p = new ServerSocket(i2, 0, InetAddress.getLocalHost());
    }

    private void a(C0031z c0031z) {
        if (c0031z.c()) {
            if (c0031z.b()) {
                f(c0031z.a());
            } else {
                f();
            }
        } else if (c0031z.b()) {
            e(c0031z.a());
        } else {
            e();
        }
    }

    private static List b(String str) {
        String stringBuffer;
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        StringBuffer stringBuffer2 = new StringBuffer();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!z && nextToken.startsWith("\"")) {
                stringBuffer2.append(d(nextToken));
                z = true;
            } else if (!z) {
                arrayList.add(d(nextToken));
            } else if (nextToken.endsWith("\"")) {
                stringBuffer2.append(" ").append(d(nextToken));
                arrayList.add(stringBuffer2.toString().substring(1, stringBuffer.length() - 1));
                z = false;
            } else {
                stringBuffer2.append(" ").append(d(nextToken));
            }
        }
        return arrayList;
    }

    public static int c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            int a2 = ao.a(str);
            if (a2 == 0) {
                int a3 = ao.a("KEYCODE_" + str.toUpperCase());
                if (a3 == 0) {
                    return -1;
                }
                return a3;
            }
            return a2;
        }
    }

    private static String d(String str) {
        return str.replace("\\\"", "\"");
    }

    private void e() {
        this.o.println(g);
    }

    private void e(String str) {
        this.o.print(g);
        this.o.print(":");
        this.o.println(str);
    }

    private void f() {
        this.o.println(h);
    }

    private void f(String str) {
        this.o.print(h);
        this.o.print(":");
        this.o.println(str);
    }

    private void g() {
        this.l = this.p.accept();
        W.c();
        i();
        this.n = new BufferedReader(new InputStreamReader(this.l.getInputStream()));
        this.o = new PrintWriter(this.l.getOutputStream(), true);
    }

    private void g(String str) {
        InterfaceC0030y interfaceC0030y;
        Log.d(j, "translateCommand: " + str);
        List b2 = b(str);
        if (b2.size() <= 0 || (interfaceC0030y = (InterfaceC0030y) e.get(b2.get(0))) == null) {
            return;
        }
        a(interfaceC0030y.a(b2, this.m));
    }

    private void h() {
        this.l.close();
        W.d();
        this.n.close();
        this.o.close();
        this.q = false;
    }

    public static final boolean i() {
        try {
            IPowerManager.Stub.asInterface(ServiceManager.getService("power")).wakeUp(SystemClock.uptimeMillis());
            return true;
        } catch (RemoteException e2) {
            Log.e(j, "Got remote exception", e2);
            return false;
        }
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public AbstractC0008c a() {
        if (!this.q) {
            try {
                g();
                this.q = true;
            } catch (IOException e2) {
                Log.e(j, "Got IOException from server", e2);
                return null;
            }
        }
        while (true) {
            try {
                AbstractC0008c a2 = this.m.a();
                if (a2 != null) {
                    return a2;
                }
                if (k != null) {
                    Log.d(j, "Waiting for event");
                    C0031z a3 = k.a();
                    k = null;
                    a(a3);
                }
                String readLine = this.n.readLine();
                if (readLine == null) {
                    Log.d(j, "Connection dropped.");
                    readLine = f;
                }
                if (f.equals(readLine)) {
                    try {
                        h();
                        return new C0019n();
                    } catch (IOException e3) {
                        Log.e(j, "Got IOException shutting down!", e3);
                        return null;
                    }
                } else if (i.equals(readLine)) {
                    Log.d(j, "Quit requested");
                    f();
                    return null;
                } else if (!readLine.startsWith("#")) {
                    g(readLine);
                }
            } catch (IOException e4) {
                Log.e(j, "Exception: ", e4);
                return null;
            }
        }
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public void a(int i2) {
    }

    @Override // com.android.commands.motifcore.InterfaceC0010e
    public boolean b() {
        return true;
    }
}
