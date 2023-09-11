package lk.icet.acpt103.pasindusampath.springboot_final.api;

import lk.icet.acpt103.pasindusampath.springboot_final.dto.StudentDTO;
import lk.icet.acpt103.pasindusampath.springboot_final.service.custom.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@Validated
@CrossOrigin
public class StudentApi {

    @Autowired
    StudentService service;

    @PostMapping(consumes = "multipart/form-data")
    public StudentDTO saveStudent(@RequestPart(value = "imageUpload") byte[] file,
                                  @RequestPart("name")String name,
                                  @RequestPart(value = "age") String age,
                                  @RequestPart("phone") String phone,
                                  @RequestPart("guardianName") String guardianName,
                                  @RequestPart("address") String address,
                                  @RequestPart("guardianPhone") String guardianPhone
                                  ) throws IOException {
        StudentDTO studentDTO = new StudentDTO(0, name, Integer.parseInt(age), phone, guardianName, address, guardianPhone, null,null, file);
        StudentDTO save = service.save(studentDTO);
        System.out.println(name);
        //return null;
        return save;
    }


    //Change
    @GetMapping(value = "/{id:\\d{1,3}}")

    public StudentDTO searchStudent(@PathVariable String id) {
        System.out.println(id);
        StudentDTO search =new StudentDTO(2, "Pasindu", 10, "0771234567", "Dayawathie", "Colombo","0771234567",null,null,null);
        try {
             search =service.search(Integer.parseInt(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return search;
    }


    @GetMapping
    public List<StudentDTO> getAll() {
        List<StudentDTO> list = service.getAll();
        return list;
    }


}
