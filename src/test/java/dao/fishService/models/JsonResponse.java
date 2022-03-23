package dao.fishService.models;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse {

    private String status;
    private String text;
    private String errorCode;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
