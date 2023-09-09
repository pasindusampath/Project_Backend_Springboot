package lk.icet.acpt103.pasindusampath.springboot_final.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private int id;
    private String name;
    private int age;
    private String phone;
    private String guardianName;
    private String address;
    private String guardianPhone;
}
