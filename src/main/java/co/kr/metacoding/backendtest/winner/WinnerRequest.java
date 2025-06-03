package co.kr.metacoding.backendtest.winner;

public class WinnerRequest {

    public static class SaveDTO {
        public String rank;


        public SaveDTO(String rank) {
            this.rank = rank;
        }

        public Winner toEntity() {
            return Winner.builder()
                    .rank(rank)
                    .build();
        }
    }


}
