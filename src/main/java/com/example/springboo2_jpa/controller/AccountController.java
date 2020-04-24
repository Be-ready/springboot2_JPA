package com.example.springboo2_jpa.controller;

import com.example.springboo2_jpa.entity.Account;
import com.example.springboo2_jpa.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 单表(Account表)crud

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/getall")
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    @GetMapping("/insert")
    public Map<String,Object> insert(Account account){

        Map<String,Object> map = new HashMap<>();
        map.put("插入前:", accountRepository.findAll());
        account.setMoney(91420);
        account.setUid(2);
        accountRepository.save(account);
        map.put("插入后：",accountRepository.findAll());
        return map;
    }

    @GetMapping("/delete/{id}")
    public Map<String,Object> deleteById(@PathVariable("id") Integer id){

        Map<String,Object> map = new HashMap<>();

        if(accountRepository.existsById(id)){
            map.put("删除前：",accountRepository.findAll());
            accountRepository.deleteById(id);
        }
        map.put("删除后：",accountRepository.findAll());

        return map;
    }

    @GetMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable("id") Integer id){

        Map<String, Object> map = new HashMap<>();
        if(accountRepository.existsById(id)){
            map.put("更新前：",accountRepository.findById(id).get());
            Account account = accountRepository.findById(id).get();
            account.setUid(7);
            account.setMoney(22222);
            accountRepository.save(account);
        }
        map.put("更新后：",accountRepository.findById(id).get());
        return map;
    }

    @GetMapping("/getById/{id}")
    public Map<String, Object> getById(@PathVariable("id") Integer id){

        Map<String, Object> map = new HashMap<>();
        if(accountRepository.existsById(id)){
            map.put("查询结果：", accountRepository.findById(id).get());
            return map;
        }else {
            map.put("查询结果：", "数据库中没有id为"+id+"的记录");
        }
        return map;
    }
    @GetMapping("/getbyid/{id}")
    public Account getbyid(@PathVariable("id") Integer id){
//        return accountRepository.getOne(id);  // 使用之后报错
        return accountRepository.findById(id).get();
    }
}
