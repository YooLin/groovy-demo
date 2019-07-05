package cn.sagreen.app

import org.junit.Test

/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-15
 * 联系邮箱   401664157@qq.com
 * 作用描述   金鹰推单算法优化
 */
class JinYingTest {
    @Test
    void testJinYing() {
        def maxAmount = 8000
        def minAmount = 5000
        def actualAmount = 0

        def randomSeed = System.currentTimeMillis()
        def random = new Random(randomSeed)
        def randomAmount = random.nextDouble() * 500
        def limitAmount = maxAmount - randomAmount
        println "limitAmount(${limitAmount}) = maxAmount(${maxAmount} - randomAmount(${randomAmount}))"

        def orders = random.doubles(50).toArray().toList()
        orders << 100D

        def times = 0
        while (actualAmount < minAmount) {
            def total = 0
            for (def order : orders) {
                if (actualAmount > limitAmount) {
                    break
                }
                if (actualAmount + order * 150 < maxAmount) {
                    if (push(order)) {
                        total += order * 150
                        actualAmount += order * 150
                    }
                }
            }
            times++
            println "times:${times},total:${total}"
        }
        println "push orders done acutalTotalAmount is ${actualAmount}"
    }

    static boolean push(def order) {
        println "push order(${order * 150}) to jingying"
        return true
    }
}
