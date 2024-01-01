package fullnavigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 모의고사
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42840">모의고사: 문제 페이지</a>
 */
public class _2_MockExam {
    public int[] solution(int[] answers) {
        //각 수포자들 찍는 배열 정의
        ArrayList<Integer> supo1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> supo2 = new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        ArrayList<Integer> supo3 = new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        BiFunction<ArrayList<Integer>, int[], Integer> getCorrectCount = (ArrayList<Integer> supoAnswerList, int[] checkAnswers) -> {
            int count = 0;
            Iterator<Integer> supoIter = supoAnswerList.iterator();

            for (int checkAnswer : checkAnswers) {
                int supoOrder;
                if (!supoIter.hasNext()) {
                    supoIter = supoAnswerList.iterator();
                }
                supoOrder = supoIter.next();
                if (supoOrder == checkAnswer) {
                    count += 1;
                }
            }
            return count;
        };

        int supo1Answers = getCorrectCount.apply(supo1, answers);
        int supo2Answers = getCorrectCount.apply(supo2, answers);
        int supo3Answers = getCorrectCount.apply(supo3, answers);
        int maxValue = Math.max(Math.max(supo1Answers, supo2Answers), supo3Answers);
        List<Integer> list = new ArrayList<>();
        if (supo1Answers == maxValue) {
            list.add(1);
        }
        if (supo2Answers == maxValue) {
            list.add(2);
        }
        if (supo3Answers == maxValue) {
            list.add(3);
        }
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
