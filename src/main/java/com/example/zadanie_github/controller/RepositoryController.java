package com.example.zadanie_github.controller;
import com.example.zadanie_github.error.UserNotFoundException;
import com.example.zadanie_github.model.RepositoryDTO;
import com.example.zadanie_github.service.GithubApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.ExecutionException;


@RestController
public class RepositoryController {

    final GithubApiService githubApiService;

    public RepositoryController(GithubApiService githubApiService) {
        this.githubApiService = githubApiService;
    }

    @GetMapping("/")
    public List<RepositoryDTO> getRepositories(@RequestParam String username)
            throws ExecutionException, InterruptedException, UserNotFoundException {
                return githubApiService.getUsersRepositories(username);
    }

}

