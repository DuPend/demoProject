package com.xinghuo.mapper;
import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface TbLogMapper {
    /*
    增加日志
     */

    int addLog(TbLog tbLog);
    /*
    根据名称查询
     */

    TbLog selectLogByName(String name);
    /*
     查询所有的日志文件
     */

    Page<TbLog> selectAllLog();
}
