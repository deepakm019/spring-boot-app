package com.etherealyt.springbootapp;

import com.etherealyt.springbootapp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyingQueries extends SpringdataApplicationTests {

    @Test
    void testModifyLevel() {
        int updated = userRepository.updateLevel(5, 4);
        List<User> users = userRepository.findByLevel(4, Sort.by("username"));

        assertAll(
                () -> assertEquals(1, updated),
                () -> assertEquals(3, users.size()),
                () -> assertEquals("katie", users.get(1).getUsername())
        );
    }

    @Test
    void testDeleteByLevel() {
        userRepository.deleteByLevel(2);
        List<User> users = userRepository.findByLevel(2, Sort.by("username"));
        assertEquals(0, users.size());
    }

    @Test
    void testDeleteBulkByLevel() {
        userRepository.deleteBulkByLevel(2);
        List<User> users = userRepository.findByLevel(2, Sort.by("username"));
        assertEquals(0, users.size());
    }
}
