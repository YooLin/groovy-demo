package cn.sagreen.groovy
/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-11
 * 联系邮箱   401664157@qq.com
 * 作用描述   Groovy基础之闭包
 */
class ClosureTest {
    static void main(String[] args) {
        /**
         * 闭包：一段代码块，可以命名可以被调用，使用和方法类似，总是有返回值，如果没有显式声明则由闭包中的最后一行代码决定
         */

        // 有参的闭包声明
        def closure1 = {
            param -> println "closure1 with param : " + param
        }
        // 使用隐式参数it
        def closure2 = {
            println "closure1 with param : ${it}"
        }

        method1(closure1)
        method1(closure2)

        // 无参的闭包声明
        method2 {
            println "closure2 without param"
        }
        // -> 可省略
        method2 {
            -> println "closure2 without param"
        }

        // 与基本类型的结合使用

        // 求指定number的阶乘
        // 求5的阶乘 1*2*3*4*5 = 120
        int res = fab(5)
        println res

        //求5的阶乘 1*2*3*4*5 = 120
//        int res = fab2(5)
//        println res//注意，最后一个参数是闭包的话，方法的圆括号可以省略int fab2(int number){    int result = 1
//        number.downto(1) { num -> result *= num }
//        return result
    }

    static fab3(int number) {
        int result = 0

        //圆括号省略，直接跟一个闭包
        number.times { num -> result += num
        }
        return result
    }

    static int fab(int number) {
        int result = 1
        1.upto(number, { num -> result *= num })
        return result
    }

    static void method1(Closure<String> closure) {
        // 闭包的调用
        // 方式一
        closure.call('123456')
    }

    static void method2(Closure closure) {
        // 方式二
        closure()
    }

}
