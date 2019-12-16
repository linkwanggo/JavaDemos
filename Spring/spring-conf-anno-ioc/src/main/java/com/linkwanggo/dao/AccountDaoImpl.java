package com.linkwanggo.dao;

import com.linkwanggo.domain.Tag;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    public List<Tag> findAll() {
        try {
            return runner.query("select * from m_tag",new BeanListHandler<>(Tag.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
