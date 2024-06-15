package com.anke.jpacrud.controller;

import com.anke.jpacrud.entity.Employee;
import com.anke.jpacrud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private IEmployeeService employeeService;

    /**
     * Bu metot, Spring Framework tarafından otomatik olarak çağrılır.
     * EmployeeService sınıfını enjekte eder.
     * Ayrıca birden fazla sınıfın implementasyonu varsa, @Qualifier annotation'ı kullanarak hangi sınıfın enjekte edileceğini belirtebiliriz.
     *
     * @param theEmployeeService
     */
    @Autowired
    public EmployeeController(IEmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    /**
     * Bu metod, bir HTTP isteği geldiğinde şu adımları izler:
     *
     * /list URL'ine yapılan istekler bu metoda yönlendirilir.
     * employeeService kullanarak veritabanından tüm çalışanları alır.
     * Alınan çalışan listesini Model nesnesine ekler.
     * "list-employees" adlı görünümü döndürür,
     *      böylece Spring Framework bu görünümü kullanarak sayfayı render eder ve kullanıcıya gösterir.
     * @param theModel
     * @return
     */
    @RequestMapping("/list")
    public String listEmployees(Model theModel) {
        // get th employees from the db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }


}
