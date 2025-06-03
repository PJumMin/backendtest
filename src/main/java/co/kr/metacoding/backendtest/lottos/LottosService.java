package co.kr.metacoding.backendtest.lottos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class LottosService {
    private final LottosRepository lottosRepository;

    public LottosRespons.RandomNumberDTO addNumber() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        while (numbers.size() < 6) {
            // 1~45까지 난수 생성
            int num = random.nextInt(45) + 1;
            // 중복제거
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        // 정렬
        Collections.sort(numbers);

        return new LottosRespons.RandomNumberDTO(numbers);
    }
}
