/**
 * 写在类的花括号外面的函数在Jvm编译之后会自动生成一个类然后这些函数就变成了这个类里面的静态方法，这个注解的目的是修改这个生成的类的名字
 */
@file:JvmName("JavaStaticFunctions")

package funTool

import dataBean.AllClass
import dataBean.Person
import dataBean.Person1

/**
 * Created by dell on 2018/2/26.
 * kotlin一些基本的概念应用和与JAVA的不同
 * kotlin的函数可以写在类外面,调用的时候直接用类所在的包名直接调用就可以，和Java的static是一样的
 * 写在类外面的这些函数被称作顶层函数，同时属性也是可以有顶层属性和顶层函数是类似的
 *
 * 在kotlin 中
 */
class KotlinBase {
}

/**
 * 函数
 * 注意if在kotlin中是表达式必须有值
 */
fun main(a: Int, b: Int): Int {

    println("Hello, world!")

    return if (a > b) a else b
}

fun max(a: Int, b: Int): Int = if (a > b) a else b//语句式函数

fun max1(a: Int, b: Int) = if (a > b) a else b//省略返回值类型

/**
 * 字符串模版
 * 在字符串里引用变量相当于 "Hello"+args
 */
fun max2(args: String) {
    println("Hello! $args")
}

fun max2_0(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("Hello,${args[0]}!")
    }
}

/**
 * 在花括号内可以添加复杂的语句
 */
fun max2_1(args: Array<String>) {
    println("Hello,${if (args.isNotEmpty()) args[0] else "wu"}!")
}

/**
 * bean 对象的调用
 */
fun transfer() {

    val persion = Person("A");
}

/**
 * 数据集合需要批量处理的方式
 * 我把when, while, do while, for 放在一起了，作为处理数据常用的语句 表达式
 *
 * is 等同于Java中instance，但是当检查某个对象是什么类型后不用再想java中一样用显示的方法再强转一遍，kotlin支持智能转换
 *
 */
fun collection(condition: Boolean, tag: Int, persion: AllClass) {


    when {//is判断后是一个Boolean值所以两个条件是同一类型的，这是用语句来做分支
        tag is Int -> "用is做判断"
        persion is Person -> "用is做判断"
    }

    /**
     * AllClass是Person和Person1的父类，如果按照JAVA的方式要用instance识别传入的到底是哪个子类然后在进行强转成相应的子类类型才可以使用其中的函数，但是kotlin识别之后就可以直接使用了
     */
    if (persion is Person) {

        println(persion.isPersion)//不用在像instance一样检查完后再强制转换为原本的类型
    } else if (persion is Person1) {

        println(persion.age)//不用在像instance一样检查完后再强制转换为原本的类型
    }

    /**
     * while And do while as same as Java
     */
    while (condition) {

    }

    do {

    } while (condition)


//==============================================
    /**
     * 对数据进行判断，用when 替代 if
     * kotlin 中when 可以识别多种类型的数据
     * when(type){} 这种形式会限定代码块中的比对的数据类型
     * when{} 这种形式在代码块中会自动识别要比对的类型
     * when代码块中只能同时比对一种类型的数据
     */
    when {//没有限定比对类型，会根据代码块中的数据进行自动识别，tag > 10 是Boolean类型的
        tag > 10 -> "bigger than ten"
        tag < 10 -> "smaller than ten"
        else -> "tag equal ten"
    }
//=============================================================
    /**
     * in 在kotlin中是一个比较常用的检查字符
     * 可以检查值是否包含在集合内
     *  !in  来检查集合中不包含某个值
     *
     */
    fun useIn(c: Char) {
        //判断是否是字母
        when (c) {
//            c in 'a' ..'z' || c in 'A'..'Z' -> "是字母"    //条件的类型是布尔值的与参数已经不是同一个类型了所以在这个代码块中不能这样写
            !in 'a'..'z', !in 'A'..'Z' -> "不是字母"  //条件的类型是布尔值的与参数已经不是同一个类型了所以在这个代码块中不能这样写
            in 'a'..'z', in 'A'..'Z' -> "多个条件可以用逗号组合"  //逗号只是把两个条件组合起来写是一种简略写法不改变条件的类型，这两个条件都是Char类型的和参数值是同一类型可以直接这样写
        }
    }
}
//=======================================================
/**
 * kotlin中异常的处理和java是很类似的你完全可以按照以前的习惯来写
 *
 * 区别可能就是在于受检和非受检异常的区分，在kotlin中没有这么明显
 */
fun throwExcepotion() {
    try {

    } catch (e: Exception) {

    } finally {

    }

    throw IllegalArgumentException("抛出异常")
}
//=========================================================================================
