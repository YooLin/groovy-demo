package cn.sagreen.groovy

import groovy.transform.ToString

/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-11
 * 联系邮箱   401664157@qq.com
 * 作用描述   Groovy基础之声明对象
 */
@ToString
class User {
    // groovy默认实现getter/setter方法
    String username
    String password

    /**
     * 当调用实例中未声明的方法时，如果实现了invokeMethod方法，将不会抛出异常，而是执行invokeMethod方法，否则抛出groovy.lang.MissingMethodException异常
     * @param name
     * @param args
     * @return
     */
    @Override
    Object invokeMethod(String name, Object args) {
        println "invoke method:${name},args:${args}"
        return null
    }

    /**
     * 同上，此优先级更高
     * @param name
     * @param args
     * @return
     */
    def methodMissing(String name, def args) {
        println "the method:${name},args:${args} is missing"
        return null
    }
}
