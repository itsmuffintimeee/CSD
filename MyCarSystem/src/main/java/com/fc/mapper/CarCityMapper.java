package com.fc.mapper;

import com.fc.entity.CarCity;
import com.fc.entity.CarCityExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarCityMapper {
    long countByExample(CarCityExample example);

    int deleteByExample(CarCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarCity record);

    int insertSelective(CarCity record);

    List<CarCity> selectByExample(CarCityExample example);

    CarCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarCity record, @Param("example") CarCityExample example);

    int updateByExample(@Param("record") CarCity record, @Param("example") CarCityExample example);

    int updateByPrimaryKeySelective(CarCity record);

    int updateByPrimaryKey(CarCity record);
}