package com.android.commands.motifcore;

import android.app.IActivityController;
import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes.dex */
class ay extends IActivityController.Stub {
    final /* synthetic */ Motifcore a;

    private ay(Motifcore motifcore) {
        this.a = motifcore;
    }

    public boolean activityResuming(String str) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        System.out.println("    // activityResuming(" + str + ")");
        boolean z = Motifcore.a(this.a, str);
        if (!z && Motifcore.a(this.a) > 0) {
            System.out.println("    // " + (z ? "Allowing" : "Rejecting") + " resume of package " + str);
        }
        Motifcore.d = str;
        StrictMode.setThreadPolicy(allowThreadDiskWrites);
        return z;
    }

    public boolean activityStarting(Intent intent, String str) {
        boolean z = Motifcore.a(this.a, str);
        if (Motifcore.a(this.a) > 0) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            System.out.println("    // " + (z ? "Allowing" : "Rejecting") + " start of " + intent + " in package " + str);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
        Motifcore.d = str;
        Motifcore.c = intent;
        return z;
    }

    public boolean appCrashed(String str, int i, String str2, String str3, long j, String str4) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        System.err.println("// CRASH: " + str + " (pid " + i + ")");
        System.err.println("// Short Msg: " + str2);
        System.err.println("// Long Msg: " + str3);
        System.err.println("// Build Label: " + Build.FINGERPRINT);
        System.err.println("// Build Changelist: " + Build.VERSION.INCREMENTAL);
        System.err.println("// Build Time: " + Build.TIME);
        System.err.println("// " + str4.replace("\n", "\n// "));
        StrictMode.setThreadPolicy(allowThreadDiskWrites);
        File file = new File(Motifcore.f, "bugreport.crash");
        try {
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("// CRASH: " + str + " (pid " + i + ")\n");
            bufferedWriter.write("// Short Msg: " + str2 + "\n");
            bufferedWriter.write("// Long Msg: " + str3 + "\n");
            bufferedWriter.write("// Build Label: " + Build.FINGERPRINT + "\n");
            bufferedWriter.write("// Build Changelist: " + Build.VERSION.INCREMENTAL + "\n");
            bufferedWriter.write("// Build Time: " + Build.TIME + "\n");
            bufferedWriter.write("// " + str4.replace("\n", "\n// ") + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!Motifcore.d(this.a) || Motifcore.e(this.a)) {
            synchronized (this.a) {
                if (!Motifcore.d(this.a)) {
                    Motifcore.e(this.a, true);
                }
                if (Motifcore.e(this.a)) {
                    Motifcore.f(this.a, true);
                    Motifcore.b(this.a, str);
                }
            }
            return !Motifcore.f(this.a);
        }
        return false;
    }

    public int appEarlyNotResponding(String str, int i, String str2) {
        return 0;
    }

    public int appNotResponding(String str, int i, String str2) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        System.err.println("// NOT RESPONDING: " + str + " (pid " + i + ")");
        System.err.println(str2);
        StrictMode.setThreadPolicy(allowThreadDiskWrites);
        synchronized (this.a) {
            Motifcore.g(this.a, true);
            Motifcore.h(this.a, true);
            Motifcore.a(this.a, true);
            if (Motifcore.e(this.a)) {
                Motifcore.b(this.a, true);
                Motifcore.b(this.a, str);
            }
        }
        if (!Motifcore.b(this.a)) {
            synchronized (this.a) {
                Motifcore.e(this.a, true);
            }
        }
        return Motifcore.f(this.a) ? -1 : 1;
    }

    public int systemNotResponding(String str) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        System.err.println("// WATCHDOG: " + str);
        StrictMode.setThreadPolicy(allowThreadDiskWrites);
        synchronized (this.a) {
            if (!Motifcore.d(this.a)) {
                Motifcore.e(this.a, true);
            }
            if (Motifcore.e(this.a)) {
                Motifcore.c(this.a, true);
            }
            Motifcore.d(this.a, true);
        }
        synchronized (this.a) {
            while (Motifcore.c(this.a)) {
                try {
                    this.a.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return Motifcore.f(this.a) ? -1 : 1;
    }
}
