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

    @GetMapping("/")
    public String Index(Model model) throws IOException {

        DadJokeService dadJokeService = new DadJokeService();
        DadJoke dadJoke = dadJokeService.GetDadJoke();

        model.addAttribute("dadJoke", dadJoke);

        return "index";
    }

    @GetMapping("/search")
    public String Index(Model model, @RequestParam String searchTerm) throws IOException {
        DadJokeService dadJokeService = new DadJokeService();
        DadJokeSearch dadJokes = dadJokeService.SearchDadJokes(searchTerm);

        model.addAttribute("dadJokes", dadJokes);

        return "search";
    }

}
