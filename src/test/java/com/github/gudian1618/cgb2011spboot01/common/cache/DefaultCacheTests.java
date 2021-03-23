package com.github.gudian1618.cgb2011spboot01.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/3/23 6:31 下午
 * @Autowired 描述属性时,表示此属性的值由spring进行注入
 * @SpringBootTest 该注解描述类为一个单元测试类,并且此类也就交给spring管理
 */

@SpringBootTest
public class DefaultCacheTests {

    @Autowired
    private DefaultCache defaultCache;

    @Test
    public void testDefaultCache() {
        System.out.println(defaultCache);
    }

}
