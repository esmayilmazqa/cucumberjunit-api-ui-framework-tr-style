Feature: US_009 When I go to the home page as a user, I should be able to see the Testimonials section
  Background:
    Given User lands on the related webpage "https://qa-test.hypnotes.net/"

  Scenario: US_009_TC_001 In this section testimonials should appear and the accounts of the relevant persons should be visible
    Then User verifies if testimonials section appears
    Then User verifies if accounts of the relevant persons are visible

  Scenario: US_009_TC_002 Buttons in this section should be functional
    Then User verifies if social buttons is clickable
    When User clicks on each social button
    Then User verifies if the relevant pages open

  Scenario: < > buttons must be available and clickable
    Then User verifies if left arrow is disabled at the begin of testimonial
    Then User verifies if right arrow is disabled at the end of the testimonial
    Then User verifies if right arrow and left arrow is enabled at the middle of the testimonial









# Scenario: 1
#1  Given User lands on homepage "https://qa-test.hypnotes.net/"
#2. Then User verifies if testimonials section appears
#3. Then User verifies if accounts of the relevant persons are visible

# Scenario: 2
#  1.  Given User lands on homepage "https://qa-test.hypnotes.net/"
#  2. Then User verifies if social buttons is clickable
#  3.  When User clicks on each social button
#  4. Then User verify if relevant pages open

# Scenario: 3
#  1.  Given User lands on homepage "https://qa-test.hypnotes.net/"
#  2. Then User verifies if left arrow is disabled at the begin of testimonial
#  3.  Then User verifies if right arrow is disabled at the end of the testimonial
#  4. Then User verifies if right arrow and left arrow is enabled at the middle of the testimonial