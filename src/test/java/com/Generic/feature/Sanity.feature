@Sanity
Feature: Sanity End to End scenarios

  @SMU
 Scenario Outline: 1 Validate Service Modelling Utility
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Service Modelling Utility
    #Then open the <company> in SMU
    Then Click on Logout

    Examples: 
      | username        | password | company           |
      | praveen.kumarnr | MQ==     | American Airlines |

  @CompanyMerge
  Scenario Outline: 2 Validate Company Merge
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Company Marge
    #Then check user permission to marge the company
    #Then select the <sourcecompany> that will merge into the other <destinationcompany>
    Then Click on Logout

    Examples: 
      | username        | password | sourcecompany          | destinationcompany |
      | praveen.kumarnr | MQ==     | Royal Bank of Scotland | Bank of America    |

  @CompanyRename
  Scenario Outline: 3 Validate Company Rename
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Company Rename
    #Then Enter the <ActiveCompany> that will be renamed
    #Then Enter the <newname> for the company
    #Then initiate company rename 
    Then Click on Logout

    Examples: 
      | username        | password | ActiveCompany          | newname                  |
      | praveen.kumarnr | MQ==     | Royal Bank of Scotland | Royal Bank of Scotland_T |

  @OrgSplit
  Scenario Outline: 4 Validate Organization Split
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Organization Split
    #Then Enter the <companyname> to select the organization
    #Then Select the organization <organization> to split
    Then Click on Logout

    Examples: 
      | username        | password | companyname            | organization           |
      | praveen.kumarnr | MQ==     | Royal Bank of Scotland | Royal Bank of Scotland |

  @AIMS
  Scenario Outline: 5 Validate AIMS
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    #When click on Alert Instruction Management System
    #Then add instructions for the customer <customer>
    #Then logout from AIMS
    Then Click on Logout

    Examples: 
      | username        | password | customer               |
      | praveen.kumarnr | MQ==     | Royal Bank of Scotland |
