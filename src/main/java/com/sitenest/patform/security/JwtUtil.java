package com.sitenest.patform.security;


import com.sitenest.patform.model.Role;
import com.sitenest.patform.model.User;
import com.sitenest.patform.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt-token-expiration-time}")
    String expirationTime;
    @Value("${jwt-secret-password}")
    String secretPassword;
    @Autowired
    UserService userService;


    /// generating token
    public String generateJwtToken(String email,
                                   String mobNum,
                                   List<String> roleName){
        Map<String , Object> claims = new HashMap<>();
        claims.put("email" , email);
        claims.put("mobNum" , mobNum);
        claims.put("roles" , roleName);

        String jwtToken = Jwts
                .builder()
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.ES256,secretPassword)
                .setClaims(claims)
                .compact();
        return jwtToken;
    }

    /// decrypting token
    public Claims decryptToken(String jwtToken){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretPassword)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims;
    }

    /// validate token
    public boolean isTokenValid(String jwtToken){
        Claims claims = this.decryptToken(jwtToken);
        String email = claims.get("email", String.class);
        String mobNum = claims.get("mobNum", String.class);
        List<String> tokenRoles = claims.get("roles", List.class);

        User user = userService.getUserByEmail(email);

        if(user == null)return false;

        List<Role> userRoles = user.getRoles();
        //check all roles

        for(String tokenRole : tokenRoles){
            boolean flag = false;
            for(Role userRole : userRoles){
                if(userRole.getRoleName().equals(tokenRole)){
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }
}
