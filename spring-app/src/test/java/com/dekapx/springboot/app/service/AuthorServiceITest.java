package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.dto.AuthorDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthorServiceITest {
    @Autowired
    private AuthorService authorService;

    @Test
    public void shouldReturnAllAuthors() {
        List<AuthorDto> authors = authorService.findAll();
        assertThat(authors)
                .isNotNull()
                .isNotEmpty()
                .hasAtLeastOneElementOfType(AuthorDto.class);
    }
}
