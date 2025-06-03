package co.kr.metacoding.backendtest.lottos;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LottosRepository {
    private final EntityManager em;

}
