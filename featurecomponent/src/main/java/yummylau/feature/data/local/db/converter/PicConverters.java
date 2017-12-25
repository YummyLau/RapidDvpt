package yummylau.feature.data.local.db.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import yummylau.feature.bean.Pic;

/**
 * Email yummyl.lau@gmail.com
 * Created by yummylau on 2017/12/25.
 */

public class PicConverters {

    @TypeConverter
    public static List<Pic> stringToPicList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Pic>>() {
        }.getType();

        return new Gson().fromJson(data, listType);
    }

    @TypeConverter
    public static String picListToString(List<Pic> someObjects) {
        return new Gson().toJson(someObjects);
    }
}
