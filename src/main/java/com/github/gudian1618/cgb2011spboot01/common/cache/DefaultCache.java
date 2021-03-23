package com.github.gudian1618.cgb2011spboot01.common.cache;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/3/23 6:24 下午
 * @Component 注解有spring定义, 主要用于描述spring框架管理一些类型的对象
 * @Lazy 按需加载,延迟加载,默认是true
 * @Scope 作用域
 */

@Component
@Scope("prototype")
@Lazy
public class DefaultCache {

    public DefaultCache() {
        System.out.println("==DefaultCache==");
    }


}
