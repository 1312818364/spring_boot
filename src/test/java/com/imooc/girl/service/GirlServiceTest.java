package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    GirlService girlService;

    @Test
    public void findOne(){
        Girl girl = girlService.findOne(5);
        Assert.assertEquals(new Integer(20), girl.getAge());
    }

}