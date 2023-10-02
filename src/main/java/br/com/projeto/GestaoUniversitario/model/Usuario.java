package br.com.projeto.GestaoUniversitario.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/*-------------IMPLEMANTAR O USERDETAILS PARA QUE O SPRING BOOT SECURITY CONSIGA ENCONTRAR O
* O USERNAME E O PASSWORD FORNECIDO*/


@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails , Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String nome;
    private String senha;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Cursos> cursos;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Forum> forum;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Salas> salas;

    @OneToMany(mappedBy = "usuario")
    private List<RespostaForum> respostas;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Role> roles;


    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Mensagem> mensagem;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Cursos> getCursos() {
        return cursos;
    }

    public void setCursos(List<Cursos> cursos) {
        this.cursos = cursos;
    }

    public List<Forum> getForum() {
        return forum;
    }

    public void setForum(List<Forum> forum) {
        this.forum = forum;
    }

    public List<Salas> getSalas() {
        return salas;
    }

    public void setSalas(List<Salas> salas) {
        this.salas = salas;
    }

    public List<RespostaForum> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaForum> respostas) {
        this.respostas = respostas;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return id.toString() ;
    }

    public String logado(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();

    }

    public List<Mensagem> getMensagem() {
        return mensagem;
    }

    public void setMensagem(List<Mensagem> mensagem) {
        this.mensagem = mensagem;
    }

    /*Retorna as autoridades concedidas ao usuário*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> role = getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role cargo: role){
            authorities.add(new SimpleGrantedAuthority(cargo.getRole().name()));
            System.out.println(cargo.getRole().name().toUpperCase());
        }
        return authorities;
    }

    /*Retorna a senha usada para autenticar o usuário*/
    @Override
    public String getPassword() {
        return this.senha;
    }
    /*Retorna o nome de usuário usado para autenticar o usuário*/
    @Override
    public String getUsername() {
        return this.email;
    }
    /*Indica se a conta do usuário expirou.*/
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /*Indica se o usuário está bloqueado ou desbloqueado*/
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /*ndica se as credenciais do usuário (senha) expiraram */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /*Indica se o usuário está habilitado ou desabilitado. Um usuário desabilitado não pode ser autenticado.*/
    @Override
    public boolean isEnabled() {
        return true;
    }
}
