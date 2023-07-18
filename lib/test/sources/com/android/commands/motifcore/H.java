package com.android.commands.motifcore;

import android.hardware.display.DisplayManagerGlobal;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class H {
    private static final Map a = new TreeMap();

    static {
        a.put("build.board", new U(Build.BOARD));
        a.put("build.brand", new U(Build.BRAND));
        a.put("build.device", new U(Build.DEVICE));
        a.put("build.display", new U(Build.DISPLAY));
        a.put("build.fingerprint", new U(Build.FINGERPRINT));
        a.put("build.host", new U(Build.HOST));
        a.put("build.id", new U(Build.ID));
        a.put("build.model", new U(Build.MODEL));
        a.put("build.product", new U(Build.PRODUCT));
        a.put("build.tags", new U(Build.TAGS));
        a.put("build.brand", new U(Long.toString(Build.TIME)));
        a.put("build.type", new U(Build.TYPE));
        a.put("build.user", new U(Build.USER));
        a.put("build.cpu_abi", new U(Build.CPU_ABI));
        a.put("build.manufacturer", new U(Build.MANUFACTURER));
        a.put("build.version.incremental", new U(Build.VERSION.INCREMENTAL));
        a.put("build.version.release", new U(Build.VERSION.RELEASE));
        a.put("build.version.sdk", new U(Integer.toString(Build.VERSION.SDK_INT)));
        a.put("build.version.codename", new U(Build.VERSION.CODENAME));
        Display realDisplay = DisplayManagerGlobal.getInstance().getRealDisplay(0);
        a.put("display.width", new U(Integer.toString(realDisplay.getWidth())));
        a.put("display.height", new U(Integer.toString(realDisplay.getHeight())));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        realDisplay.getMetrics(displayMetrics);
        a.put("display.density", new U(Float.toString(displayMetrics.density)));
        a.put("am.current.package", new I());
        a.put("am.current.action", new K());
        a.put("am.current.comp.class", new L());
        a.put("am.current.comp.package", new M());
        a.put("am.current.data", new N());
        a.put("am.current.categories", new O());
        a.put("clock.realtime", new P());
        a.put("clock.uptime", new Q());
        a.put("clock.millis", new R());
        a.put("monkey.version", new J());
    }
}
