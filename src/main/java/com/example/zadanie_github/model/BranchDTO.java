package com.example.zadanie_github.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchDTO {
   private String name;
   private String lastCommitSha;
}
