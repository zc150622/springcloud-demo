package com.anxin.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZC
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("payment")
public class Payment {

    @TableId
    private Long id;

    private String serial;
}
