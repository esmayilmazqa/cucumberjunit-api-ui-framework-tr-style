@US_007
Feature: US_007 When I enter the main page as a user, I should be able to see various titles and make various controls.
  Background:
    Given User lands on the related webpage "https://test.hypnotes.net/"

  @AboutHynotes1
  Scenario: US_007_TC_001 What is Hypnotes? Youtube video should be clickable and the video should play
    #checks the link clickable - iframe -
    Then User checks  the What is Hypnotes? link is clickable
    # clicks on youtube video - iframe -
    When User clicks on What is Hypnotes? the video link
    Then User checks the video plays

  @AboutHynotes2
  Scenario: US_007_TC_002 More info should be visible
    Then User verifies that "More info" is visible

  @AboutHynotes3
  Scenario: US_007_TC_004 More info should be clickable and the relevant page should be seen. 'https://qa-test.hypnotes.net/about-us'
    Then User verifies that if "More info" is clickable
    When User clicks on the "More info"
    Then User verifies the relevant page opens "https://test.hypnotes.net/about-us"



# User lands on Homepage 'https://qa-test.hypnotes.net/' şeklinde parametrik yapılsa herkes istediği url yi girebilir mi

# https://qa-test.hypnotes.net/ , About Hypnotes section

# US_007_TC_001 What is Hypnotes? Youtube video should be clickable and the video should play
#  1. Given User lands on homepage ""https://qa-test.hypnotes.net/""
#  2. Then User checks the ""What is Hypnotes?"" link is clickable
#  3. When User clicks on the video link
#  4. Then User checks the video plays"

# US_007_TC_002 More info should be visible
#  1. Given User lands on homepage "https://qa-test.hypnotes.net/"
#  2. Then User verifies that More Info is visible

# More info should be clickable and the relevant page should be seen. 'https://qa-test.hypnotes.net/about-us'
# 1. Given User lands on homepage "https://qa-test.hypnotes.net/"
# 2. Then User verifies that if "More Info" is clickable.
# 3. When User  clicks on the "More info"
# 4. Then User verifies the relevant page  opens  'https://qa-test.hypnotes.net/about-us '

