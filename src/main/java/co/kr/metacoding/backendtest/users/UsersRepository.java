package co.kr.metacoding.backendtest.users;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UsersRepository {
    private final EntityManager em;

    public Users save(Users users) {
        em.persist(users);
        return users;
    }

    public Users findById(Integer id) {
        Users users = em.find(Users.class, id);
        return users;
    }
}
