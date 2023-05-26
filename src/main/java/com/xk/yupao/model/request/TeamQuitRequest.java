package com.xk.yupao.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍请求体
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = -5327597749412166666L;

    /**
     * id
     */
    private Long teamId;

}
