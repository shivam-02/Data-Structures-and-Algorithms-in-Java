package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueue {

    public static int minIndex(Queue<Integer> queue, int sortIndex) {
        int min_index = 0;
        int min_value = Integer.MAX_VALUE;
        int size = queue.size();
        int currentValue;
        for (int i = 0; i < size; i++) {
            currentValue = queue.poll();
            if (currentValue < min_value && i < sortIndex) {
                min_index = i;
                min_value = currentValue;
            }
            queue.add(currentValue);
        }
        return min_index;
    }

    public static void insertAtRear(Queue<Integer> queue, int min_index) {
        int size = queue.size();
        int current;
        int min_value = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            current = queue.poll();
            if (i != min_index)
                queue.add(current);
            else
                min_value = current;
        }
        queue.add(min_value);
    }

    public static void sortQueue(Queue<Integer> queue) {
        for (int i = 0; i < queue.size(); i++) {
            int min_index = minIndex(queue, queue.size() - i);
            insertAtRear(queue, min_index);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<Integer>();
        list.add(30);
        list.add(11);
        list.add(15);
        list.add(4);

        //Sort Queue
        sortQueue(list);

        //print sorted Queue
        while (list.isEmpty() == false) {
            System.out.print(list.peek() + " ");
            list.poll();
        }
    }
}
