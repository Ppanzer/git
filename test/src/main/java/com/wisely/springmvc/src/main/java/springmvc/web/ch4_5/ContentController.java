package springmvc.web.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.domain.DemoObj;

@Controller
public class ContentController {
    @RequestMapping(value = "/getdemo")
    public String getDemo(Model model){
        DemoObj demoObj = new DemoObj(333L, "WYF");
        model.addAttribute("demoObj",demoObj);
        return "demoObj";

    }

}
