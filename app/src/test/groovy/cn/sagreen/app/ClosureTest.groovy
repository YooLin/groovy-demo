package cn.sagreen.app

import org.junit.Test

/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-11
 * 联系邮箱   401664157@qq.com
 * 作用描述   Groovy基础之闭包
 */
class ClosureTest {
    /**
     * 闭包：一段代码块，可以命名可以被调用，使用和方法类似，总是有返回值，如果没有显式声明则由闭包中的最后一行代码决定
     */
    @Test
    void testClosure() {
        // 有参的闭包声明
        def closure1 = {
            param -> println "closure1 with param : ${param}"
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
        println fab(5)

        // 与String的结合使用
        String str = 'hello world'
        str.each {
            println it
        }

        // 返回值为集合
        String str1 = 'tom has 63 books and 3 apples'
        println str1.findAll {
            it.isNumber()
        }

        // 只要有一项满足就返回
        println str1.any {
            it.isNumber()
        }

        // every()方法是只要有一项不满足就返回
        println str1.every {
            it.isNumber()
        }

        println str1.collect {
            it.toUpperCase()
        }

        // 闭包的关键字
        // this:代表闭包定义处的类
        // owner:代表闭包定义处的类或者对象
        // delegate:代表任意对象，但是默认是和owner是一样的

        def stu = new Student(name: 'tom')
        def tea = new Teacher(name: 'Mrs Li')
        //1 没有改变委托策略的情况下
        println stu.toString()
        //2 改变闭包的委托策略
        stu.showMe.delegate = tea
        stu.showMe.resolveStrategy = Closure.DELEGATE_FIRST //把委托策略改成先从delegate中找name
        println stu.toString()
    }

    static class Student {
        String name

        //定义一个闭包
        def showMe = {
            return "my name is $name"
        }

        @Override
        String toString() {
            return showMe()
        }
    }

    static class Teacher {
        String name
    }

    /**
     * upto 方法 从1->number执行closure闭包中的逻辑
     * @param number
     * @return
     */
    static int fab(int number) {
        int result = 1
        1.upto(number, { num -> result *= num })
        // 等同于 number.downto(1){ num -> result *= num}
        // number.times { num -> result *= num }
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
