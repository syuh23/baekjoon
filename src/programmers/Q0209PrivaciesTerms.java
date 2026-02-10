package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0209PrivaciesTerms {

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};  // 약관 유효기간
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};  // 수집된 개인정보의 정보 (i -> i+1번 개인정보)

        int[] answer = {};

        ArrayList<Integer> answerList = new ArrayList<>();
        ArrayList<String> type = new ArrayList<>();
        Arrays.stream(terms).forEach(data -> type.add(data.split(" ")[0]));

        int todayArr = Integer.parseInt(today.replace(".", ""));

        for (int i = 0; i < privacies.length; i ++) {
            int typeIndex = type.indexOf(privacies[i].split(" ")[1]);
            String[] privaciesDate = privacies[i].split(" ")[0].split("\\.");

            int[] dateArr = new int[3];
            dateArr[0] = Integer.parseInt(privaciesDate[0]);
            dateArr[1] = Integer.parseInt(privaciesDate[1]) + Integer.parseInt(terms[typeIndex].split(" ")[1]);
            dateArr[2] = Integer.parseInt(privaciesDate[2]) - 1;

            if (dateArr[2] == 0) {
                dateArr[1] --;
                dateArr[2] = 28;
            }

            if (dateArr[1] > 12) {
                dateArr[0] += dateArr[1] / 12;
                dateArr[1] %= 12;
            }
            else if (dateArr[1] == 0) {
                dateArr[0] --;
                dateArr[1] = 12;
            }

            // 숫자로 각각 비교?


//            int dateInt = Integer.parseInt(String.valueOf(dateArr[0]) + String.valueOf(dateArr[1]) + String.valueOf(dateArr[2]));
//
//            if (dateInt < todayInt)
//                answerList.add(i);
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i ++) {
            answer[i] = answerList.get(i);
        }
    }
}
