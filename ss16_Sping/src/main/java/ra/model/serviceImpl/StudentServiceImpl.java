package ra.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ra.model.dao.IStudentDao;
import ra.model.daoImpl.StudentDAOImpl;
import ra.model.entity.Student;
import ra.model.service.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int studentId) {
        return studentDao.findById(studentId);
    }

    @Override
    public Boolean update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public Boolean delete(int studentId) {
        return studentDao.delete(studentId);
    }

    @Override
    public Boolean save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public List<Student> searchStudentByName(String studentName) {
        return studentDao.searchStudentByName(studentName);
    }
}
