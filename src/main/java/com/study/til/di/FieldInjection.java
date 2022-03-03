package com.study.til.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldInjection {

    @Autowired
    private SomeRepository repository; // Field Injection

    public void save(String foo) {
        repository.insert(foo);
    }
}
