package lk.icet.acpt103.pasindusampath.springboot_final.dao.custom;

import lk.icet.acpt103.pasindusampath.springboot_final.entity.Student;
import org.springframework.data.repository.CrudRepository;




public interface StudentRepo extends CrudRepository<Student, Integer> {
}
