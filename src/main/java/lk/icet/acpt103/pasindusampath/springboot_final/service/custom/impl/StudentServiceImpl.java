package lk.icet.acpt103.pasindusampath.springboot_final.service.custom.impl;

import lk.icet.acpt103.pasindusampath.springboot_final.dao.custom.StudentRepo;
import lk.icet.acpt103.pasindusampath.springboot_final.dto.StudentDTO;
import lk.icet.acpt103.pasindusampath.springboot_final.entity.Student;
import lk.icet.acpt103.pasindusampath.springboot_final.service.custom.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo repo;
    @Autowired
    ModelMapper mapper;
    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student save = repo.save(mapper.map(studentDTO, Student.class));
        return mapper.map(save, StudentDTO.class);
    }
}
