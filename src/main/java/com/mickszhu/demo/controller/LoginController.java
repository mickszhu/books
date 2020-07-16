package com.mickszhu.demo.controller;

import com.mickszhu.demo.dto.Admin;
import com.mickszhu.demo.dto.ReaderCard;
import com.mickszhu.demo.interceptor.PassToken;
import com.mickszhu.demo.service.LoginService;
import com.mickszhu.demo.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/Login")
@Api(value = "/Lend",tags = "权限控制")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Autowired
    public TokenService tokenService;

    @PostMapping
    @PassToken
    public Object loginCheck(@RequestParam String userId, @RequestParam String passwd) {

        long Id =Long.parseLong(userId);
        boolean isReader = loginService.hasMatchReader(Id, passwd);
        boolean isAdmin = loginService.hasMatchAdmin(Id, passwd);
        HashMap<String, String> res = new HashMap<>();
        if (isAdmin) {
            Admin admin = new Admin();
            admin.setAdmin_id(Id);
            admin.setPassword(passwd);
            String username = loginService.getAdminUsername(Id);
            admin.setUsername(username);
            String token  = tokenService.getToken(Id,passwd);
            res.put("stateCode", "1");
            res.put("msg", "管理员登陆成功！");
            res.put("token",token);
        } else if (isReader) {
            ReaderCard readerCard = loginService.findReaderCardByReaderId(Id);
            //request.getSession().setAttribute("readercard", readerCard);
            res.put("stateCode", "2");
            res.put("msg", "读者登陆成功！");
        } else {
            res.put("stateCode", "0");
            res.put("msg", "账号或密码错误！");
        }
        return res;
    }

    @PutMapping
    @PassToken
    public Boolean rePasswdDo(@RequestParam("Id")  long Id,
                             @RequestParam("oldPasswd")  String oldPasswd,
                             @RequestParam("newPasswd")  String newPasswd,
                             @RequestParam("reNewPasswd")  String reNewPasswd) {
        String password = loginService.getAdminPassword(Id);
        if (password.equals(oldPasswd)) {
            if (loginService.adminRePassword(Id, newPasswd)) {
                return  true;
            }
        }
        return  false;
    }

}