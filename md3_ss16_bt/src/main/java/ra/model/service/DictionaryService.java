package ra.model.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService {
    private final Map<String, String> dictionary;

    public DictionaryService() {
        dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("apple", "táo");
        dictionary.put("book", "sách");
        dictionary.put("computer", "máy tính");
        // Thêm các từ và nghĩa khác tại đây
    }

    public String getMeaning(String word) {
        return dictionary.get(word.toLowerCase());
    }
}
