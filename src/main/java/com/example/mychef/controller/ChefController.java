package com.example.mychef.controller;

import com.example.mychef.dto.ChefDTO;
import com.example.mychef.model.ChefEntity;
import com.example.mychef.service.ChefService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chef")
public class ChefController {

    final
    ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChefEntity addChef(@RequestBody ChefEntity chef){
        return chefService.newChef(chef);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChefEntity updateChefInfo(@RequestBody ChefEntity chefUpdate,@PathVariable(name = "id") Integer id){
        return chefService.updateChef(chefUpdate,id);
    }

    @GetMapping(path = "/{id}")
    public ChefDTO getChefById(@PathVariable(value = "id") int id){
        return chefService.getChefById(id);
    }

    @GetMapping(path = "/all")
    public List<ChefDTO> getAllChef(){
        return chefService.getAllChef();
    }
}
