package com.developer.jdk8.designpatterns.inter.factorymethod;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 16:26
 * @description:工厂方法模式核心工厂类，这个工厂接口提供导出文件的功能，这里需要注意factory方法的返回值是一个对象，
 *              然后就将实际产品的生成下沉到子类中去了，由于ExportFile也是一个接口，具体子类实现它，就将产品类的创建与实际
 *              子类相关联了
 */
public interface ExportFactory {

    /**
     * 根据type生成不同的对象
     *
     * @param type
     * @return
     */
    ExportFile factory(String type);
}
