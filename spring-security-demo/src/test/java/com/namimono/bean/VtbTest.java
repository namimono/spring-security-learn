package com.namimono.bean;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class VtbTest {

    @Test
    public void test(){

        Vtb vtb = new Vtb().builder().age(1).channel("q").company("g").build();
        System.out.println(vtb);
    }


    @Test
    public void testRandom(){
        int a = (int) (Math.random()*(Math.pow(10,4)));
        double b =  Math.random()*100;
        Random random=new Random();
//        IntStream ints = random.ints(4);
        int ints = random.nextInt((int)Math.pow(10,4));
//        System.out.println(a);
//        System.out.println(b);
        System.out.println(ints);
    }

}