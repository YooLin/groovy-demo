package cn.sagreen.groovy

/**
 * 开发人员   YooLin1c
 * 编写日期   2019-01-13
 * 联系邮箱   401664157@qq.com
 * 作用描述   Groovy基础之switch case
 */
class SwitchTests {
    static void main(String[] args) {
        def x = 3.14
        def result
        // switch case 可以是任意类型或数据
        switch (x) {
            case 'test':
                result = 'test'
                break
        // 列表
            case [4, 5, 6, 'test']:
                result = 'list'
                break
        // 范围
            case 3..11:
                result = 'range'
                break
        // 类型
            case Integer:
                result = 'Integer'
                break
            case BigDecimal:
                result = 'BigDecimal'
                break
            default:
                result = 'default'
                break
        }
        println result
    }
}
