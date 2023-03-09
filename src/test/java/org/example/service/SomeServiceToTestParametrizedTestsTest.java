package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SomeServiceToTestParametrizedTestsTest {

    private SomeServiceToTestParametrizedTests subject;

    @BeforeEach
    void setUp() {
        subject = new SomeServiceToTestParametrizedTests();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertThat(subject.isOdd(number)).isTrue();
    }
}