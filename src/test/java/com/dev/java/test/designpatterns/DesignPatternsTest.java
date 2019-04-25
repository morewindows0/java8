package com.dev.java.test.designpatterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.dev.java.designpatterns.abstractfactory.ComputerEngineer;
import com.dev.java.designpatterns.abstractfactory.IntelFactory;
import com.dev.java.designpatterns.builder.Director;
import com.dev.java.designpatterns.builder.Product;
import com.dev.java.designpatterns.decorator.ConcreteDecorator;
import com.dev.java.designpatterns.inter.abstractfactory.AbstractFactory;
import com.dev.java.designpatterns.inter.adapter.impl.Adapter;
import com.dev.java.designpatterns.inter.builder.Builder;
import com.dev.java.designpatterns.inter.builder.impl.ConcreteBuilder;
import com.dev.java.designpatterns.inter.decorator.Component;
import com.dev.java.designpatterns.inter.decorator.impl.ConcreteComponent;
import com.dev.java.designpatterns.inter.factorymethod.ExportFactory;
import com.dev.java.designpatterns.inter.factorymethod.ExportFile;
import com.dev.java.designpatterns.inter.factorymethod.impl.ExportPdfFactory;
import com.dev.java.designpatterns.inter.observer.impl.ConcreteObserver;
import com.dev.java.designpatterns.inter.prototype.PrototypeRegister;
import com.dev.java.designpatterns.inter.prototype.PrototypeSimple;
import com.dev.java.designpatterns.inter.prototype.impl.ConcretePrototypeRegister1;
import com.dev.java.designpatterns.inter.prototype.impl.ConcretePrototypeSimple1;
import com.dev.java.designpatterns.inter.proxy.Server;
import com.dev.java.designpatterns.inter.proxy.impl.NginxProxy;
import com.dev.java.designpatterns.inter.proxy.impl.NginxProxyInvocationHandler;
import com.dev.java.designpatterns.inter.proxy.impl.SinaServer;
import com.dev.java.designpatterns.inter.simplefactory.Login;
import com.dev.java.designpatterns.inter.strategy.Strategy;
import com.dev.java.designpatterns.inter.strategy.impl.ConcreteStrategyA;
import com.dev.java.designpatterns.observer.ConcreteSubject;
import com.dev.java.designpatterns.prototype.PrototypeManager;
import com.dev.java.designpatterns.simplefactory.GenerateLogin;
import com.dev.java.designpatterns.simplefactory.LoginFactory;
import com.dev.java.designpatterns.simplefactory.ObjectPathConfig;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 15:42
 * @description: 设计模式测试
 */
public class DesignPatternsTest {

    /**
     * 简单工厂模式测试
     */
    @Test
    public void simpleFactoryTest() {

        String type = "domaincode";

        String username = "micro";
        String password = "123456";

        Login login = LoginFactory.factory(type);

        boolean loginVerify = login.verify(username, password);
        if (loginVerify) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }


        Login login2 = GenerateLogin.generteObject(ObjectPathConfig.PASSWORD_LOGIN_PATH);
        boolean verify = login2.verify("test", "123456");

        System.out.println("登录情况：" + verify);

    }

    /**
     * 工厂方法模式测试
     */
    @Test
    public void factoryMethodTest() {
        /**
         * 工厂方法模式是将对象的实现下沉到子类中去，核心工厂对象中提供公共的方法，该方法的返回对象又是一个抽象的工厂，
         * 提供一个公共的方法，因此可以通过实例化直接子类，进行具体方法的调用
         *
         */
        String data = "";
        //ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFactory exportFactory = new ExportPdfFactory();

        ExportFile exportFile = exportFactory.factory("financial");
        exportFile.export(data);
    }

    /**
     * 抽象工厂模式测试
     */
    @Test
    public void abstractFactoryTest() {

        ComputerEngineer ce = new ComputerEngineer();

        AbstractFactory af = new IntelFactory();

        ce.makeComputer(af);
    }

    /**
     * 建造模式测试
     */
    @Test
    public void builderTest() {

        Builder builder = new ConcreteBuilder();

        Director director = new Director(builder);

        director.construct();

        Product product = builder.retrieveResult();

        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
        System.out.println(product);

    }

    /**
     * 原型模式测试
     */
    @Test
    public void proptotypeTest() {

        PrototypeSimple prototypeSimple = new ConcretePrototypeSimple1();

        Object object = prototypeSimple.clone();

        PrototypeRegister prototype1 = new ConcretePrototypeRegister1();

        PrototypeManager.setPrototype("p1", prototype1);

        PrototypeRegister p2 = PrototypeManager.getPrototype("p1").clone();

        p2.setName("李四");

        System.out.println("第一个实例" + p2.toString());

    }


    /**
     * 适配器模式测试
     */
    @Test
    public void adapterTest() {

        Adapter adapter = new Adapter();
        adapter.sampleOperation1();
        adapter.sampleOperation2();
    }


    /**
     * 观察者模式测试
     */
    @Test
    public void observerTest() {

        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer0 = new ConcreteObserver();
        ConcreteObserver observer1 = new ConcreteObserver();

        observer1.setObserverState("观察者1当前状态");

        System.out.println("主题状态：" + subject.getState());
        System.out.println("观察者0状态：" + observer0.getObserverState());
        System.out.println("观察者1状态：" + observer1.getObserverState());

        /**
         * 注册观察者，只注册观察者0
         */
        subject.attach(observer0);
        subject.attach(observer1);

        subject.changeState("主题状态发生改变");

        System.out.println("观察者0状态：" + observer0.getObserverState());
        System.out.println("观察者1状态：" + observer1.getObserverState());


       /* ConcreteSubject1 subject1 = new ConcreteSubject1();

        ConcreteObserver1 observer1 = new ConcreteObserver1();

        subject1.attach(observer1);

        subject1.changeState("test state");*/

    }

    /**
     * 代理模式测试
     */
    @Test
    public void proxyTest() {
        //#1.静态代理模式
        Server sinaServer = new SinaServer();
        Server nginxServer = new NginxProxy(sinaServer);
        String pageTitle = nginxServer.getPageTitle("");
        System.out.println(pageTitle);

        //#2.动态代理模式
        InvocationHandler handler = new NginxProxyInvocationHandler(sinaServer);
        Server proxy = (Server) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Server.class}, handler);
        System.out.println(proxy.getPageTitle(""));
    }


    /**
     * 策略模式测试
     */
    @Test
    public void strategyTest() {
        Strategy strategy = new ConcreteStrategyA();
        strategy.strategyInterface();
    }


    /**
     * 装饰模式测试
     */
    @Test
    public void decoratorTest() {
        //注意在装饰模式中，装饰的对象为Component，注意不要转变了对象，造成理解的不一致
        Component component = new ConcreteComponent();
        Component decorator = new ConcreteDecorator(component);
        decorator.sampleOperation();
    }
}
