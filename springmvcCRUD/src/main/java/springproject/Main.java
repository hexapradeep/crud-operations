package springproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class Main {
	
	private static final Logger logger = LoggerFactory
			.getLogger(Employee.class);

	private EmployeeService employeeService;

	@Autowired(required = true)
	@Qualifier(value = "employeeService")
	public void setEmployeeService(EmployeeService ps) {
		this.employeeService = ps;
	}

	@RequestMapping(value = "/empl", method = RequestMethod.GET)
	public String listemployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listemployees",
				this.employeeService.listemployees());
		return "employee";
	}

	// For add and update person both
	@RequestMapping(value = "/empl/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		logger.debug("Started Adding a Employee detaiils for employee name ="
				+ employee.getEmployeeName());

		if (employee.getEmployeeId() == 0) {
			// new employee, add it
			this.employeeService.addEmployee(employee);
		} else {
			// existing employee, call update
			this.employeeService.updateEmployee(employee);
		}
		logger.debug("End of Adding an Employee =" + employee.getEmployeeName());
		return "redirect:/empl";

	}

	@RequestMapping("/remove/{employeeId}")
	public String removeEmployee(@PathVariable("employeeId") int employeeId) {

		this.employeeService.removeEmployee(employeeId);
		return "redirect:/empl";
	}

	@RequestMapping("/edit/{employeeId}")
	public String editEmployee(@PathVariable("employeeId") int employeeId,
			Model model) {
		model.addAttribute("employee",
				this.employeeService.getEmployeeById(employeeId));
		model.addAttribute("listemployees",
				this.employeeService.listemployees());
		return "employee";
	}

}
