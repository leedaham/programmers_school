package sort;

import java.util.Arrays;

/**
 * H-Index
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42747">H-Index: 문제 페이지</a>
 */
public class _3_HIndex {
    public int solution(int[] citations) {
        int answer = 0;

        int hIndexLimit = citations.length;
        Arrays.sort(citations);

        for (int h = hIndexLimit; h >= 0; h--) {
            int a  = h;
            var overHIndex = Arrays.stream(citations).filter(i -> i >= a).count();
            if (overHIndex >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
