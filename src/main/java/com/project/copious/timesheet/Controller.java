package com.project.copious.timesheet;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

    
   static Map<String,String> m = new HashMap<>();
  
    Controller(){
      
     for(int i=1;i<=30;i++)
     m.put(""+i,"8");

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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value=("/uploadFile"))
    public void uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {

       System.out.println("file upload");

        if (uploadfile.isEmpty()) {
            System.out.println("file empty");
        }

        try {

            
         } catch (Exception e) {
            System.out.println(e);
         }
          System.out.println("everything fine");
    

    }


    @GetMapping("/testapi")
    public String testApi(){
      return "Hello World";
    }

 

   
}