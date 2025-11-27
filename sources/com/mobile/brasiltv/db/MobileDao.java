package com.mobile.brasiltv.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import ba.t;
import com.umeng.analytics.pro.f;
import h9.g;
import h9.h;
import java.util.ArrayList;
import java.util.List;
import ra.a;
import t9.i;

public final class MobileDao implements a.b {
    /* access modifiers changed from: private */
    public final String DATABASE_NAME = "CloudSteam.db";
    /* access modifiers changed from: private */
    public final int DB_VERSION = 1;
    /* access modifiers changed from: private */
    public final boolean DUBUG_MODEL = true;
    private final String TAG = "MobileDao";
    /* access modifiers changed from: private */
    public Context context;
    private final g db$delegate = h.b(new MobileDao$db$2(this));

    public MobileDao(Context context2) {
        i.g(context2, f.X);
        this.context = context2;
    }

    public final void addAccount(SwitchAccountBean switchAccountBean) {
        Class<SwitchAccountBean> cls = SwitchAccountBean.class;
        i.g(switchAccountBean, "accountBean");
        try {
            if (switchAccountBean.getPassword().length() > 32) {
                String substring = switchAccountBean.getPassword().substring(0, 32);
                i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                switchAccountBean.setPassword(substring);
            }
            List m10 = getDb().m(cls, "userId='" + switchAccountBean.getUserId() + '\'');
            List k10 = getDb().k(cls);
            if (m10 != null && m10.size() != 0) {
                getDb().e(m10.get(0));
            } else if (k10 != null && k10.size() >= 5) {
                getDb().e(k10.get(0));
            }
            getDb().r(switchAccountBean);
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, (Object) null)) {
                    return;
                }
            }
            throw e10;
        }
    }

    public final void addAudioSetting(AudioSettingBean audioSettingBean) {
        i.g(audioSettingBean, "audioSetting");
        k7.f.e("增加一个局部音轨设置", new Object[0]);
        Class<AudioSettingBean> cls = AudioSettingBean.class;
        if (getDb().k(cls).size() == 100) {
            getDb().g(cls, 0);
        }
        List m10 = getDb().m(cls, "contentId='" + audioSettingBean.getContentId() + '\'');
        if (m10.size() != 0) {
            getDb().e(m10.get(0));
        }
        getDb().r(audioSettingBean);
    }

    public final void addSearchHistory(SearchHistory searchHistory) {
        Class<SearchHistory> cls = SearchHistory.class;
        i.g(searchHistory, "searchHistory");
        try {
            if (getDb().k(cls).size() == 10) {
                getDb().g(cls, 0);
            }
            List m10 = getDb().m(cls, "contentId='" + searchHistory.getContentId() + '\'');
            if (m10.size() != 0) {
                getDb().e(m10.get(0));
            }
            getDb().r(searchHistory);
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, (Object) null)) {
                    return;
                }
            }
            throw e10;
        }
    }

    public final void addSearchLiveHistory(SearchLiveHistory searchLiveHistory) {
        Class<SearchLiveHistory> cls = SearchLiveHistory.class;
        i.g(searchLiveHistory, "searchHistory");
        try {
            if (getDb().k(cls).size() == 10) {
                getDb().g(cls, 0);
            }
            List m10 = getDb().m(cls, "channelCode='" + searchLiveHistory.getChannelCode() + '\'');
            if (m10.size() != 0) {
                getDb().e(m10.get(0));
            }
            getDb().r(searchLiveHistory);
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, (Object) null)) {
                    return;
                }
            }
            throw e10;
        }
    }

    public final void addSubtitleSetting(SubtitleSettingBean subtitleSettingBean) {
        i.g(subtitleSettingBean, "subtitleSetting");
        k7.f.e("增加一个局部字幕设置", new Object[0]);
        Class<SubtitleSettingBean> cls = SubtitleSettingBean.class;
        if (getDb().k(cls).size() == 100) {
            getDb().g(cls, 0);
        }
        List m10 = getDb().m(cls, "contentId='" + subtitleSettingBean.getContentId() + '\'');
        if (m10.size() != 0) {
            getDb().e(m10.get(0));
        }
        getDb().r(subtitleSettingBean);
    }

    public final void deleteAccount(SwitchAccountBean switchAccountBean) {
        i.g(switchAccountBean, "accountBean");
        try {
            List m10 = getDb().m(SwitchAccountBean.class, "userId='" + switchAccountBean.getUserId() + '\'');
            if (m10 != null && m10.size() != 0) {
                getDb().e(m10.get(0));
            }
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, (Object) null)) {
                    return;
                }
            }
            throw e10;
        }
    }

    public final void deleteAllAccount() {
        getDb().f(SwitchAccountBean.class);
    }

    public final void deleteAllSearchHistory() {
        getDb().f(SearchHistory.class);
    }

    public final void deleteAllSearchLiveHistory() {
        getDb().f(SearchLiveHistory.class);
    }

    public final a getDb() {
        Object value = this.db$delegate.getValue();
        i.f(value, "<get-db>(...)");
        return (a) value;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public final SwitchAccountBean queryAccount(String str) {
        i.g(str, "userId");
        try {
            List m10 = getDb().m(SwitchAccountBean.class, "userId='" + str + '\'');
            if (m10 == null || m10.size() <= 0) {
                return null;
            }
            return (SwitchAccountBean) m10.get(0);
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, (Object) null)) {
                    return null;
                }
            }
            throw e10;
        }
    }

    public final List<SwitchAccountBean> queryAllAccount() {
        try {
            List<SwitchAccountBean> k10 = getDb().k(SwitchAccountBean.class);
            if (k10 == null) {
                return new ArrayList();
            }
            return k10;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, (Object) null)) {
                    return new ArrayList();
                }
            }
            throw e10;
        }
    }

    public final List<AudioSettingBean> queryAllAudioSetting() {
        List<AudioSettingBean> k10 = getDb().k(AudioSettingBean.class);
        i.f(k10, "db.findAll(AudioSettingBean::class.java)");
        return k10;
    }

    public final List<SearchHistory> queryAllSearchHistory() {
        try {
            List<SearchHistory> k10 = getDb().k(SearchHistory.class);
            i.f(k10, "db.findAll(SearchHistory::class.java)");
            return k10;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, (Object) null)) {
                    return new ArrayList();
                }
            }
            throw e10;
        }
    }

    public final List<SearchLiveHistory> queryAllSearchLiveHistory() {
        try {
            List<SearchLiveHistory> k10 = getDb().k(SearchLiveHistory.class);
            i.f(k10, "db.findAll(SearchLiveHistory::class.java)");
            return k10;
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, (Object) null)) {
                    return new ArrayList();
                }
            }
            throw e10;
        }
    }

    public final List<SubtitleSettingBean> queryAllSubtitleSetting() {
        List<SubtitleSettingBean> k10 = getDb().k(SubtitleSettingBean.class);
        i.f(k10, "db.findAll(SubtitleSettingBean::class.java)");
        return k10;
    }

    public final AudioSettingBean queryAudioSetting(String str) {
        i.g(str, "contentId");
        List m10 = getDb().m(AudioSettingBean.class, "contentId='" + str + '\'');
        if (m10 == null || m10.size() <= 0) {
            return null;
        }
        return (AudioSettingBean) m10.get(0);
    }

    public final SubtitleSettingBean querySubtitleSetting(String str) {
        i.g(str, "contentId");
        List m10 = getDb().m(SubtitleSettingBean.class, "contentId='" + str + '\'');
        if (m10 == null || m10.size() <= 0) {
            return null;
        }
        return (SubtitleSettingBean) m10.get(0);
    }

    public final boolean updateAccountEmail(String str, String str2, String str3) {
        SwitchAccountBean queryAccount;
        i.g(str, "userId");
        i.g(str2, "oldEmail");
        i.g(str3, "changedEmail");
        if (TextUtils.isEmpty(str) || (queryAccount = queryAccount(str)) == null || !TextUtils.equals(queryAccount.getUserName(), str2)) {
            return false;
        }
        queryAccount.setUserName(str3);
        getDb().t(queryAccount);
        return true;
    }
}
