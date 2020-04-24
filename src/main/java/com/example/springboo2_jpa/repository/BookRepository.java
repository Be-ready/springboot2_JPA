package com.example.springboo2_jpa.repository;

import com.example.springboo2_jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // 查询书籍id,书籍名称,书籍作者(同名书籍的不同作者放一行，按分号;隔开)
    // 在原生sql语句中加 ?1 可以用参数赋值
    // 还是在于sql的熟练程度
    @Query(nativeQuery = true,
            value = "select b.id, b.bookname , GROUP_CONCAT(a.authorname SEPARATOR';') as authorName from book b, author a, book_author ba where b.id = ba.book_id and a.id=ba.author_id and b.bookname like ?1 group by b.id, b.bookname ")
    List<Object> getLikeBookName(String bookname);

    // 查询作者id,作者姓名,作者著作(多篇著作按分号;分割)
    @Query(nativeQuery = true,
            value = "select a.id, a.authorname, GROUP_CONCAT(b.bookname SEPARATOR ';') from book b, author a, book_author ba where b.id = ba.book_id and a.id=ba.author_id and a.authorname='鲁迅' group by a.id, a.authorname ")
    List<Object> getLikeAuthor(String author);

}
