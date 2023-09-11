package lk.icet.acpt103.pasindusampath.springboot_final.service.custom;

import lk.icet.acpt103.pasindusampath.springboot_final.dto.StudentDTO;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    StudentDTO save(StudentDTO studentDTO);
    List<StudentDTO> getAll();
    StudentDTO search(int id) throws IOException;


}
