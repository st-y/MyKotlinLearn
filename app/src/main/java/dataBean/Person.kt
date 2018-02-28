package dataBean

/**
 * Created by dell on 2018/2/25
 *
 * Kotlin javaBean类使用 值对象 方式.
 */
class Person(val name: String) : AllClass {

    /**
     * kotlin 会自动为变量分配访问器
     * 也可以自己定义访问器
     */
    val isPersion: Boolean
        get() {
            return isPersion
        }
}

/**
 * kotlin可以把多个类放在一个文件中
 */
class Person0(val name: String) {

    /**
     * kotlin 会自动为变量分配访问器
     * 也可以自己定义访问器
     */
    val isPersion: Boolean
        get() {
            return isPersion
        }
}
