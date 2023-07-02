package com.bit.devScore.repositories;

import com.bit.devScore.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillRepository extends JpaRepository <Skill, Long> {


}