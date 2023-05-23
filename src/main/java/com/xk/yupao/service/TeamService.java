package com.xk.yupao.service;

import com.xk.yupao.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xk.yupao.model.domain.User;
import com.xk.yupao.model.dto.TeamQuery;
import com.xk.yupao.model.request.TeamUpdateRequest;
import com.xk.yupao.model.vo.TeamUserVO;

import java.util.List;

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

    /**
     * 查询队伍列表
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍信息
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);
}
