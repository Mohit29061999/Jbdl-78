package com.db.springDbDemo.db.repo;

import com.db.springDbDemo.db.config.ConfigurationFile;
import com.db.springDbDemo.db.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcImpl implements PersonRepo {

    @Autowired
    Connection connection;

    @Override
    public List<Person> getAllPerson() {
        List<Person> persons = new ArrayList<>();
        //Connection connection = null;
        try {
            String sql = "select * from person";
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummydb",
//                    "root", "Pass@123");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            //next will tell if we have more records
            //or not
            while (resultSet.next()) {
                //coulmn index is 1 based indexing
                persons.add(new Person(resultSet.getInt(1), resultSet.getString(2)));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return persons;
    }

    @Override
    public int addPerson(Person person) {
       // Connection connection = null;
        try {
            String sql = "insert into person (id,name) VALUES (?,?)";
            boolean currentAutoCommit = connection.getAutoCommit();
            //don't commit after every query
            connection.setAutoCommit(false);
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummydb",
//                    "root", "Pass@123");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //this will set values
            if (person.getId() != null) {
                preparedStatement.setInt(1, person.getId());
            } else {
                preparedStatement.setNull(1, Types.INTEGER);
            }
            preparedStatement.setString(2, person.getName());

            //jdbc will commit every query after it is executed
            int result = 0;
            try {
               result =  preparedStatement.executeUpdate();
                //throw new SQLException("exception occured");
                connection.commit();

            }
            catch(SQLException e){
                connection.rollback();
                throw new RuntimeException("sql failed");

            }
           // int result2 =  preparedStatement.executeUpdate();

            //since we committed it so changes are visible to other places


            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person getPersonByid(int id) {
       // Connection connection = null;
        Person person = null;
        try {
            String sql = "select * from person where id=?";
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummydb",
//                    "root", "Pass@123");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person = new Person(resultSet.getInt(1), resultSet.getString(2));
            }
            return person;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
