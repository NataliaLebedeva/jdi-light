package io.github.epam.html.tests.elements.composite;

import io.github.epam.TestsInit;
import io.github.epam.test.data.SupportMessages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsFormsPage;
import static io.github.com.pages.BootstrapFormsPage.supportMessageForm;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

public class BootstrapFormTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsFormsPage.shouldBeOpened();
    }

    @Test
    public void submitForm() {
        supportMessageForm.submit(SupportMessages.DEFAULT_MESSAGE);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(supportMessageForm);
    }
}
