package hr.kingict.akademija2023.springbootakademija2023.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.FilenameUtils;
@Configuration
public class FilenamUtilsConfig {
    @Bean
    public FilenameUtils getFilenameUtilsConfig(){
        return new FilenameUtils();
    }
}
