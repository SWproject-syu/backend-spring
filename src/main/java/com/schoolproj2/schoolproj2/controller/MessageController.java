package com.schoolproj2.schoolproj2.controller;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import net.nurigo.sdk.message.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

   private  DefaultMessageService messageService;

    public MessageController() {
        this.messageService = NurigoApp.INSTANCE.initialize("NCSZUPX7ARG8DUJU", "IRY1SPIWVVJRLYXI7XS6HVOC7K0OI0UD", "https://api.solapi.com");
    }
    /**
     * 단일 메시지 발송 예제
     */
    @PostMapping("/send-one")
    public SingleMessageSentResponse sendOne() {
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01020393071");
        message.setTo("01022039894");
        message.setText("인증되었습니다.");

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);

        return response;
    }




}


