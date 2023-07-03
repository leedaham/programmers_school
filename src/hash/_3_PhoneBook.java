package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _3_PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i=0; i < phone_book.length; i++){
            if(phone_book[i].length() != 20) {
                String num1 = phone_book[i];

                for(int j=0; j < phone_book.length; j++){
                    if(i != j){
                        String num2 = phone_book[j];
                        if(num1.length() < num2.length()){
                            answer = num2.startsWith(num1);
                            if(!answer){
                                return answer;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
