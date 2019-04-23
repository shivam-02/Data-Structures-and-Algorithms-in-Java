package Queue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;

public class LRUCache {

    ArrayDeque<Integer> cache=new ArrayDeque<>(4);
    HashSet<Integer> set=new HashSet<>();
    int cacheSize=4;

    public void refer(int item){
        if(!set.contains(item)){
            if(cacheSize==cache.size()){
                int data=cache.removeLast();
                set.remove(data);
            }
        } else{
            Iterator iterator=cache.iterator();
            while(iterator.hasNext()){
                int i= (int) iterator.next();
                if(i==item){
                    iterator.remove();
                }
            }
        }
        cache.addFirst(item);
        set.add(item);
    }
    public void display()
    {
        Iterator<Integer> itr = cache.iterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next()+" ");
        }
    }


    public static void main(String[] args) {
        LRUCache ca=new LRUCache();
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}

