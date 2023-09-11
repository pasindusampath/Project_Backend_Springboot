package lk.icet.acpt103.pasindusampath.springboot_final.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.TreeSet;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private int id;
    private String name;
    private int age;
    private String phone;
    private String guardianName;
    private String address;
    private String guardianPhone;
    private String imageData;
    private String imagePath;
    private byte[] imageArray;
}
