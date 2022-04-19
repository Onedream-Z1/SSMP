package cn.xz.springboot.service;

import cn.xz.springboot.pojo.Book;
import cn.xz.springboot.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IBookService extends IService<Book> {

    Result getAll();

    Result updateBook(Book book);

    Result saveBookInfo(Book book);

    Result getOneBook(Integer id);

    Result remove(Integer id);

    Result selectByPage(Integer currentPage, Integer pageSize,Book book);
}
