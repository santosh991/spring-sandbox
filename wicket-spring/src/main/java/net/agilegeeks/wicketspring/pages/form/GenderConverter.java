package net.agilegeeks.wicketspring.pages.form;

import java.util.Locale;

import org.apache.wicket.util.convert.IConverter;

public class GenderConverter implements IConverter<Gender> {

	private static final long	serialVersionUID	= 1411883372841637040L;

	@Override
	public Gender convertToObject(String value, Locale locale) {
		return Gender.valueOf(value);
	}

	@Override
	public String convertToString(Gender value, Locale locale) {
		return value.toString();
	}

}
