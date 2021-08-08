package com.erik5594.blog.domain.service.impl;

import com.erik5594.blog.domain.entity.Usuario;
import com.erik5594.blog.domain.service.UsuarioService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author erik_
 * Data Criacao: 08/08/2021 - 19:12
 */
public class JwtUserDetailsServiceTeste {

    private JwtUserDetailsService service;
    private UsuarioService userService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before(){
        service = new JwtUserDetailsService();
        userService = Mockito.mock(UsuarioService.class);
        service.setUserService(userService);
    }

    @Test
    public void testeLoadUserByUsername(){
        //cenario
        String email = "teste@teste.com";
        Mockito.when(userService.buscarPorEmail(email)).thenReturn(getUsuario());

        //acao
        service.loadUserByUsername(email);
    }

    @Test
    public void testeLoadUserByUsernameInvalido(){
        //cenario
        String email = "teste1@teste.com";
        Mockito.when(userService.buscarPorEmail(email)).thenReturn(getUsuario());

        expectedException.expect(UsernameNotFoundException.class);
        expectedException.expectMessage(Matchers.equalTo("Não foi encontrado usuário com o email: teste1@teste.com"));

        //acao
        service.loadUserByUsername(email);
    }

    private Usuario getUsuario(){
        return new Usuario("Teste", "teste@teste.com", "1234");
    }
}
