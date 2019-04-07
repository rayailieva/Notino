package norvina.web.controllers;

import norvina.domain.models.view.BrandViewModel;
import norvina.service.BrandService;
import norvina.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
public class HomeController extends BaseController{

    private final BrandService brandService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(BrandService brandService, ProductService productService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    public ModelAndView index(){

        return super.view("index");
    }

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView home(ModelAndView modelAndView){

        modelAndView.addObject("brands",
                this.brandService.findAllBrands()
                        .stream()
                        .map(b -> this.modelMapper.map(b, BrandViewModel.class))
                        .collect(Collectors.toList()));
        return super.view("home", modelAndView);
    }


}