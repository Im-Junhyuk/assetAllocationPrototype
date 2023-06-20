package asset.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//main page. can go to strategic aa selection page
@Controller
public class HomeController {
    @GetMapping("/")
    public String hello() {
        return "home";
    }

//    @GetMapping("/assetAllocations/strategicAssetAllocation")
//    public String strategic(){
//        return "strategicAssetAllocation";
//    }
}
