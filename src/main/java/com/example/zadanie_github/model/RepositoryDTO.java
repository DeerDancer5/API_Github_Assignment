package com.example.zadanie_github.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RepositoryDTO {
  private String name;
  private String ownerLogin;
  private List <BranchDTO> branches;

  public RepositoryDTO(Repository repository) {
        name = repository.getName();
        ownerLogin = repository.getOwner().getLogin();
        branches = new ArrayList<>();

        for(Branch branch : repository.getBranches()) {
            BranchDTO branchDTO = new BranchDTO();
            branchDTO.setName(branch.getName());
            branchDTO.setLastCommitSha(branch.getCommit().getSha());
            branches.add(branchDTO);
        }
  }
}
