package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.brand;
import com.example.demo.entity.Product;
import com.example.demo.entity.image;
import com.example.demo.entity.detailsCategories;

import com.example.demo.responsitory.brandRepository;
import com.example.demo.responsitory.detailsCateRepository;
import com.example.demo.responsitory.imageRepository;
import com.example.demo.service.productService;


@Controller
public class ProductManagerController {
	
	@Autowired
	productService proSer;
	
	@Autowired
	brandRepository brandRepo;
	
	@Autowired
	detailsCateRepository detaisCateRepo;
	
	@Autowired
	imageRepository imageRepo;
	@GetMapping("/productManager")
	public String productManager(Model model) {
		
		List<detailsCategories> listDetail = detaisCateRepo.findAll();
		
		List<brand> listBrand =	brandRepo.findAll();
		
	    List<Product> listPro	 = proSer.getAllProduct();
		
			model.addAttribute("listDetail",listDetail);
			
			model.addAttribute("listBrand",listBrand);
			
			model.addAttribute("listPro",listPro);
			
		return "productManager";
	}
	
	@PostMapping("/manager/addPro")
	 public @ResponseBody String saveProduct(@RequestParam("file") MultipartFile file,
			
	    		@RequestParam("name") String name,
	    		@RequestParam("price") Double price,
	    		@RequestParam("desc") String desc
	    		,@RequestParam("quantity") int quantity
	    		,@RequestParam("brand") int brand,
	    		@RequestParam("cate") int categories)
	    {
//		String fileName =  StringUtils.cleanPath(file.getOriginalFilename());
//	    	System.out.println(fileName);
//	    	System.out.println( name + price + desc + quantity + brand + categories);
//	    	try {
//	    		proSer.savePro(file,name, price,desc,quantity ,brand,categories);
//				System.out.println("susscess");
//			} catch (Exception e) {
//				System.out.println("error");
//				e.printStackTrace();
//				
//			}
		
	    	return "redirect:/productManager";
	    }
	
	@PostMapping("/manager/updatePro")
	 public @ResponseBody String updateProduct(
			 @RequestParam(name = "file", required = false) MultipartFile file,
			 @RequestParam(name = "encode", required = false) String encode,
			 @RequestParam(name = "idPro")   String id,
			 @RequestParam("name")	 String name,
	    		 Double price,
	    		 String desc
	    		,int quantity
	    		,int brand,
	    		int cate)
	    {
		if (file != null) {
			String fileName =  StringUtils.cleanPath(file.getOriginalFilename());
			System.out.println(fileName);
			
		}
    	
    	System.out.println(id);
    	
    	// update pro have image
	    	try {
	    		proSer.updatePro(encode,Integer.parseInt(id),name, price,desc,quantity ,brand,cate);
				System.out.println("susscess");
				return "success";
			} catch (Exception e) {
				System.out.println("error");
				e.printStackTrace();
				
			}
		System.out.println(encode);
	    	return "fail";
	    }

	

}
