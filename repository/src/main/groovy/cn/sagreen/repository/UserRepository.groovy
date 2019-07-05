package cn.sagreen.repository

import cn.sagreen.model.User

/**
 * @author linyicong* @since 2019-07-06
 */
class UserRepository {
    private Map<String, User> userRepository

    User getByUserName(String username) {
        return userRepository.get(username)
    }
}
