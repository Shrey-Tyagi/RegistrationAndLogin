package com.project2.registration.controller;
import com.project2.registration.entity.Corporate;
import com.project2.registration.services.CorporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/corporate")
@CrossOrigin
public class CorporateController {

    @Autowired
    CorporateService corporateService;

    @PostMapping("")
    Corporate addCorporateData(@RequestBody Corporate corporate){
        return corporateService.addCorporateData(corporate);
    }

    @GetMapping("data/{channelId}/{pageId}")
    Corporate showCorporateData(@PathVariable int channelId , @PathVariable String pageId, @PathVariable int role){
        return corporateService.findByChannelIdAndPageIdAndRole(channelId,pageId,role);
    }

//    @GetMapping("dataUpdate")
//    Corporate updateCorporateData(@RequestBody Corporate corporate){
//        return corporateService.updateCorporateData(corporate);
//    }

    @DeleteMapping("del/{channelId}/{pageId}/{userId}")
    Corporate delCorporateData(@PathVariable int channelId, @PathVariable String pageId, @PathVariable int role){
        return corporateService.deleteByChannelIdAndPageIdAndRole(channelId,pageId,role);
    }


}
