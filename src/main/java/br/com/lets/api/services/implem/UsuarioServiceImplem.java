package br.com.lets.api.services.implem;

import br.com.lets.api.domain.Usuario;
import br.com.lets.api.domain.dto.UsuarioDto;
import br.com.lets.api.repositories.UsuarioRepository;
import br.com.lets.api.services.UsuarioService;
import br.com.lets.api.services.exceptions.DadosMessageException;
import br.com.lets.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping
public class UsuarioServiceImplem implements UsuarioService {


    private ModelMapper mapp = new ModelMapper();

    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> elemento = repositorio.findById(id);
        return elemento.orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado!"));
    }

    public List<Usuario> findAll(){
        return repositorio.findAll();
    }

    @Override
    public Usuario registrationVaccine(UsuarioDto obj) {
        findByEmail(obj);
        return repositorio.save(mapp.map(obj, Usuario.class));
    }

    @Override
    public void deleterRgistration(Integer id) {
        findById(id);
        repositorio.deleteById(id);
    }

    @Override
    public Usuario updateRegistration(UsuarioDto obj) {
        findByEmail(obj);
        return repositorio.save(mapp.map(obj, Usuario.class));
    }

    private void findByEmail(UsuarioDto obj){
        Optional<Usuario> usuario = repositorio.findByEmail(obj.getEmail());
        if(usuario.isPresent() && !usuario.get().getId().equals(obj.getId())){
            throw new DadosMessageException("O email informado já está sendo usado!");
        }
    }
}
