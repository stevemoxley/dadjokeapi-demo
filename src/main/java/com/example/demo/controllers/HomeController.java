package com.example.demo.controllers;

import com.example.demo.services.DadJoke;
import com.example.demo.services.DadJokeSearch;
import com.example.demo.services.DadJokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {

    DadJokeService dadJokeService = new DadJokeService();

    @GetMapping("/")
    public String Index(Model model) throws IOException {

        DadJoke dadJoke = dadJokeService.GetDadJoke();
        model.addAttribute("dadJoke", dadJoke);

        return "index";
    }

    @GetMapping("/search")
    public String Search(Model model, @RequestParam String searchTerm) throws IOException{
        DadJokeSearch dadJokeSearch = dadJokeService.SearchDadJokes(searchTerm);
        model.addAttribute("dadJokes", dadJokeSearch);

        return "search";
    }

}
