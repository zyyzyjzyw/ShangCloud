package com.tedu.java.config.exception;

import com.tedu.java.common.result.ResultCodeEnum;
import lombok.Getter;

/**
 * @author zyy
 * @version 1.0.0
 * @ClassName CustomException.java
 * @Description TODO
 * @createTime 2023年03月08日 21:39:00
 */
@Getter
public class CustomException extends RuntimeException{
    private Integer code; //状态码

    private String message;// 描述的信息

    /**
     * 通过状态码和错误消息创建异常对象
     * @param code
     * @param message
     */
    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public CustomException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
