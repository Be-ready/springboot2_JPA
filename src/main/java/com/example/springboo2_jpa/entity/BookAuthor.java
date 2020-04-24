package com.example.springboo2_jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

// 复合主键由多个主键字段组成（主键类）
@Entity
@IdClass(BookAuthorPK.class) // @IdClass注解:指定一个联合主键类来映射实体类的多个属性
public class BookAuthor {

    @Id
    private Integer bookId;
    @Id
    private String authorId;

    // 当主键类有默认无参构造函数时，ID类就不必有了
//    public BookAuthor() {
//    }
//
//    public BookAuthor(Integer bookId, String authorId) {
//        this.bookId = bookId;
//        this.authorId = authorId;
//    }


    @Override
    public String toString() {
        return "BookAuthor{" +
                "bookId=" + bookId +
                ", authorId='" + authorId + '\'' +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
