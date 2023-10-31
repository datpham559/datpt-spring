package rest.security.jwt;


import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import rest.security.userDetails.CustomUserDetails;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;


@Component
public class JwtTokenProvider {
    private final Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);
    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private final String JWT_SECRET = "PT";

    //Thời gian có hiệu lực của chuỗi jwt
    private final long JWT_EXPIRATION = 604800000L;
    private byte[] keyBytes;

    public String createJwtToken(CustomUserDetails customUserDetails) {
        getSignKey();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts
                .builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, keyBytes)
                .compact();
    }

    public String getUserNameJwtToken(String jwtToken){
        getSignKey();
        Claims claims = Jwts.parser()
                .setSigningKey(this.keyBytes)
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String jwtToken){
        getSignKey();
        try {
            Jwts.parser().setSigningKey(this.keyBytes).parseClaimsJws(jwtToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
    public void getSignKey(){
        this.keyBytes = JWT_SECRET.getBytes(StandardCharsets.UTF_8);
    }

}
