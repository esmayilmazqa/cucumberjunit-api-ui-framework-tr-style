package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RefundSchedulingPage extends Base {
    @FindBy(css = "#rc-tabs-1-panel-1 button")
    public WebElement cancelAppBtn;

    @FindBy(css = "#control-hooks_clientCancelBefore")
    public WebElement cancelHoursLimitDrop;

    @FindBy(css = "#control-hooks_cancellationFee")
    public WebElement cancelFeeDrop;

    @FindBy(css = "div.ant-form-item-control-input-content button")
    public WebElement saveBtn;

    @FindBy(css = "div.ant-select.ant-select-single.ant-select-show-arrow")
    public WebElement symbolDrop;

    @FindBy(css = "div.ant-select-item-option-content")
    public List<WebElement> symbols;

    @FindBy(css = "div.toast.toast-success")
    public WebElement successMessage;

}
