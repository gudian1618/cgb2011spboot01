package com.github.gudian1618.cgb2011spboot01.common.cache;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
// @Scope("singleton")
// @Lazy
public class DefaultCache implements Cache {

    public DefaultCache() {
        System.out.println("==DefaultCache==");
    }

    // 生命周期初始化方法,对象构建以后执行,用于初始化一些资源
    @PostConstruct
    public void init() {
        System.out.println("init()");
    }

    // 声明周期销毁方法,对象销毁之前执行,只针对singleton模式生效
    @PreDestroy
    public void destiry() {
        System.out.println();
    }

}
