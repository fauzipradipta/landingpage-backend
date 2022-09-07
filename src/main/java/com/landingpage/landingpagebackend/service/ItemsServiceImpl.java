package com.landingpage.landingpagebackend.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.landingpage.landingpagebackend.Entity.Items;
import com.landingpage.landingpagebackend.repository.ItemsRepository;
import com.landingpage.landingpagebackend.response.MessageResponse;
import com.landingpage.landingpagebackend.util.ItemsUtility;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ItemsServiceImpl {
	@Autowired
    ItemsRepository itemsRepository;

    // Post an Items Data
	 @PostMapping("/upload/itemImage")
     public ResponseEntity<MessageResponse> uploadImage(@RequestParam("image")  MultipartFile file, @RequestPart Items item)
                throws IOException {

		  itemsRepository.save(Items.builder()
                  .name(item.getName())
                  .itemDesc(item.getItemDesc())
                  .itemprice(item.getItemprice())
                  .type(file.getContentType())
                  .image(ItemsUtility.compressImage(file.getBytes())).build());
          return ResponseEntity.status(HttpStatus.OK)
                  .body(new MessageResponse("Image uploaded successfully: " +
                          file.getOriginalFilename()));
		 
        }
    

	 @GetMapping(path = {"/get/itemImage/info/{id}"})
	    public Items getImageDetails(@PathVariable("id") Long id) throws IOException {
		 
	        final Optional<Items> dbImage = itemsRepository.findById(id);

	        return Items.builder()
	                .name(dbImage.get().getName())
	                .itemDesc(dbImage.get().getItemDesc())
	                .itemprice(dbImage.get().getItemprice())
	                .type(dbImage.get().getType())
	                .image(ItemsUtility.decompressImage(dbImage.get().getImage())).build();
	    }
	 @GetMapping(path = {"/get/image/{name}"})
	    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

	        final Optional<Items> item = itemsRepository.findByName(name);
	        
	        
	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.valueOf(item.get().getType()))
	                .body(ItemsUtility.decompressImage(item.get().getImage()));
	    }
	 @GetMapping(value="/get/getAllItem")
	 public List<Items> getAllItems(){
		 return itemsRepository.findAll();
	 }
}
