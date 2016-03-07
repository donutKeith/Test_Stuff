package com.example;

public class MyClass {

    public static void main(String [] args){

        float []sortThis = new float[5];


        //SeiveOfEratosthenes(100);

        NumConverter converter = new NumConverter();

        //for(int i = 0; i <= 999999999; i++) {//999999999
            System.out.print(converter.Convert(123000));
        //    System.out.println(" = " + i);
        //}

        //PopulateArrayWithRandomNumbers(sortThis, 0f, 100f);
        //MergeSort m = new MergeSort();
        //QuickSort q = new QuickSort();
        //q.QSortWall(sortThis, 0, sortThis.length - 1);
        //q.PrintArray(sortThis);
        /*System.out.println("LIST BEFORE SORTING:");
        m.PrintList(sortThis);
        sortThis = m.SortList(sortThis);
        System.out.println("LIST AFTER SORTING:");
        m.PrintList(sortThis);
        */
    }

    public static int fib(int num){
    // Enter the number of numbers from the fibbonachi sequence you would like to see printed to the screen.
    // Returns the num number of the fibbonachi sequence (num starting at 0 NOT 1)
        int returnVal = 0;
        int cur = 1;
        int prev = 0;
        int sum;
        for(int i = 0; i < num; i++){
            if(i <= 1){
                returnVal = i;
            }
            else {
                sum = cur + prev;
                prev = cur;
                cur = sum;
                returnVal = sum;
            }

            System.out.println("fib[" + i + "]" + returnVal);
        }
        return returnVal;
    }

    public static int[] SeiveOfEratosthenes(int max){
    // Prints all the prime numbers from 0 to max
    // PRIME NUMBER DEFINITION:
    //          A prime number (or a prime) is a natural number greater than 1
    //          that has no positive divisors other than 1 and itself.
        int nums[] = new int[max+1];
        int ret[];
        int sqrt = (int)Math.sqrt((double)max);
        int counter;
        int numberOfPrimesFound = 0;

        if(max < 2) {
            ret = new int[0];
            System.out.println("ERROR: THERE ARE NO PRIME NUMBERS < 2");
        }
        else{
            // Cross out all non-prime numbers
            nums[0] = 1; // ZERO is not prime by the definition of prime numbers
            nums[1] = 1; // ONE is not prime by the definition of prime numbers
            for (int i = 2; i <= sqrt; i++) {
                counter = i;
                if (nums[counter] != 1) {
                    while (counter <= max) {
                        counter += i;   // Increment first we do not want to cross out the first
                                        //  number as it, itself is prime since it was not previously
                                        //  crossed out
                        if (counter <= max) {
                            nums[counter] = 1;

                        }

                    }
                }
            }

            // Print numbers that were not crossed out
            for (int i = 0; i <= max; i++) {
                if (nums[i] != 1) {
                    numberOfPrimesFound++;
                    System.out.print(i + " ");
                }
            }

            ret = new int[numberOfPrimesFound];
            counter = 0;
            for(int j = 0; j <= max; j++){
                if(nums[j] != 1){
                    ret[counter] = j;
                    counter++;
                }
            }

        }
        return ret;
    }

    public static void PopulateArrayWithRandomNumbers(float [] arr, float start, float end){
        float range = end - start;
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(Math.random() * range) - start;
        }
    }
}
