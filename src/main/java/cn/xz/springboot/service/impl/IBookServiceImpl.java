package cn.xz.springboot.service.impl;

import cn.xz.springboot.mapper.BookMapper;
import cn.xz.springboot.pojo.Book;
import cn.xz.springboot.service.IBookService;
import cn.xz.springboot.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.IOException;
import java.util.List;


@Service
public class IBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Override
    public Result getAll() {
        List<Book> books = list();
        return Result.ok(books);
    }

    @Override
    @Transactional
    public Result updateBook(Book book) {
        boolean success = updateById(book);
        if(!success){
            return Result.fail("修改失败,自动刷新！");
        }
        return Result.ok();
    }

    @Override
    @Transactional
    public Result saveBookInfo(Book book) {
        boolean save = saveOrUpdate(book);
        if(!save){
            return Result.fail("添加失败,自动刷新！");
        }
        return Result.ok();
    }

    @Override
    public Result getOneBook(Integer id) {
        Book book = getById(id);

        if(book==null){
            return Result.fail("查询图书不存在或数据同步失败,自动刷新！");
        }
        return Result.ok(book);
    }

    @Override
    @Transactional
    public Result remove(Integer id) {
        boolean b = removeById(id);
        System.out.println("b信息："+b);
        if(!b){
            return Result.fail("删除图书失败,自动刷新！");
        }
        return Result.ok();
    }

    @Override
    public Result selectByPage(Integer currentPage, Integer pageSize,Book book) {

        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(book.getBookType()),Book::getBookType,book.getBookType());
        queryWrapper.like(StringUtils.isNotBlank(book.getBookName()),Book::getBookName,book.getBookName());
        queryWrapper.like(StringUtils.isNotBlank(book.getDescription()),Book::getDescription,book.getDescription());
        System.out.println("book="+book);

        Page<Book> pages = new Page<>(currentPage,pageSize);
        page(pages, queryWrapper);
        if(currentPage > pages.getPages()){
            pages=new Page<>(pages.getPages(),pageSize);
            page(pages, queryWrapper);
        }
        return Result.ok(pages);
    }
}
