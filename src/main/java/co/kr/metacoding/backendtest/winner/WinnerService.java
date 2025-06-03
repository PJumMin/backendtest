package co.kr.metacoding.backendtest.winner;

import co.kr.metacoding.backendtest.lottos.LottosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class WinnerService {
    private final WinnerRepository winnerRepository;
    private final LottosRepository lottosRepository;

    public WinnerRespons.BatchDTO batch() {
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


        return new WinnerRespons.BatchDTO(numbers);
    }

    public List<Winner> findWinner() {
        List<Winner> winnerList = winnerRepository.findAll();
        return winnerList;
    }
}
