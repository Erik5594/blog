package com.erik5594.blog.domain.service.impl;

import com.erik5594.blog.domain.entity.Usuario;
import com.erik5594.blog.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 12:36
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = userService.buscarPorEmail(email);

        if (usuario.getEmail().equals(email)) {
            return new User(email, usuario.getSenha(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Não foi encontrado usuário com o email: " + email);
        }
    }

    public void setUserService(UsuarioService userService) {
        this.userService = userService;
    }
}