package com.android.a.a;

import android.app.IActivityController;
import android.content.Intent;
/* loaded from: classes.dex */
class v extends IActivityController.Stub {
    final /* synthetic */ t a;

    private v(t tVar) {
        this.a = tVar;
    }

    public boolean activityResuming(String str) {
        return true;
    }

    public boolean activityStarting(Intent intent, String str) {
        return true;
    }

    public boolean appCrashed(String str, int i, String str2, String str3, long j, String str4) {
        return true;
    }

    public int appEarlyNotResponding(String str, int i, String str2) {
        return 0;
    }

    public int appNotResponding(String str, int i, String str2) {
        return 0;
    }

    public int systemNotResponding(String str) {
        return 0;
    }
}
