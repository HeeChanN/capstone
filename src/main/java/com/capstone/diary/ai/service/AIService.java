package com.capstone.diary.ai.service;

import com.capstone.diary.ai.AI;
import com.capstone.diary.ai.repository.AIRepository;
import com.capstone.diary.ai.dto.AIMessageDto;
import com.capstone.diary.common.RabbitMQConfig;
import lombok.RequiredArgsConstructor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AIService {

    private final RabbitTemplate rabbitTemplate;
    private final AIRepository aiRepository;
    @Value("${mq.queue-name}")
    private String QUEUE_NAME;

    @Value("${mq.exchange_name}")
    private String EXCHANGE_NAME;

    @Value("${mq.routing-key}")
    private String ROUTING_KEY;

    public String sendMessage(AIMessageDto aiMessageDto) {
        AI ai = new AI(aiMessageDto);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,ROUTING_KEY, aiMessageDto);
        return "메시지 전송 완료";
    }

    public List<AIMessageDto> getAIMessageDto() {

        List<AIMessageDto> aiMessageDtos = new ArrayList<>();
        aiRepository.findAll().forEach(o-> aiMessageDtos.add(new AIMessageDto(o)));
        while(true){
            AIMessageDto message = rabbitTemplate.receiveAndConvert(QUEUE_NAME, new ParameterizedTypeReference<AIMessageDto>() {});
            if(message == null){
                break;
            }
            aiRepository.save(new AI(message));
            aiMessageDtos.add(message);
        }
        return aiMessageDtos;
    }
}
