package com.learn.ardentDertat.sort;

public class QuickSort {
    private int[] arr;
    private int nElems;

    public QuickSort(int[] arr, int nElems) {
        this.arr = arr;
        this.nElems = nElems;
    }

    public void quickSort(int left, int right){
        if(right - left <= 0){
            return;
        } else {
            int pivot = arr[right];
            int partition = partition(left, right, pivot);
            quickSort(left, partition - 1);
            quickSort(partition+1, right);
        }
    }

     private int partition( int left, int right, int pivot){
        int leftPtr = left - 1;
        int rightPtr = right;

        while(true){
            while (arr[++leftPtr] < pivot);

            while (rightPtr > 0 && arr[--rightPtr] > pivot);

            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr,rightPtr);
        }

        swap(leftPtr,right);
        return leftPtr;
    }

     private void swap( int left, int right){
        int temp = arr[left];
         arr[left] = arr[right];
         arr[right] = temp;
    }
}
