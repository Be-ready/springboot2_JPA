package com.example.springboo2_jpa.controller;

// 多表的多对多查询（作者-书籍）

import com.example.springboo2_jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Multi2MultiController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getlikebookname/{bookname}")
    public List<Object> getLikeBookName(@PathVariable("bookname") String bookname){

        return bookRepository.getLikeBookName("%"+bookname+"%");
    }

    @GetMapping("/getlikeauthor/{author}")
    public List<Object> getLikeAuthor(@PathVariable("author") String author){

        return bookRepository.getLikeAuthor(author);
    }
}
