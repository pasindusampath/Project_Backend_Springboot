package lk.icet.acpt103.pasindusampath.springboot_final.api;

import lk.icet.acpt103.pasindusampath.springboot_final.dto.StudentDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@Validated
@CrossOrigin()
public class StudentApi {

    @PostMapping
    public String saveStudent(@RequestBody StudentDTO student) {
        System.out.println(student);
        return "OK";
    }
    //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

    @GetMapping(value = "/{id:\\d{1,3}}")

    public StudentDTO searchStudent(@PathVariable String id) {
        System.out.println(id);
        return new StudentDTO(2, "Pasindu", 10, "0771234567", "Dayawathie", "Colombo","0771234567");
    }


    @GetMapping
    public List<StudentDTO> getAll() {
        ArrayList<StudentDTO> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new StudentDTO(i, "Pasindu", 10, "0771234567", "Dayawathie", "Colombo","0771234567"));
        }
        return list;
    }


}
