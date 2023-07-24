package com.moviement.service;

import java.util.List;

import com.moviement.container.Container;
import com.moviement.dao.ReviewDao;
import com.moviement.dto.Review;

public class ReviewService {
	private ReviewDao reviewDao;

	public ReviewService() {
		reviewDao = Container.reviewDao;
	}

	public List<Review> getForPrintReivews(String nickName) {
		return reviewDao.getForPrintReviews(nickName);
	}

	public List<Review> getReviews() {
		return reviewDao.getReviews();
	}

	public Review getForPrintReview(int reviewId) {
		return reviewDao.getForPrintReview(reviewId);
	}

	public void modifyReview(int id, String body, float grades) {
		reviewDao.modifyReview(id, body, grades);
		
	}
}
