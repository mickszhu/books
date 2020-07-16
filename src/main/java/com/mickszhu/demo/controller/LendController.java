//package com.mickszhu.demo.controller;
//
//import com.mickszhu.demo.dto.Lend;
//import com.mickszhu.demo.service.BookService;
//import com.mickszhu.demo.service.LendService;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//@RestController
//@RequestMapping("/Lend")
//@Api(value = "/Lend",tags = "借书记录登记")
//public class LendController {
//    @Autowired
//    private LendService lendService;
//
//    @Autowired
//    private BookService bookService;
//
//    @DeleteMapping
//    public Boolean deleteBook(@PathVariable("bookId") long bookId) {
//
//        return bookService.deleteBook(bookId);
//    }
//
//    @GetMapping
//    public ArrayList<Lend> lendList() {
//
//        return lendService.lendList();
//    }
//
//    @GetMapping("/{readerId}")
//    public ArrayList<Lend> myLend(@PathVariable("readerId") long readerId) {
//
//        return lendService.myLendList(readerId);
//    }
//
//    @PostMapping("/{bookId}/{readercard}")
//    public Boolean bookLend(@PathVariable("bookId") long bookId, @PathVariable("readercard") long readercard) {
//
//        return lendService.lendBook(bookId, readercard);
//    }
//
//    @PostMapping("/returnbook.html")
//    public Boolean bookReturn(@PathVariable("bookId") long bookId, @PathVariable("readercard") long readercard) {
//        return lendService.returnBook(bookId, readercard);
//    }
//}
