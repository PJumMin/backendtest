package co.kr.metacoding.backendtest.winner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class WinnerRepository {
    private final EntityManager em;

    public List<Winner> findAll() {
        Query query = em.createQuery("select w from Winner w", Winner.class);
        return query.getResultList();
    }

    public void save(Winner winner) {
        em.persist(winner);

    }
}
