package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeServiceToTestStaticTest {

    // TODO: learn how to use ArgumentCaptor
    @Captor
    private ArgumentCaptor<Object> objectArgumentCaptor;

    private SomeServiceToTestStatic subject;

    @BeforeEach
    void setUp() {
        subject = spy(new SomeServiceToTestStatic());
    }

    @Test
    void someMethodToTestSpy() {
        LocalDateTime expected = LocalDateTime.of(2023, 2, 2, 2, 2);

        when(subject.someMethodToTestStatic()).thenReturn(expected);

        LocalDateTime actual = subject.someMethodToTestSpy();

        verify(subject).someMethodToTestStatic();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void someMethodToTestStatic() {
    }
}