package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * K번째 수
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42748">K번째 수: 문제 페이지</a>
 */
public class _1_KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        BiFunction<ArrayList<Integer>, int[], Integer> getValue = (ArrayList<Integer> arr, int[] ints) -> {
            List<Integer> returnList = new ArrayList<>(arr.subList(ints[0] - 1, ints[1]));
            returnList.sort(Comparator.naturalOrder());
            return returnList.get(ints[2] - 1);
        };

        final var list = Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        for (int i=0; i < commands.length ; i++) {
            int result = getValue.apply(list, commands[i]);
            answer[i] = result;
        }

        return answer;
    }
}
