package com.example;

/**
 * Created by Keith on 2/16/2016.
 */
public class QuickSort {

    //float pivot;

    int wall; //This is the index of the most recent lowest element seen which will be towards the front of the partitioned list.
    // At the end of the partition step the pivot should be placed at index == wall + 1


    public QuickSort(){

    }

    public void QSortWall( float []list, int low, int hi){

        PartitionWall(list, low, hi);

        if(hi - low > 1){
            if(wall > 0) {
                QSortWall(list, low, wall - 1);
            }
            if(wall < list.length - 1) {
                QSortWall(list, wall + 1, hi);
            }
        }
    }

    public int PickPivotWall(float []list){
        // Choose the right most element, for the wall implementation
        int returnIndex = list.length - 1;
        return returnIndex;
    }

    public float[] PartitionWall(float []list, int start, int end){
        int pivotIndex;
        int currentElement; // The current element we are trying to place such that everything towards the front of the list is <= to the pivot
                            // and everything towards the end of the list is > pivot. So everything from index == 0 to index == (wall) should be <= pivot and
                            // everything from index == (wall + 2) to index == ((list.length - 1) - 1) [aka end of list - pivot element] will be > pivot

        System.out.println("List Before Partition:" + start + " - " + end);
        PrintArray(list);

        pivotIndex = end;//PickPivotWall(list);// Just picks the last element DOESN'T REALLY NEED ITS OWN FUNCTION BUT IT MIGHT BE NICE FOR OTHER Q-SORT IMPLEMENTATIONS LATER ON

        currentElement = start; // Start at the beginning of the list;
        wall = currentElement - 1; //Initially -1 but we increment every time BEFORE we use this value so it starts at 0 actually

        // We pick the last element (aka list.length - 1) as the pivot so we do not need to compare
        //   it so we stop before the last element (aka (list.length - 1) - 1 ==  list.length - 2)
        while(currentElement <= end - 1){// 0 -> length - 2
            if(list[currentElement] <= list[pivotIndex]){
                wall++;
                Swap(currentElement, wall, list);
            }
            currentElement++;
        }

        wall++;
        Swap(wall, pivotIndex, list);

        return list;
    }

    public void Swap(int indexL, int indexR, float []list){
        float tempValue = list[indexL];
        list[indexL] = list[indexR];
        list[indexR] = tempValue;
    }

    public void PrintArray(float [] list){
        System.out.print("[");
        for(int i = 0; i < list.length; i++){
            if(i == 0){
                System.out.print(list[i]);
            }
            else {
                System.out.print(", " + list[i]);
            }
        }
        System.out.println("]");
    }
}
