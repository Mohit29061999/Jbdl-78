package com.db.springDbDemo.db.repo;

import com.db.springDbDemo.db.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Primary
public class SpringJdbc implements PersonRepo{
   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //our goal should be to convert result set into Person object
    @Override
    public List<Person> getAllPerson() {
        String sql = "Select * from person";
        return jdbcTemplate.query(sql, new RowMapper<Person>() {
            //it will map one row to one person object
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Person(rs.getInt(1),rs.getString(2));
            }
        });
    }

    @Override
    public int addPerson(Person person) {
//        String sql  = "insert into person (id,name) VALUES " + "(" + person.getId() +
//                ", "+ person.getName() + ")";
        //rather than using index , we use variable name here
        String sql = "insert into person (id,name) VALUES (:id,:name)";

        //fill id and name parameter
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id",person.getId());
        mapSqlParameterSource.addValue("name",person.getName());

        //it will execute update query and it will return rows affected
        return namedParameterJdbcTemplate.update(sql,mapSqlParameterSource);

    }

    @Override
    public Person getPersonByid(int id) {
        return null;
    }
}
