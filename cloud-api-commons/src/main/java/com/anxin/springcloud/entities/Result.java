package com.anxin.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ZC
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public Result(Integer code, String message) {
       this(code,message,null);
    }
}
