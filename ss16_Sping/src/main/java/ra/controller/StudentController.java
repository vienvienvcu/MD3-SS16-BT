package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Student;
import ra.model.service.IStudentService;

import java.util.List;

@Controller
@RequestMapping("studentController")

public class StudentController {
    @Autowired
    private IStudentService studentService;
     @RequestMapping(value = "getAll")
     public ModelAndView getAllStudent(){
         ModelAndView modelAndView = new ModelAndView("studentList");
         List<Student> studentList = studentService.findAll();
         modelAndView.addObject("studentList", studentList);
         return modelAndView;
    }

    @RequestMapping(value = "initCreate")
    public String initCreate( Model model){
         Student newStudent = new Student();
         model.addAttribute("newStudent", newStudent);
         return "studentCreate";
    }

    @RequestMapping(value = "create")
    public String create(@Validated @ModelAttribute("newStudent")Student student, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "studentCreate";
        }
        boolean message = studentService.save(student);
        if (message) {
            return "redirect:getAll";
        } else {
            return "error";
        }
    }
    @RequestMapping(value = "initUpdate")
    // tham so vao thi lay o trang web tham chieu den no
    public String initUpdate(@RequestParam("studentId") Integer studentId, Model model){
         Student studentUpdate = studentService.findById(studentId);
         model.addAttribute("studentUpdate", studentUpdate);
         return "studentUpdate";
    }
    @RequestMapping(value = "update")
    public String update(@ModelAttribute("studentUpdate")Student studentUpdate){
         boolean result = studentService.update(studentUpdate);
         if(result){
             return "redirect:getAll";
         }else {
             return "error";
         }
    }
    @RequestMapping(value = "delete")
    public String delete(@RequestParam("studentId") Integer studentId){
         studentService.delete(studentId);
         return "redirect:getAll";
    }

    @RequestMapping(value = "search")
    public ModelAndView search(@RequestParam("studentName") String studentName) {
        ModelAndView modelAndView = new ModelAndView("studentList");
        List<Student> studentList;

        if (studentName != null && !studentName.trim().isEmpty()) {
            studentList = studentService.searchStudentByName(studentName);
        } else {
            studentList = studentService.findAll();
        }
        modelAndView.addObject("studentList", studentList);
        return modelAndView;
    }
}
