package net.agilegeeks.wicketspring.pages.home;

import net.agilegeeks.wicketspring.pages.count.CountPage;
import net.agilegeeks.wicketspring.pages.form.FormPage;
import net.agilegeeks.wicketspring.services.HelloService;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {

	private static final long	serialVersionUID	= 5834939847063747143L;
	
	@SpringBean
	private HelloService helloService;
 
	public HomePage(final PageParameters parameters) {

		add(new Label("msg", helloService.sayHello()));

		BookmarkablePageLink<Void> countLink = new BookmarkablePageLink<Void>("count_page", CountPage.class);
		add(countLink);
		
		BookmarkablePageLink<Void> formLink = new BookmarkablePageLink<Void>("form_page", FormPage.class);
		add(formLink);
	}
 
}
