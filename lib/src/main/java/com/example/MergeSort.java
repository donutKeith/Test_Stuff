package com.example;

/**
 * Created by Keith on 2/16/2016.
 */
public class MergeSort {

    public MergeSort(){

    }

    public float[] SortList(float list[]){
        float list1[], list2[];
        int middleIndex;
        int secondIndex;

        middleIndex = list.length/2;
        if(list.length < 2) {
            return list;
        }
        else{
            list1 = new float[middleIndex];
            list2 = new float[list.length - middleIndex];

            for(int i = 0; i < list1.length; i++){
                list1[i] = list[i];
            }
            secondIndex = middleIndex;
            for(int j = 0; j < list2.length; j++){
                list2[j] = list[secondIndex];
                secondIndex++;
            }
            PrintList(list1);
            list1 = SortList(list1);
            PrintList(list1);
            PrintList(list2);
            list2 = SortList(list2);
            PrintList(list2);
            return MergeSortedLists(list1, list2);
        }

    }

    public float[] MergeSortedLists(float []list1, float []list2){
        float ret[] = new float [list1.length + list2.length];
        int l1iter, l2iter, retiter;

        l1iter = 0;
        l2iter = 0;
        retiter = 0;

        while(l1iter < list1.length && l2iter < list2.length){
            if (list1[l1iter] < list2[l2iter]) {
                ret[retiter] = list1[l1iter];
                l1iter++;
            } else {
                ret[retiter] = list2[l2iter];
                l2iter++;
            }
            retiter++;
        }

        while(retiter < ret.length){
            if(l1iter < list1.length){
                ret[retiter] = list1[l1iter];
                l1iter++;
            }
            else if(l2iter < list2.length){
                ret[retiter] = list2[l2iter];
                l2iter++;
            }
            retiter++;
        }

        return ret;
    }

    public void PrintList(float []list){
        System.out.print("MergeSort:[");
        for(int i = 0; i < list.length; i++){
            if(i > 0){
                System.out.print(",");
            }
            System.out.print(list[i]);
        }
        System.out.print("]");
        System.out.println();
    }
}
