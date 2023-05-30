package com.xk.yupao.utils;

public class RedisConstants {
    public static final String RECOMMEND_KEY = "yupao:user:recommend:";
    public static final Long RECOMMEND_TTL = 300L;
    public static final Long RECOMMEND_SCHEDULED_TTL = 360L;


    public static final String PRECACHE_LOCK_KEY = "yupao:precachejob:lock";
    public static final Long PRECACHE_TTL = 30L;


    public static final String JOIN_TEAM_LOCK_KEY = "yupao:joinTeam:lock:";
    public static final Long JOIN_TEAM_WAIT_TTL = 720L;
    public static final Long JOIN_TEAM_LEASE_TTL = 1000L;
}
