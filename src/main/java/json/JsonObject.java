package json;

import java.util.ArrayList;
/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> jsPairs = new ArrayList<>(); ;
    private int counter;

    public JsonObject(JsonPair... jsonPairs) {
        for(JsonPair jsp: jsonPairs){
            this.add(jsp);
        }
    }

    @Override
    public String toJson() {
        String res = "";
        int counter = 0;
        if(this.jsPairs.isEmpty()){
            return "{}";
        }

        for(JsonPair jp : this.jsPairs){
            if(this.counter ==1){
                return "{'" + jp.key + "': " + jp.value.toJson()+ "}" ;
            }
            if(counter == 0){
                res += "{'" + jp.key + "': " + jp.value.toJson() ;
                counter++;
            }
            else if(counter < this.counter - 1){
                res += ", '" + jp.key + "': " + jp.value.toJson() ;
                counter++;
            }
            else{
                res += ", '" + jp.key + "': " + jp.value.toJson() + "}";
            }

        }
        return res;
    }

    public void add(JsonPair jsonPair) {
        boolean val = false;
        if(!val){
            this.jsPairs.add(jsonPair);
            this.counter++;
        }

    }

    public Json find(String name) {
        for(JsonPair jsp: this.jsPairs){
            if (jsp.key.equals(name)){
                return jsp.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject jsObj = new JsonObject();
        for(JsonPair jsp : this.jsPairs){
            for( String proj: names){
                if(jsp.key.equals(proj)){
                    jsObj.add(jsp);
                }
            }
        }
        return jsObj;
    }
}