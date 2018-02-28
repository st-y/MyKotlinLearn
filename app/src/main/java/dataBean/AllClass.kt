package dataBean

/**
 * Created by dell on 2018/2/27.
 */
interface AllClass {

    fun mamamiya() = println("AllClass _ mamamiya")
}

interface ClickAble {

    fun click()
    fun mamamiya() = println("ClickAble _ mamamiya")
}

interface interfaceThread {

    fun click()
    fun mamamiya()
}