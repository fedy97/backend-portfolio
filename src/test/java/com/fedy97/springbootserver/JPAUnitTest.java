package com.fedy97.springbootserver;

import com.fedy97.springbootserver.models.Personal;
import com.fedy97.springbootserver.repositories.PersonalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

// more tests here https://github.com/bezkoder/spring-boot-datajpatest/blob/master/src/test/java/com/bezkoder/spring/data/jpa/test/JPAUnitTest.java
// every time the tests run, we build the db and than drop cascade it.
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE) // this will use db prod. if commented we use h2.
@DataJpaTest
class JPAUnitTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    PersonalRepository personalRepository;

    @Test
    void should_find_no_personal_if_repository_is_empty() {
        Iterable<Personal> personal = personalRepository.findAll();
        assertThat(personal).isEmpty();
    }

    @Test
    void should_store_personal_info() {
        Personal personal = new Personal();
        personal.setFirstName("Federico");
        personal = personalRepository.save(personal);
        assertThat(personal).hasFieldOrPropertyWithValue("firstName", "Federico");
    }

  // @Test
  // void should_find_all_users() {
  //     User user1 = new User("frc.morreale@gmail.com", "String password", "String name", "String surname", "1997-10-06", false);
  //     entityManager.persist(user1);

  //     User user2 = new User("frc.morreale2@gmail.com", "String password", "String name", "String surname", "1997-10-06", false);
  //     entityManager.persist(user2);

  //     User user3 = new User("frc.morreale3@gmail.com", "String password", "String name", "String surname", "1997-10-06", false);
  //     entityManager.persist(user3);

  //     Iterable<User> users = repository.findAll();

  //     assertThat(users).hasSize(3).contains(user1, user2, user3);
  // }
}

