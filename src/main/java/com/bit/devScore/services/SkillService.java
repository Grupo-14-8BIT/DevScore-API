package com.bit.devScore.services;

import com.bit.devScore.entity.Skill;
import com.bit.devScore.repositories.SkillRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Skill> skillOptional =skillRepository.findById(id);
        if (skillOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("skill inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(skillOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Skill> veiculoes = skillRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }


    public ResponseEntity<?> create(Skill dev) {



            try {
                skillRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Skill skill) {
        Optional<Skill> optionalSkill = skillRepository.findById(id);
        if (optionalSkill.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found with ID: " + id);
        } else {
            Skill condutor = optionalSkill.get();
            BeanUtils.copyProperties(skill, condutor);
            skillRepository.save(condutor);
            return ResponseEntity.ok().body("Skill atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Skill> optionalSkill = this.skillRepository.findById(id);

        if(optionalSkill.isPresent()) {
            Skill veiculo = skillRepository.getById(optionalSkill.get().getId());
            this.skillRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
