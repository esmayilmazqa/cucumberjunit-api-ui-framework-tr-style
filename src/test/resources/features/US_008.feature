Feature: US_008 When I enter the home page as a user, I should be able to see various titles and perform various controls. "Hypnotes Practice Management Software & EHR Features" section

  Background:
    Given User lands on the related webpage "https://qa-test.hypnotes.net/"

  Scenario Outline: US_008_TC_001 All headings should be visible and clickable in the relevant section
    Then User verifies if all headings are visible, "<text>"
    Then User checks if all headings are clickable, "<text>"
    Examples:
      | text                            |
      | Video Conferencing - Telehealth |
      | Appointment Scheduling          |
      | eSign Documents Online          |
      | Security-HIPAA Compliance       |
      | Billing & Invoicing             |
      | Customize your service          |
      | Get organized                   |
      | Handwriting to Text - OCR       |
      | Speech to Text - Voice Note     |
      | Bio-feedback                    |


  Scenario Outline: US_008_TC_003 Relevant pages should be open.
    When User clicks on the heading link, "<text>"
    Then User verifies if relevant pages open
    Examples:
      | text                   |
     | Video Conferencing - Telehealth |
#      | Appointment Scheduling          |
#      | eSign Documents Online |
      |Security-HIPAA Compliance        |
      |Billing & Invoicing              |
#      |Customize your service           |
#      |Get organized                    |
#      |Handwriting to Text - OCR        |
#      |Speech to Text - Voice Note      |
     |Bio-feedback                     |


# US_008_TC_002 yukaridaki yapida Then -When- Then bir text icin calisiyor, sonra basa donuyor,
# bu dongu her text icin tekrar ediyor

# Yukaridaki Scenario Outline lari tek bir degeri olan stepler
# icin de kullanabilir miyiz.










