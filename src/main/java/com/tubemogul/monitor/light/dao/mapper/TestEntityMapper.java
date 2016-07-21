package com.tubemogul.monitor.light.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.tubemogul.monitor.light.entity.TestEntity;

public class TestEntityMapper implements ResultSetMapper<TestEntity> {

    @Override
    public TestEntity map(int index, ResultSet rs, StatementContext cx) throws SQLException {
        TestEntity entity = new TestEntity();
        entity.setId(rs.getInt("id"));
        entity.setName(rs.getString("name"));
        return entity;
    }

}
