package com.xk.yupao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xk.yupao.model.domain.UserTeam;
import com.xk.yupao.service.UserTeamService;
import com.xk.yupao.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author jojiboy
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2023-05-10 21:09:25
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




