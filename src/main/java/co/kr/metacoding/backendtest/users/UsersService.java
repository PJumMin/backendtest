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

    public Users detail(Integer id) {
        Users usersPS = usersRepository.findById(id);
        return usersPS;
    }

    @Transactional
    public Users update(Integer id, UsersRequest.UpdateDTO updateDTO) {
        Users usersPS = usersRepository.findById(id);
        // 더티채킹
        usersPS.update(updateDTO.getName());


        return usersPS;
    }
}
