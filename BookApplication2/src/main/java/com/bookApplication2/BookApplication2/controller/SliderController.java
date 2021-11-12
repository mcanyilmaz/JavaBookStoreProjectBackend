package com.bookApplication2.BookApplication2.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookApplication2.BookApplication2.model.ImageModel;
import com.bookApplication2.BookApplication2.model.Slider;
import com.bookApplication2.BookApplication2.repository.SliderRepository;
import com.bookApplication2.BookApplication2.requests.SliderCreateRequest;
import com.bookApplication2.BookApplication2.requests.SliderRequest;
import com.bookApplication2.BookApplication2.service.SliderService;
import com.bookApplication2.BookApplication2.util.ImageUtility;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/slider/")

public class SliderController {
	
	private SliderRepository sliderRepository;
	private SliderService sliderService;


	

	public SliderController(SliderRepository sliderRepository, SliderService sliderService) {
		super();
		this.sliderRepository = sliderRepository;
		this.sliderService = sliderService;
	}
	
	@DeleteMapping("/deleteSliderImageById/{id}")
	public ResponseEntity<Void> deleteSliderImageById(@PathVariable int id){
	
		sliderService.deleteSliderImageById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	
	@PostMapping("/upload")	
	public ResponseEntity<?> uplaodImage(@RequestParam("imageFile") MultipartFile file,@RequestParam("payload") String payload) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
	/*	ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		imageRepository.save(img);
		return ResponseEntity.status(HttpStatus.OK);*/
		sliderService.addSliderImage(file,payload);
		return  ResponseEntity.ok(HttpStatus.OK);
	}
	
	/*@GetMapping(path = { "/get/{imageName}" })
	public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
		final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
		ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}*/
	
	/*@GetMapping("/getImageId/{id}")
	public ImageModel getImage(@PathVariable long id) throws IOException {
		final Optional<ImageModel> retrievedImage = imageRepository.findById(id);
		ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}*/
	
	
	@GetMapping("/getAll")
	public List<Slider> getAllImage(){
		//final List<ImageModel> retrievedImage = imageRepository.findAll();
		
		/* List<ImageModel> foods = imageRepository.findAll();
	        for (ImageModel book:foods){
	        
	            if(book != null){
	            	book.setPicByte(ImageUtility.decompressBytes(book.getPicByte()));
	            }
	        }

	        return foods;*/
		return sliderService.getAllSlider(); 
	        
	        

	}
	
	@GetMapping("/getAllSliderViewTrue")
	public List<Slider> getAllSliderViewTrue(){
		//final List<ImageModel> retrievedImage = imageRepository.findAll();
		
		/* List<ImageModel> foods = imageRepository.findAll();
	        for (ImageModel book:foods){
	        
	            if(book != null){
	            	book.setPicByte(ImageUtility.decompressBytes(book.getPicByte()));
	            }
	        }

	        return foods;*/
		return sliderService.getAllSliderViewTrue();
	        
	        

	}
	
	@GetMapping("/findAllSliderByStateTrueOrderByLineNumberAsc")
	public List<Slider> findAllSliderByStateTrueOrderByLineNumberAsc(){
		return sliderService.findAllSliderByStateTrueOrderByLineNumberAsc();
	}
	
	@PutMapping("updateSliderLineNumber/{id}")
	public Slider updateSliderLineNumber(@PathVariable int id, @RequestBody SliderCreateRequest sliderCreateRequest) {
		return sliderService.updateSliderLineNumber(id, sliderCreateRequest);
	}
	
	
	
	
	@PutMapping("updateSliderImageView/{id}")
	public Slider updateSliderImageView(@PathVariable int id, @RequestBody SliderRequest sliderRequest) {
		System.out.print(sliderRequest.getState());
	
		return sliderService.updateSliderImageView(id, sliderRequest);
	}
	
	
	
	

}
