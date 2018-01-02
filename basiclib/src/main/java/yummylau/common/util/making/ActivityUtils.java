package yummylau.common.util.making;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/**
 * activity工具类
 * Email yummyl.lau@gmail.com
 * Created by yummylau on 2017/12/11.
 */

public class ActivityUtils {

    public static Activity scanForActivity(Context context) {
        if (context == null)
            return null;
        else if (context instanceof Activity)
            return (Activity) context;
        else if (context instanceof ContextWrapper)
            return scanForActivity(((ContextWrapper) context).getBaseContext());

        return null;
    }
}
