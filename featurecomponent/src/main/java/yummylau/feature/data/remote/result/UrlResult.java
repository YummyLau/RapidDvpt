package yummylau.feature.data.remote.result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import yummylau.feature.bean.UrlShort;

/**
 * Email yummyl.lau@gmail.com
 * Created by yummylau on 2017/12/17.
 */

public class UrlResult extends ApiResult{

    @SerializedName("urls")
    public List<UrlShort> urls;
}
