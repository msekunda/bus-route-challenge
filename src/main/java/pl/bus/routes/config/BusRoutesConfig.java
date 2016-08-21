package pl.bus.routes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class BusRoutesConfig {

    @Value("${file}")
    private String filePath;

    @Bean
    public Path getPath() throws IOException {
        return Paths.get(filePath);
    }

}
