# API for fetching user's Github repositories
---
## Used technologies
- Java 21
- Spring Boot 3.22
  <p>&nbsp;</p>
## Headers
- **Accept**

  application/json (required)
    <p>&nbsp;</p>
## Parameters
- **username**

  Github username (required)
    <p>&nbsp;</p>
## Example response
```
[
  {"name":"repository_name",
    "ownerLogin":"github_user",
    "branches":[{"name":"master","lastCommitSha":"commit_sha"},
                {"name":"test","lastCommitSha":"commit_sha"}]},
  {"name":"another_repository_name",
    "ownerLogin":"github_user",
    "branches":[{"name":"master","lastCommitSha":"commit_sha"},
                {"name":"test","lastCommitSha":"commit_sha"}]}
]

```
<p>&nbsp;</p>

## Error responses
- *404* (NOT_FOUND)

  User hasn't been found
  
- *400* (BAD_REQUEST)

  Invalid header
