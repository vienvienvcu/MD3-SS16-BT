package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.model.service.DictionaryService;

@Controller
@RequestMapping("dictionaryController")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping
    public String showFormSearch(Model model) {
        return "showFormSearch";
    }

    @PostMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {
        String meaning = dictionaryService.getMeaning(word);
        if (meaning != null) {
            model.addAttribute("message", "Nghĩa: " + meaning);
        } else {
            model.addAttribute("message", "Không tìm thấy từ này.");
        }
        return "showFormSearch";
    }
}
