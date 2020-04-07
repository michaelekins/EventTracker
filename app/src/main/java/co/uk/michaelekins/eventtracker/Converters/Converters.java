package co.uk.michaelekins.eventtracker.Converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class Converters {
    @TypeConverter
    public static List<String> jsonToStringList(String data) {
        Gson gson = new Gson();

        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<String>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String stringListToJson(List<String> data) {
        Gson gson = new Gson();

        return gson.toJson(data);
    }
}
