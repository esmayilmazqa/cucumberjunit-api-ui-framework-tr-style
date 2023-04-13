package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

// https://qa-test.hypnotes.net/
public class HomePage extends Base{

    @FindBy(xpath = "//button[text()='Accept']")
    public WebElement acceptButton;

    @FindBy(xpath="//a[text()='What is Hypnotes?']")
    public WebElement whatIsHypnotesLink;

    @FindBy(xpath = "//iframe[@title='Hypnotes']")
    public WebElement youtubeIframe;

    @FindBy(css = "video.video-stream.html5-main-video")
    public WebElement youtubeVideo;

    @FindBy(xpath = "//a[text()='More info']")
    public  WebElement moreInfoLink;

    @FindBy(xpath="//h3[contains(text(),'Video Conferencing - Telehealth')]")
    public WebElement videoConferencingTelehealth;

    @FindBy(xpath="//h3[contains(text(),'Appointment Scheduling')]")
    public WebElement appointmentScheduling;
    @FindBy(xpath="//h3[contains(text(),'eSign Documents Online')]")
    public WebElement eSignDocumentsOnline;
    @FindBy(xpath="//h3[contains(text(),'Security-HIPAA Compliance')]")
    public WebElement securityHIPAACompliance;
    @FindBy(xpath="//h3[contains(text(),'Billing & Invoicing')]")
    public WebElement billingInvocing;
    @FindBy(xpath="//h3[contains(text(),'Customize your service')]")
    public WebElement customizeYourService;

    @FindBy(xpath="//h3[contains(text(),'Get organized')]")
    public WebElement getOrganized;
    @FindBy(xpath="//h3[contains(text(),'Handwriting to Text - OCR')]")
    public WebElement handwritingToTextOCR;
    @FindBy(xpath="//h3[contains(text(),'Speech to Text - Voice Note')]")
    public WebElement speechToTextVoiceNote;
    @FindBy(xpath="//h3[text()='Bio-feedback']")
    public WebElement bioFeedback;

    @FindBy(xpath = "//h2[text()='Testimonials']")
    public WebElement testimonialTitle;

    @FindBy(css = "div.flickity-slider")
    public WebElement testimonialSlider;

    @FindBy(css="div.details a.color-black") //scoial links in testimonial
    public List<WebElement> socialLinksInTestimonial;

    @FindBy(css ="button.next")
    public WebElement rightArrow;

    @FindBy(css="button.previous")
    public WebElement leftArrow;

    @FindBy(css = "div.is-selected")
    public List<WebElement> controlofPeople; //right left arrow control

    // ******************Second Sprint for Login Background

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginBtn;


}





//bu metot önemli. ArrayList tanimlamamamin sebebi
// List<Element>olarak tanimlayamamis olmam.