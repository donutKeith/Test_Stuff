package com.example;

/**
 * Created by Keith on 2/28/2016.
 */
public class NumConverter {
    String[] lowTable;
    String[] tensTable;
    String[] highTable;


    public NumConverter(){
        lowTable = new String[20];
        tensTable = new String[10];
        highTable = new String[5];
        PopulateLowTable();
        PopulateTensTable();
        PopulateHighTable();
    }

    public String ConvertUnderOneThousand(int number){
    // Expects number to be under 1000. If number >= 1000 returns a blank string
        String retValue = "";
        int tempNum;

        if(number < 1000) {
            if (number < 20) {
                retValue = lowTable[number];
                if(number > 0){
                    retValue += " ";
                }
            }
            else if (number < 100) {
                tempNum = number / 10;
                retValue = tensTable[tempNum] + " " + ConvertUnderOneThousand(number % 10);
            }
            else {
                tempNum = number / 100;
                retValue = ConvertUnderOneThousand(tempNum) + "hundred " + ConvertUnderOneThousand(number % 100);
            }
        }
        return retValue;
    }

    public String Convert(int num){
    // Returns a string representation of num. num is expected as a whole number (integer)
        String returnValue = "";
        String numStr;
        int tempNum = num;
        int countGroupOfThrees = 0;
        int counter = 0;

        if(tempNum < 0){
            returnValue = "negative ";
            tempNum = Math.abs(num);
        }

        numStr = tempNum + "";

        if(tempNum == 0) { //Typically we do not want to say "zero" when we see it in a number so we have this special case for when the number is 0
            returnValue = "zero";
        }
        else {// THIS IS THE PART THAT BREAKS APART THE NUMBER BY 3 DIGITS OR LESS (aka numbers between 0 and 999) AND RETURNS THE NAME
            //Determine how many sets of 3 or less digits there are. Ex. In 100,000 there are 2 sets of 3, and in 10,000 there are still
            //  2 sets since we want to find the name of 10 and xx,000 (aka thousand)

            while (tempNum > 0) {
                tempNum = tempNum / 1000;
                countGroupOfThrees++;
            }

            // For each set of 3 digits or less we determine if the number is 1 - 999 and write out the word then add the word "thousand", "million", etc.
            while (countGroupOfThrees > 0) {
                countGroupOfThrees--;

                tempNum = numStr.substring(counter).length() % 3;
                if(tempNum == 0){
                    tempNum = 3;
                }
                // For each set of 3 digits or less (aka a number < 1000) return the name then add the high table value up to quadrillion
                returnValue +=  ConvertUnderOneThousand(Integer.parseInt(SubString(numStr, counter, tempNum)));

                counter += tempNum;
                if (countGroupOfThrees > 0) {
                    returnValue += highTable[countGroupOfThrees - 1] + " ";
                }
                else if(countGroupOfThrees > highTable.length - 1){
                    System.err.println("ADD TO THE HIGHTABLE! " + countGroupOfThrees + " > the number of words in the hightable.");
                }
            }
        }

        return returnValue;
    }

    public String SubString(String s, int start, int length){
        String returnValue = "";
        if(start + length <= s.length()) {
            returnValue = s.substring(start, start + length);
        }
        return returnValue;
    }

    public void PopulateLowTable(){
        lowTable[0] = "";
        lowTable[1] = "one";
        lowTable[2] = "two";
        lowTable[3] = "three";
        lowTable[4] = "four";
        lowTable[5] = "five";
        lowTable[6] = "six";
        lowTable[7] = "seven";
        lowTable[8] = "eight";
        lowTable[9] = "nine";
        lowTable[10] = "ten";
        lowTable[11] = "eleven";
        lowTable[12] = "twelve";
        lowTable[13] = "thirteen";
        lowTable[14] = "fourteen";
        lowTable[15] = "fifteen";
        lowTable[16] = "sixteen";
        lowTable[17] = "seventeen";
        lowTable[18] = "eighteen";
        lowTable[19] = "nineteen";
    }

    public void PopulateTensTable(){
        tensTable[0] = "";
        tensTable[1] = "ten";
        tensTable[2] = "twenty";
        tensTable[3] = "thirty";
        tensTable[4] = "forty";
        tensTable[5] = "fifty";
        tensTable[6] = "sixty";
        tensTable[7] = "seventy";
        tensTable[8] = "eighty";
        tensTable[9] = "ninety";
    }

    public void PopulateHighTable(){
        highTable[0] = "thousand";
        highTable[1] = "million";
        highTable[2] = "billion";
        highTable[3] = "trillion";
        highTable[4] = "quadrillion";
    }
}
