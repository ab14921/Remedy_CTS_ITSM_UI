@MergeE2E
Feature: Merge - UI - Merge Initiation

  @Merge
  Scenario Outline: Merge - Companies End to End
    Given open browser and start application
    Then login with <username> and <password> to Remedy
    When click on Company Marge
    Then check user permission to marge the company
    Then validate syn_mdm_co table of sourcecompany <sourcecompany> from database before merge
    Then validate syn_mdm_co table of destinationcompany <destinationcompany> from database before merge
    Then validate COM_Company and CTM_people table of source company <sourcecompany> before merge
    Then validate COM_Company and CTM_people table of destination company <destinationcompany> before merge
    #Then convert the result to pdf
    Then validate AST_Impacted_Areas table of source company <sourcecompany> before merge
    Then validate AST_Impacted_Areas table of destination company <destinationcompany> before merge
    Then validate SIT_Site_Company_Association table of source company <sourcecompany> before merge
    Then validate SIT_Site_Company_Association table of destination company <destinationcompany> before merge
    Then validate CTM_People_Organization table of source company <sourcecompany> before merge
    Then validate CTM_People_Organization table of destination company <destinationcompany> before merge
    Then validate HPD_Help_desk table of source company <sourcecompany> before merge
    Then validate HPD_Help_desk table of destination company <destinationcompany> before merge
    Then validate SAV_AIMS_EvResInsAss_Appr table of source company <sourcecompany> before merge
    Then validate SAV_AIMS_EvResInsAss_Appr table of destination company <destinationcompany> before merge
    Then validate SERV_ZN Remedy table for the source company <sourcecompany> before merge
    Then validate SERV_ZN Remedy table for the source company <destinationcompany> before merge
    Then validate SERV_ACCT Remedy table for the destination company <sourcecompany> before merge
    Then validate SERV_ACCT Remedy table for the destination company <destinationcompany> before merge
    Then validate smu_companymergeauditrecord table of source company <sourcecompany> and destination company <destinationcompany> before merge
    Then validate CO table for the source company <sourcecompany> before merge
    Then validate CO table for the destination company <destinationcompany> before merge
    Then validate CO_NM table for the source company <sourcecompany> before merge
    Then validate CO_NM table for the destination company <destinationcompany> before merge
    Then validate KEY_CROSS_REF table for the source company <sourcecompany> before merge
    Then validate KEY_CROSS_REF table for the destination company <destinationcompany> before merge
    Then validate SERV_ZN table for the source company <sourcecompany> before merge
    Then validate SERV_ZN table for the destination company <destinationcompany> before merge
    Then validate SERV_ACCT table for the source company <sourcecompany> before merge
    Then validate SERV_ACCT table for the destination company <destinationcompany> before merge
    Then select the <sourcecompany> that will merge into the other <destinationcompany>
    When Click on initiate button
    Then check <sourcecompany> and <destinationcompany> both are locked while merging
    Then Check the merge status
    Then check any error occured or not
    Then If merge is success then click on view results in SMU
    Then Expand the result
    Then validate syn_mdm_co table of sourcecompany <sourcecompany> from database after merge
    Then validate syn_mdm_co table of destinationcompany <destinationcompany> from database after merge
    Then validate COM_Company and CTM_people table of source company <sourcecompany> after merge
    Then validate COM_Company and CTM_people table of destination company <destinationcompany> after merge
    Then validate AST_Impacted_Areas table of source company <sourcecompany> after merge
    Then validate AST_Impacted_Areas table of destination company <destinationcompany> after merge
    Then validate SIT_Site_Company_Association table of source company <sourcecompany> after merge
    Then validate SIT_Site_Company_Association table of destination company <destinationcompany> after merge
    Then validate CTM_People_Organization table of source company <sourcecompany> after merge
    Then validate CTM_People_Organization table of destination company <destinationcompany> after merge
    Then validate HPD_Help_desk table of source company <sourcecompany> after merge
    Then validate HPD_Help_desk table of destination company <destinationcompany> after merge
    Then validate SAV_AIMS_EvResInsAss_Appr table of source company <sourcecompany> after merge
    Then validate SAV_AIMS_EvResInsAss_Appr table of destination company <destinationcompany> after merge
    Then validate SERV_ZN Remedy table for the source company <sourcecompany> after merge
    Then validate SERV_ZN Remedy table for the source company <destinationcompany> after merge
    Then validate SERV_ACCT Remedy table for the destination company <sourcecompany> after merge
    Then validate SERV_ACCT Remedy table for the destination company <destinationcompany> after merge
    Then check <sourcecompany> and <destinationcompany> both are unlocked After merging
    Then validate smu_companymergeauditrecord table of source company <sourcecompany> and destination company <destinationcompany> after merge
    Then validate CO table for the source company <sourcecompany> after merge
    Then validate CO table for the destination company <destinationcompany> after merge
    Then validate CO_NM table for the source company <sourcecompany> after merge
    Then validate CO_NM table for the destination company <destinationcompany> after merge
    Then validate KEY_CROSS_REF table for the source company <sourcecompany> after merge
    Then validate KEY_CROSS_REF table for the destination company <destinationcompany> after merge
    Then validate SERV_ZN table for the source company <sourcecompany> after merge
    Then validate SERV_ZN table for the destination company <destinationcompany> after merge
    Then validate SERV_ACCT table for the source company <sourcecompany> after merge
    Then validate SERV_ACCT table for the destination company <destinationcompany> after merge
    Then Close the browser
    Then copy results on console into a text file

    Examples: 
      | username | password | sourcecompany | destinationcompany |
      | ab81315  | MQ==     | Edward McLeay | lokanta            |
