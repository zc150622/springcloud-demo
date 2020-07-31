package com.anxin.springcloud.dao;

import com.anxin.springcloud.pojo.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ZC
 */

@Mapper
@Repository
public interface PaymentMapper extends BaseMapper<Payment> {
}
