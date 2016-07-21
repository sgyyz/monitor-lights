package com.tubemogul.monitor.light.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.tubemogul.monitor.light.dao.mapper.TestEntityMapper;
import com.tubemogul.monitor.light.entity.TestEntity;

public interface TestDao {
    
    @SqlQuery("SELECT * FROM test WHERE id = :id")
    @Mapper(TestEntityMapper.class)
    public TestEntity findById(@Bind("id") Integer id);
}
