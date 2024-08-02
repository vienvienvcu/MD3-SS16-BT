package ra.model.service;

import ra.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int studentId);
    Boolean update(Student student);
    Boolean delete(int studentId);
    Boolean save(Student student);
    List<Student> searchStudentByName(String studentName);
}
