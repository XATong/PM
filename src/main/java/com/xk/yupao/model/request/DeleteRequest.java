package com.xk.yupao.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用删除请求
 */
@Data
public class DeleteRequest implements Serializable {
    private static final long serialVersionUID = -3535047495770545600L;

    private long id;
}
