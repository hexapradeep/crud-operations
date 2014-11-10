package springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Main 
{
	 private EmployeeService employeeService;
     
	    @Autowired(required=true)
	    @Qualifier(value="employeeService")
	    public void setEmployeeService(EmployeeService ps){
	        this.employeeService = ps;
	    }
	     
	    @RequestMapping(value = "/empl", method = RequestMethod.GET)
	    public String listemployees(Model model) {
	        model.addAttribute("employee", new Employee());
	        model.addAttribute("listemployees", this.employeeService.listemployees());
	        return "employee";
	    }
	     
	    //For add and update person both
	    @RequestMapping(value= "/empl/add", method = RequestMethod.POST)
	    public String addEmployee(@ModelAttribute("employee") Employee e){
	         
	        if(e.getId() == 0){
	            //new person, add it
	            this.employeeService.addEmployee(e);
	        }else{
	            //existing person, call update
	            this.employeeService.updateEmployee(e);
	        }
	         
	        return "redirect:/empl";
	         
	    }
	     
	    @RequestMapping("/remove/{id}")
	    public String removeEmployee(@PathVariable("id") int id){
	         
	        this.employeeService.removeEmployee(id);
	        return "redirect:/empl";
	    }
	  
	    @RequestMapping("/edit/{id}")
	    public String editEmployee(@PathVariable("id") int id, Model model){
	        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
	        model.addAttribute("listemployees", this.employeeService.listemployees());
	        return "employee";
	    }
	     
	}

