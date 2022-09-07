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
		 
//		 System.out.println("Original File name -" + file.getOriginalFilename());
//		 
//		 Items item = new Items(file.getOriginalFilename(), file.getContentType(),
//				 compressBytes(file.getBytes()));
		 
//		 itemsRepository.save(item);
//		 return ResponseEntity.status(HttpStatus.OK);
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
		 
//		 final Optional<Items>retrievedImage = itemsRepository.findByName(Name);
//		 Items item = new Items(retrievedImage.get().getName(),retrievedImage.get().getType(),
//				 decompressImage(retrievedImage.get().getImage()));
//		 return item;
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
	 
//	// compress the image bytes before storing it in the database
//		public static byte[] compressBytes(byte[] data) {
//			Deflater deflater = new Deflater();
//			deflater.setInput(data);
//			deflater.finish();
//
//			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//			byte[] buffer = new byte[1024];
//			while (!deflater.finished()) {
//				int count = deflater.deflate(buffer);
//				outputStream.write(buffer, 0, count);
//			}
//			try {
//				outputStream.close();
//			} catch (IOException e) {
//			}
//			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//
//			return outputStream.toByteArray();
//		}
//
//		// uncompress the image bytes before returning it to the angular application
//		public static byte[] decompressBytes(byte[] data) {
//			Inflater inflater = new Inflater();
//			inflater.setInput(data);
//			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//			byte[] buffer = new byte[1024];
//			try {
//				while (!inflater.finished()) {
//					int count = inflater.inflate(buffer);
//					outputStream.write(buffer, 0, count);
//				}
//				outputStream.close();
//			} catch (IOException ioe) {
//			} catch (DataFormatException e) {
//			}
//			return outputStream.toByteArray();
//		}
}
