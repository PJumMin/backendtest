package co.kr.metacoding.backendtest.winner;

import co.kr.metacoding.backendtest.lottos.Lottos;
import lombok.Data;

import java.util.List;

public class WinnerRespons {
    @Data
    public static class BatchDTO {
        private List<Integer> numbers;
        private List<Lottos> lottosId;


        public BatchDTO(List<Integer> numbers, List<Lottos> lottosId) {
            this.numbers = numbers;
            this.lottosId = lottosId;
        }
    }
}
