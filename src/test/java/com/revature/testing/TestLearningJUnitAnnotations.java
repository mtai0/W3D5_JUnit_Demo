package com.revature.testing;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLearningJUnitAnnotations {

    @Test
    @DisplayName("First Test")
    @Order(1)
    public void firstTestCase() {
        System.out.println("First test case implemented here...");
    }

    @Test
    @DisplayName("Second Test")
    @Order(2)
    public void secondTestCase() {
        System.out.println("Second test case implemented here...");
    }


    //used to set up and initialize things before tests
    @BeforeEach
    public void testBeforeEach() {
        System.out.println("BeforeEach: This executes before each test method.");
    }

    //used to clean up objects and values after tests
    @AfterEach
    public void testAfterEach() {
        System.out.println("AfterEach: This executes after each test method.");
    }

    @BeforeAll
    public static void testBeforeAll() {
        System.out.println("BeforeAll: Executes before all methods only once.");
    }

    @AfterAll
    public static void testAfterAll() {
        System.out.println("AfterAll: Executes after all methods only once.");
    }
}
