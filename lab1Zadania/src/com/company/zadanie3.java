package com.company;

public class zadanie3 {

    public static void main(String[] args)
    {

        int array[] = new int[] {4,5,7,11,12,15,20,21,40,45};
        var index = searchIndex(array, 11);
        System.out.println(index);
    }

    public static int searchIndex(int[] array, int value)
    {
        int index = 0;
        int limit = array.length -1;
        while (index<= limit)
        {
            int point = (int) Math.ceil((index+limit)/2);
            int entry = array[point];
            if (value > entry) {
                index = point + 1;
                continue;
            }
            if (value < entry) {
                limit = point - 1;
                continue;
            }
            return point; // value == entry
        }
        return -1;

        }
    }