package Queue;

import java.util.LinkedList;
import java.util.Queue;

class QueueUsingLL {

    public static void main(String[] args) {
        Queue<Integer> list=new  LinkedList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
        System.out.println(list.peek());
        list.remove();
        System.out.println(list.peek());;


    }
}