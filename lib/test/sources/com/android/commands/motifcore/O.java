package com.android.commands.motifcore;
/* loaded from: classes.dex */
final class O implements V {
    @Override // com.android.commands.motifcore.V
    public String a() {
        if (Motifcore.c == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : Motifcore.c.getCategories()) {
            stringBuffer.append(str).append(" ");
        }
        return stringBuffer.toString();
    }
}
