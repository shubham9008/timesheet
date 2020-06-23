package com.project.copious.timesheet;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

    
   static Map<String,String> m = new HashMap<>();
  
    Controller(){
      m.put("1","8");
      m.put("2","9");
      m.put("3","9");
      m.put("45","8");
      System.out.println("askjfg");
    }

    @GetMapping("/getTimeSheetData")
    public Map<String,String> getTimeSheetData(){
      return m; 
        
    }

    @PostMapping("/setTimeSheetData")
    public boolean setTimeSheetData(@RequestParam(required=false,name="dayId") String dayId,
     @RequestParam(required=false,name="hours") String hours){

        System.out.println("the request for day"+dayId+"hours"+hours);
        m.put(dayId,hours);

       for( Map.Entry mapElement:m.entrySet()){
         System.out.println(mapElement.getKey()+" "+mapElement.getValue());
       }



        if(dayId!=null)
        return true;
        return false;

    }
 

   
}