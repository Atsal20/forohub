package com.Challenge.Forohub.security;


public class SecurityConstants {
    public static final String SECRET = "YourJWTSecretKey";
    public static final long EXPIRATION_TIME = 300_000; // 5min
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
