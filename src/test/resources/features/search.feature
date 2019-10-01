Feature:
  Scenario:
    Given the user creates the following jobs
      | Title                                            | Description |
      | with car in title and description                | car         |
      | without keyword intitle and description          | Job2        |
      | Job                                              | car driver  |
      | Car Driver                                       | Job4        |
      | this job contains keyword Car in the title       | Car driver  |
      | this job contains keyword Car in the description | driver      |
    And the user is in search Page
    When the user search for a Job with "car driver" Keyword
    Then the job "car driver" should be displayed
    Then the job "job 3" should be displayed
    Then the job "job 3" should not be displayed
    Then the job "Car Driver 2" should be displayed
    Then the job that contains the keyword "Car" in the title should be displayed
    Then the job that contains the keyword "Car" in the description should be displayed



Feature:
  Scenario:
    Given the user creates the following jobs
      | Title                                            | Description |
      | with car in title and description                | car         |
      | without keyword intitle and description          | Job2        |
      | Job                                              | car driver  |
      | Car Driver                                       | Job4        |
      | this job contains keyword Car in the title       | Car driver  |
      | this job contains keyword Car in the description | driver      |
    And the user is in search Page
    When the user search for a Job with "car driver" Keyword
    Then the job "car driver" should be displayed
    Then the job "job 3" should be displayed
    Then the job "job 3" should not be displayed
    Then the job "Car Driver 2" should be displayed
    Then the job that contains the keyword "Car" in the title should be displayed
    Then the job that contains the keyword "Car" in the description should be displayed
