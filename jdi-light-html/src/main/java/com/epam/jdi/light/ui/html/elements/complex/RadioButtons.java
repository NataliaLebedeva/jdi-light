package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.TextTypes.LABEL;

/**
 * To see an example of RadioButtons in bootstrap please visit https://getbootstrap.com/docs/4.3/components/forms/#default-stacked
 */

public class RadioButtons extends UIListBase<UISelectAssert> {

    @Override
    public WebList list() {
        return super.list().setUIElementName(LABEL);
    }

    public WebList list(JFunc1<WebElement, Boolean> searchRule, ElementArea elementArea) {
        WebList radioBtnWebList = new WebList(base()).setup(jdiB -> jdiB.setSearchRule(searchRule))
                .setUIElementName(LABEL);
        radioBtnWebList.setClickArea(elementArea);
        return radioBtnWebList;
    }

    public RadioButtons() {
        base().setLocator("input[type=radio]");
    }
}
