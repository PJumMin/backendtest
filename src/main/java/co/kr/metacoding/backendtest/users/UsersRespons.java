package co.kr.metacoding.backendtest.users;

import lombok.Data;

public class UsersRespons {
    @Data
    public static class DetailDTO {
        Integer id;
        String name;
    }
}
