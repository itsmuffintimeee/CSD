package com.fc.mapper;

import com.fc.entity.CarOrder;
import com.fc.entity.CarOrderExample;
import com.fc.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarOrderMapper {

    List<CarOrder> findAll();

    List<OrderVO> afterAll();

    long countByExample(CarOrderExample example);

    int deleteByExample(CarOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarOrder record);

    int insertSelective(CarOrder record);

    List<CarOrder> selectByExample(CarOrderExample example);

    CarOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarOrder record, @Param("example") CarOrderExample example);

    int updateByExample(@Param("record") CarOrder record, @Param("example") CarOrderExample example);

    int updateByPrimaryKeySelective(CarOrder record);

    int updateByPrimaryKey(CarOrder record);

}