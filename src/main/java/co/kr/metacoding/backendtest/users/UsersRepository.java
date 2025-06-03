package co.kr.metacoding.backendtest.users;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UsersRepository {
    private final EntityManager em;
}
