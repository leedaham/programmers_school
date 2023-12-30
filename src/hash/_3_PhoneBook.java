package hash;

import java.util.Arrays;

/**
 * 전화번호 목록
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42577">전화번호 목록: 문제 페이지</a>
 */
public class _3_PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return answer;
    }
}
