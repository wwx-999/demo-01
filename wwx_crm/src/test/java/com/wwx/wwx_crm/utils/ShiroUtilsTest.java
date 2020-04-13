package com.wwx.wwx_crm.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShiroUtilsTest {

    @Test
    public void encryptPassword() {
        System.out.println("随机盐"+ShiroUtils.randomSalt());
    }

    @Test
    public void randomSalt() {
        System.out.println("密码"+ShiroUtils.encryptPassword("admin","admin2e7a903e306a"));
    }
}