package com.eden.practice.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationConfigTests {

    @Autowired
    private ApplicationProps applicationProps;

    @Test
    void testLoadingConfiguration() {

        assertThat(applicationProps.getProfiles().get(0)).isEqualTo("dev");
        assertThat(applicationProps.getProfiles().get(4).getClass()).isEqualTo(Integer.class);
        assertThat(applicationProps.getProfiles().size()).isEqualTo(5);
    }

    @Test
    void testLoadingComplexLists() {
        System.out.println("Test");
        assertThat(applicationProps.getUsers().get(0).getPassword()).isEqualTo("admin@10@");
        assertThat(applicationProps.getProps().get(0)).containsEntry("name", "YamlList");
        assertThat(applicationProps.getProps().get(1).get("port").getClass()).isEqualTo(Integer.class);
    }
}
