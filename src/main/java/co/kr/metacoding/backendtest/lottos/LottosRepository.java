package co.kr.metacoding.backendtest.lottos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class LottosRepository {
    private final EntityManager em;

    public List<Lottos> findAll() {
        Query quert = em.createQuery("select l from Lottos l", Lottos.class);
        return quert.getResultList();
    }

    public void save(Lottos lottos) {
        em.persist(lottos);
    }

}
