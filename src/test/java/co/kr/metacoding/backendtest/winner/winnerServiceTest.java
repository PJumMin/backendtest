package co.kr.metacoding.backendtest.winner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@SpringBootTest
public class winnerServiceTest {

    @Test
    public void batchTest() {
        Integer[] n = {4, 3, 12, 44, 23, 33};
//        Integer[] a = {4, 3, 12, 44, 20, 37};

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

        List<Integer> winnernumber = new ArrayList<>(List.of(n));
        Collections.sort(winnernumber);

//        List<Integer> sam = new ArrayList<>(List.of(a));
//        Collections.sort(sam);

//        int matchCount = 0;
//        for (Integer num : sam) {
//            if (winnernumber.contains(num)) {
//                matchCount++;
//                System.out.print("winnernumber : " + winnernumber);
//                System.out.println();
//                System.out.print("batchnum : " + sam);
//                System.out.println();
//                System.out.println("matchCount : " + matchCount);
//            }
//        }

        int matchCount = 0;
        for (Integer num : batchnum) {
            if (winnernumber.contains(num)) {
                matchCount++;
                System.out.print("winnernumber : " + winnernumber);
                System.out.println();
                System.out.print("batchnum : " + batchnum);
                System.out.println();
                System.out.println("matchCount : " + matchCount);
            }
        }

        if (matchCount == 6) {
            System.out.println("1등");
        } else if (matchCount == 5) {
            System.out.println("2등");
        } else if (matchCount == 4) {
            System.out.println("3등");
        } else if (matchCount == 3) {
            System.out.println("4등");
        } else {
            System.out.println("5등");
        }
    }
}
