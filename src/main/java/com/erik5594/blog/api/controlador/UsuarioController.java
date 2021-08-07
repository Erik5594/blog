package com.erik5594.blog.api.controlador;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.UsuarioDto;
import com.erik5594.blog.domain.entity.Usuario;
import com.erik5594.blog.domain.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 11:17
 */

@Api(tags = "Usuários")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired @Qualifier("usuario")
    private Assembler assembler;

    @ApiOperation("Cadastrar novo usuário.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> cadastrar(@ApiParam(name = "Usuário", required = true, value = "Representação de um usuário.") @RequestBody UsuarioDto usuarioDto){
        Usuario usuario = (Usuario) assembler.dtoToEntity(usuarioDto);

        usuario = service.cadastrar(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @ApiOperation("Excluir usuário.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Void> deletar(@ApiParam("ID do usuário a ser excluido.") @PathVariable("id") Long idUsuario){
        service.deletar(idUsuario);
        return ResponseEntity.accepted().build();
    }

}
