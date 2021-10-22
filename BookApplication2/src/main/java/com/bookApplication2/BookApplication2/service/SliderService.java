package com.bookApplication2.BookApplication2.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookApplication2.BookApplication2.exception.ResourceNotFoundException;
import com.bookApplication2.BookApplication2.model.Author;
import com.bookApplication2.BookApplication2.model.ImageModel;
import com.bookApplication2.BookApplication2.model.Slider;
import com.bookApplication2.BookApplication2.repository.SliderRepository;
import com.bookApplication2.BookApplication2.requests.AuthorCreateRequest;
import com.bookApplication2.BookApplication2.requests.SliderCreateRequest;
import com.bookApplication2.BookApplication2.requests.SliderRequest;
import com.bookApplication2.BookApplication2.util.ImageUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SliderService {
	
	private SliderRepository sliderRepository;

	public SliderService(SliderRepository sliderRepository) {
		super();
		this.sliderRepository = sliderRepository;
	}
	
	
	public void deleteSliderImageById(int id) {
		
		 sliderRepository.deleteById(id);	
				
				
	}
	
	public Slider updateSliderImageView(int id,SliderRequest sliderRequest) {
		
	     // Sliderda olan resimlerin hangilerinin görüntülenmesi görüntülenmemesi
	    //için dönecek  olan boolean true false degerini dönemedim. Bu sebeple sorunu çözmek adına
	   // request açmak zorunda kaldım. kısa sürede çözüp update edeceğim.
		Boolean state = false;
		
	
		Slider slider = sliderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("slidere ait id bulunamadıu" + id));
	

		if(sliderRequest.getState().equals("false")){
			state = false;
		}else {
			state = true;
		}
		
		slider.setState(state);
		return sliderRepository.save(slider);
	}
	public List<Slider> getAllSlider() {
		
		 List<Slider> sliderData = sliderRepository.findAll();
		 
	        for (Slider slider:sliderData){
	        
	            if(slider != null){
	            	slider.setPicByte(ImageUtility.decompressBytes(slider.getPicByte()));
	            }
	        }

	        return sliderData;
	}
	
	
	public List<Slider> getAllSliderViewTrue() {
		
		 List<Slider> sliderData = sliderRepository.findAllSliderByStateTrue();
		 
	        for (Slider slider:sliderData){
	        
	            if(slider != null){
	            	slider.setPicByte(ImageUtility.decompressBytes(slider.getPicByte()));
	            }
	        }

	        return sliderData;
	}
	
	
	
	
	/*
	
	public Slider addSliderImage(MultipartFile file,String json) throws IOException {
		
		
		
		AuthorCreateRequest authorCreateRequest = new ObjectMapper().readValue(json,AuthorCreateRequest.class);

		
		
		Author author = new Author();
		LocalDateTime createdDate = LocalDateTime.now();
		//ImageModel img = new ImageModel(authorCreateDto.getFile().getOriginalFilename(), authorCreateDto.getFile().getContentType(),
		//			compressBytes(authorCreateDto.getFile().getBytes()));
		
		//author.setImageModal(img);
		
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				ImageUtility.compressBytes(file.getBytes()));
		
		
		
		author.setAuthorName(authorCreateRequest.getAuthorName());
		
		author.setAuthorAbout(authorCreateRequest.getAuthorAbout());
	
		author.setCreatedDate(createdDate);
		author.setImageName(authorCreateRequest.getImageName());	
		
		author.setUpdateDate(authorCreateRequest.getUpdateDate());
		
		author.setName(file.getName());
		author.setType(file.getContentType());
	
		author.setPicByte(ImageUtility.decompressBytes(img.getPicByte()));	

		
		//author.setBooks(authorCreateDto.getBooks());
		
		return authorRepository.save(author);
		
	}
*/


	
	public Slider addSliderImage(MultipartFile file,String json) throws IOException {
		
		SliderCreateRequest sliderCreateRequest = new ObjectMapper().readValue(json,SliderCreateRequest.class);

		
		ImageUtility imageUtility = null;
				
		Slider img = new Slider(true,file.getOriginalFilename(), file.getContentType(),
			imageUtility.compressBytes(file.getBytes()));
		
		img.setState(sliderCreateRequest.getState());
		
		return sliderRepository.save(img);
		//return sliderRepository.save(slider);
	}
	
	

}
