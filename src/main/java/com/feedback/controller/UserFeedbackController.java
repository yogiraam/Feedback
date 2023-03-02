package com.feedback.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.dto.ErrorDTO;
import com.feedback.dto.FeedbackResponseDTO;
import com.feedback.dto.MyDTO;
import com.feedback.entity.Feedback;
import com.feedback.service.FeedbackService;
import com.feedback.util.FeedbackDTOConvertor;

@RestController                                              
@RequestMapping("/feedback/user")

public class UserFeedbackController {

	@Autowired
	FeedbackService feedbackService;

	@Autowired
	FeedbackDTOConvertor dtoConvertor;
	@GetMapping("/allfeedbacks")
	public List<Feedback> getAllFeedbacks() {
		try { 
			List<Feedback> allExtractedFeedbacks = feedbackService.getAllFeedbacks();
			return allExtractedFeedbacks;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
}

	@PostMapping("/addFeedback")
	public ResponseEntity<MyDTO> addFeedback(@RequestBody Feedback feedback) {
		try {
			Feedback savedFeedback = feedbackService.addFeedback(feedback);
			FeedbackResponseDTO dto = FeedbackDTOConvertor.convertToDTO(savedFeedback);
			return new ResponseEntity<MyDTO>(dto, HttpStatus.OK);
		} catch (Exception e) {
			ErrorDTO errorDTO = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{feedbackId}")
	public ResponseEntity<String> deleteFeedback(@PathVariable int feedbackId) {
		try {
			String deleteFeedback = feedbackService.deleteFeedback(feedbackId);
			String responseMsg = "deleted the selected feedback ";
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact concerned manager \n" + e;
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public Feedback updateFeedback(@RequestBody Feedback description) throws Exception {
		return feedbackService.updateFeedback(description);
	}
}

