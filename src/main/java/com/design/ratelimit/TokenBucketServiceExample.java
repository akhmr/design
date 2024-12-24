package com.design.ratelimit;

public class TokenBucketServiceExample {
    public static void main(String[] args) throws InterruptedException {

        TokenBucketService tokenBucketService  = new TokenBucketService();

        String userId="user_1";

        for (int i = 0; i < 20; i++) {

            if(tokenBucketService.isAllowed(userId)){
                System.out.println("User "+userId+" is allowed");
            }else{
                System.out.println("User "+userId+" is not allowed");
            }
            Thread.sleep(500);

        }



    }
}
