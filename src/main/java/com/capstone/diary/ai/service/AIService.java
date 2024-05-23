package com.capstone.diary.ai.service;

import com.capstone.diary.ai.AI;
import com.capstone.diary.ai.repository.AIRepository;
import com.capstone.diary.ai.dto.AIMessageDto;
import com.capstone.diary.common.RabbitMQConfig;
import lombok.RequiredArgsConstructor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AIService {

    private final RabbitTemplate rabbitTemplate;
    private final AIRepository aiRepository;
    private final RabbitMQConfig config;

    public String sendMessage(AIMessageDto aiMessageDto) {
        AI ai = new AI(aiMessageDto);
        rabbitTemplate.convertAndSend(config.getEXCHANGE_NAME(),config.getROUTING_KEY(), aiMessageDto);
        return "메시지 전송 완료";
    }

    public List<AIMessageDto> getAIMessageDto() {

        List<AIMessageDto> aiMessageDtos = new ArrayList<>();
        aiRepository.findAll().forEach(o-> aiMessageDtos.add(new AIMessageDto(o)));
        while(true){
            AIMessageDto message = rabbitTemplate.receiveAndConvert(config.getQUEUE_NAME(), new ParameterizedTypeReference<AIMessageDto>() {});
            if(message == null){
                break;
            }
            aiRepository.save(new AI(message));
            aiMessageDtos.add(message);
        }
        return aiMessageDtos;
    }
}
