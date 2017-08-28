package com.workday.Map;

import java.util.*;
import com.workday.Base.Ids;
import com.workday.Base.RangeContainer;

public class TreeMapContainer implements RangeContainer{
    private TreeMap<Long, List<Short>> rangeMap = new TreeMap<>();

    public TreeMapContainer(long[] data){
        for(short i=0; i < data.length; i++) {
            if(rangeMap.get(data[i])!=null){
                rangeMap.get(data[i]).add(i);
            } else{
                rangeMap.put(data[i], new ArrayList<Short>());
                rangeMap.get(data[i]).add(i);
            }
        }
    }
    /* Uses the subMap method of the TreeMap to get those range of values,
    * Used TreeMap to store (data: ListofIds) so that for duplicate  values
    * the ids are appended to the value.
    */
    @Override
    public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {


        NavigableMap<Long,List<Short>> sMap = rangeMap.subMap(fromValue, fromInclusive,
                toValue, toInclusive);


        //return an iterator over the subMap
        Ids ids = new IdIteratorMap(sMap);
        return ids;
    }
}
