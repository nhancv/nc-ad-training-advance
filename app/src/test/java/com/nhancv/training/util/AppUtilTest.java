package com.nhancv.training.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nhancao on 10/17/17.
 */
public class AppUtilTest {

    @Test
    public void isOdd_true() throws Exception {
        Assert.assertTrue(AppUtil.isOdd(1));
    }

    @Test
    public void isOdd_false() throws Exception {
        Assert.assertFalse(AppUtil.isOdd(2));
    }

}