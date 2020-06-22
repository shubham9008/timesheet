package com.project.copious.timesheet;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

   static Map<String,String> m = new HashMap<>();
    
    @GetMapping("/getTimeSheetData")
    public Map<String,String> getTimeSheetData(){

        Map<String,String> m = new HashMap<>();
        m.put("1","8");
        m.put("2","9");
        m.put("3","8");
      return m;
        
    }

    @PostMapping("/setTimeSheetData")
    public void setTimeSheetData(@RequestParam String dayId, @RequestParam 
    String hours){
        m.put(dayId,hours);
    }



}