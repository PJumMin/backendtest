package co.kr.metacoding.backendtest.users;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Table(name = "users_tb")
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Builder
    public Users(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void update(String name) {
        this.name = name;
    }
}


