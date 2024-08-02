package ra.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Student {
    private Integer studentId;
    @NotBlank(message = "Student Name cannot is empty")
    private String studentName;
    @NotNull(message = "Age cannot be null")
    @Min(value = 6, message = "Age must be a positive number")
    @Max(value = 100, message = "Age must be less than or equal to 150")
    private Integer age;
    @NotNull(message = "Sex cannot be null")
    private boolean sex;
    @NotBlank(message = "student address cannot is empty")
    private String address;
    @NotNull(message = "Birth date cannot be null")
    @Past(message = "Birth date must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @NotNull(message = "Status cannot be null")
    private boolean status;

    public Student() {}

    public Student(Integer studentId, String studentName, Integer age, boolean sex, String address, Date birthDate, boolean status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.birthDate = birthDate;
        this.status = status;
    }

    public Integer getStudentId() {

        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
