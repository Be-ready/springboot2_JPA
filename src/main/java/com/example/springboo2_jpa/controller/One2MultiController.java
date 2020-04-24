package com.example.springboo2_jpa.controller;

import com.example.springboo2_jpa.entity.User;
import com.example.springboo2_jpa.entity.result.ViewInfo;
import com.example.springboo2_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 多表查询（一对多，user表->account表）

@RestController
public class One2MultiController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/multi/getall")
    public List<Object> getAll(){

        return userRepository.getAll();
    }

    @GetMapping("/multi/getall2")
    public List<Object> getAll2(){  // 最终的结果是两个表的数据，不可以指定类型为User

        return userRepository.getAll2();
    }

    @GetMapping("/multi/getall3")
    public List<Object> getAll3(){  // 最终的结果是两个表的数据，不可以指定类型为User

        return userRepository.getAll3();
    }

    // 无法实现（）
//    @GetMapping("/multi/getById/{id}")
//    public Map<String,Object> getById(@PathVariable("id") Integer id){
//        Map<String, Object> map = new HashMap<>();
//        if(userRepository.existsById(id)){
//            map.put("查询结果：", userRepository.getById(id));
//            return map;
//        }else {
//            map.put("查询结果：", "数据库中没有id为"+id+"的记录");
//            return map;
//        }
//
//    }
}
