package com.mickszhu.demo.controller;

import com.mickszhu.demo.dto.Book;
import com.mickszhu.demo.interceptor.PassToken;
import com.mickszhu.demo.interceptor.UserLoginToken;
import com.mickszhu.demo.service.BookService;

import com.mickszhu.demo.utiles.DateTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(value = "/Books",tags = "图书管理接口")
@RestController
@RequestMapping("/Books")
@Slf4j
public class BookController {
    @Autowired
    private BookService bookService;

    @ApiOperation("新增图书")
    @PostMapping
    @UserLoginToken
    public Boolean addBook(@RequestBody Book request) {
        request.setPub_date(DateTools.getDate());
        return bookService.addBook(request);
    }

    @ApiOperation("删除图书")
    @DeleteMapping
    @UserLoginToken
    @ApiImplicitParam(name = "bookId",value = "图书Id",defaultValue = "0")
    public boolean  boolDelete(@PathVariable("bookId") long bookId){
       return  bookService.deleteBook(bookId);
    }

    @ApiOperation("修改图书")
    @PutMapping
    @UserLoginToken
    public boolean bookEditDo(@RequestBody Book book) {
        book.setPub_date(DateTools.getDate());
        return bookService.editBook(book);

    }

    @ApiOperation("查询图书")
    @GetMapping("/{searchWord}")
    @PassToken
    @ApiImplicitParam(name = "searchWord",value = "关键字",defaultValue = "三生")
    public ArrayList<Book> queryBookDo(@PathVariable("searchWord") String searchWord) {
        log.info("查询图书的关键字："+searchWord);
        if (bookService.matchBook(searchWord)) {
            return bookService.queryBook(searchWord);
        } else {
            return new ArrayList<>();
        }
    }


}
