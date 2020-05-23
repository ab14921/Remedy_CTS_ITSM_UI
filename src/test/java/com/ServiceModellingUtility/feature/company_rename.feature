@CompanyRenameE2E
Feature: Company rename

  @CompanyRename
  Scenario Outline: Rename the company
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Company Rename
    Then validate syn_mdm_co table for the company <ActiveCompany> before update
    Then validate COM_Company and CTM_people table for the company <ActiveCompany> before update
    Then validate AST_Impacted_Areas table for the company <ActiveCompany> before update
    Then validate CTM_People_Organization table for the company <ActiveCompany> before update
    Then validate HPD_Help_desk table for the company <ActiveCompany> before update
    Then validate AST_AssetPeople table for the company <ActiveCompany> before update
    Then validate HPD_Impacted_Areas table for the company <ActiveCompany> before update
    Then validate SAV_AIMS_EvResInsAss_Appr table for the company <ActiveCompany> before update
    Then validate SERV_ZN Remedy table for the company <ActiveCompany> before update
    Then validate SERV_ACCT Remedy table for the company <ActiveCompany> before update
    Then validate CO table for the company <ActiveCompany> before update
    Then validate CO_NM table for the company <ActiveCompany> before update
    Then validate SERV_ZN table for the company <ActiveCompany> before update
    Then validate SERV_ACCT table for the company <ActiveCompany> before update
    Then Enter the <ActiveCompany> that will be renamed
    Then Enter the <newname> for the company
    Then initiate company rename
    Then Validate company rename status
    Then click on view Result button
    Then clear the company name field
    Then validate syn_mdm_co table for the old company <ActiveCompany> after update
    Then validate COM_Company and CTM_people table for the old company <ActiveCompany> after update
    Then validate AST_Impacted_Areas table for the old company <ActiveCompany> after update
    Then validate CTM_People_Organization table for the old company <ActiveCompany> after update
    Then validate HPD_Help_desk table for the old company <ActiveCompany> after update
    Then validate AST_AssetPeople table for the old company <ActiveCompany> after update
    Then validate HPD_Impacted_Areas table for the old company <ActiveCompany> after update
    Then validate SAV_AIMS_EvResInsAss_Appr table for the old company <ActiveCompany> after update
    Then validate SERV_ZN Remedy table for the old company <ActiveCompany> after update
    Then validate SERV_ACCT Remedy table for the old company <ActiveCompany> after update
    Then validate CO table for the old company <ActiveCompany> after update
    Then validate CO_NM table for the old company <ActiveCompany> after update
    Then validate SERV_ZN table for the old company <ActiveCompany> after update
    Then validate SERV_ACCT table for the old company <ActiveCompany> after update
    Then validate syn_mdm_co table for the new company <newname> after update
    Then validate COM_Company and CTM_people table for the new company <newname> after update
    Then validate AST_Impacted_Areas table for the new company <newname> after update
    Then validate CTM_People_Organization table for the new company <newname> after update
    Then validate HPD_Help_desk table for the new company <newname> after update
    Then validate AST_AssetPeople table for the new company <newname> after update
    Then validate HPD_Impacted_Areas table for the new company <newname> after update
    Then validate SAV_AIMS_EvResInsAss_Appr table for the new company <newname> after update
    Then validate SERV_ZN Remedy table for the new company <newname> after update
    Then validate SERV_ACCT Remedy table for the new company <newname> after update
    Then validate smu_companyrenameauditrecord table for the company <ActiveCompany> to audit changes
    Then validate CO table for the new company <newname> after update
    Then validate CO_NM table for the new company <newname> after update
    Then validate SERV_ZN table for the new company <newname> after update
    Then validate SERV_ACCT table for the new company <newname> after update
    Then Click on Logout
    Then copy results on console into a text file

    Examples: 
      | username | password | ActiveCompany     | newname      |
      | AB81315  | MQ==     | AcXess, Inc._Test | AcXess, Inc. |
