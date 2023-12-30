package stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 같은 숫자는 싫어
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42577">같은 숫자는 싫어: 문제 페이지</a>
 */
public class _1_IDontLikeSameNumbers {
    public int[] solution(int []arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        List result = new ArrayList();
        result.add(list.get(0));
        for(int i = 0; i < list.size()-1; i ++){
            if(list.get(i) != list.get(i+1)){
                result.add(list.get(i + 1));
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = (int) result.get(i);
        }

        return answer;
    }
}
