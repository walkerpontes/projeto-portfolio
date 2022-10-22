package br.com.projeto.GestaoUniversitario.configurations;


import br.com.projeto.GestaoUniversitario.model.Usuario;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/*ESSA CLASSE FAZ COM QUE O USERDETAILS USADO NO USUARIO CONSIGA SE CONECTAR COM O BANCO DE DADOS
* , ASSIM PERMITINDO COM QUE AJA  UMA COMUNICAO ENTRE PARA VERIFICAR SE O USUARIO EXISTE*/
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public UserDetailsServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario email = repository.findByEmailAllIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException("usuario nao encontrado"));
        return new User(email.getUsername(), email.getPassword(), true,true,true,true,email.getAuthorities());
    }



}
