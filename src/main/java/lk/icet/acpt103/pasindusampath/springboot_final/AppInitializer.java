package lk.icet.acpt103.pasindusampath.springboot_final;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class);
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
