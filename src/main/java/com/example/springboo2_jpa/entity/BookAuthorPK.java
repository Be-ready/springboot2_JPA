package com.example.springboo2_jpa.entity;

import java.io.Serializable;

// ID类
// 当一个实体(BookAuthor)有多个主键字段时，JPA需要定义一个特殊的ID类，
// 该类是使用@idclass注释附加到实体类的。必须（implements Serializable）
// 存储bookId和authorId的对应关系（非实体类，不用@Entity）
public class BookAuthorPK implements Serializable {

    private Integer bookId;
    private Integer authorId;

    // 当主键类有无参构造函数时，ID类不必再有
    public BookAuthorPK() {
    }

    // 有参构造函数可以不要
//    public BookAuthorPK(Integer bookId, Integer authorId) {
//        this.bookId = bookId;
//        this.authorId = authorId;
//    }

    // 不需要getter和setter方法
//    public Integer getBookId() {
//        return bookId;
//    }
//
//    public void setBookId(Integer bookId) {
//        this.bookId = bookId;
//    }
//
//    public Integer getAuthorId() {
//        return authorId;
//    }
//
//    public void setAuthorId(Integer authorId) {
//        this.authorId = authorId;
//    }
}
