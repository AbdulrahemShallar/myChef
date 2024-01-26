package com.example.mychef.controller;

import com.example.mychef.dto.requestDTO.ChefRequestDTO;
import com.example.mychef.dto.responseDTO.ChefResponseDTO;
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
    public ChefEntity addChef(@RequestBody ChefResponseDTO chef){
        return chefService.newChef(chef);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChefEntity updateChefInfo(@RequestBody ChefResponseDTO chefUpdate,@PathVariable(name = "id") Integer id){
        return chefService.updateChef(chefUpdate,id);
    }

    @GetMapping(path = "/id")
    public ChefRequestDTO getChefById(@RequestParam("id") int id){
        return chefService.getChefById(id);
    }

    @GetMapping(path = "/all")
    public List<ChefRequestDTO> getAllChef(){
        return chefService.getAllChef();
    }


    @GetMapping("/byName")
    public List<ChefRequestDTO> getChefsByName(@RequestParam("name") String name) {
        return chefService.getChefsByName(name);
    }

    @GetMapping("/withChannelLink")
    public List<ChefRequestDTO> getChefsWithChannelLink(@RequestParam("link") String link) {
        return chefService.getChefWithChannelLink(link);
    }

    @GetMapping("/rateGreaterThan")
    public List<ChefRequestDTO> getChefsRateGreaterThan(@RequestParam("rate") int rate) {
        return chefService.getChefRateGreaterThan(rate);
    }

    @GetMapping("/rateLessThan")
    public List<ChefRequestDTO> getChefsRateLessThan(@RequestParam("rate") int rate) {
        return chefService.getChefRateLessThan(rate);
    }

    @GetMapping("/rateBetween")
    public List<ChefRequestDTO> getChefsRateBetween(
            @RequestParam("minRate") int minRate,
            @RequestParam("maxRate") int maxRate) {
        return chefService.getChefRateBetween(minRate, maxRate);
    }

    @GetMapping("/aboutContaining")
    public List<ChefRequestDTO> getChefsAboutContaining(@RequestParam("keyword") String keyword) {
        return chefService.getAboutContaining(keyword);
    }

    @GetMapping("/byVideoRecipeTitle")
    public List<ChefRequestDTO> getChefsByVideoRecipeTitle(@RequestParam("recipeTitle") String recipeTitle) {
        return chefService.getChefsByVideoRecipeTitle(recipeTitle);
    }

    @GetMapping("/orderByRateDesc")
    public List<ChefRequestDTO> getChefsOrderByRateDesc() {
        return chefService.getOrderByChefRateDesc();
    }

    @GetMapping("/orderByRateAsc")
    public List<ChefRequestDTO> getChefsOrderByRateAsc() {
        return chefService.getOrderByChefRateAsc();
    }

    @GetMapping("/byPicture")
    public List<ChefRequestDTO> getChefsByPicture(@RequestParam("pictureUrl") String pictureUrl) {
        return chefService.getPicture(pictureUrl);
    }

}
