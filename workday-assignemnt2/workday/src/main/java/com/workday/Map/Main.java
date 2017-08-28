package com.workday.Map;

import java.util.Random;
import com.workday.Base.*;

/*
* Main class to have th main method , for running it through random data
* in the ranges of 0-32000 per container.
*
* */
public class Main {
    public static void main(String [] argv) {
        RangeContainerFactory factory = new RangeContainerFactoryImpl();
        int ranges [][] = generateRandomRange();
        long begin;
        long end;
        short id=0;
        long testData [] = generateRandomData();

        RangeContainer rc1 = factory.createContainer(new long[] { 10,12,17,21,2,15,16});
        RangeContainer rc2 = factory.createContainer(testData);


        Ids ids = rc1.findIdsInRange(14, 17, true, true);

        /*
        * Run with random data
        * */
        runLoadTest(testData,rc2, ranges);

        //print out the ids from 14 to 17 on the console
        while ((id = ids.nextId()) != Ids.END_OF_IDS) {
            System.out.println(id);
        }


    }
    private static void runLoadTest(long[] testData, RangeContainer rc2, int[][] ranges) {

        for(int i = 0; i < ranges.length; i++) {

            Ids ids = null;
            long value1 = testData[ranges[i][0]];
            long value2 = testData[ranges[i][1]];

            if(value1 > value2) {
                ids = rc2.findIdsInRange(value2, value1, true, true);
            } else {
                ids = rc2.findIdsInRange(value1, value2, true, true);
            }

        }
    }
    /*
    * Generating random data
    * */
    private static long[] generateRandomData() {
        Random generator = new Random();
        long [] data = new long[32000];
        for(short i = 0; i < data.length; i++) {
            data[i] = generator.nextLong();
        }
        return data;
    }
    /*
    * Constructing a 2d array ranges, with start and end ranges for 100k records
    * as there could be at max 32k records per container
    * */
    private static int[][] generateRandomRange() {
        Random generator = new Random();

        int numberOfRecords = 100000;
        int[][] ranges = new int[numberOfRecords][2];
        for(int i = 0; i < numberOfRecords; i++) {
            ranges[i][0] = generator.nextInt(32000);
            ranges[i][1] = generator.nextInt(32000);
        }

        return ranges;
    }



}
