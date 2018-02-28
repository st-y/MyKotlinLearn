package com.example.dell.myapplication

import funTool.KotlinFun
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import funTool.insteadOfString
import funTool.collectionToString

class KotlinBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        implementCollectionToString()
        implementStaticFun()
    }

}

/**
 * kotlin采用了JAVA的集合类，所以大家会比较熟悉，并且kotlin增加了一些新的方法
 */
fun collectionDefinition() {

    /**
     * arrayList ,hashSetOf , hasMapOf
     */
    val list = arrayListOf<String>()
    val list1 = arrayListOf(1, 2, 3)

}

/**
 * 调用函数的方法
 */
fun implementCollectionToString() {
    val kf = KotlinFun()//声明一个类
    val collection = arrayListOf<String>("试试", "不行么", "行")
    val resultString = kf.collectionToString(collection, separator = "-", tag = 10)//调用声明类中的函数,抵用的时候可以显示的标明参数的名称，但是当一个标明后其后的参数必须都标明
    val resultString0 = kf.collectionToString(collection, "-", 10)
    val resultString1 = kf.collectionToString(collection, tag = 10, separator = "-")//标明参数名字可以改变顺序
    val resultString2 = kf.collectionToString(collection, "-")//参数有默认值的时候可以进行省略
    val resultString3 = kf.collectionToString(collection, tag = 10)//标明参数名字可以间隔省略

    val resultString4 = collection.collectionToString("-", 30)//调用集合的扩展函数

    println(resultString)
    println(resultString0)
    println(resultString1)
    println(resultString2)
    println(resultString3)
    println(resultString4)
}

/**
 * 调用写在类的花括号外面的函数
 */
fun implementStaticFun() {

    funTool.max(0, 0)//调用在类外的函数直接用包名（类所在的包）直接调用就可以，和java的static是一样的而且jvm编译之后时就是等同于Java的static
}

/**
 * 调用扩展函数
 */
fun useExpandFunction() {
    val cc = "哈哈哈，卡他输出啥".insteadOfString()
    println(cc)
}




















