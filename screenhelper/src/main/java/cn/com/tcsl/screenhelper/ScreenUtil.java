package cn.com.tcsl.screenhelper;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/9/7.
 */
public class ScreenUtil {
    // 当前屏幕的densityDpi
    private static float dmDensityDpi = 0.0f;
    private static DisplayMetrics dm;
    private static float scale = 0.0f;

    public static String getScreenInfor(Context context) {
        StringBuffer buffer = new StringBuffer();
        dm = context.getResources().getDisplayMetrics();
        int densityDpi = dm.densityDpi;
        scale = densityDpi / 160;

        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;

        buffer.append("densityDpi=").append(densityDpi).append("\n")
                .append("density=").append(dm.density).append("\n")
                .append("scaledDensity=").append(dm.scaledDensity).append("\n")
                .append("scale=").append(scale).append("\n")
                .append("width=").append(width).append("\n")
                .append("height=").append(height).append("\n");

        buffer.append("sw").append((int)(width/scale)).append("dp-").append(getHdpi(scale));
        return buffer.toString();
    }

    private static String getHdpi(float scale) {
        if (scale == 1.0f) {
            return "mdpi";
        }
        else if (scale == 1.5f) {
            return "hdpi";
        }
        else if (scale == 2.0f) {
            return "xhdpi";
        }
        else if (scale == 3.0f) {
            return "xxhdpi";
        }
        else if (scale == 4.0f) {
            return "xxxhdpi";
        }
        else {
            return "nodpi";
        }
    }
}
