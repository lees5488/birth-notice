package com.lee.birthnotice.controller;

import com.lee.birthnotice.model.PeriodInfo;
import com.lee.birthnotice.request.period.PeriodAddRequest;
import com.lee.birthnotice.request.period.PeriodAllFindRequest;
import com.lee.birthnotice.request.period.PeriodUpdateRequest;
import com.lee.birthnotice.response.BaseResponse;
import com.lee.birthnotice.response.period.PeriodAllFindResponse;
import com.lee.birthnotice.response.period.PeriodUpdateResponse;
import com.lee.birthnotice.service.PeriodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Objects;

@Controller
public class TestController {

	@Resource
	private PeriodService periodService;

	@RequestMapping("/")
	public String login (/*@RequestBody Object obj, */HttpServletRequest res, HttpServletResponse pon){
		return "login";
	}

	@RequestMapping("/hello")
	public String hello (/*@RequestBody Object obj, */HttpServletRequest res, HttpServletResponse pon){
		return "hello";
	}

	@RequestMapping("/hello2")
	public String hello (@RequestParam String name , @RequestParam String password , HttpServletRequest res, HttpServletResponse pon){

		if(Objects.equals("root",name) && Objects.equals("password",password)) {
			return "hello";
		}else
			throw new RuntimeException();
	}

	@RequestMapping("/check")
	public String check (/*@RequestParam(name = "name") String name,
						 @RequestParam(name = "password")String password,*/
						 @RequestBody Object obj,
						 HttpServletRequest res, HttpServletResponse pon) throws IOException {
		LinkedHashMap map = (LinkedHashMap) obj;
		if(Objects.equals("root",map.get("name")) && Objects.equals("password",map.get("password"))) {
			return "hello";
		}else
			throw new RuntimeException();
	}


	public void test1(){
		File file = new File("try-with-resources-demo.txt");
		try (
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				){

		}catch (Exception e){

		}
	}


	@RequestMapping("/find_all_period")
	@ResponseBody
	public PeriodAllFindResponse findAllPeriodInfo(Integer userNumId){
		PeriodAllFindRequest request = new PeriodAllFindRequest();
		request.setUserNumId(userNumId);
		return periodService.findAllPeriod(request);
	}

	@RequestMapping("/update_period")
	@ResponseBody
	public PeriodUpdateResponse updateById(@RequestBody PeriodInfo periodInfo){
		PeriodUpdateRequest request = new PeriodUpdateRequest();
		request.setPeriodInfo(periodInfo);
		return periodService.updateById(request);
	}


	@RequestMapping("/add_period")
	@ResponseBody
	public BaseResponse addPeriodInfo(@RequestBody PeriodInfo periodInfo){
		PeriodAddRequest request = new PeriodAddRequest();
		request.setPeriodInfo(periodInfo);
		periodService.addPeriodInfo(request);
		return new BaseResponse();
	}




}
