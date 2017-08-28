package com.workday.Map;

import java.util.*;
import com.workday.Base.Ids;
import com.workday.Base.RangeContainer;

/**
 * Use Map to keep track of the data and the index of the data. This  method intakes the
 * incoming data to be in the key:val format , so the resulting map is
 * (id, data)
 * Used an ArrayList to store ids to find the range
 * */

public class MapRangeContainer implements RangeContainer {


    private Map<Short, Long> rangeMap = new HashMap<>();

    public MapRangeContainer(long[] data){
        for(short i=0; i < data.length; i++) {

            rangeMap.put(i,data[i]);
        }
    }
    /* Returns an iterator for the Ids in the and creates an iterator
    *  entry.getValue() has the integer value of the data .
    *  entry.getKey() gives the ids of the elements in the range
    *
    */
    @Override
    public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {

        List<Short> idList = new ArrayList<>();

        for(Map.Entry<Short, Long> entry: rangeMap.entrySet()){
            if((entry.getValue() == fromValue && fromInclusive) ||
                    (entry.getValue() == toValue && toInclusive)){

                idList.add(entry.getKey());
            } else if(entry.getValue()>fromValue && entry.getValue()<toValue){
                idList.add(entry.getKey());
            }

        }

        //return an iterator over the list
        Ids ids = new IdIteratorMap(idList);
        return ids;
    }

    /*
    * If we want objects instead of numerical values to be searched , we can use
    * this class to create an obj, with the same key as the id and hence have many
    * attribute with it.
    * inner class to hold the entry object , named as Entry1 cause maps
    * have an an Map.Entry interface which I have used to go through the map
    *
    private static class Entry1{
        short id;
        long value;


        public Entry1(short id, long value){
            super();
            this.id =id;
            this.value=value;
        }

    }*/



}
