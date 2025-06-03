package co.kr.metacoding.backendtest.winner;

import co.kr.metacoding.backendtest.lottos.Lottos;
import co.kr.metacoding.backendtest.lottos.LottosRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Winner batch() {
        List<Integer> batchNums = new ArrayList<>();
        Random random = new Random();

        while (batchNums.size() < 6) {
            int num = random.nextInt(45) + 1;
            if (!batchNums.contains(num)) {
                batchNums.add(num);
            }
        }

        Collections.sort(batchNums);

        List<Lottos> lottosList = lottosRepository.findAll();

        int bestMatchCount = 0;
        Lottos bestLotto = null;

        for (Lottos lotto : lottosList) {
            String cleaned = lotto.getNumbers().replace("[", "").replace("]", "");
            String[] split = cleaned.split(",");

            List<Integer> userNums = new ArrayList<>();
            for (String s : split) {
                userNums.add(Integer.parseInt(s.trim()));
            }

            int match = 0;
            for (Integer num : batchNums) {
                if (userNums.contains(num)) {
                    match++;
                }
            }

            if (match > bestMatchCount) {
                bestMatchCount = match;
                bestLotto = lotto;
            }
        }


        String rank = "";
        if (bestMatchCount == 6) {
            rank = "1등";
        } else if (bestMatchCount == 5) {
            rank = "2등";
        } else if (bestMatchCount == 4) {
            rank = "3등";
        } else if (bestMatchCount == 3) {
            rank = "4등";
        } else if (bestMatchCount == 2) {
            rank = "5등";
        } else {
            rank = "꽝";
        }

        Winner winner = Winner.create(rank, bestLotto);
        winnerRepository.save(winner);
        return winner;
    }

    public List<Winner> findWinner() {
        List<Winner> winnerList = winnerRepository.findAll();
        return winnerList;
    }
}
