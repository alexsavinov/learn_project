package org.example.service;

import org.example.util.DateUtil;

import java.time.LocalDateTime;

public class SomeServiceToTestStatic {

    // TODO: how would you mock static? Try writing a unit test for it
    public LocalDateTime someMethodToTestStatic(Long id) {
        return DateUtil.now();
    }
}
