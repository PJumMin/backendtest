package co.kr.metacoding.backendtest.winner;

import co.kr.metacoding.backendtest.lottos.Lottos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Table(name = "winner")
@Entity
public class Winner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rank;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lottos lottos;

}


