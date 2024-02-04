package com.example.mychef.controller;

import com.example.mychef.convert.VideoCategoriesDTOConverter;
import com.example.mychef.dto.requestDTO.VideoCategoriesRequestDTO;
import com.example.mychef.dto.responseDTO.VideoCategoriesResponseDTO;
import com.example.mychef.model.VideoCategoriesEntity;
import com.example.mychef.service.VideoCategoriesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videoCategories")
public class VideoCategoriesController {

    final
    VideoCategoriesService videoCategoriesService;

    final
    VideoCategoriesDTOConverter videoCategoriesDTOConverter;

    public VideoCategoriesController(VideoCategoriesService videoCategoriesService, VideoCategoriesDTOConverter videoCategoriesDTOConverter) {
        this.videoCategoriesService = videoCategoriesService;
        this.videoCategoriesDTOConverter = videoCategoriesDTOConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoCategoriesEntity addCategories(@RequestBody VideoCategoriesResponseDTO videoCategories){
        return videoCategoriesService.newCategory(videoCategoriesDTOConverter.convertVideoCategoriesDTOToEntity(videoCategories));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoCategoriesEntity updateCategoriesInfo(@RequestBody VideoCategoriesResponseDTO videoCategoriesUpdate,@RequestParam("id") Integer id){
        return videoCategoriesService.updateCategory(videoCategoriesDTOConverter.convertVideoCategoriesDTOToEntity(videoCategoriesUpdate),id);
    }

    @GetMapping(path = "/id")
    public VideoCategoriesRequestDTO getVideoCategoryById(@RequestParam("id") int id){
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getVideoCategoriesById(id));
    }

    @GetMapping(path = "/all")
    public List<VideoCategoriesRequestDTO> getAllCategories(){
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getAllCategories());
    }

    @GetMapping("/withVideoRecipes")
    public List<VideoCategoriesRequestDTO> getCategoriesWithVideoRecipes() {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getCategoriesWithVideoRecipes());
    }

    @GetMapping("/byNameContaining")
    public List<VideoCategoriesRequestDTO> getCategoriesByNameContaining(@RequestParam("keyword") String keyword) {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getCategoriesByNameContaining(keyword));
    }

    @GetMapping("/byPicture")
    public List<VideoCategoriesRequestDTO> getCategoriesByPicture(@RequestParam("pictureUrl") String pictureUrl) {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getCategoriesByPicture(pictureUrl));
    }

    @GetMapping("/allOrderByNameAsc")
    public List<VideoCategoriesRequestDTO> getAllCategoriesOrderByNameAsc() {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getAllCategoriesOrderByNameAsc());
    }

    @GetMapping("/allOrderByNameDesc")
    public List<VideoCategoriesRequestDTO> getAllCategoriesOrderByNameDesc() {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getAllCategoriesOrderByNameDesc());
    }

    @GetMapping("/withMostVideoRecipes")
    public List<VideoCategoriesRequestDTO> getCategoriesWithMostVideoRecipes() {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getCategoriesWithMostVideoRecipes());
    }

    @GetMapping("/withNoVideoRecipes")
    public List<VideoCategoriesRequestDTO> getCategoriesWithNoVideoRecipes() {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getCategoriesWithNoVideoRecipes());
    }

    @GetMapping("/withVideoRecipesAndPicture")
    public List<VideoCategoriesRequestDTO> getCategoriesWithVideoRecipesAndPicture() {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getCategoriesWithVideoRecipesAndPicture());
    }

    @GetMapping("/excludingName")
    public List<VideoCategoriesRequestDTO> getCategoriesByExcludingName(@RequestParam("excludeKeyword") String excludeKeyword) {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getCategoriesByExcludingName(excludeKeyword));
    }

    @GetMapping("/by-name-containing-order-by-video-recipe-countDesc")
    public List<VideoCategoriesRequestDTO> getCategoriesByNameContainingOrderByVideoRecipeCountDesc(@RequestParam("keyword") String keyword) {
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesService.getCategoriesByNameContainingOrderByVideoRecipeCountDesc(keyword));
    }

}
