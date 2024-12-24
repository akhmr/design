package com.design.ratelimit;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class TokenBucketService {

    public static Map<String,TokenBucket> userIdToToken = new HashMap<>();
    public static Integer MAX_TOKEN_LIMIT=5;
    private static long refillTimeGap =2000l;
    public boolean isAllowed(String userId){
        
        TokenBucket  tokenBucket = userIdToToken.get(userId);
        if( tokenBucket  == null ){
            tokenBucket = new TokenBucket(userId,5);
            userIdToToken.put(userId,tokenBucket);
        }
        
        refill(tokenBucket);
        if(tokenBucket.getTokenAllowed() <=0 ){
            return false;
        }

        tokenBucket.setTokenAllowed(tokenBucket.getTokenAllowed()-1);
        tokenBucket.setUpdatedTime(LocalDateTime.now());
        System.out.println("Token remaining for user = "+tokenBucket.getTokenAllowed());


        return true;
    }

    private synchronized void refill(TokenBucket tokenBucket) {

        LocalDateTime currentTime = LocalDateTime.now();
        long gapInMilliseconds = ChronoUnit.MILLIS.between(
                tokenBucket.getUpdatedTime().atZone(ZoneId.systemDefault()).toInstant(),
                currentTime.atZone(ZoneId.systemDefault()).toInstant()
        );

        if(gapInMilliseconds > refillTimeGap){
            System.out.println("Refill is done for user = "+tokenBucket.getUserId());
            tokenBucket.setTokenAllowed(MAX_TOKEN_LIMIT);
            tokenBucket.setUpdatedTime(currentTime);
        }

    }


}
