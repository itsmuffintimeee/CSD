package com.fc.mapper;

import com.fc.entity.CarUser;
import com.fc.entity.CarUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarUserMapper {
    long countByExample(CarUserExample example);

    int deleteByExample(CarUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarUser record);

    int insertSelective(CarUser record);

    List<CarUser> selectByExample(CarUserExample example);

    CarUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarUser record, @Param("example") CarUserExample example);

    int updateByExample(@Param("record") CarUser record, @Param("example") CarUserExample example);

    int updateByPrimaryKeySelective(CarUser record);

    int updateByPrimaryKey(CarUser record);
}