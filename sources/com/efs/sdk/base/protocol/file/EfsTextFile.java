package com.efs.sdk.base.protocol.file;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.config.GlobalInfo;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.JSONSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.efs.sdk.base.protocol.file.section.TextSection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EfsTextFile extends AbsFileLog {
    private static final String FILE_START = "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***";
    private static final String SECTION_START = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    private long beginTime = 0;
    private long endTime = 0;
    private boolean mHasInitLinkInfo = false;
    private String mLinkID = null;
    private String mLinkKey = null;
    private List<AbsSection> sectionList = new ArrayList();

    public EfsTextFile(String str) {
        super(str);
    }

    private String changeToStr() {
        StringBuilder sb = new StringBuilder(FILE_START);
        sb.append("\n");
        int i10 = 0;
        for (AbsSection next : this.sectionList) {
            if (i10 > 0) {
                sb.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            }
            sb.append(next.changeToStr());
            i10++;
        }
        return sb.toString();
    }

    private void initLinkInfo() {
        if ((TextUtils.isEmpty(this.mLinkID) || TextUtils.isEmpty(this.mLinkKey)) && !this.mHasInitLinkInfo) {
            for (AbsSection next : this.sectionList) {
                if (next instanceof KVSection) {
                    Map<String, Object> dataMap = ((KVSection) next).getDataMap();
                    if (TextUtils.isEmpty(this.mLinkID) && dataMap.containsKey(Constants.LOG_KEY_LINK_ID)) {
                        this.mLinkID = String.valueOf(dataMap.get(Constants.LOG_KEY_LINK_ID));
                    }
                    if (TextUtils.isEmpty(this.mLinkKey) && dataMap.containsKey(Constants.LOG_KEY_LINK_KEY)) {
                        this.mLinkKey = String.valueOf(dataMap.get(Constants.LOG_KEY_LINK_KEY));
                    }
                }
            }
            this.mHasInitLinkInfo = true;
        }
    }

    private void insertCustomInfoSection() {
        KVSection kVSection = new KVSection("custom_info");
        for (Map.Entry next : ControllerCenter.getGlobalEnvStruct().getPublicParamMap().entrySet()) {
            kVSection.put((String) next.getKey(), next.getValue());
        }
        this.sectionList.add(0, kVSection);
    }

    public JSONSection createAndAddJSONSection(String str) {
        JSONSection jSONSection = new JSONSection(str);
        this.sectionList.add(jSONSection);
        return jSONSection;
    }

    public KVSection createAndAddKVSection(String str) {
        KVSection kVSection = new KVSection(str);
        this.sectionList.add(kVSection);
        return kVSection;
    }

    public TextSection createAndAddTextSection(String str) {
        TextSection textSection = new TextSection(str);
        this.sectionList.add(textSection);
        return textSection;
    }

    public byte[] generate() {
        String changeToStr = changeToStr();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.i("efs.base", changeToStr);
        }
        return changeToStr.getBytes();
    }

    public String generateString() {
        return changeToStr();
    }

    public String getLinkId() {
        initLinkInfo();
        return this.mLinkID;
    }

    public String getLinkKey() {
        initLinkInfo();
        return this.mLinkKey;
    }

    public long getLogBeginTime() {
        return this.beginTime;
    }

    public long getLogEndTime() {
        return this.endTime;
    }

    public void insertGlobal(GlobalInfo globalInfo) {
        insertCustomInfoSection();
        this.sectionList.addAll(0, globalInfo.getGlobalSectionList(getLogType()));
    }

    public void setLogBeginTime(long j10) {
        this.beginTime = j10;
    }

    public void setLogEndTime(long j10) {
        this.endTime = j10;
    }
}
