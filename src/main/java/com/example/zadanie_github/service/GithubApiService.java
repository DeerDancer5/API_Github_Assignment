package com.example.zadanie_github.service;
import com.example.zadanie_github.error.UserNotFoundException;
import com.example.zadanie_github.model.Branch;
import com.example.zadanie_github.model.Repository;
import com.example.zadanie_github.model.RepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


@Service
public class GithubApiService {

    private final RestTemplate template;

    @Autowired
    public GithubApiService(RestTemplate template) {
       this.template = template;
    }


    public List<RepositoryDTO> getUsersRepositories(String username) throws ExecutionException, InterruptedException, UserNotFoundException {
       String url = "https://api.github.com/users/"+username+"/repos";
       ResponseEntity<Repository[]> response = template.exchange(
               url,
               HttpMethod.GET,
               null,
               Repository[].class);

       Repository[] repositories = response.getBody();

       if(response.getStatusCode() == HttpStatus.OK && repositories.length>0) {
           CompletableFuture[] futures = Arrays.stream(repositories)
                   .map(r -> CompletableFuture.runAsync(()->getBranches(r))).
                   toArray(CompletableFuture[]::new);

           CompletableFuture.allOf(futures).get();
           return mapToDTOs(repositories);
       }

       else {
           throw new UserNotFoundException();
       }
    }


    private void getBranches(Repository repository) {
        String url = "https://api.github.com/repos/"+repository.getOwner().getLogin()
                +"/"+repository.getName()+"/branches";

        ResponseEntity<Branch[]> response = template.exchange(
                url,
                HttpMethod.GET,
                null,
                Branch[].class);
        repository.setBranches(response.getBody());
    }


    public List<RepositoryDTO> mapToDTOs(Repository[] repositories) {
        return Arrays.stream(repositories)
                .map(RepositoryDTO::new)
                .collect(Collectors.toList());
    }
}
