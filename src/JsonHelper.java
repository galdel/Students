import com.google.gson.Gson;

public class JsonHelper {
    private static Gson gson = new Gson();

    // Метод для сериализации объекта в JSON-строку
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    // Метод для десериализации JSON-строки обратно в объект
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}