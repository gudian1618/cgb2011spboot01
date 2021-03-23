package com.github.gudian1618.cgb2011spboot01.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/3/23 8:49 下午
 */

@SpringBootTest
public class CacheTests {

    // @Autowired
    // @Qualifier("defaultCache")
    private Cache cache01;

    // public CacheTests() {
    // }

    // @Autowired
    // @Qualifier("weakCache")
    public Cache cache02;

    // 通过构造方法为属性赋值(构造注入)
    @Autowired
    public CacheTests(@Qualifier("defaultCache") Cache cache01, @Qualifier("weakCache") Cache cache02) {
        this.cache01 = cache01;
        this.cache02 = cache02;
    }

    @Test
    public void testCache01() {
        System.out.println("cache01=" + cache01);
    }

    @Test
    public void testCache02() {
        System.out.println("cache02=" + cache02);
    }

    @Test
    public void testCache0102() {
        System.out.println("cache01=" + cache01);
        System.out.println("cache02=" + cache02);
    }

}
