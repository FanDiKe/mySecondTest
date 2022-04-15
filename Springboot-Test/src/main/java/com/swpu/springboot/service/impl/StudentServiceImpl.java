package com.swpu.springboot.service.impl;

import com.swpu.springboot.mapper.StudentMapper;
import com.swpu.springboot.model.Student;
import com.swpu.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Student selectStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertStudentById(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void putRedis(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void GetRedis(String key) {
        redisTemplate.opsForValue().get(key);
    }
}
