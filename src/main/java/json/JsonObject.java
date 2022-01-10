package json;

import java.util.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    HashMap<String, Json> json = new HashMap<>();

    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair pair: jsonPairs) {
            json.put(pair.key, pair.value);
        }
    }

    @Override
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        Iterator<Map.Entry<String, Json>> jsonIterator
                = json.entrySet().iterator();
        jsonBuilder.append("{");
        while (jsonIterator.hasNext()) {
            Map.Entry<String, Json> pair = jsonIterator.next();
            jsonBuilder.append(pair.getKey() + ": " + pair.getValue().toJson());
            if (jsonIterator.hasNext()) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    public void add(JsonPair jsonPair) {
        json.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        return json.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject newJson = new JsonObject();
        for (String name : names) {
            if (json.containsKey(name))
                newJson.add(new JsonPair(name, json.get(name)));
        }

        return newJson;
    }
}
