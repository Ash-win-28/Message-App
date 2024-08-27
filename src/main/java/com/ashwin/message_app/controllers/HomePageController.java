package com.ashwin.message_app.controllers;

import com.ashwin.message_app.data.Folders;
import com.ashwin.message_app.repository.FoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private FoldersRepository foldersRepository;

    @GetMapping(value = "/")
    public String getHomePage(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal == null || !StringUtils.hasText(principal.getAttribute("name"))) {
            return "index";
        }

        String userId = principal.getAttribute("name");
        List<Folders> userFolders = foldersRepository.findByUserId(userId);
        model.addAttribute("userFolders", userFolders);

        return "inbox-page";

    }
}
