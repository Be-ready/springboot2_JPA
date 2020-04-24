package com.example.springboo2_jpa.repository;

import com.example.springboo2_jpa.entity.User;
import com.example.springboo2_jpa.entity.result.ViewInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    // 原生SQL语句
    @Query(nativeQuery = true,value = "select a.*, b.uid, b.money from user_jpa a,account_jpa b where a.id=b.uid ") //原生SQL方法
    List<Object> getAll();

    // 默认的JPQL方法
    @Query(value = "select a.id,a.address,a.boss,a.sex,a.username, b.uid, b.money from User a,Account b where a.id=b.uid ") //原生SQL方法
    List<Object> getAll2();

    // 使用Model(将结果存入类中，model类中必须要有getter,setter,无参构造器，不然报错)
    // 实体类中好像不用无参构造器...
    @Query(value = "select new com.example.springboo2_jpa.entity.result.ViewInfo(a, b) from User a,Account b where a.id=b.uid ") //原生SQL方法
    List<Object> getAll3();

    // 无法实现只取某一用户的所有账户信息（无法在sql语句中传入id）
//    @Query(nativeQuery = true, value = "select a.*, b.uid, b.money from user_jpa a,account_jpa b where a.id=b.uid and a.id=#{id} ")
//    User getById(Integer id);
}
