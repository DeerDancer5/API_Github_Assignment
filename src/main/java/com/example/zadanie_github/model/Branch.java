package com.example.zadanie_github.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Branch {

    private String name;
    private Commit commit;

    @Getter
    @Setter
    public static class Commit {
        private String sha;
    }

}
