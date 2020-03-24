package com.calc;

import java.util.List;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArithmaticController {

	@Autowired
	private ArithmaticService service;

	
	@RequestMapping(value = "/performops",method = RequestMethod.POST)
	public String performOperations(@RequestParam(value = "value1") String expression, Model model) throws Exception {

		Calculator calc = new Calculator();
		 ScriptEngineManager mgr = new ScriptEngineManager();

         ScriptEngine engine = mgr.getEngineByName("JavaScript");
   		calc.setInputVal(expression);
		calc.setOutVal((int) engine.eval(expression));
		
		service.save(calc);
		
		List<Calculator> calcs =  service.findAllCalc();
		calcs.stream().forEach((p)->{System.out.println(p.getInputVal());});

		model.addAttribute("calc",calcs);
		model.addAttribute("message","done");
		
		return "displayRecords";

	}
	
	
	@RequestMapping(value="/getData", method = RequestMethod.GET)
	public String getCalc(Model model){
		List<Calculator> calcs =  service.findAllCalc();
		
		model.addAttribute("calc",calcs);
		model.addAttribute("message","done");
		
		return "displayRecords";
	}
	
	@RequestMapping(value="/clear", method = RequestMethod.GET)
	public String deleteAll(Model model){
		service.deleteAll();

		model.addAttribute("message","done");
		
		return "displayRecords";
	}
	
	
	
}
