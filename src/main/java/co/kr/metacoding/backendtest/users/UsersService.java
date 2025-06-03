package co.kr.metacoding.backendtest.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
}
