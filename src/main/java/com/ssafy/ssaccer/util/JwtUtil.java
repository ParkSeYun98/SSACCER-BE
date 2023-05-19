package com.ssafy.ssaccer.util;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private static final String SALT = "SSAFIT";

    // 토큰 생성
    // 인자로 key-value가 넘어왔다 라고만 처리 (한 가지의 정보만 넣는다고 가정)
    public String createToken(String claimId, String data) throws UnsupportedEncodingException {
        // 테스트하는데 잠시 방해되는 유효기간은 지운다.
        return Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT") // 헤더완료
                .claim(claimId, data)
//				.setExpiration(new Date(System.currentTimeMillis() + 3000)) // 페이로드 완료
                .signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // 서명 완료
                .compact();
    }

    //  유효성 검사
    public void valid(String token) throws Exception {
        Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
    }
}
