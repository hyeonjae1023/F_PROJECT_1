package com.moviement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.moviement.container.Container;
import com.moviement.db.DBConnection;
import com.moviement.dto.Member;
import com.moviement.dto.Review;



public class ReviewDao {
	private DBConnection dbConnection;
	
	public ReviewDao() {
		dbConnection = Container.getDBConnection();
	}
	
	public List<Review> getReviews() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("SELECT * FROM review"));
		List<Review> reviews = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());
		
		for (Map<String, Object> row : rows) {
			reviews.add(new Review(row));
		}
		return reviews;
	}

	public Review getForPrintReview(int reviewId) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM review "));
		sb.append(String.format("WHERE id = '%d' ", reviewId));

		
		Map<String, Object> row = dbConnection.selectRow(sb.toString());

	
		if (row.isEmpty()) {
			return null;
		}

		return new Review(row);
	}
	
	public List<Review> getForPrintReviews(String nickName) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM review "));
		sb.append(String.format("WHERE `name` = '%s' ", nickName));

		List<Review> reviews = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			reviews.add(new Review(row));
		}
		
		return reviews;
	}
	
	public int modifyReview(int id, String body, float grades) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("UPDATE review "));
		sb.append(String.format("SET updateDate = NOW(), "));
		sb.append(String.format("grades = '%.2f', ", grades));
		sb.append(String.format("body = '%s' ", body));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.update(sb.toString());
	}
}