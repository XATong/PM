package com.xk.yupao.service;

import com.xk.yupao.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xk.yupao.model.domain.User;

/**
* @author jojiboy
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-05-10 21:08:04
*/
public interface TeamService extends IService<Team> {


    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

}
