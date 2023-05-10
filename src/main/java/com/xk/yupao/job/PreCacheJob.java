package com.xk.yupao.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xk.yupao.model.domain.User;
import com.xk.yupao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.xk.yupao.utils.RedisConstants.*;

/**
 * 缓存预热任务
 */
@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;


    //每天执行, 预热推荐用户
    @Scheduled(cron = "0 59 23 * * *")
    public void doCacheRecommendUser(){
        RLock lock = redissonClient.getLock(PRECACHE_LOCK_KEY);
        try {
            //分布式锁, 只有一个线程能获取到锁
            if (lock.tryLock(0, PRECACHE_TTL, TimeUnit.SECONDS)){
                //重点用户
                List<User> userList = userService.list(new QueryWrapper<User>().lt("id",12));
                for (User user : userList) {
                    String redisKey = RECOMMEND_KEY + user.getId();
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1,10), queryWrapper);
                    try {
                        redisTemplate.opsForValue().set(redisKey, userPage, RECOMMEND_SCHEDULED_TTL, TimeUnit.MINUTES);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }
            }
        } catch (InterruptedException e) {
            log.error("doCacheRecommendUser error", e);
        } finally {
            //释放锁, 只能释放自己的锁
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}
