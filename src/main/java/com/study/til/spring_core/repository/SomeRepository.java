package com.study.til.spring_core.repository;

import org.springframework.stereotype.Repository;

@Repository
public class SomeRepository {

    public void insert(String foo) {
        System.out.println("insert Foo -> " + foo);
    }
}