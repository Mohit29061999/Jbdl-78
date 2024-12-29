package com.db.springDbDemo.db.repo;

import com.db.springDbDemo.db.model.Person;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcImpl implements PersonRepo{
    @Override
    public List<Person> getAllPerson()  {
        List<Person> persons = new ArrayList<>();
        Connection connection = null;
        try {
            String sql = "select * from person";
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummydb",
                    "root", "Pass@123");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            //next will tell if we have more records
            //or not
            while(resultSet.next()){
                //coulmn index is 1 based indexing
                persons.add(new Person(resultSet.getInt(1),resultSet.getString(2)));
            }



        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }


        return persons;
    }
}
