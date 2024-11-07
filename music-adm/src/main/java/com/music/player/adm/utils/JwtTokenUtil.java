package com.music.player.adm.utils;

import com.music.player.adm.config.JwtConfig;
import com.music.player.adm.vo.UserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * ClassName : JwtTokenUtil<br>
 * Description : JwtTokenUtil<br>
 *
 * @author : sj
 * @date : 2024/3/30
 */
@Component
public class JwtTokenUtil implements Serializable {

    @Autowired
    private JwtConfig jwtConfig;

    private Clock clock = DefaultClock.INSTANCE;


    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getLoginName());
    }


    public boolean validateToken(String token) {
        return isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    private Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsFunction) {
        final Claims claims = getAllClaimFromToken(token);
        return claimsFunction.apply(claims);
    }

    private Claims getAllClaimFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtConfig.getSecret())
                .parseClaimsJwt(token)
                .getBody();
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret())
                .compact();
    }


    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + jwtConfig.getExpiration());
    }

}
