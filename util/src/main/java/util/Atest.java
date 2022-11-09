package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Atest {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        list.add(4);
        list.add(10);
        list.add(5);
        list.add(1);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return 1;
                }else if (o1>o2){
                    return -1;
                }
                return 0;

            }
        });
        System.out.println(list);
    }
}
