package json;

import java.util.ArrayList;
/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> jsonPairs;
    private int count;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = new ArrayList<>();
        for (JsonPair p : jsonPairs) {
            add(p);
        }
    }

    @Override
    public String toJson() {
        String res = "";
        if(this.jsonPairs.isEmpty()){
            return "{}";
        }
        for(JsonPair jp : this.jsonPairs){
            if(this.count == 1){
                return "{' " + jp.key + " ': " + jp.value.toJson()+ "}" ;
            }
            if(this.count == 0){
                res += "{'" + jp.key + "': " + jp.value.toJson() ;
                count++;
            }
            else if(this.count < this.count - 1){
                res += ", ' " + jp.key + " ': " + jp.value.toJson() ;
                count++;
            }
            else{
                res += ", ' " + jp.key + " ': " + jp.value.toJson() + "}";
            }
        }
        return res;
    }

    public void add(JsonPair jsonPair) {
        jsonPairs.add(jsonPair);
    }

    public Json find(String name) {
        Json res = null;
        for (JsonPair pr : jsonPairs) {
            if (pr.key.equals(name)) {
                res = pr.value;
                break;
            }
        }
        return res;
    }

    public JsonObject projection(String... names) {
        JsonObject pnOfObject = new JsonObject();
        for (String key : names) {
            for (JsonPair pr : jsonPairs) {
                if (pr.key.equals(key)) {
                    pnOfObject.add(pr);
                }
            }
        }

        return pnOfObject;
    }
}
