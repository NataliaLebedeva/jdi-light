package appium.nativeApp.contacts;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;

import static com.epam.jdi.light.common.CheckTypes.CONTAINS;

public class StaticApp {

    public static ContactsMainPage mainPage;
    @Title(value = "Создать контакт", validate = CONTAINS)
    public static CreateNewContact newContactPage;
}
