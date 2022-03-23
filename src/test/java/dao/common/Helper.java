package dao.common;

import java.util.HashMap;
import java.util.Map;

public class Helper {

    public static Map<String, String> transformMap(Map<String, String> map) {
        Map<String, String> transformedMap = new HashMap<>(map);

        map.forEach((k, v) -> {
            if (v != null) {
                if (v.equalsIgnoreCase("[empty]") || v.equalsIgnoreCase("empty")) {
                    transformedMap.put(k, "");
                } else if (v.equalsIgnoreCase("[null]") || v.equalsIgnoreCase("null")) {
                    transformedMap.put(k, null);
                } else if (v.equalsIgnoreCase("\"null\"")) {
                    transformedMap.put(k, "null");
                }
            }
        });
        return transformedMap;
    }
}
