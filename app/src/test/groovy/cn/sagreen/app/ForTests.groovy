package cn.sagreen.app

import org.junit.Test

/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-13
 * 联系邮箱   401664157@qq.com
 * 作用描述   Groovy基础之for循环
 */
class ForTests {
    @Test
    void testEach() {
        // 范围循环
        def sum = 0
        for (it in 0..3) {
            sum += it
        }
        println sum

        // list循环
        for (it in ['A', 'B', 'C']) {
            println it
        }

        // map循环
        for (it in ['key1': 'value1', 'key2': 1]) {
            println "key = ${it.key}, value = ${it.value}"
        }
    }
}
