package br.com.lets.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;


    @Column(unique = true)
    @Email
    private String email;
    @Column(nullable = false)
    @CPF
    private String cpf;
    @Column(nullable = false, unique = true)
    private Integer cartaoSaude;
    private String endereco;
    @Column(nullable = false)
    private boolean grupoPrioritario;
    private String cidade;
    private Long telefone;

}
