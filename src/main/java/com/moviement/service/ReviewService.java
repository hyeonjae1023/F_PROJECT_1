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

	public Review getForPrintReview(String menu) {
		// TODO Auto-generated method stub
		return reviewDao.getForPrintReview(menu);
	}

	public void modifyReview(String title, String body, float grades) {
		reviewDao.modifyReview(title, body, grades);
		
	}
}
