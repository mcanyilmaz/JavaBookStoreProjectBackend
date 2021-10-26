package com.bookApplication2.BookApplication2.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bookApplication2.BookApplication2.exception.ResourceNotFoundException;
import com.bookApplication2.BookApplication2.model.Author;
import com.bookApplication2.BookApplication2.model.Book;
import com.bookApplication2.BookApplication2.model.ImageModel;
import com.bookApplication2.BookApplication2.model.User;
import com.bookApplication2.BookApplication2.repository.AuthorRepository;
import com.bookApplication2.BookApplication2.requests.AuthorCreateRequest;
import com.bookApplication2.BookApplication2.requests.AuthorUpdateRequest;
import com.bookApplication2.BookApplication2.requests.BookCreateRequest;
import com.bookApplication2.BookApplication2.requests.UserCreateDataDetails;
import com.bookApplication2.BookApplication2.util.ImageUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuthorService {
	
	private AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	
	
	public Page<Author> getAllAuthorPageable(int pageSize,int page){
		Pageable pageable = PageRequest.of(page, pageSize);
		return authorRepository.findAll(pageable);
	}
	
	
	public Author addAuthor(MultipartFile file,String json) throws IOException {
		
		
		
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

	
	public Author findByAuthorName(String authorName) {
		return authorRepository.findByAuthorName(authorName);	
	}

	public List<Author> getAllAuthor() {
		return authorRepository.findAll();
	}
	
	public void deleteAuthor(int id) {
		authorRepository.deleteById(id);
	}
	
	public Author updateAuthor(MultipartFile file, String json ) throws IOException {
		
		
		AuthorCreateRequest authorCreateRequest= new ObjectMapper().readValue(json,AuthorCreateRequest.class);

    	
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				ImageUtility.compressBytes(file.getBytes()));
		
		Author author = authorRepository.findById(authorCreateRequest.getId())
				.orElseThrow(()-> new ResourceNotFoundException("not found id" +authorCreateRequest.getId()));
	
		LocalDateTime updatedTime = LocalDateTime.now();
		
		author.setAuthorName(authorCreateRequest.getAuthorName());
		author.setAuthorAbout(authorCreateRequest.getAuthorAbout());
		author.setCreatedDate(author.getCreatedDate());
		author.setUpdateDate(updatedTime);
		author.setName(file.getName());
		author.setType(file.getContentType());
	
		author.setPicByte(ImageUtility.decompressBytes(img.getPicByte()));	
		
		
		;
		/*user.setUserPhoneNumber(userCreateDataDetails.getUserPhoneNumber());		
		user.setUserAddress(userCreateDataDetails.getUserAddress());
		user.setImageName(img.getName());
		user.setPicByte(file.getBytes());
	
		user.setType(img.getType());*/

		
	
		
		/*Author newAuthor  = authorRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("not found " + id));
		
		LocalDateTime updatedTime = LocalDateTime.now();
		
		newAuthor.setAuthorName(authorUpdateDto.getAuthorName());
		newAuthor.setAuthorAbout(authorUpdateDto.getAuthorAbout());
		
		//newAuthor.setAuthorCountry(author.getAuthorCountry());
		//newAuthor.setBooks(authorUpdateDto.getBooks());
		newAuthor.setCreatedDate(newAuthor.getCreatedDate());
		newAuthor.setUpdateDate(updatedTime);
		
		*/
		return authorRepository.save(author);
		
		
	}
	
	public Optional<Author> getByAuthorId(int id) {
		return authorRepository.findById(id);
		
		
	}
	/*
	
	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
			return outputStream.toByteArray();
		}
		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
	*/

}
