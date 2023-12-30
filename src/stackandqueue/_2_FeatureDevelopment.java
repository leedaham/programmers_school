package stackandqueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 기능개발
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42586">기능개발: 문제 페이지</a>
 */
public class _2_FeatureDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {

        List list = new ArrayList();
        for (int i = 0; i < progresses.length; i++) {
            double needDay = (100 - (double)progresses[i]) / (double) speeds[i];
            int needIntDay = (int) Math.floor(needDay);
            if (needDay > needIntDay) {
                needIntDay += 1;
            }
            list.add(needIntDay);
        }
        list.add(101);

        List result = new ArrayList();

        Iterator<Integer> intIterator = list.iterator();
        int standardValue = intIterator.next().intValue();
        intIterator.remove();

        int count = 1;
        while (intIterator.hasNext()) {
            int dynamicValue = intIterator.next();
            if(standardValue >= dynamicValue){
                count += 1;
            }else{
                result.add(count);
                count = 1;
                standardValue = dynamicValue;
            }
            intIterator.remove();

        }

        int[] answer = new int[result.size()];
        for (int i=0; i < answer.length; i++) {
            answer[i] = (int) result.get(i);
        }


        return answer;
    }
}
