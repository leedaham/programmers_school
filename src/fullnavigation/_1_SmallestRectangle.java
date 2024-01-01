package fullnavigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 최소 직사각형
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/86491">최소 직사각형: 문제 페이지</a>
 */
public class _1_SmallestRectangle {
    public int solution(int[][] sizes) {
        int answer;

        int max = 0;
        int maxI = 0;
        int maxJ = 0;

        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes[i].length; j++) {
                if(max <= sizes[i][j]){
                    max = sizes[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        int maxPairJ = (maxJ == 0) ? 1 : 0;
        int maxPair = sizes[maxI][maxPairJ];
        sizes[maxI] = new int[]{0, 0};

        var list = Arrays.stream(sizes)
                .map((int[] ints) -> Math.min(ints[0], ints[1]))
                .collect(Collectors.toCollection(ArrayList::new));

        int secondaryMax = Collections.max(list);

        int residue = Math.max(maxPair, secondaryMax);
        answer = max * residue;

        return answer;
    }
}
