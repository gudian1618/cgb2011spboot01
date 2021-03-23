package com.github.gudian1618.cgb2011spboot01;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/3/22 10:09 下午
 */

// 设置注解运行时有效
@Retention(RetentionPolicy.RUNTIME)
// 设置注解作用范围
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Component {
}

@Component
class Container {
}

public class TestScanClass01 {

    static Map<String, Object> beanPool = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // 1.获取启动类的字节码对象
        Class<TestScanClass01> cls = TestScanClass01.class;
        // 2.获取启动类所在的包
        String pkgName = cls.getPackage().getName();
        // 3.将包结构转换为目录结构
        String clsDir = pkgName.replace(".", "/");
        System.out.println(clsDir);
        // 4.获取目录对应的类文件所在的目录
        URL url = ClassLoader.getSystemResource(clsDir);
        System.out.println("path=" + url.getPath());
        // 5.获取url对应的目录下的所有的类
        File file = new File(url.getPath());
        String[] classNames = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        });

        for (String className : classNames) {
            System.out.println(className);
        }

        // 6.加载类,基于类的配置信息创建类的实例
        for (String className : classNames) {
            String cls1 = className.substring(0, className.lastIndexOf("."));
            System.out.println(cls1);
            Class<?> clsObject = ClassLoader.getSystemClassLoader().loadClass(pkgName + "." + cls1);
            System.out.println(clsObject.getName());
            // 检测类上是否有注解
            // boolean flag = clsObject.isAnnotationPresent(Component.class);
            Component an = clsObject.getAnnotation(Component.class);
            if (an == null) continue;
                // 底层通过构造方法对象构造
            Object instance = clsObject.newInstance();
            beanPool.put(cls1.substring(0, 1).toLowerCase() + cls1.substring(1), instance);
        }
        // 7.输出beanPool中的对象
        System.out.println("beanPool=" + beanPool);
    }
}
