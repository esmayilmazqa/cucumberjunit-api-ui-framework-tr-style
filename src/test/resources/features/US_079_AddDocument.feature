@USS
Feature: As a user, I should be able to add files to Documents

  Background: User as a Therapist navigates to dashboard
    Given the user navigates to "https://test.hypnotes.net/"
    When the user click on login button on the homepage
    And the user types "therapistEmail" to Email Input on login page
    And the user types "therapistPassword" to Password Input on login page
    And the user clicks on Login button on login page
    Then the user verifies if the relevant page opens "https://test.hypnotes.net/dashboard/calendar"

  @AddDocuments
  Scenario: TC_001 The Therapist User controls the various buttons and titles are visible or functional
    Given the user is on "https://test.hypnotes.net/dashboard/calendar"
    Then the user verifies if the "Documents" link is visible on the left menu
    When the user clicks on the "Documents" button
    Then the user verifies if "Documents" page is visible "https://test.hypnotes.net/dashboard/documents"
    When the user clicks on the "Add Document" button
    Then the user verifies if Cancel button is visible and clickable
    When the user clicks on the Cancel button on Add Documents page
    Then the user verifies if "Add Documents" page is visible "https://test.hypnotes.net/dashboard/documents"
    When the user clicks on Logout button
    Then User verifies the relevant page opens "https://test.hypnotes.net/"


  @UploadSection
  Scenario: TC_002 The user as a therapist controls the components are visible and functional on Upload section
    Given the user is on "https://test.hypnotes.net/dashboard/calendar"
    When the user clicks on the "Documents" button
    And the user clicks on the "Add Document" button
    Then the user verifies if relevant titles are visible
      | Upload           | Add Annotations |
      | Self Annotations | Preview         |
    Then the user verifies Select File is clickable and selectable
    When the user attaches the file
    Then the user verifies if attached file is appear on the screen
    Then the user verifies if file name input is active
    When the user clicks on the "Next" button on upload page
    Then the user verifies if "Add Annotations" section is visible
    When the user clicks on Logout button
    Then User verifies the relevant page opens "https://test.hypnotes.net/"


  @AddAnnotationsSection
  Scenario: TC_003 The user as a therapist controls the components are visible and functional on Add Annotations section
    Given the user is on "https://test.hypnotes.net/dashboard/calendar"
    When the user clicks on the "Documents" button
    And the user clicks on the "Add Document" button
    When the user attaches the file
    When the user clicks on the "Next" button on upload page
    Then the user verifies if "Add Annotations" section is visible
    Then the user verifies if "Signature" option is selected on Select Annotation menu
   Then the user verifies if Select Annotation Menu is functional
    #When the user clicks on Logout button
    #Then User verifies the relevant page opens "https://test.hypnotes.net/"

#  Documents button should be clickable
#  Clicking the Documents button, the Documents page should be visible
#    When the Add Document button is clicked Cancel, Upload, Add Annotations, Self Annotations, Preview pipeline should be visible
#    When you click the Cancel button, the Add Document page should be visible.


#  Select File should be clickable and the file should be selectable
#  Attached file should appear on the screen
#  File Name window should be active when the file is added----bunu ekle
#    When you click the Next button, the Add Annotation section should be visible ---
#  Select Annotation menu should be functional and Signature default should appear  --
#  An annotation must be selectable
#  Optional Field must be functional
#    Then the 'Add Annotation' button should be clickable to add it to the Document
#    When you click the Next button, the Self Annotation section should be visible. ----
#  As a user, I should be able to sign the document before saving and be able to complete the upload by pressing the finish button.
#  View Guide option should be clickable
#  Video should play when click view guide
#  Annotate and Insert options must be active
#  Buttons on the Add New Signature screen must be active
#  Signature must be able to be generated
#  Click the Next button and the Preview section should appear
#  Finish button should be clickable
#    When the Finish button is clicked, the message 'Documents successfully uploaded' should appear

