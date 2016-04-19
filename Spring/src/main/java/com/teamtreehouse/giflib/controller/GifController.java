package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class GifController {
    @Autowired
    private GifRepository mGifRepository;

    @RequestMapping("/")
    public String listGifs(){
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = mGifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

}
