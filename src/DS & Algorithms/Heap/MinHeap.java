package Heap;

import Stack.MinStack;

public class MinHeap {
    int capacity;
    int arr[];
    int size;

    MinHeap(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.size = 0;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void insert(int item) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        size++;
        int i = size - 1;
        arr[i] = item;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }

    public int getMin() {
        return arr[0];
    }

    public void decreaseKey(int i, int newVal) {
        arr[i] = newVal;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }

    public int extractMin() {

        int root = arr[0];
        arr[0] = arr[size - 1];
        MinHeapify(0);
        size--;
        return root;
    }

    public void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < size && arr[l] < arr[i])
            smallest = l;
        if (r < size && arr[r] < arr[smallest])
            smallest = r;
        if (smallest != i) {
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            MinHeapify(smallest);
        }
    }

    public void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public static void main(String gg[]) {
        MinHeap h = new MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.deleteKey(1);
        h.insert(15);
        h.insert(5);
        h.insert(4);
        h.insert(45);
        System.out.println(h.extractMin());
        System.out.println(h.getMin());
        h.decreaseKey(2, 1);
        System.out.println(h.getMin());
    }
}

