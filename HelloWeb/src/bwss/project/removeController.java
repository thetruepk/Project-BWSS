package bwss.project;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@EnableWebMvc
public class removeController {
	private EmployeeLogin employee;
	@Autowired
	private JdbcTemplate jdbctemplate;
	private DataSource datasource;
	
	public void setDataSource(DataSource dataSource) {
		this.datasource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		}
	public void setEmployee(EmployeeLogin tempEmp){
		this.employee = tempEmp;
	}

	 @RequestMapping(value = "/menuEDeleteView")
	 public String employeeDelete(
			 RedirectAttributes redirectAttributes,
			 @ModelAttribute("Employee") EmployeeLogin emp,
			 @ModelAttribute("jdbcTemplate") JdbcTemplate jtemplate){
		 setEmployee(emp);
	
		 return "removeEmployee";
   }
	 @RequestMapping(value="/removeID")
	 public String remove(@RequestParam("employeeID")int ID,
			 RedirectAttributes redirectAttributes){
		String sql = "DELETE FROM bwss.employee WHERE EmployeeID =" +
				ID+";";
		jdbctemplate.execute(sql);
		redirectAttributes.addFlashAttribute("ContEmployee", employee);
	      redirectAttributes.addFlashAttribute("ContJTemplate", jdbctemplate);
		 return "redirect:menu";
		 
	 }
	
}