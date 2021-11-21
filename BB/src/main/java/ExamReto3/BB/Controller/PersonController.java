package ExamReto3.BB.Controller;

import ExamReto3.BB.Entity.Person;
import ExamReto3.BB.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    
    @Autowired
    PersonServices personServices;
    
    @GetMapping("/")
    public String list(Model model, Person person){
        var persons = personServices.list();
        model.addAttribute("persons", persons);
        return "index";
    }
    
    @PostMapping("/guardar")
    public String create(Person person,Model model){
        if(personServices.existsByFullname(person.getFullname())){
            model.addAttribute("message", "Name already exists");
            var persons = personServices.list();
            model.addAttribute("persons", persons);
            return "index";
        }else{
            
            personServices.save(person);
            var persons = personServices.list();
            model.addAttribute("persons", persons);
            model.addAttribute("message", "Success");
            return "index";
        }
    }
    
    @GetMapping("/edit/{id}")
    public String edit(Person person, Model model){
        person = personServices.findById(person);
        model.addAttribute("person", person);
        return "eddit";
    }
    
    @PostMapping("/editsuccess")
    public String editsuccess(Person person,Model model){
        if(personServices.existsByFullname(person.getFullname()) && personServices.findByFullname(person.getFullname()).get().getId() != person.getId()){
            var persons = personServices.list();
            model.addAttribute("persons", persons);
            model.addAttribute("message", "Name already exists");
            return "index";
        }else{
            personServices.save(person);
            return "redirect:/";
        }
    }
    
    @GetMapping("/delete/{id}")
    public String delete(Person person){
        personServices.delete(person);
        return "redirect:/";
    }
}
