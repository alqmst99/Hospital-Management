
package com.Hospital_App.Hospital.Management.System.Segurity;

import io.Jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */

@Component
public class JwtUtil {

    private final String SECRET_KEY= "M@rina995";
    private final long EXPIRATION_TIME= 86400000;
    
    
    public String generateToken(String username){
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    
    public String extractUsername(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    
    public boolean validatetoken(String token, String username){
        return username.equals(extractUsername(token))&& !isTokenExpired(token);
    }
    
    public boolean isTokenExpired(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
