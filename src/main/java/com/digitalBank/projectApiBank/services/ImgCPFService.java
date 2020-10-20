package com.digitalBank.projectApiBank.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
<<<<<<< HEAD
import javax.validation.Valid;
=======
import java.util.Optional;

import javax.validation.Valid;

>>>>>>> main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
<<<<<<< HEAD
=======

import com.digitalBank.projectApiBank.entities.Client;
>>>>>>> main
import com.digitalBank.projectApiBank.entities.ImgCPF;
import com.digitalBank.projectApiBank.repositories.ImgCPFRepository;
import com.digitalBank.projectApiBank.services.exceptions.ConstraintViolationException;
import com.digitalBank.projectApiBank.services.exceptions.EntityNotFoundException;

@Service
public class ImgCPFService {

	@Autowired
	ImgCPFRepository imgCPFRepository;

	private static String raiz = "C:/Users/Mateus/Pictures/";

	private static String directoryPhotos = "/file/";

	public boolean savePhoto(MultipartFile photo) {
		try {
<<<<<<< HEAD
			this.save(ImgCPFService.directoryPhotos, photo);
=======
			this.save(this.directoryPhotos, photo);
>>>>>>> main
			return true;

		} catch (Exception e) {
			throw new RuntimeException("Problems for save file: ", e);
		}

	}

	public void save(String directory, MultipartFile photo) {
<<<<<<< HEAD
		Path directoryPath = Paths.get(ImgCPFService.raiz, directory);
=======
		Path directoryPath = Paths.get(this.raiz, directory);
>>>>>>> main
		Path photoPath = directoryPath.resolve(photo.getOriginalFilename());

		try {
			Files.createDirectories(directoryPath);
			photo.transferTo(photoPath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Problems for save file: ", e);
		}

	}

	public ImgCPF findById(Long id) {

		return imgCPFRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("id photo " + id + " not found"));
	}

	public ImgCPF saveImgCPF(@Valid @RequestBody ImgCPF imgCPF) {
		try {
			return imgCPFRepository.save(imgCPF);
		} catch (Exception e) {
			throw new ConstraintViolationException("error information = /n" + e);
		}

	}

}
