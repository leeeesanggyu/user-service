package com.user.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.sql.DriverManager.println

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun save() {
        var user = User()

        userRepository.save(user)

        val users = userRepository.findById(user.id!!)
        Assertions.assertThat(users.get()).isEqualTo(user)
    }
}