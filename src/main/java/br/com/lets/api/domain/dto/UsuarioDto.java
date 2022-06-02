package br.com.lets.api.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Integer id;
    private String nome;

    @Email
    private String email;
    @CPF
    private String cpf;
    private Integer cartaoSaude;
    private String endereco;
    private boolean grupoPrioritario;
    private String cidade;
    private Long telefone;
}
