package co.kr.metacoding.backendtest.lottos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Table(name = "lottos_tb")
@Entity
public class Lottos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numbers;

    public Lottos(int id, String numbers) {
        this.id = id;
        this.numbers = numbers;
    }
}


