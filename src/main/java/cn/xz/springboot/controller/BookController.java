package cn.xz.springboot.controller;

import cn.xz.springboot.pojo.Book;
import cn.xz.springboot.service.impl.IBookServiceImpl;
import cn.xz.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookServiceImpl bookService;

    @GetMapping
    public Result getAllBooks(){
        return bookService.getAll();
    }

    @PutMapping
    public Result updateBooks(@RequestBody Book book){
        return bookService.updateBook(book);

    }


    @PostMapping
    public Result addBook(@RequestBody Book book){
        return bookService.saveBookInfo(book);
    }

    @GetMapping("/{id}")
    public Result getOneById(@PathVariable Integer id){
        return bookService.getOneBook(id);
    }

    @DeleteMapping("/{id}")
    public Result deleteBook(@PathVariable Integer id){
        return bookService.remove(id);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result getBookByPage(@PathVariable(value = "currentPage") Integer currentPage,
                                @PathVariable("pageSize") Integer pageSize,Book book){

        return bookService.selectByPage(currentPage,pageSize,book);
    }
}
