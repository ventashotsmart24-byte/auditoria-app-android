package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    long f15323a;

    /* renamed from: b  reason: collision with root package name */
    String f15324b;

    /* renamed from: c  reason: collision with root package name */
    int f15325c;

    /* renamed from: d  reason: collision with root package name */
    public int f15326d;

    /* renamed from: e  reason: collision with root package name */
    public int f15327e;

    /* renamed from: f  reason: collision with root package name */
    public int f15328f;

    /* renamed from: g  reason: collision with root package name */
    public int f15329g;

    /* renamed from: h  reason: collision with root package name */
    public int f15330h;

    /* renamed from: i  reason: collision with root package name */
    public int f15331i;

    /* renamed from: j  reason: collision with root package name */
    public int f15332j;

    public af(String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f15323a = System.currentTimeMillis();
        this.f15324b = str;
        this.f15325c = i10;
        this.f15326d = i11;
        this.f15327e = i12;
        this.f15328f = i13;
        this.f15329g = i14;
        this.f15330h = i15;
        this.f15331i = i16;
        this.f15332j = i17;
    }

    public final ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Time", Long.valueOf(this.f15323a));
        contentValues.put("MsgId", this.f15324b);
        contentValues.put("MsgType", Integer.valueOf(this.f15325c));
        contentValues.put("NumDisplay", Integer.valueOf(this.f15326d));
        contentValues.put("NumOpenFull", Integer.valueOf(this.f15327e));
        contentValues.put("NumOpenTop", Integer.valueOf(this.f15328f));
        contentValues.put("NumOpenBottom", Integer.valueOf(this.f15329g));
        contentValues.put("NumClose", Integer.valueOf(this.f15330h));
        contentValues.put("NumDuration", Integer.valueOf(this.f15331i));
        contentValues.put("NumCustom", Integer.valueOf(this.f15332j));
        return contentValues;
    }

    public af(Cursor cursor) {
        this.f15324b = cursor.getString(cursor.getColumnIndexOrThrow("MsgId"));
        this.f15325c = cursor.getInt(cursor.getColumnIndexOrThrow("MsgType"));
        this.f15326d = cursor.getInt(cursor.getColumnIndexOrThrow("NumDisplay"));
        this.f15327e = cursor.getInt(cursor.getColumnIndexOrThrow("NumOpenFull"));
        this.f15328f = cursor.getInt(cursor.getColumnIndexOrThrow("NumOpenTop"));
        this.f15329g = cursor.getInt(cursor.getColumnIndexOrThrow("NumOpenBottom"));
        this.f15330h = cursor.getInt(cursor.getColumnIndexOrThrow("NumClose"));
        this.f15331i = cursor.getInt(cursor.getColumnIndexOrThrow("NumDuration"));
        this.f15332j = cursor.getInt(cursor.getColumnIndexOrThrow("NumCustom"));
    }
}
