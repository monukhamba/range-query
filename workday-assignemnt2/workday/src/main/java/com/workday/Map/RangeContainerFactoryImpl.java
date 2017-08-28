package com.workday.Map;
import com.workday.Base.Ids;
import com.workday.Base.RangeContainerFactory;
import com.workday.Base.RangeContainer;

/**
 * builds an immutable container optimized for range queries.
 * Data is expected to be 32k items or less.
 * The position in the “data” array represents the “id” for that instance
 * in question. For the “PayrollResult” example before, the “id” might be
 * the worker’s employee number, the data value is the corresponding
 * net pay. E.g, data[5]=2000 means that employee #6 has net pay of 2000.
 *
 *
 * Implemented via TreeMap and HashMap
 * TreeMap implementation uses subMap and
 * stores data in <data, List of ids> format which handles the case of duplicate data
 * but needs the ids to be sorted later on as TreeMap only stores sorted values.
 * If I use (id,data) format , for the ease of  having already sorted keys in the Map,
 * it does not handle duplicate keys.
 */

public class RangeContainerFactoryImpl implements RangeContainerFactory {
    @Override
    public RangeContainer createContainer(long[] data) {
        //Use either implementation
        return new MapRangeContainer(data);
        //return new TreeMapContainer(data);

    }
}
