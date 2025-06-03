package co.kr.metacoding.backendtest.users;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public Users signUp(UsersRequest.SaveDTO users) {
        Users usersPS = usersRepository.save(users.toEntity());
        return usersPS;
    }
}
