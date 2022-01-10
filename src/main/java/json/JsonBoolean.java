package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private final boolean bool;

    public JsonBoolean(Boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toJson() {
        // ToDo
        StringBuilder sb = new StringBuilder();
        sb.append(bool);
        return sb.toString();
    }
}
