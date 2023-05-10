package com.xk.yupao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xk.yupao.model.domain.Team;
import com.xk.yupao.service.TeamService;
import com.xk.yupao.mapper.TeamMapper;
import org.springframework.stereotype.Service;

/**
* @author jojiboy
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2023-05-10 21:08:04
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService{

}




