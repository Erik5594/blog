package com.erik5594.blog.api.controlador;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.AlbumDto;
import com.erik5594.blog.config.security.JwtTokenUtil;
import com.erik5594.blog.domain.entity.Album;
import com.erik5594.blog.domain.service.AlbumService;
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
 * Data Criacao: 06/08/2021 - 10:45
 */

@Api(tags = "Álbuns")
@RestController
@RequestMapping("/albuns")
public class AlbumController {

    @Autowired
    private AlbumService service;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired @Qualifier("album")
    private Assembler assembler;

    @ApiOperation("Criar um álbum de fotos.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> cadastrarAlbum(@ApiParam(name = "Álbum", required = true, value = "Representação de um álbum.") @RequestBody AlbumDto albumDto){
        Album album = service.cadastrar(jwtUtil.getEmailUsuario(), (Album) assembler.dtoToEntity(albumDto));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(album.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @ApiOperation("Buscar um álbum de fotos.")
    @GetMapping("/{id}")
    public ResponseEntity<AlbumDto> buscarAlbum(@ApiParam("Identificador do álbum.") @PathVariable("id") Long idAlbum){
        Album album = service.buscarPeloId(idAlbum);
        return ResponseEntity.ok((AlbumDto) assembler.entityToDto(album));
    }

    @ApiOperation("Excluir um álbum de fotos.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AlbumDto> excluirAlbum(@ApiParam("Identificador do álbum.") @PathVariable("id") Long idAlbum){
        service.excluir(idAlbum, jwtUtil.getEmailUsuario());
        return ResponseEntity.accepted().build();
    }
}
