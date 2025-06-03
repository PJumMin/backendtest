package co.kr.metacoding.backendtest._core.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Resp<T> {
    private Integer status;
    private String msg;
    private T body;

    public static <T> Resp<T> OK(T body) {
        return new Resp<T>(200, "OK", body);
    }
}
