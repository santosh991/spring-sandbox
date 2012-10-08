package net.agilegeeks.wicketspring.pages.count;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class CountPage extends WebPage {

	private static final long	serialVersionUID	= 2978112042283499662L;
	
	public CountPage(final PageParameters parameters) {
		
		final Count count1 = new Count(); 
		
		Link<String> link1 = new Link<String>("link1") {
			private static final long	serialVersionUID	= -4675489611305334575L;

			public void onClick() {
				count1.increment();
			}
		};
		
		link1.add(new Label("label1", new Model<String>() {
			private static final long	serialVersionUID	= -146817049839216401L;

			public String getObject() {
				return count1.toString();
			}
		}));
		
		add(link1);				
 
	}
 
}
