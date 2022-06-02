package br.com.lets.api.controller;

import br.com.lets.api.domain.Usuario;
import br.com.lets.api.domain.dto.UsuarioDto;
import br.com.lets.api.services.UsuarioService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    private ModelMapper mapp = new ModelMapper();

    @Autowired
    private UsuarioService userService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioDto>findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapp.map(userService.findById(id), UsuarioDto.class));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> findAll(){
        List<Usuario> lista = userService.findAll();
        List<UsuarioDto> listaDTO = lista.stream().map(elemen -> mapp.map(elemen, UsuarioDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);

    }

    @PostMapping
    public ResponseEntity<UsuarioDto> registrationVaccine(@RequestBody UsuarioDto elemen) {
        userService.registrationVaccine(elemen);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioDto> updateRegistration(@PathVariable Integer id, @RequestBody UsuarioDto elem ){
        elem.setId(id);
        return ResponseEntity.ok().body(mapp.map(userService.updateRegistration(elem), UsuarioDto.class));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UsuarioDto> deleteRegistration(@PathVariable Integer id){
        userService.deleterRgistration(id);
        return ResponseEntity.noContent().build();

    }
}
