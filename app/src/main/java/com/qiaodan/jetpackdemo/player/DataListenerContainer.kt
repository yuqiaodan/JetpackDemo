package com.qiaodan.jetpackdemo.player

/**
 * author: created by yuqiaodan on 2022/12/23 17:14
 * description:
 *
 * 数据容器 对数据进行监听
 *
 *
 */
class DataListenerContainer<T> {

    private val blocks = arrayListOf<(T?) -> Unit>()

    var value: T? = null
        set(v: T?) {
            //给value赋值 这里调用关键字field
            field = v
            blocks.forEach {
                it.invoke(v)
            }
        }
        //取value值  由于set只是取值 没有任何实现 可忽略
        get() = field


    fun addListener(block: (T?) -> Unit) {
        if (!blocks.contains(block)) {
            blocks.add(block)
        }
    }


}