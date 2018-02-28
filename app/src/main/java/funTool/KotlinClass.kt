package funTool

import dataBean.AllClass
import dataBean.ClickAble
import dataBean.interfaceThread

/**
 * Created by dell on 2018/2/28.
 *
 * 列举一些kotlin类的相关内容
 *
 * 继承类只能继承一个，接口可以继承多个
 */
class KotlinClass : AllClass, ClickAble, interfaceThread {

    /**
     * kotlin中可见性有四种，  在省略修饰符的情况下默认是public的
     *
     * 可见性由低到高 ：如下
     *
     * private 本类可见  可顶层声明（本文件可见）
     * protected 子类中可见
     * internal 模块中可见   可顶层声明（模块中可见） ：模块是kotlin 新加的修饰符，模块指一组一起编译的kotlin文件
     * public 均可见   可顶层声明（均可见）
     *
     * 而且和Java一样可见度之间是有层级关系的
     */


    /**
     * 在引入的两个接口中有同名的函数，以一个方法作为引入，然后在方法中，用super<> 的形式进行显示标明你想要使用的是哪个父类的方法，可以都标明或只标明其中的一部分
     */
    override fun mamamiya() {
        super<AllClass>.mamamiya()
        super<ClickAble>.mamamiya()
    }

    override fun click() = println()

}
