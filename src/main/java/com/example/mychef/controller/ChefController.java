package com.example.mychef.controller;

import com.example.mychef.convert.ChefDTOConverter;
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

    final ChefDTOConverter chefDTOConverter;

    public ChefController(ChefService chefService,ChefDTOConverter chefDTOConverter) {
        this.chefService = chefService;
        this.chefDTOConverter = chefDTOConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChefEntity addChef(@RequestBody ChefResponseDTO chef){
        return chefService.newChef(chefDTOConverter.convertChefDTOToEntity(chef));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChefEntity updateChefInfo(@RequestBody ChefResponseDTO chefUpdate,@RequestParam("id") Integer id){
        return chefService.updateChef(chefDTOConverter.convertChefDTOToEntity(chefUpdate),id);
    }

    @GetMapping(path = "/id")
    public ChefRequestDTO getChefById(@RequestParam("id") int id){
        return chefDTOConverter.convertChefEntityToDTO(chefService.getChefById(id));
    }

    @GetMapping(path = "/all")
    public List<ChefRequestDTO> getAllChef(){
        return chefDTOConverter.convertChefEntityToDTO(chefService.getAllChef());
    }


    @GetMapping("/byName")
    public List<ChefRequestDTO> getChefsByName(@RequestParam("name") String name) {
        return  chefDTOConverter.convertChefEntityToDTO(chefService.getChefsByName(name));
    }

    @GetMapping("/withChannelLink")
    public List<ChefRequestDTO> getChefsWithChannelLink(@RequestParam("link") String link) {
        return chefDTOConverter.convertChefEntityToDTO(chefService.getChefWithChannelLink(link));
    }

    @GetMapping("/rateGreaterThan")
    public List<ChefRequestDTO> getChefsRateGreaterThan(@RequestParam("rate") int rate) {
        return chefDTOConverter.convertChefEntityToDTO(chefService.getChefRateGreaterThan(rate));
    }

    @GetMapping("/rateLessThan")
    public List<ChefRequestDTO> getChefsRateLessThan(@RequestParam("rate") int rate) {
        return chefDTOConverter.convertChefEntityToDTO(chefService.getChefRateLessThan(rate));
    }

    @GetMapping("/rateBetween")
    public List<ChefRequestDTO> getChefsRateBetween(
            @RequestParam("minRate") int minRate,
            @RequestParam("maxRate") int maxRate) {
        return chefDTOConverter.convertChefEntityToDTO(chefService.getChefRateBetween(minRate, maxRate));
    }

    @GetMapping("/aboutContaining")
    public List<ChefRequestDTO> getChefsAboutContaining(@RequestParam("keyword") String keyword) {
        return chefDTOConverter.convertChefEntityToDTO(chefService.getAboutContaining(keyword));
    }

    @GetMapping("/byVideoRecipeTitle")
    public List<ChefRequestDTO> getChefsByVideoRecipeTitle(@RequestParam("recipeTitle") String recipeTitle) {
        return chefDTOConverter.convertChefEntityToDTO(chefService.getChefsByVideoRecipeTitle(recipeTitle));
    }

    @GetMapping("/orderByRateDesc")
    public List<ChefRequestDTO> getChefsOrderByRateDesc() {
        return chefDTOConverter.convertChefEntityToDTO(chefService.getOrderByChefRateDesc());
    }

    @GetMapping("/orderByRateAsc")
    public List<ChefRequestDTO> getChefsOrderByRateAsc() {
        return chefDTOConverter.convertChefEntityToDTO(chefService.getOrderByChefRateAsc());
    }

    @GetMapping("/byPicture")
    public List<ChefRequestDTO> getChefsByPicture(@RequestParam("pictureUrl") String pictureUrl) {
        return chefDTOConverter.convertChefEntityToDTO(chefService.getPicture(pictureUrl));
    }

}
