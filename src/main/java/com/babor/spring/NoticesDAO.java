package com.babor.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("noticeDao")
public class NoticesDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public NoticesDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
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

    public Notice getNoticeById(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbc.queryForObject("select * from notices where id = :id", params, new RowMapper<Notice>() {

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

    public Boolean deleteNoticeById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.update("delete from notices where id = :id", params) == 1;
    }
}
