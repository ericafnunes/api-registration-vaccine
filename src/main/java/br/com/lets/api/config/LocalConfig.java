package br.com.lets.api.config;


import br.com.lets.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UsuarioRepository repositorio;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
