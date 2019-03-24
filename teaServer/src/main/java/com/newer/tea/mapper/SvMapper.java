package com.newer.tea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.newer.tea.SalesVolume;

@Mapper
public interface SvMapper {
	
	@Select("select * from sv")
	List<SalesVolume> loadAll();
	
	@Update("update sv set `value` = `value`+1 where `name` = #{name} ")
	void update(@Param("name") String name);

}
