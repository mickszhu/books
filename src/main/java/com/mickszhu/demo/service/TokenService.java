package com.mickszhu.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/***
 * token 下发
 */
@Service("TokenService")
public class TokenService {

    public String getToken(long userId, String password) {
        Date start = new Date();
        //5分钟有效时间
        long currentTime = System.currentTimeMillis() + 5* 60 * 1000;
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(String.valueOf(userId)).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(password));
        return token;
    }
}
