package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.common.*;
import org.mytests.uiobjects.example.entities.Contacts;
import org.mytests.uiobjects.example.site.custom.MultiDropdown;

import java.lang.reflect.Field;

import static com.epam.jdi.tools.ReflectionUtils.*;

public class ContactForm extends Form<Contacts> {
	TextField name, lastName, position, passportNumber, passportSeria;

	DropdownSelect gender;
	IsCombobox religion;
	MultiDropdown weather;

	Checkbox passport, acceptConditions;
	TextArea description;

	//@UI("['Submit']") public Button submit;

	@Override
	public void fillAction(Field field, Object element, Object parent, String setValue) {
		if (isInterface(field, TextField.class))
			((TextField)element).highlight();
		super.fillAction(field, element, parent, setValue);
	}
}