package com.feedback.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.entity.Feedback;
import com.feedback.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	@Autowired
	private FeedbackRepository feedbackRepository;

	

	@Override
	public Feedback getById(int feedbackId) throws Exception {
	
		return feedbackRepository.findById(feedbackId).get();
	}

	


	@Override
	public Feedback addFeedback(Feedback feedback) throws Exception {
		// TODO Auto-generated method stub
		Feedback savedFeedback = feedbackRepository.save(feedback);
		if(savedFeedback != null) {
			return savedFeedback;
		}
		else
		return null;
	
	}

	@Override
	public String deleteFeedback(int feedbackId) throws Exception {
		// TODO Auto-generated method stub
		feedbackRepository.deleteById(feedbackId);
		return "feedback with id "+feedbackId+"has deleted";

	}

	@Override
	public Feedback updateFeedback(Feedback feedback) throws Exception {
		// TODO Auto-generated method stub
		Feedback updatedFeedback = feedbackRepository.save(feedback);
		return updatedFeedback;
	}

	@Override
	public List<Feedback> getAllFeedbacks() throws Exception {
		// TODO Auto-generated method stub
		List<Feedback> allFeedbacks = feedbackRepository.findAll();
		return allFeedbacks;

	}
	

}
