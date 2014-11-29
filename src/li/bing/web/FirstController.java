package li.bing.web;

import javax.servlet.http.HttpServletRequest;

import li.bing.entity.Person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/firstController")
public class FirstController {
	@RequestMapping(params="showpage")
     public String showpage(HttpServletRequest request){
		
		Person p=new Person();
		p.setId("1");
		p.setUsername("小李");
		p.setPassword("123456");
		request.setAttribute("per", p);
		
		
    	 return "libing/bing";
     }
	@RequestMapping(params="saveper")
	public String saveper(HttpServletRequest request,Person p){
		request.setAttribute("per", p);
   	    return "libing/bing";
	     
	}
	
	
}
