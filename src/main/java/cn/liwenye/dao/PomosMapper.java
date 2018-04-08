package cn.liwenye.dao;

import cn.liwenye.bean.Booklist;
import cn.liwenye.bean.LastRecord;
import cn.liwenye.bean.Pomos;
import cn.liwenye.bean.PomosExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PomosMapper {
    long countByExample(PomosExample example);

    int deleteByExample(PomosExample example);

    int insert(Pomos record);

    void insertByBatch(@Param("records") List<Pomos> records);

    int insertSelective(Pomos record);

    List<Pomos> selectByExample(PomosExample example);

    int updateByExampleSelective(@Param("record") Pomos record, @Param("example") PomosExample example);

    int updateByExample(@Param("record") Pomos record, @Param("example") PomosExample example);

    List<Booklist> selectBooklist();

    void deleteDuplicatedRecord();

    LastRecord selectLastRecord();

    void deleteAll();
}