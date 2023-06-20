package asset.controller;

import asset.domain.AssetAllocation;
import asset.service.AssetAllocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class StaticAssetAllocationController {
//    @GetMapping("/assetAllocations/strategicAssetAllocation")
//    public String strategic(Model model){
//        return "assetAllocations/strategicAssetAllocation";
//    }
    private final AssetAllocationService assetAllocationService;
    public StaticAssetAllocationController(AssetAllocationService assetAllocationService){
        this.assetAllocationService = assetAllocationService;

    }

    @GetMapping("/staticAssetAllocation")
    public  String staticAssetAllocation(){
        return "/staticAssetAllocation";
    }

    @GetMapping("/staticAssetAllocations/new")
    public  String createForm(){
        return "staticAssetAllocations/createForm";
    }

    @PostMapping(value = "/staticAssetAllocations/new")
    public String create(StaticAssetAllocationCreateForm form) {
        AssetAllocation assetAllocation = new AssetAllocation();

        assetAllocation.setName(form.getName());
        assetAllocation.setCash(0);
        assetAllocation.setStock(form.getStock());
        assetAllocation.setBond(form.getBond());
        assetAllocation.setGold(form.getGold());

        assetAllocationService.addAssetAllocation(assetAllocation);
        return "staticAssetAllocation";
    }

    @GetMapping("/staticAssetAllocations")
    public String list(Model model){
        List<AssetAllocation> staticAssetAllocations = assetAllocationService.findAllAssetAllocation();
        model.addAttribute("staticAssetAllocations", staticAssetAllocations);
        return "staticAssetAllocations/staticAssetAllocationList";
    }

    @GetMapping("/staticAssetAllocations/{id}")
    public String showStaticAssetAllocation(@PathVariable int id, Model model){
        model.addAttribute("sAA", assetAllocationService.findById(id));
        return "staticAssetAllocations/editForm";
    }

    @PostMapping("/staticAssetAllocations/{id}")
    public String edit(@PathVariable int id, @ModelAttribute AssetAllocation assetAllocation, Model model){
        assetAllocationService.update(id, assetAllocation);
        List<AssetAllocation> staticAssetAllocations = assetAllocationService.findAllAssetAllocation();
        model.addAttribute("staticAssetAllocations", staticAssetAllocations);
        return "staticAssetAllocations/staticAssetAllocationList";
    }

    @GetMapping("/staticAssetAllocations/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        System.out.println("삭제 컨트롤 실행");
        System.out.println(id);
        assetAllocationService.delete(id);
        List<AssetAllocation> staticAssetAllocations = assetAllocationService.findAllAssetAllocation();
        model.addAttribute("staticAssetAllocations", staticAssetAllocations);
        return "staticAssetAllocations/staticAssetAllocationList";
    }
//    @PostMapping("/staticAssetAllocations/delete/{id}")
//    public String delete1(@PathVariable int id){
//        System.out.println("실행1");
//        assetAllocationService.delete(id);
//        return "staticAssetAllocation";
//    }
    @GetMapping("/staticAssetAllocations/search")
    public  String searchForm(){
        return "staticAssetAllocations/searchForm";
    }
//
//    @GetMapping ("/staticAssetAllocations/search")
//    public String search(Model model, SearchForm form){
//        Optional<AssetAllocation> assetAllocation = assetAllocationService.findOneByName(form.getName());
//        model.addAttribute("assetAllocation", assetAllocation);
//        return "staticAssetAllocations/{name}";
//    }

}
