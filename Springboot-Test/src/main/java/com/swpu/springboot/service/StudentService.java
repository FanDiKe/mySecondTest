package com.swpu.springboot.service;

import com.swpu.springboot.model.Student;


public interface StudentService {
    public abstract Student selectStudentById(Integer id);

    void insertStudentById(Student student);

    void putRedis(String key, String value);

    void GetRedis(String key);
}
