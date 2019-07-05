package cn.sagreen.app

import org.junit.Test

/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-11
 * 联系邮箱   401664157@qq.com
 * 作用描述   Groovy基础之集合
 */
class CollectionTest {
    @Test
    void testCollection() {
        // 定义数组
        def array = [1, 2, 3, 4, 5, 6] as int[]
        int[] arrayInt = [1, 2, 3, 4, 5, 6]

        println array
        println arrayInt

        // 定义范围
        def range = 0..10
        // 范围的开始值
        println range.to
        // 范围的终止值
        println range.from
        println range[1]
        println range.contains(7)

        // 定义list
        def listNumber = [-7, 5, -3, 9, 4, 0]

        // find 根据闭包中的条件，查询第一个符合条件的集合元素
        def findResult = listNumber.find {
            it -> it % 2 == 0
        }
        println findResult

        // findAll 根据闭包中的条件，查询所有符合条件的集合元素
        def findAllResult = listNumber.findAll {
            it -> it > 0
        }
        println findAllResult

        // count 根据闭包中的条件，查询符合条件的元素数量
        println listNumber.count {
            it -> it % 2 == 0
        }

        // sort 根据闭包中的条件，对集合进行排序
        listNumber.sort {
            a, b -> a == b ? 0 : Math.abs(a) - Math.abs(b)
        }
        println listNumber


        def list = []
        list << "maven"
        println list[0]
        list[1] = "unkown"
        println list.last()
        println list.getClass()

        def map = [tom: '上海', ella: '北京']
        map.jack = '深圳'
        println map.jack
        map.complex = [a: 1, b: 2] as Map<String, Integer>
        println map['complex']
        println map.getClass()

        // map遍历
        map.each {
            it -> println "key:${it.key},value:${it.value}"
        }
        map.eachWithIndex {
            it, index -> println "index:${index},key:${it.key},value:${it.value}"
        }
        map.each {
            key, value -> println "key:${key},value:${value}"
        }

        // mao 查询
        println map.find {
            it -> it.key.size() > 3
        }
        println map.findAll {
            it -> it.key.size() > 3
        }
        println map.count {
            it -> it.key.size() > 3
        }

        println map.findAll {
            it -> it.key.size() > 3
        }.collect {
            it.value
        }
    }
}
