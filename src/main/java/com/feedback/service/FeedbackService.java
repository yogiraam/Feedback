package com.feedback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feedback.entity.Feedback;

@Service
public interface FeedbackService {
	public Feedback addFeedback(Feedback feedback) throws Exception;
	public Feedback getById(int feedbackId) throws Exception;
	public String deleteFeedback(int feedbackId) throws Exception;
	public Feedback updateFeedback(Feedback feedback) throws Exception;
	public List<Feedback> getAllFeedbacks() throws Exception;

}
