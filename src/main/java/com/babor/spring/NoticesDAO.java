package com.babor.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("noticeDao")
public class NoticesDAO {
    private JdbcTemplate jdbc;

    @Autowired
    public NoticesDAO(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Notice> getNotices() {

        return jdbc.query("select * from notices", new RowMapper<Notice>() {

            public Notice mapRow(ResultSet resultSet, int i) throws SQLException {
                Notice notice = new Notice();

                notice.setId(resultSet.getInt("id"));
                notice.setName(resultSet.getString("name"));
                notice.setEmail(resultSet.getString("email"));
                notice.setText(resultSet.getString("text"));

                return notice;
            }

        });
    }
}
