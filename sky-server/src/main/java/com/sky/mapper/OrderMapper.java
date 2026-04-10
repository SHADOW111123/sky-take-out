package com.sky.mapper;


import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface OrderMapper {
    void insert(Orders orders);

    Integer countByMap(Map map);

    Double sumByMap(Map map);
}


