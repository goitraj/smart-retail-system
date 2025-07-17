package com.smartretail.user.event;

import com.smartretail.common.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendUserCreatedEvent(UserDto userDto) {
       // kafkaTemplate.send("user-events", new UserCreatedEvent(userDto));
    }
}
