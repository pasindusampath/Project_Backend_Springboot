package lk.icet.acpt103.pasindusampath.springboot_final.service.custom.impl;

import lk.icet.acpt103.pasindusampath.springboot_final.dao.custom.StudentRepo;
import lk.icet.acpt103.pasindusampath.springboot_final.dto.StudentDTO;
import lk.icet.acpt103.pasindusampath.springboot_final.entity.Student;
import lk.icet.acpt103.pasindusampath.springboot_final.service.custom.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {

        try {
            InputStream is = new ByteArrayInputStream(studentDTO.getImageArray());
            BufferedImage bi = ImageIO.read(is);
            //new StudentDTO("","","","","","","");
            File outputfile = new File("images/" + LocalDate.now().toString().replace("-", "_") + "__"
                    + LocalTime.now().toString().replace(":", "_") + ".jpg");
            boolean jpg = ImageIO.write(bi, "jpg", outputfile);
            String path = outputfile.getPath();
            studentDTO.setImagePath(outputfile.getAbsolutePath());
            System.out.println("AB path: " + outputfile.getAbsolutePath());
            System.out.println("path: " + outputfile.getPath());
        } catch (IOException e) {
            System.out.println(e.getMessage()+"Student Service Implementation Method save");
        }
        Student save = repo.save(mapper.map(studentDTO, Student.class));
        return mapper.map(save, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAll() {
        Iterable<Student> all = repo.findAll();
        List<StudentDTO> list = StreamSupport.stream(all.spliterator(), false).map(e -> mapper.map(e, StudentDTO.class)).collect(Collectors.toList());
        /*list.forEach(e -> {
            try {
                InputStream stream = new FileInputStream(e.getImagePath());
                byte[] bytes = stream.readAllBytes();
                e.setImageData(Base64.getEncoder().encodeToString(bytes));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });*/
        return list;
    }

    public StudentDTO search(int id){
        Optional<Student> byId = repo.findById(id);
        Student ob = byId.orElseGet(Student::new);
        StudentDTO map = mapper.map(ob, StudentDTO.class);
        try {
            BufferedImage read = ImageIO.read(new File(map.getImagePath()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(read, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            map.setImageData(Base64.getEncoder().encodeToString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
