package cn.sagreen.app

import cn.sagreen.repository.UserRepository

/**
 * @author linyicong* @since 2019-07-06
 */
class Application {
    private static final def userRepository = new UserRepository()

    static void main(String[] args) {
        println userRepository.getByUserName('test')
    }
}
