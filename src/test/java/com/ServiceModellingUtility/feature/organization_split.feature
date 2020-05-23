@OrganizationSplitE2E
Feature: Organization Split

  @OrganizationSplit
  Scenario Outline: Split the Organization
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Organization Split
    Then Enter the <companyname> to select the organization
    Then Select the organization <organization> to split
    Then Click on Initiate button
    Then validate syn_mdm_co table for the company <companyname> before split
    Then validate syn_mdm_co table for the organization <organization> before split
    Then validate COM_Company table for the company <companyname> before split
    Then validate COM_Company table for the organization <organization> before split
    Then validate CTM_people table for the company <companyname> before split
    Then validate CTM_people table for the organization <organization> before split
    Then validate SIT_Site_Company_Association table for the company <companyname> before split
    Then validate AST_Impacted_Areas table for the company <companyname> before split
    Then validate AST_Impacted_Areas table for the organization <organization> before split
    Then validate CTM_People_Organization table for the company <companyname> before split
    Then validate CTM_People_Organization table for the organization <organization> before split
    Then validate HPD_Help_desk table for the company <companyname> before split
    Then validate AST_AssetPeople table for the company <companyname> before split
    Then validate AST_AssetPeople table for the organization <organization> before split
    Then validate HPD_Impacted_Areas table for the company <companyname> before split
    Then validate HPD_Impacted_Areas table for the organization <organization> before split
    Then validate SAV_AIMS_EvResInsAss_Appr table for the company <companyname> before split
    Then validate SERV_ZN Remedy table for the company <companyname> before update
    Then validate SERV_ACCT Remedy table for the company <companyname> before update
    Then validate CO table for the company <companyname> before split
    Then validate CO table for the organization <organization> before split
    Then validate CO_NM table for the company <companyname> before split
    Then validate CO_NM table for the organization <organization> before split
    Then validate SERV_ZN table for the company <companyname> before split
    Then validate SERV_ZN table for the organization <organization> before split
    Then validate SERV_ACCT table for the company <companyname> before split
    Then validate SERV_ACCT table for the organization <organization> before split
    Then Run Presplit validation by entering <abbreviation> to the new company
    Then validate organization split status
    Then validate syn_mdm_co table for the company <companyname> after split
    Then validate syn_mdm_co table for the new company <organization> after split
    Then validate COM_Company table for the company <companyname> after split
    Then validate COM_Company table for the new company <organization> after split
    Then validate CTM_people table for the company <companyname> after split
    Then validate CTM_people table for the new company <organization> after split
    Then validate SIT_Site_Company_Association table for the company <companyname> after split
    Then validate AST_Impacted_Areas table for the company <companyname> after split
    Then validate AST_Impacted_Areas table for the new company <organization> after split
    Then validate CTM_People_Organization table for the company <companyname> after split
    Then validate CTM_People_Organization table for the new company <organization> after split
    Then validate HPD_Help_desk table for the company <companyname> after split
    Then validate AST_AssetPeople table for the company <companyname> after split
    Then validate AST_AssetPeople table for the new company <organization> after split
    Then validate HPD_Impacted_Areas table for the company <companyname> after split
    Then validate HPD_Impacted_Areas table for the new company <organization> after split
    Then validate SAV_AIMS_EvResInsAss_Appr table for the company <companyname> after split
    Then validate SERV_ZN Remedy table for the company <companyname> after update
    Then validate SERV_ACCT Remedy table for the company <companyname> after update
    Then validate CO table for the company <companyname> after split
    Then validate CO table for the organization <organization> after split
    Then validate CO_NM table for the company <companyname> after split
    Then validate CO_NM table for the organization <organization> after split
    Then validate KEY_CROSS_REF table for the organization <organization> after split
    Then validate SERV_ZN table for the company <companyname> after split
    Then validate SERV_ZN table for the organization <organization> after split
    Then validate SERV_ACCT table for the company <companyname> after split
    Then validate SERV_ACCT table for the organization <organization> after split
    Then View the results in SMU

    Examples: 
      | username | password | companyname | organization  | abbreviation |
      | ab81315  | MQ==     | lokanta     | Edward McLeay | EM           |
