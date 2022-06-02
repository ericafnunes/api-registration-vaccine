package br.com.lets.api.services;

import br.com.lets.api.domain.Usuario;
import br.com.lets.api.domain.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    Usuario findById(Integer id);
    List<Usuario>findAll();
    Usuario registrationVaccine(UsuarioDto obj);
    void deleterRgistration(Integer id);
    Usuario updateRegistration(UsuarioDto obj);




}
