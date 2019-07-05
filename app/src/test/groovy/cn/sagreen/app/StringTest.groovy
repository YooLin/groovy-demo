package cn.sagreen.app

import org.junit.Test

/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-11
 * 联系邮箱   401664157@qq.com
 * 作用描述   Groovy基础之字符串
 */
class StringTest {
    @Test
    void testString() {
        // 单引号
        def str1 = 'str1'

        // 双引号
        def str2 = "str2 is not equal to ${str1}"

        // 三引号
        def str3 = '''str3 is not equal to
str1 and 
str2
'''
        println str1
        println str2
        println str3

        // 字符串比较
        println str1 < str2

        // 判等
        println str1 == str2

        // 使用索引
        println str1[1]

        // 使用范围
        println str1[1..3]

        // minus 去掉减数字符串中包含的被减数字符串
        println str3 - str1
        println str3.minus(str1)

        // reverse 字符串反转
        println str1.reverse()

        // capitalize 首字母大写
        println str2.capitalize()

        // isNumber 判断是否是数字
        println str1.isNumber()

        // center 字符串居中，被指定的其他字符所填充，如果numberOfChars<=字符串长度，返回原字符串
        def strArr = ['A', 'BB', 'CCC', 'DDDD']
        strArr.each {
            println "|" + it.center(6, "+") + "|"
        }

        // padLeft 距左偏移
        [1, 10, 100, 1000].each { println it.toString().padLeft(5) }

        // padRight 距右偏移
        ['A', 'BB', 'CCC', 'DDDD'].each { println it.padRight(5) + it.size() }
    }
}
