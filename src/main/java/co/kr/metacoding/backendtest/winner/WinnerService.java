package co.kr.metacoding.backendtest.winner;

import co.kr.metacoding.backendtest.lottos.Lottos;
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

    public Winner batch() {
        List<Integer> batchnum = new ArrayList<>();
        Random random = new Random();

        while (batchnum.size() < 6) {
            // 1~45까지 난수 생성
            int num = random.nextInt(45) + 1;
            // 중복제거
            if (!batchnum.contains(num)) {
                batchnum.add(num);
            }
        }
        // 정렬
        Collections.sort(batchnum);

        List<Lottos> LottoList = lottosRepository.findAll();

        int matchCount = 0;
        for (Integer num : batchnum) {
            if (LottoList.contains(num)) {
                matchCount++;
            }
        }

        String rank = "";
        if (matchCount == 6) {
            rank = "1등";
        } else if (matchCount == 5) {
            rank = "2등";
        } else if (matchCount == 4) {
            rank = "3등";
        } else if (matchCount == 3) {
            rank = "4등";
        } else if (matchCount == 2) {
            rank = "5등";
        } else {
            rank = "꽝";
        }

        Winner winner = new WinnerRequest.SaveDTO(rank).toEntity();

        return winner;
    }

    public List<Winner> findWinner() {
        List<Winner> winnerList = winnerRepository.findAll();
        return winnerList;
    }
}
