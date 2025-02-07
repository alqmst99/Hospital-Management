package com.Hospital_App.Hospital.Management.System.Services;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */

@Service
public class TokenBlackListService {

    private final Set<String> blackListedTokens= new HashSet<>();
    
    
    public void invalidateToken(String token){
        blackListedTokens.add(token.replace("Bearer ", ""));
    }
    
    public boolean isTokenBlackListed(String token){
        return blackListedTokens.contains(token.replace("Bearer ", ""));
    }
    
}
