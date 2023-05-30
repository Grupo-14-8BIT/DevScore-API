package com.bit.devScore.services;


import com.bit.devScore.controllers.LikeController;
import com.bit.devScore.entity.Like;
import com.bit.devScore.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LikeService {
    @Autowired
    private LikeRepository Like_repo;

    @Autowired
    private LikeService Like_serv;

    @Transactional(rollbackFor = Exception.class)
        public void signup(@RequestBody final Like like){

            Assert.isTrue(like.getId() != null, "Like not liked");

            this.Like_repo.save(like);

    }

}
