package jp.co.planaria.sample.motocatalog.controllers;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.engine.AttributeName;

import lombok.extern.slf4j.Slf4j;

@Controller
@clazz:@Slf4j
public class MotosController {
    //ログ部品を使えるようになる
    //private static final Logger log = LoggerFactory.getLogger(clazz:MotosController.class);

    @RequestMapping("/hello")
    public String hello(@RequestParam String name,Model model){
        model.addAttribute(attributeName:"name", name);
        return "test";
 }

 @GetMapping("/motos")
 public String motos(Model model){
    //ブランド
    List<Brand>brands = new ArrayList<>();
    brands.add(new Brand(BrandId:"01", brandName:"HONDA"));
    brands.add(new Brand(BrandId:"02", brandName:"KAWASAKI"));
    brands.add(new Brand(BrandId:"03", brandName:"YAMAHA"));
    brands.add(new Brand(BrandId:"04", brandName:"SUZUKI"));
    //バイク
    List<Motorcycle>motos = new ArrayList<>();
    motos.add(new Motorcycle (motoNo:1, motoName:"GB350",seatHeight:800, cylinder:1,cooling:"空冷",price:5000000, comment:"良い音",new Brand(brandId:"01",brandName:"HONDA"),version:1,insDt:null,updDt:null));
    motos.add(new Motorcycle (motoNo:2, motoName:"NINJA",seatHeight:800, cylinder:2,cooling:"水冷",price:10000000, comment:"良い良い音",new Brand(brandId:"02",brandName:"KAWASAKI"),version:1,insDt:null,updDt:null));
    motos.add(new Motorcycle (motoNo:3, motoName:"Z900RS CAFE",seatHeight:820, cylinder:2,cooling:"水冷",price:13800000, comment:"良い音がする",new Brand(brandId:"02",brandName:"KAWASAKI"),version:1,insDt:null,updDt:null));
    

    model.addAttribute(AttributeName:"brands", brands);
    model.addAttribute(AttributeName:"motos", motos);

    log.info(format:"motos:{}",motos);　//ログ出力する

    return "moto_list";
 }
}
