package com.feedback.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.feedback.dto.FeedbackResponseDTO;
import com.feedback.entity.Feedback;

@Component
@Scope("singleton")
public class FeedbackDTOConvertor {
	public static FeedbackResponseDTO convertToDTO(Feedback feedback)
	{
		return new FeedbackResponseDTO(feedback.getFeedbackId(),feedback.getFeedback());
	}

}
