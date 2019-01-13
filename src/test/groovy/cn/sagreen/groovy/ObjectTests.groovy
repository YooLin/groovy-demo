package cn.sagreen.groovy

/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-11
 * 联系邮箱   401664157@qq.com
 * 作用描述   Groovy基础之对象
 */
class ObjectTests {

    static void main(String[] args) {
        // 类的实例化
        def user1 = new User(
                username: 'admin',
                password: '123456'
        )
        println user1

        def user2 = new User(
                username: 'unkown'
        )
        println user2

        /**
         * Groovy元编程：
         * 代码在执行过程中运行的时期，调用类的一个方法如下
         * 1.类中是否有此方法，有则调用
         * 2.如果没有，从MetaClass中查找是否有此方法，有则调用MetaClass中的方法
         * 3.如果没有，查询类中是否重写了methodMissing方法，有则调用
         * 4.如果没有，查询类中是否重写了invokeMethod方法，有则调用
         * 5.如果没有，抛出MissingMethodException异常
         */
        user2.test()

        /**
         * Groovy MetaClass：可以在运行时为类动态添加属性
         */

        // 为类动态添加一个sex属性
        User.metaClass.sex = '男'

        // 为类动态添加一个login方法
        User.metaClass.login = {
            username, password -> return username == 'test' && password == 'test'
        }

        // 为类动态添加一个静态方法
        User.metaClass.static.build = {
            username, password -> new User(username: username, password: password)
        }

        def user3 = new User(
                username: 'test',
                password: 'test'
        )
        println user3.sex

        println user3.login(user3.username, user3.password) ? 'login success' : 'login failed'

        println User.build('test1','test1')
    }
}
