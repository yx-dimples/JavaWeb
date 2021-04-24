package org.s166.ums.commons;

import lombok.Data;

/**
 * 响应对象
 */
@Data
public class ResultDto {
    /**
     * 消息代码提示
     * 默认200
     */
    private int code = 200;

    /**
     * 客户端消息
     *
     */
    private String msg = "";

    /**
     * 返回客户端具体的数据结果
     */
    private Object value ;
}

