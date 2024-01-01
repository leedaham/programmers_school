package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 가장 큰 수
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42746">가장 큰 수: 문제 페이지</a>
 */
public class _2_BiggestNumber {
    public String solution(int[] numbers) {
        String answer;

        ArrayList<Integer> list = Arrays.stream(numbers).boxed().sorted((o1, o2) -> {
            String o1str = o1.toString();
            String o2str = o2.toString();
            int o1f = Integer.parseInt(o1str + o2str);
            int o2f = Integer.parseInt(o2str + o1str);
            return Integer.compare(o2f, o1f);
        }).collect(Collectors.toCollection(ArrayList::new));

        StringBuilder sum = new StringBuilder();
        for (int value : list) {
            sum.append(value);
        }
        answer = sum.toString();
        if (answer.charAt(0) == '0') {
            answer = "0";
        }

        return answer;
    }
}
