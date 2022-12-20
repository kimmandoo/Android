import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main {
    static class Item {
        String label;
        int price;

        Item(String label, int price) {
            this.label = label;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        String jsonString = "{\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"label\": \"캐시미어 100% 터틀넥 스웨터\",\n" +
                "      \"price\": 70000\n" +
                "    },\n" +
                "    {\n" +
                "      \"label\": \"반팔 스트라이프 스웨터\",\n" +
                "      \"price\": 30000\n" +
                "    },\n" +
                "    {\n" +
                "      \"label\": \"화이트 스포츠 점퍼\",\n" +
                "      \"price\": 150000\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JSONObject jObject = new JSONObject(jsonString);
        JSONArray jArray = jObject.getJSONArray("items");
        ArrayList<Item> result = getJson(jArray);

        for(Item i : result){
            System.out.println(i.label+":"+ i.price);
        }
    }

    private static ArrayList<Item> getJson(JSONArray jArray) {
        int len = jArray.length();
        ArrayList<Item> result = new ArrayList<Item>(len);
        ArrayList<Item> sorted = new ArrayList<Item>(len);

        for (int i = 0; i < len; i++) {
            JSONObject jObject = jArray.getJSONObject(i);
            result.add(new Item(jObject.getString("label"), jObject.getInt("price")));
        }

        int idx = 0;


        for (int i = 0; i < len; i++) {
            for (int j = 0; j < (len - 1) - i; j++) {
                if (result.get(j).price < result.get(j+1).price) {	// 버블 정렬 사용
                    Item tmp = result.get(j);
                    result.set(j,result.get(j+1));
                    result.set(j+1,tmp);
                }
            }
        }

        return result;
    }
}

