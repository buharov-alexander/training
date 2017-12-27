package ru.bukharov.training.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.bukharov.training.spring.bean.Person;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("sqlitePersonDAO")
public class SQLitePersonDAO implements PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Person person) {
        String sql = "insert into person (name) values (?)";
        jdbcTemplate.update(sql, person.getName());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from person where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Person> findAll() {
        String sql = "select * from person";
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }

    @Override
    public Person findByName(String name) {
        String sql = "select * from person where name=?";
        List<Person> list =  jdbcTemplate.query(sql, new Object[]{name}, new PersonRowMapper());
        return list.get(0);
    }

    private class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            return person;
        }
    }
}
