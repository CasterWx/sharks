package com.antzuhl.sharks.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

/**
 * JWT认证工具类
 * @author AntzUhl
 * @Date 16:51
 */
@Slf4j
public class SecretUtil {

    /**
     * 根据salt + 月份生成密钥
     * @param userId 用户Id
     * */
    public static String create(Integer userId, String username){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withSubject("subject")
                    .withClaim("username",username)
                    .withClaim("userId",userId)
                    .sign(algorithm);
            log.info(">>>> token:{}", token);
            return token;
        } catch (JWTCreationException exception){
            throw exception;
        }
    }

    public static Integer verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            String payload = jwt.getPayload();
//            String username = jwt.getClaim("username").asString();
            return jwt.getClaim("userId").asInt();
        } catch (JWTVerificationException exception){
            log.error(">>>> JWTVerificationException", exception);
            return -1;
        }
    }



}
