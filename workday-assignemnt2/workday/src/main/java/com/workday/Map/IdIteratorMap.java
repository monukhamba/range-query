package com.workday.Map;

import java.util.*;

import com.workday.Base.Ids;

/*
Iterator over the ArrayList of ids generated by Map container
*/
public class IdIteratorMap implements Ids{

    private List<Short> ids;
    private NavigableMap<Long, List<Short>> map;
    private int i= -1;
    public IdIteratorMap(List<Short> ids) {

        this.ids = ids;
    }

    // Iterator over the subMap
    // For the TreeMap implementation where ids is a list of ids
    public IdIteratorMap(NavigableMap<Long, List<Short>> map) {
        ids = new ArrayList<Short>();
        this.map = map;
        for(List<Short> idList:this.map.values()){
            ids.addAll(idList);
        }
        Collections.sort(ids);

    }
    //For the HashMap Implementation
    public short nextId() {
        i++;
        if(i< ids.size()){
            return ids.get(i);
        }

        return END_OF_IDS;

    }

}
