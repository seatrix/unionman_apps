package cn.com.unionman.umtvsetting.system.logic;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;


import cn.com.unionman.umtvsetting.system.R;
import cn.com.unionman.umtvsetting.system.interfaces.AudioInterface;
import cn.com.unionman.umtvsetting.system.interfaces.InterfaceValueMaps;
import cn.com.unionman.umtvsetting.system.logic.factory.InterfaceLogic;
import cn.com.unionman.umtvsetting.system.model.WidgetType;
import cn.com.unionman.umtvsetting.system.model.WidgetType.AccessSysValueInterface;
import cn.com.unionman.umtvsetting.system.util.Util;

/**
 * SPDIF output
 *
 * @author wangchuanjian
 *
 */
public class SPDIFLogic implements InterfaceLogic {

    private Context mContext;

    // private WidgetType mSPDIFOutput;// SPDIF output
    // private List<WidgetType> mWidgetList = null;
    // private int[][] mSPDIFOutputValue = InterfaceValueMaps.SPDIF_output;

    public SPDIFLogic(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public List<WidgetType> getWidgetTypeList() {
        List<WidgetType> mWidgetList = new ArrayList<WidgetType>();
        Resources res = mContext.getResources();

        // SPDIFOutput
        WidgetType mSPDIFOutput = new WidgetType();
        // set name for SPDIFOutput
        mSPDIFOutput.setName(res.getStringArray(R.array.voice_setting)[5]);
        // set type for SPDIFOutput
        mSPDIFOutput.setType(WidgetType.TYPE_SELECTOR);
        mSPDIFOutput.setmAccessSysValueInterface(new AccessSysValueInterface() {

            @Override
            public int setSysValue(int i) {
                AudioInterface
                        .setSPDIFOutput(InterfaceValueMaps.SPDIF_output[i][0]);
                return i;
            }

            @Override
            public int getSysValue() {

                int mode = AudioInterface.getSPDIFOutput();
                return Util.getIndexFromArray(mode,
                        InterfaceValueMaps.SPDIF_output);
            }
        });
        // set data for SPDIFOutput
        mSPDIFOutput.setData(Util
                .createArrayOfParameters(InterfaceValueMaps.SPDIF_output));
        mWidgetList.add(mSPDIFOutput);
        return mWidgetList;
    }

    @Override
    public void setHandler(Handler handler) {
        // TODO Auto-generated method stub

    }

}
