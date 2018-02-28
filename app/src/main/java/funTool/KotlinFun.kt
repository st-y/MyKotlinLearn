package funTool

import dataBean.Person
import dataBean.Person1

/**
 * Created by dell on 2018/2/27.
 */
class KotlinFun {

    /**
     * 实现集合的toString方法
     * 在KotlinBaseActivity中进行调用
     * kotlin 中参数可以带有默认值
     * 在调用的时候，如果是没有标明参数名的可以从后往前省略参数(省略的参数需要有默认值)而且不可以改变顺序，如果是标明参数名字的可以间隔的省略参数，可以改变参数顺序
     */
    fun <T> collectionToString(collection: Collection<T>, separator: String = ",", tag: Int = 10): String {

        val result = StringBuilder();

        for ((index, element) in collection.withIndex()) {
            if (index > 0) {
                result.append(separator)
            }
            result.append(element)
        }

        return result.toString()
    }
}

/**
 * kotlin 很神奇的扩展函数
 * 扩展函数可以给JAVA API 中的类用也可以给自己定义的类使用，可以是kotlin的也可是java的，它是对不方便修改的原有代码的一种扩展方式，便于实现个性需求
 * 扩展函数在使用的时候需要导入import String.insteadOfString
 *
 * 扩展函数会被编译为静态函数，它是不能被重写的，父类和子类有相同名字的扩展函数那么在使用的时候，对象是哪个类型的就调用哪个类型的扩展函数
 *
 * 而且有一个问题，给某对象定义一个扩展函数，例如这个扩展函数的名字就做sum，如果这个对象本身就有(或是后来又新加的)一个叫做sum的普通函数，
 * 那在使用这个对象调用扩展函数的时候会优先调用同名的普通函数，而且如果是在已经有扩展函数并且被使用的情况下新加的同名普通函数则会重新编译代码，
 * 原先使用扩展函数的地方会自动换成新加的同名的普通函数
 */
fun String.insteadOfString(): String {

    return "我在kotlin中为String类扩展添加了一个方法，这个方法的作用就是演示"
}

/**
 * 把上面的collectionToString按照扩展函数的方式模仿kotlin标准函数
 */
fun <T> Collection<T>.collectionToString(separator: String = ",", tag: Int = 10): String {
    val result = StringBuilder();

    for ((index, element) in this.withIndex()) {//这个this就会指向接收者对象其实就是调用这个方法的那个集合对象，所以这个函数没有传入集合对象的参数
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }

    return result.toString()
}

/**
 * 扩展属性
 * 必须定义getter
 * 也可以定义setter来改变属性的值
 */
val String.lastChar: Char get() = get(length - 1)

/**
 * 简单介绍String和正则的方法
 */
fun StringFun() {

    val stringS = "365.21-759.23:好多钱"
    /**
     * kotlin 的 String.split函数增加了很多扩展函数，
     * 可以处理“.”为间隔的分离
     * 也可以处理正则表达式，但是正则表达式要转为Regex类型
     */
    stringS.split("\\.|-".toRegex()) //kotlin给Java的split增添了一些扩展函数，例如这个在处理正则表达式和Java是类似的，但是需要转换成Regex类型
    stringS.split(".", "-", ":")//可以制定多个分隔符

    /**
     * 三重引号
     * 可以避免转义
     * 可以使用换行符等字符
     */
    //   "\\." 和 """\.""" 是一样的，就是在一个三重的引号中不用做转义
    val simpleStr = """|9
        .|7
        .|7
        .|7
        |7
    """.trimMargin()//trimMargin删除每行的前缀和前面的空格 “.”是前缀

    /**
     * kotlin新添了一种局部函数的概念
     * 解决在函数中出现大量重复代码的问题
     *
     * 和可以和扩展函数结合使用，这样既可以丰富这个类的方法，也避免在这个类中添加过多的函数减少代码冗余
     */
    fun saveUser(person: Person1) {
        fun verfyData(tag: String) {//好神奇的局部函数,由此可见kotlin的创造者对Java是有多少感触啊
            if (tag.isEmpty()) {
            }
        }
        verfyData(person.name)
        verfyData(person.sex)
    }







}