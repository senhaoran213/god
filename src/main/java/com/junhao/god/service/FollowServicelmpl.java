package com.junhao.god.service;
import com.junhao.god.common.exception.BusinessException;
import com.junhao.god.mapper.QuestionFollowMapper;
import com.junhao.god.service.implement.QuestionFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServicelmpl implements QuestionFollowService {

    @Autowired
    private QuestionFollowMapper questionFollowMapper;

    @Override
    public Boolean followQuestion(Long userId, Long questionId) {
            if(questionFollowMapper.hasFollow(userId,questionId)>0) {
                throw new BusinessException("你已关注该问题");
            }
            return questionFollowMapper.insertUser(userId,questionId)>0;
       }
}
