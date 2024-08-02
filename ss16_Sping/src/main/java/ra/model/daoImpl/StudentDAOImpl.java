package ra.model.daoImpl;

import org.springframework.stereotype.Repository;
import ra.model.dao.IStudentDao;
import ra.model.entity.Student;
import ra.model.util.ConnectionDB;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentDAOImpl implements IStudentDao {
    @Override
    public List<Student> findAll() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Student> students = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call getAllStudent()}");
            ResultSet resultSet = callableStatement.executeQuery();
            students = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getBoolean("sex"));
                student.setAddress(resultSet.getString("address"));
                student.setBirthDate(resultSet.getDate("birthDate"));
                student.setStatus(resultSet.getBoolean("studentStatus"));
                students.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return students;
    }

    @Override
    public Student findById(int studentId) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Student student = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call getByStudentId(?)}");
            callableStatement.setInt(1, studentId);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getBoolean("sex"));
                student.setAddress(resultSet.getString("address"));
                student.setBirthDate(resultSet.getDate("birthDate"));
                student.setStatus(resultSet.getBoolean("studentStatus"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return student;
    }

    @Override
    public Boolean update(Student student) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call updateStudent(?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, student.getStudentId());
            callableStatement.setString(2, student.getStudentName());
            callableStatement.setInt(3, student.getAge());
            callableStatement.setBoolean(4,student.isSex());
            callableStatement.setString(5, student.getAddress());
            callableStatement.setDate(6,new Date(student.getBirthDate().getTime()));
            callableStatement.setBoolean(7,student.isStatus());
            callableStatement.executeUpdate();

        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return result;
    }

    @Override
    public Boolean delete(int studentId) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Boolean result = false;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call deleteStudent(?)}");
            callableStatement.setInt(1, studentId);
            callableStatement.executeUpdate();
            int affectedRows = callableStatement.executeUpdate(); // Execute update and get the number of affected rows

            if (affectedRows > 0) {
                result = true; // Set result to true if at least one row was affected
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }

        return result;
    }

    @Override
    public Boolean save(Student student) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call insertStudent(?,?,?,?,?,?)}");
            callableStatement.setString(1, student.getStudentName());
            callableStatement.setInt(2, student.getAge());
            callableStatement.setBoolean(3,student.isSex());
            callableStatement.setString(4, student.getAddress());
            callableStatement.setDate(5,new Date(student.getBirthDate().getTime()));
            callableStatement.setBoolean(6,student.isStatus());
            callableStatement.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return result;
    }

    @Override
    public List<Student> searchStudentByName(String studentName) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Student> studentSearch = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call searchStudentByName(?)}");
            callableStatement.setString(1, studentName);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getBoolean("sex"));
                student.setAddress(resultSet.getString("address"));
                student.setBirthDate(resultSet.getDate("birthDate"));
                student.setStatus(resultSet.getBoolean("studentStatus"));
                studentSearch.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return studentSearch;
    }
}
