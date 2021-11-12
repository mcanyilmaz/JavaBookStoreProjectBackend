package com.bookApplication2.BookApplication2.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
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
	
	
	public List<Slider> findAllSliderByStateTrueOrderByLineNumberAsc(){
		 List<Slider> sliderData = sliderRepository.findAllSliderByStateTrueOrderByLineNumberAsc();
		 
		  for (Slider slider:sliderData){
		        
	            if(slider != null){
	            	slider.setPicByte(ImageUtility.decompressBytes(slider.getPicByte()));
	            }
	        }

	        return sliderData;
	}
	
	public Slider updateSliderLineNumber(int id,SliderCreateRequest sliderCreateRequest) {
		Slider slider = sliderRepository.findById(id).orElseThrow(null);
		Slider oldSliderLineNumber = sliderRepository.findByLineNumber(sliderCreateRequest.getLineNumber()); 
		List<Slider> getAllSlider = sliderRepository.findAll();
		
	
		if(sliderCreateRequest.getLineNumber()==1) {
			
			for (int i = 0; i < getAllSlider.size(); i++) {
				if(sliderCreateRequest.getLineNumber()==getAllSlider.get(i).getLineNumber()) {
					
					getAllSlider.get(i).setLineNumber(slider.getLineNumber());
					getAllSlider.get(i).setActive("");
					slider.setLineNumber(sliderCreateRequest.getLineNumber());
					slider.setActive("active");
					
					/*for (int j=getAllSlider.get(i).getLineNumber(); j <getAllSlider.size(); j++) {
							getAllSlider.get(i).setLineNumber(j);
							
						}*/
				}
			}
			//3 nolu idi aldım. 
			/*slider.setLineNumber(sliderCreateRequest.getLineNumber());
			slider.setActive("active");
			oldSliderLineNumber.setLineNumber(id);
			oldSliderLineNumber.setActive("");*/

	
			
		/*	for (int i = 0; i < getAllSlider.size(); i++) {
				if(getAllSlider.get(i).getLineNumber()==1 && getAllSlider.get(i).getActive().equals("active")) {
					getAllSlider.get(i).setActive("");
					getAllSlider.get(i).setLineNumber(0);
				}
			}*/
			
			
			/*for (int i = 1; i <getAllSlider.size(); i++) {
				getAllSlider.get(i).setLineNumber(i+1);
				getAllSlider.get(i).setActive("");
			}
			*/
			//slider.setActive("active");
			//slider.setLineNumber(sliderCreateRequest.getLineNumber());
			//
			
		}else {

			//3 nolu idi aldım. 
			//slider.setLineNumber(sliderCreateRequest.getLineNumber());
			
			//oldSliderLineNumber.setLineNumber(sliderCreateRequest.getLineNumber());

		
				for (int i = 0; i < getAllSlider.size(); i++) {
					if(sliderCreateRequest.getLineNumber()==getAllSlider.get(i).getLineNumber()) {
						
						getAllSlider.get(i).setActive("");
						getAllSlider.get(i).setLineNumber(slider.getLineNumber());
						slider.setLineNumber(sliderCreateRequest.getLineNumber());
						
						
						/*for (int j=getAllSlider.get(i).getLineNumber(); j <getAllSlider.size(); j++) {
								getAllSlider.get(i).setLineNumber(j);
								
							}*/
					}
				}
			
		/*	for (int i = 2; i <getAllSlider.size(); i++) {
				getAllSlider.get(i).setLineNumber(i+1);
				getAllSlider.get(i).setActive("");
			
			}*/
			
		
		}
		
		/*if(slider.getLineNumber()!=1) {
			slider.setActive("");
			slider.setLineNumber(sliderCreateRequest.getLineNumber());
		
			
		}else {
			slider.setActive("active");
			slider.setLineNumber(id);
		}*/
		
	
		
		return sliderRepository.save(slider);
		
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
