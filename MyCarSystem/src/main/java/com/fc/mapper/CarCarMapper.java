package com.fc.mapper;

import com.fc.entity.CarCar;
import com.fc.entity.CarCarExample;
import com.fc.vo.CarVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarCarMapper {

    List<CarCar> getCarByCidOnSite(Integer cid);

    List<CarCar> getCarByCidOnPrice(Integer cid);

    long countByExample(CarCarExample example);

    int deleteByExample(CarCarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarCar record);

    int insertSelective(CarCar record);

    List<CarCar> selectByExample(CarCarExample example);

    CarCar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarCar record, @Param("example") CarCarExample example);

    int updateByExample(@Param("record") CarCar record, @Param("example") CarCarExample example);

    int updateByPrimaryKeySelective(CarCar record);

    int updateByPrimaryKey(CarCar record);

    List<CarVO> findAllIncludeCityName();
}