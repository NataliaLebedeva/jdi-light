package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.*;
import com.epam.jdi.light.elements.base.JdiSettings;
import com.epam.jdi.light.elements.base.SeleniumSettings;
import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.pairs.Pair;

import static com.epam.jdi.light.common.SearchStrategies.*;
import static com.epam.jdi.light.settings.JDISettings.*;

public enum Strategies {
    JDI(() -> {
        ELEMENT.getElementWithArgs = JdiSettings.GET_WITH_ARGS;
        ELEMENT.clickType = ElementArea.CENTER;
        ELEMENT.getTextType = TextTypes.SMART_TEXT;
        ELEMENT.setTextType = SetTextTypes.CLEAR_SEND_KEYS;
        onlyVisible();
        COMMON.killBrowser = "afterAndBefore";
        ELEMENT.beforeSearch = el -> {};
    }),
    JDI_SMART(() -> {
        ELEMENT.getElementWithArgs = JdiSettings.GET_WITH_ARGS;
        ELEMENT.clickType = ElementArea.SMART_CLICK;
        ELEMENT.getTextType = TextTypes.SMART_TEXT;
        ELEMENT.setTextType = SetTextTypes.SET_TEXT;
        inView();
        COMMON.killBrowser = "afterAndBefore";
    }),
    SELENIUM(() -> {
        ELEMENT.getElementWithArgs = SeleniumSettings.GET_WITH_ARGS;
        ELEMENT.clickType = ElementArea.CENTER;
        ELEMENT.getTextType = TextTypes.TEXT;
        ELEMENT.setTextType = SetTextTypes.SEND_KEYS;
        ELEMENT.searchRule = Pair.$("Any", ANY_ELEMENT);
        ELEMENT.beforeSearch = el -> {};
    });

    public JAction action;
    Strategies(JAction action) { this.action = action; }
}
