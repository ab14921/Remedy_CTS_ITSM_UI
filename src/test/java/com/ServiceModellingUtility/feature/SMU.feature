@Regression
Feature: Service Modelling Utility

  #@SMU1
  #Scenario Outline: 1 Validate staging performance - Delete Site IDs - Reset and Cancel buttons
  #Given open browser and start application
  #Then login with <username> and <password> to Remedy
  #When click on Service Modelling Utility
  #Then open the <companyname> in Edit mode
  #Then delete siteIDs from siteID table
  #Then click on reset staging button on SMU for the <companyname>
  #Then click on cancel button on SMU for the <companyname>
  #Then Click on Logout
  #
  #Examples:
  #| username | password | companyname                        |
  #| AB81315  | Tm92b0AyMDE3 | EchoStar Satellite LLC                        |
  #| AB81315  | MQ==     | Mobile Computing Corporation (MCC) |
  #
  #| ab81315  | MQ==     | Savvis                    |
  #| ab81315  | MQ==     | Thomson Reuters (Markets) |
  #| AB81315  | Tm92b0AyMDE3 | Time Warner, Inc.                             |
  #| AB81315  | Tm92b0AyMDE3 | Four Seasons Hotels Limited |
  #| AB81315  | Tm92b0AyMDE3 | savvisdirect                                  |
  #| AB81315  | Tm92b0AyMDE3 | The Coca-Cola Company                         |
  #| AB81315  | Tm92b0AyMDE3 | Resource Capital |
  #| AB81315  | Tm92b0AyMDE3 | Cognizant Technology Solutions US Corporation |
  #| AB81315  | Tm92b0AyMDE3 | CS STARS LLC                                  |
  #
  #@SMU2
  #Scenario Outline: 2 Validate staging performance - Commit Changes
  #Given open browser and start application
  #Then login with <username> and <password> to Remedy
  #When click on Service Modelling Utility
  #Then open the <companyname> in Edit mode
  #Then delete siteIDs from siteID table
  #Then click on commit changes button on SMU for the <companyname>
  #Then validate siteIDs from siteID table
  #Then Click on Logout
  #
  #Examples:
  #| username | password | companyname |
  #
  #| AB81315  | Tm92b0AyMDE3 | Resource Capital |
  #| AB81315  | Tm92b0AyMDE3 | Mobile Computing Corporation (MCC) |
  #| ab81315  | MQ==     | Savvis      |
  #| AB81315  | Tm92b0AyMDE3 | Thomson Reuters (Markets)                     |
  #| AB81315  | Tm92b0AyMDE3 | Time Warner, Inc.                             |
  #| AB81315  | Tm92b0AyMDE3 | Four Seasons Hotels Limited |
  #| AB81315  | Tm92b0AyMDE3 | savvisdirect                                  |
  #| AB81315  | Tm92b0AyMDE3 | The Coca-Cola Company                         |
  #| AB81315  | Tm92b0AyMDE3 | Avid Technology, Inc.                         |
  #| AB81315  | Tm92b0AyMDE3 | Cognizant Technology Solutions US Corporation |
  #| AB81315  | Tm92b0AyMDE3 | CS STARS LLC                                  |
  #@SMU3
  #Scenario Outline: 3 Validate staging performance - Department Rename - - Reset and Cancel buttons
  #Given open browser and start application
  #Then login with <username> and <password> to Remedy
  #When click on Service Modelling Utility
  #Then open the <companyname> in Edit mode
  #Then rename the <department> with <department new name>
  #Then click on reset staging button on SMU for the <companyname>
  #Then click on cancel button on SMU for the <companyname>
  #Then Click on Logout
  #
  #Examples:
  #| username | password | companyname | department | department new name |
  #
  #| AB81315  | Tm92b0AyMDE3 | Savvis                      | SUP212                    | SUP212_new                  |
  #| AB81315  | Tm92b0AyMDE3 | Four Seasons Hotels Limited | Four Season Hotel Limited | Four Season Hotel Limited_1 |
  #
  #@SMU4
  #Scenario Outline: 4 Move contact to an exsting department of the company
  #Given open browser and start application
  #Then login with <username> and <password> to Remedy
  #When click on Service Modelling Utility
  #Then Validate if <contact> is associated to <source dept>
  #Then open the <companyname> in Edit mode
  #Then drag the <contact> from <source dept> to drop into <destination dept>
  #Then click on commit changes button on SMU for the <companyname>
  #Then validate if <contact> is associated to dest <destination dept>
  #Then validate people section on SMU UI for dest <destination dept>
  #Then Click on Logout
  #
  #Examples:
  #| username | password | companyname | source dept         | destination dept | contact |
  #| ab81315  | MQ==     | meow        | Jungle Department22 | Litter Box       | Katt    |
  #@SMU5
  #Scenario Outline: 5 Move contact to a new department of the company
    #Given open browser and start application
    #Then login with <username> and <password> to Remedy
    #When click on Service Modelling Utility
    #Then open the <companyname> in Edit mode
    #Then create new <destination dept> under the <organization>
    #Then click on commit changes button on SMU for the <companyname>
    #Then clear the company name field
    #Then open the <companyname> in Edit mode
    #Then Validate if <contact> is associated to <source dept>
    #Then drag the <contact> from <source dept> to drop into <destination dept>
    #Then click on commit changes button on SMU for the <companyname>
    #Then validate if <contact> is associated to dest <destination dept>
    #Then validate people section on SMU UI for dest <destination dept>
    #Then Click on Logout
#
    #Examples: 
      #| username        | password | companyname | organization | source dept | destination dept | contact |
      #| praveen.kumarnr | MQo=     | meow        | Litter Box   | Litter Box  | Dept_Test10      | user    |

  #@SMU6
  #Scenario Outline: 6 Create new department
  #Given open browser and start application
  #Then login with <username> and <password> to Remedy
  #When click on Service Modelling Utility
  #Then open the <companyname> in Edit mode
  #Then validate syn_mdm_co table for the old department <new dept> after update
  #Then validate SYN_MDM_SERV_ZN table for the old department <new dept> after update
  #Then validate SYN_MDM_SERV_ACCT table for the old department <new dept> after update
  #Then validate CO table for the old department <new dept> after update
  #Then validate CO_NM table for the old department <new dept> after update
  #Then validate SERV_ZN table for the old department <new dept> after update
  #Then validate SERV_ACCT table for the old department <new dept> after update
  #Then create new <new dept> under the <organization>
  #Then click on commit changes button on SMU for the <companyname>
  #Then validate syn_mdm_co table for the new department <new dept> after update
  #Then validate SYN_MDM_SERV_ZN table for the new department <new dept> after update
  #Then validate SYN_MDM_SERV_ACCT table for the new department <new dept> after update
  #Then validate CO table for the new department <new dept> after update
  #Then validate CO_NM table for the new department <new dept> after update
  #Then validate SERV_ZN table for the new department <new dept> after update
  #Then validate SERV_ACCT table for the new department <new dept> after update
  #Then Click on Logout
  #
  #Examples:
  #| username | password | companyname | organization | new dept   |
  #| AB81315  | MQ==     | Altoros     | Altoros      | Dept_Test4 |
  
  @SMU7
  Scenario Outline: 5 Move contact to a new department of the company
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Service Modelling Utility
    Then click on Company Marge
    Then select the comp1 that will merge into the other comp2
    Then Click on initiate button
    Then Click on Logout

    Examples: 
      | username        | password | comp1             | comp2            |
      | praveen.kumarnr | MQo=     | Tech Radium, Inc. | TeleMessage Ltd. |
