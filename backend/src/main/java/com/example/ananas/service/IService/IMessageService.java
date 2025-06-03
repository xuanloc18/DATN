package com.example.ananas.service.IService;

import java.util.List;

import com.example.ananas.dto.MessageDTO;

public interface IMessageService {
    List<MessageDTO> getMessBySender(int id);

    List<MessageDTO> getMessByReceiver(int id);

    MessageDTO sendMessage(MessageDTO MessageDTO);

    MessageDTO updateMessage(int id, MessageDTO MessageDTO);

    void deleteMessage(int id);

    List<MessageDTO> getMessList(int receiverId);

    List<MessageDTO> getMessBySenderAndReceiver(int senderId, int receiverId);

    List<MessageDTO> getMessByReceiverAndSender(int receiverId, int senderId);
}
