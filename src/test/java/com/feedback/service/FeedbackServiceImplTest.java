package com.feedback.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.feedback.entity.Feedback;
import com.feedback.repository.FeedbackRepository;
@SpringBootTest
class FeedbackServiceImplTest {
	
	@Mock
	FeedbackRepository feedbackRepository;
	@InjectMocks
	FeedbackServiceImpl feedbackService;
	
	
	@Test
	@DisplayName("Test - to verify add operation")
	void testAddFeedback() throws Exception{
		Feedback sampleInput= new Feedback(10,"very expensive product");
		Feedback expectedOutput=new Feedback(10,"Very expensive product");
		BDDMockito.given(feedbackService.addFeedback(sampleInput)).willReturn(expectedOutput);
		Feedback actualOutput =feedbackService.addFeedback(sampleInput);
		assertEquals(expectedOutput, actualOutput);
	}
	
	
	

	
  /*  @Test
	@DisplayName("Test to verify all user returned")
	//@Disabled
	void testGetAllFeedbacks() throws Exception {

		// given
		
		Feedback feedback1=new Feedback(11,"This product features are very useful");
		
		
		Feedback feedback2=new Feedback(12,"The product is worth to use");
		
		
		
		List<Feedback> sampleOutput = new ArrayList<>();
		sampleOutput.add(feedback1);
		sampleOutput.add(feedback2);
		
		BDDMockito.given(feedbackService.getAllFeedbacks()).willReturn(sampleOutput);
		
		// ----------------------------------------------------------------------
		
		// when :- readyto test the funcationality (service)
		List<Feedback> actualOutput = feedbackService.getAllFeedbacks();
		
		
		// then : verify the sampleOutput with actual output
		
		assertNotNull(actualOutput);
		assertThat(actualOutput.size()).isGreaterThan(0);
		assertIterableEquals(sampleOutput, actualOutput);
		
	}*/


	

}
