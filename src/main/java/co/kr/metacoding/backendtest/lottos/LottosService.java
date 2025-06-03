package co.kr.metacoding.backendtest.lottos;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LottosService {
    private final LottosRepository lottosRepository;

    @Transactional
    public LottosRespons.RandomNumberDTO addNumber() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        while (numbers.size() < 6) {
            int num = random.nextInt(45) + 1;
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }

        Collections.sort(numbers);

        // 정제된 문자열로 변환 (대괄호 없이)
        String numberString = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")); // 예: "3,12,18,24,35,41"

        // DB 저장
        Lottos lotto = new Lottos(0, numberString);
        lottosRepository.save(lotto);

        return new LottosRespons.RandomNumberDTO(numbers);
    }

    public LottosRespons.LottosDTO findNumber() {

        List<Lottos> lottosList = lottosRepository.findAll();

        return new LottosRespons.LottosDTO(lottosList);
    }
}
