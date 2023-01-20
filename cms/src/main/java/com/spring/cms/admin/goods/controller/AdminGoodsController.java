package com.spring.cms.admin.goods.controller;

import java.io.File;
import java.util.Iterator;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cms.admin.goods.service.AdminGoodsService;
import com.spring.cms.goods.dto.GoodsDto;
import com.spring.cms.goods.service.GoodsService;

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {
	
	
	@Autowired
	private AdminGoodsService adminGoodsService;
	
	@Autowired
	private GoodsService goodsService;

	private final String CURR_IMAGE_REPO_PATH = "C:\\file_repo\\";					// window
	//private final String CURR_IMAGE_REPO_PATH = "/var/lib/tomcat9/file_repo/";	// linux
	
	
	@RequestMapping(value="/adminGoodsList" , method=RequestMethod.GET)
	public ModelAndView adminGoodsList() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/goods/adminGoodsList");
		mv.addObject("goodsList", adminGoodsService.getGoodsList());
		return mv;
	}
	
	
	@RequestMapping(value="/adminGoodsAdd" , method=RequestMethod.GET)
	public ModelAndView addNewGoods() throws Exception{
		return new ModelAndView("/admin/goods/adminGoodsAdd");
	}
	
	@RequestMapping(value="/adminGoodsAdd" , method=RequestMethod.POST)
	public ResponseEntity<Object> addNewGoods(MultipartHttpServletRequest multipartRequest) throws Exception{
		
		multipartRequest.setCharacterEncoding("utf-8");
	
		
		GoodsDto goodsDto = new GoodsDto();
		goodsDto.setGoodsNm(multipartRequest.getParameter("goodsNm"));
		goodsDto.setPrice(Integer.parseInt(multipartRequest.getParameter("price")));
		goodsDto.setDiscountRate(Integer.parseInt(multipartRequest.getParameter("discountRate")));
		goodsDto.setStock(Integer.parseInt(multipartRequest.getParameter("stock")));
		goodsDto.setSort(multipartRequest.getParameter("sort"));
		goodsDto.setGoodsSize(multipartRequest.getParameter("goodsSize"));
		goodsDto.setPoint(Integer.parseInt(multipartRequest.getParameter("point")));
		goodsDto.setPart(multipartRequest.getParameter("part"));
		goodsDto.setColor(multipartRequest.getParameter("color"));
		goodsDto.setIntro(multipartRequest.getParameter("intro"));
		
		Iterator<String> file = multipartRequest.getFileNames();
		if (file.hasNext()) {
			
			MultipartFile uploadFile = multipartRequest.getFile(file.next()); 	
			
			if(!uploadFile.getOriginalFilename().isEmpty()) {
				String uploadFileName = UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
				File f = new File(CURR_IMAGE_REPO_PATH  + uploadFileName);	
				uploadFile.transferTo(f); 
				goodsDto.setGoodsFileName(uploadFileName);
			}
		
		}
		
		
		adminGoodsService.addNewGoods(goodsDto);
		
		String jsScript= "<script>";
			   jsScript += " alert('상품을 등록하였습니다.');";
			   jsScript +=" location.href='adminGoodsList';";
			   jsScript +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(jsScript, responseHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/adminGoodsModify" , method=RequestMethod.GET)
	public ModelAndView modifyGoods(@RequestParam("goodsCd") int goodsCd) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/goods/adminGoodsModify");
		mv.addObject("goodsDto", goodsService.getGoodsDetail(goodsCd));
		
		return mv;
	}
	
	@RequestMapping(value="/adminGoodsModify" , method=RequestMethod.POST)
	
		  public ResponseEntity<Object> adminGoodsModify(MultipartHttpServletRequest multipartRequest) throws Exception {
		  
		  multipartRequest.setCharacterEncoding("utf-8");
		  
		  GoodsDto goodsDto = new GoodsDto();
		  goodsDto.setGoodsNm(multipartRequest.getParameter("goodsNm"));
		  goodsDto.setPrice(Integer.parseInt(multipartRequest.getParameter("price")));
		  goodsDto.setColor(multipartRequest.getParameter("color"));
		  goodsDto.setGoodsSize(multipartRequest.getParameter("goodsSize"));
		  goodsDto.setDiscountRate(Integer.parseInt(multipartRequest.getParameter("discountRate")));
		  goodsDto.setPart(multipartRequest.getParameter("part"));
		  goodsDto.setStock(Integer.parseInt(multipartRequest.getParameter("stock")));
		  goodsDto.setPoint(Integer.parseInt(multipartRequest.getParameter("point")));
		  goodsDto.setSort(multipartRequest.getParameter("sort"));
		  goodsDto.setIntro(multipartRequest.getParameter("intro"));
		  
		  Iterator<String> file = multipartRequest.getFileNames();
		  
		  if(file.hasNext()) {
			  
			  MultipartFile uploadFile = multipartRequest.getFile(file.next());
			  
			  if(!uploadFile.getOriginalFilename().isEmpty()) {
				  String uploadFileName = UUID.randomUUID() + "_" + uploadFile.getOriginalFilename();
				  File f = new File(CURR_IMAGE_REPO_PATH + uploadFileName);
				  uploadFile.transferTo(f);
				  goodsDto.setGoodsFileName(uploadFileName);
			  
				  new File(CURR_IMAGE_REPO_PATH + goodsService.getGoodsDetail(Integer.parseInt(multipartRequest.getParameter("goodsCd"))).getGoodsFileName()).delete();
			  }
				  	  
		  }
		
		  adminGoodsService.modifyGoods(goodsDto);
		  
		  String jsScript  = "<script>";
		  jsScript += " alert('상품정보를 수정하였습니다.');";
		  jsScript += " location.href='adminGoodsList';";
		  jsScript += "</script>";
		  
		  HttpHeaders responseHeaders = new HttpHeaders();
		  responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		  
		  return new ResponseEntity<Object>(jsScript,responseHeaders,HttpStatus.OK);
	  }
	 
	
}
