package org.example.service;

import org.example.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

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
        LocalDateTime expected = LocalDateTime.of(2023, 2, 2, 2, 2);

        try (MockedStatic<DateUtil> dateUtil = mockStatic(DateUtil.class)) {
            dateUtil.when(DateUtil::now).thenReturn(expected);

            LocalDateTime actual = subject.someMethodToTestStatic();

            verify(subject).someMethodToTestStatic();
            verifyNoMoreInteractions(subject);

            assertThat(actual).isEqualTo(expected);
        }
    }
}