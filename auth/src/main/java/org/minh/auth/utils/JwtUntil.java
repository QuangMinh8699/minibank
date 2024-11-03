package org.minh.auth.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.minh.auth.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUntil {

    private final ApplicationConfig applicationConfig;

    @Autowired
    public JwtUntil(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    //Phương thức này tạo một token mới cho người dùng với tên là 'username'
    public String generateToken(String username) {
        //Claims chứa các dữ liệu muốn đưa vào token
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    //Phương thức này xây dựng và ký token
    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder() //Khởi tạo một builder để tạo token
                .setClaims(claims) //Thiết lập các claim cho token
                .setSubject(username) //Đặt tên người dùng cho token
                .setIssuedAt(new Date(System.currentTimeMillis())) //Đặt thời điểm token được tao
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //Đặt thời gian hết hạn
                .signWith(SignatureAlgorithm.ES256, applicationConfig.getSecretKeyJwt()) //Ký token bằng thuật toán ES256 và secretKey
                .compact(); //Tạo ra token dạng chuỗi
    }

    public boolean verifyToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    //Lấy tất cả claim từ token
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(applicationConfig.getSecretKeyJwt()).parseClaimsJws(token).getBody();
    }

    //Check token token hết hạn
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
