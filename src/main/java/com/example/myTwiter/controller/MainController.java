package com.example.myTwiter.controller;

import com.example.myTwiter.entity.Message;
import com.example.myTwiter.entity.User;
import com.example.myTwiter.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/messages")
    public String messages(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages;
        if(filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        }else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "messages";
    }

    @GetMapping("/")
    public String main(Map<String, Object> model){
        model.put("messages", "Hello! Lets code!");
        return "main";
    }

    @PostMapping("/addMessage")
    public String addMessages(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model){
        Message message = new Message(text, tag, user);
        if (message.getText().isEmpty()){
            message.setText("пусте повідомлення");
        }
        if (message.getTag().isEmpty()){
            message.setTag("-//-");
        }
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "messages";
    }

}
