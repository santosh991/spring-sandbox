package net.agilegeeks.wicketspring.pages.form;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.validation.validator.RangeValidator;

public class FormPage extends WebPage {

	private static final long	serialVersionUID	= 9203343843977430454L;
	
	public FormPage(final PageParameters parameters) {
		
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		final FormBean formModel = new FormBean();
		
		// Define submit processing
		Form<FormBean> form = new Form<FormBean>("inputForm") {
			
			private static final long	serialVersionUID	= 2966444093355998503L;

			@Override
			protected void onSubmit() {

				// Display the model state
				info(formModel);
				
			}
		};
		
		// Simple required text field
		TextField<String> usernameField = new TextField<String>("username");
		usernameField.setModel(new PropertyModel<String>(formModel, "username"));
		usernameField.setRequired(true);
		
		/* Another way to map a field and a model */
		//Form<FormModel> form = new Form<FormModel>("inputForm", new CompoundPropertyModel<FormModel>(formModel));
		//TextField<String> usernameField = new TextField<String>("username");
		
		// Integer field using a range validator
		TextField<Integer> ageField = new TextField<Integer>("age");
		ageField.setModel(new PropertyModel<Integer>(formModel, "age"));
		ageField.setRequired(true);
		ageField.add(new RangeValidator<Integer>(1, 70));
		
		// RadioButtons using a Custom converter
		List<Gender> choices = Arrays.asList(Gender.values());
		RadioChoice<Gender> genderChoice = new RadioChoice<Gender>("gender", choices) {
			
			private static final long	serialVersionUID	= -7613140643470451104L;

			@Override
			@SuppressWarnings("unchecked")
			public <C> IConverter<C> getConverter(Class<C> type) {
				 if (Gender.class.isAssignableFrom(type))
                 {
                     return (IConverter<C>) new GenderConverter();
                 }
                 else
                 {
                     return super.getConverter(type);
                 }
			}
		};
		genderChoice.setModel(new PropertyModel<Gender>(formModel, "gender"));
		genderChoice.setRequired(true);
		genderChoice.setSuffix("");
		
		// Simple checkbox
		CheckBox newsletterCheckbox = new CheckBox("newsletter");
		newsletterCheckbox.setModel(new PropertyModel<Boolean>(formModel, "allowEmails"));
		
		Button submitButton = new Button("submit");
		
		Button resetButton = new Button("reset") {
			
			private static final long	serialVersionUID	= -7465955861422311088L;

			@Override
			public void onSubmit() {
				setResponsePage(FormPage.class);
			}
			
		};
		// Bypass form processing
		resetButton.setDefaultFormProcessing(false);
		
		// Add components
		add(feedbackPanel);
		
		form.add(usernameField);
		form.add(ageField);
		form.add(genderChoice);
		form.add(newsletterCheckbox);
		form.add(resetButton);
		form.add(submitButton);
		
		add(form);
	}
 
}
