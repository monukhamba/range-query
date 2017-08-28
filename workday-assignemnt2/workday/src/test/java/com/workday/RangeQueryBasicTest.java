package com.workday;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import com.workday.Base.Ids;
import com.workday.Base.RangeContainer;
import com.workday.Base.RangeContainerFactory;
import com.workday.Map.RangeContainerFactoryImpl;


/*
* Test case suite to check for the sample data provided and
* other edge cases .
*
* */
public class RangeQueryBasicTest {
    private RangeContainer rc;
    private RangeContainerFactory rf;
    private RangeContainer largeContainer;
    private long[] largeData = new long[32000];
    @Before
    public void setUp(){
        rf = new RangeContainerFactoryImpl();
    }


    @Test
    public void runARangeQuery(){
        rc = rf.createContainer(new long[]{10,12,17,21,2,15,16});
        Ids ids = rc.findIdsInRange(14, 17, true, true);
        Assert.assertEquals(2, ids.nextId());
        Assert.assertEquals(5, ids.nextId());
        Assert.assertEquals(6, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        ids = rc.findIdsInRange(14, 17, true, false);
        Assert.assertEquals(5, ids.nextId());
        Assert.assertEquals(6, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
        ids = rc.findIdsInRange(20, Long.MAX_VALUE, false, true);
        Assert.assertEquals(3, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
    }


    @Test
    public void testFromAndToAreEqual() {
        rc = rf.createContainer(new long[] { 10, 12, 17, 21, 17, 2, 14, 16 });

        Ids ids = rc.findIdsInRange(17, 17, true, true);
        Assert.assertEquals(2, ids.nextId());
        Assert.assertEquals(4, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
    }

    @Test
    public void testDupMix() {
        rc = rf.createContainer(new long[] { 6, 21, 7, 6, 21 });
        Ids ids = rc.findIdsInRange(6, 21, true, true);
        Assert.assertEquals(0, ids.nextId());
        Assert.assertEquals(1, ids.nextId());
        Assert.assertEquals(2, ids.nextId());
        Assert.assertEquals(3, ids.nextId());
        Assert.assertEquals(4, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());

        ids = rc.findIdsInRange(6, 21, false, false);
        Assert.assertEquals(2, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());

        ids = rc.findIdsInRange(Long.MIN_VALUE, Long.MAX_VALUE, true, true);
        Assert.assertEquals(0, ids.nextId());
        Assert.assertEquals(1, ids.nextId());
        Assert.assertEquals(2, ids.nextId());
        Assert.assertEquals(3, ids.nextId());
        Assert.assertEquals(4, ids.nextId());
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());

    }
    @Test
    public void testEmptyData() {
        rc = rf.createContainer(new long[] { });
        Ids ids = rc.findIdsInRange(14, 17, true, true);
        Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
    }


}
