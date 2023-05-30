package com.bit.devScore.services;

import com.bit.devScore.entity.Comentario;
import com.bit.devScore.entity.Desenvolvedor;
import com.bit.devScore.repositories.ComentarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Service
public class ComentarioServices {


    @Autowired
    private ComentarioRepository comentarioRepository;

    public ResponseEntity<?> findById(Long id) {
        final Comentario comentario = this.comentarioRepository.findById(id).orElse(null);
        return comentario == null
                ? ResponseEntity.badRequest().body("valor nao encontrado.")
                : ResponseEntity.ok(comentario);
    }

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.comentarioRepository.findAll());

    }

    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final Comentario comentario) {

        Assert.isTrue(comentario.getComentario() != null, "comentario não encontrado");

        this.comentarioRepository.save(comentario);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(final Comentario comentario, final Long id) {
        final Comentario cometarioBanco = this.comentarioRepository.findById(id).orElse(null);

        Assert.isTrue(cometarioBanco != null || this.comentarioRepository.findById(id).equals(comentario.getId()), "Não foi possivel identificar o registro informado.");


        this.comentarioRepository.save(comentario);
    }


    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> delete(Long id) {
        final Comentario comentario = this.comentarioRepository.findById(id).orElse(null);
        if (comentario == null) {
            return ResponseEntity.badRequest().body("ID não encontrado !");
        }
        this.comentarioRepository.delete(comentario);
        return ResponseEntity.ok("Registro Excluido");
    }
}