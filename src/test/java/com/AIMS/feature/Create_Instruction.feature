@AIMS_End_to_End
Feature: AIMS End to End testing

  @Create_Instruction_Company
  Scenario Outline: Create Instruction of type Company
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Alert Instruction Management System
    Then add instructions for the customer <customer>
    #Then add matching criteria for servicezone
    #Then add matching criteria for ci
    #Then add matching criteria for cigroup
    #Then add matching criteria for site/location
    #Then add matching criteria for organization
    #Then add matching criteria for department
    #Then add matching criteria for serviceaccount
    #Then save AIMS instruction
    Then logout from AIMS

    Examples: 
      | username | password | customer               |
      | AB81315  | MQ==     | Royal Bank of Scotland |
