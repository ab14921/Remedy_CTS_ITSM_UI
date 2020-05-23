@DepartmentRenameE2E
Feature: Department Rename

  @DepartmentRename
  Scenario Outline: Rename the Department
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Service Modelling Utility
    Then validate syn_mdm_co table for the department <department> before update
    Then validate CTM_People table for the department <department> before update
    Then validate AST_Impacted_Areas table for the department <department> before update
    Then validate CTM_People_Organization table for the department <department> before update
    Then validate AST_AssetPeople table for the department <department> before update
    Then validate HPD_Impacted_Areas table for the department <department> before update
    Then validate SERV_ZN Remedy table for the company <companyname> before update
    Then validate SERV_ACCT Remedy table for the company <companyname> before update
    Then validate CO table for the department <department> before update
    Then validate CO_NM table for the department <department> before update
    Then validate KEY_CROSS_REF table for the department <department> before update
    Then validate SERV_ZN table for the department <department> before update
    Then validate SERV_ACCT table for the department <department> before update
    Then open the <companyname> in Edit mode
    Then rename the <department> with <department new name>
    Then click on commit changes button on SMU for the <companyname>
    Then complete the process of department rename
    Then validate syn_mdm_co table for the old department <department> after update
    Then validate CTM_People table for the old department <department> after update
    Then validate AST_Impacted_Areas table for the old department <department> after update
    Then validate CTM_People_Organization table for the old department <department> after update
    Then validate AST_AssetPeople table for the old department <department> after update
    Then validate HPD_Impacted_Areas table for the old department <department> after update
    #Then validate SYN_MDM_SERV_ZN table for the old department <department> after update
    #Then validate SYN_MDM_SERV_ACCT table for the old department <department> after update
    Then validate CO table for the old department <department> after update
    Then validate CO_NM table for the old department <department> after update
    Then validate KEY_CROSS_REF table for the old department <department> after update
    Then validate SERV_ZN table for the old department <department> after update
    Then validate SERV_ACCT table for the old department <department> after update
    Then validate syn_mdm_co table for the new department <department new name> after update
    Then validate CTM_People table for the new department <department new name> after update
    Then validate AST_Impacted_Areas table for the new department <department new name> after update
    Then validate CTM_People_Organization table for the new department <department new name> after update
    Then validate AST_AssetPeople table for the new department <department new name> after update
    Then validate HPD_Impacted_Areas table for the new department <department new name> after update
    Then validate SERV_ZN Remedy table for the company <companyname> after update
    Then validate SERV_ACCT Remedy table for the company <companyname> after update
    Then validate CO table for the new department <department new name> after update
    Then validate CO_NM table for the new department <department new name> after update
    Then validate KEY_CROSS_REF table for the new department <department new name> after update
    Then validate SERV_ZN table for the new department <department new name> after update
    Then validate SERV_ACCT table for the new department <department new name> after update
    Then validate the results on UI for new <department new name>

    Examples: 
      | username | password | companyname                  | department         | department new name     |
      | AB81315  | MQ==     | Renaissance Technologies LLC | Renaissance Custom | Renaissance Custom_Test |
      #| AB72476  | Q3RsaUAxMjM0 | HSBC Private Bank | Pradeep_Test15 | Pradeep_Test16      |
