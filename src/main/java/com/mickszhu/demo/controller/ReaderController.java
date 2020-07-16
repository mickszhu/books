//package com.mickszhu.demo.controller;
//
//import com.mickszhu.demo.dto.ReaderInfo;
//import com.mickszhu.demo.service.LoginService;
//import com.mickszhu.demo.service.ReaderCardService;
//import com.mickszhu.demo.service.ReaderInfoService;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//
//@RestController
//@RequestMapping("/Reader")
//@Api(value = "/Lend",tags = "借书人管理")
//public class ReaderController {
//    @Autowired
//    private ReaderInfoService readerInfoService;
//
//    @Autowired
//    private LoginService loginService;
//
//    @Autowired
//    private ReaderCardService readerCardService;
//
//
//    @PostMapping
//    public Boolean readerInfoAddDo(@RequestBody ReaderInfo request) {
//
//        long readerId = readerInfoService.addReaderInfo(request);
//        request.setReader_id(readerId);
//        return readerId > 0 && readerCardService.addReaderCard(request, "123123");
//
//    }
//
//    @DeleteMapping("/{readerId}")
//    public Boolean readerDelete(@PathVariable("readerId")  long readerId) {
//
//        return readerInfoService.deleteReaderInfo(readerId) && readerCardService.deleteReaderCard(readerId);
//    }
//
//    @PutMapping
//    public Boolean readerInfoEditDo(@RequestBody ReaderInfo request) {
//        return readerInfoService.editReaderInfo(request) && readerInfoService.editReaderCard(request);
//    }
//
//    @GetMapping
//    public ArrayList<ReaderInfo> allBooks() {
//        return readerInfoService.readerInfos();
//    }
//
//    @GetMapping("/{readerId}")
//    public ReaderInfo toReaderInfo(@PathVariable("readercard") long readerId) {
//
//        return readerInfoService.getReaderInfo(readerId);
//    }
//}
