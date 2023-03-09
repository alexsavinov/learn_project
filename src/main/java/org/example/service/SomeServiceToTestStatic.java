package org.example.service;

import org.example.util.DateUtil;

import java.time.LocalDateTime;

public class SomeServiceToTestStatic {

    // TODO: you can mock someMethodToTestStatic() using Spy to test this method.
    public LocalDateTime someMethodToTestSpy() {
        return someMethodToTestStatic();
    }

    // TODO: how would you mock static? Try writing a unit test for it.
    public LocalDateTime someMethodToTestStatic() {
        return DateUtil.now();
    }
}
