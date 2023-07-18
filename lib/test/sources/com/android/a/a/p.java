package com.android.a.a;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
class p implements s {
    final /* synthetic */ n a;
    private SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private PrintWriter c;

    public p(n nVar, File file) {
        this.a = nVar;
        this.c = new PrintWriter(file);
    }

    @Override // com.android.a.a.s
    public void a() {
        this.c.close();
    }

    @Override // com.android.a.a.s
    public void a(String str) {
        this.c.printf("%s %s\n", this.b.format(new Date()), str);
    }
}
