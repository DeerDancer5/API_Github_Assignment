package com.example.zadanie_github.model;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Repository {
    private String name;
    private Owner owner;
    private String fork;
    private Branch[] branches;


    @Getter
    @Setter
    public static class Owner {
        private String login;
    }

}
