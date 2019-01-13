package cn.sagreen.groovy

/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-13
 * 联系邮箱   401664157@qq.com
 * 作用描述   Groovy基础之for循环
 */
class ForTests {
    static void main(String[] args) {
        // 范围循环
        def sum = 0
        for (i in 0..3) {
            sum += i
        }
        println sum

        // list循环
        for (i in ['A', 'B', 'C']) {
            println i
        }

        // map循环
        for (i in ['key1': 'value1', 'key2': 1]) {
            println "key:${i.key},value:${i.value}"
        }
    }
}
