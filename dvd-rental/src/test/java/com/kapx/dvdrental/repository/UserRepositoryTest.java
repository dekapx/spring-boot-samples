package com.kapx.dvdrental.repository;

import com.kapx.dvdrental.domain.User;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() throws Exception {
        // Arrange
        User user = new User();
        user.setUsername("dummyuser");
        user.setFirstName("Dummy");
        user.setLastName("User");
        user.setEmail("dummy.user@dvd-rental.com");
        user.setActive(true);
        user.setCreateDate(new Date());

        // Act
        user = userRepository.save(user);

        // Assert
        assertThat(user.getId(), is(notNullValue()));
    }

    @Test
    public void find() throws Exception {
        final Optional<User> userOptional = userRepository.findByUsername("dummyuser");
        final User user = userOptional.get();
        assertThat(user.getId(), is(notNullValue()));
        assertThat(user.getUsername(), is(equalTo("dummyuser")));
        assertThat(user.getFirstName(), is(equalTo("Dummy")));
        assertThat(user.getLastName(), is(equalTo("User")));
        assertThat(user.getEmail(), is(equalTo("dummy.user@dvd-rental.com")));
    }

    @Test
    public void remove() throws Exception {
        final Optional<User> userOptional = userRepository.findByUsername("dummyuser");
        final User user = userOptional.get();
        userRepository.delete(user);
        assertThat(userRepository.findOne(user.getId()), is(nullValue()));
    }
}
