package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _3_PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        //더 짧은수가 긴 수의 접두어일 수 있다. -> 같은 자릿수는 비교 불가, 더 긴수는 접두어일 수 없다.
        HashMap<Integer, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<String> compareList = new ArrayList<>();

        int num=1;
        while (num <= 20) {
            map.put(num, list);

            num++;
        }

        for(String number : phone_book){
            int digit = number.length();

            list = map.get(digit);
            list.add(number);
            map.replace(digit, list);
        }



        return answer;
    }
}
