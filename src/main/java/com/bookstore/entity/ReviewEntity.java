package com.bookstore.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookReviewEntity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerReviewEntity;

    @Column(name = "rating")
    private int rating;

    @Column(name = "headline")
    private String headline;

    @Column(name = "comment")
    private String comment;

    @Column(name = "review_time")
    private Timestamp reviewTime;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public BookEntity getBookReviewEntity() { return bookReviewEntity; }

    public void setBookReviewEntity(BookEntity bookReviewEntity) { this.bookReviewEntity = bookReviewEntity; }

    public CustomerEntity getCustomerReviewEntity() { return customerReviewEntity; }

    public void setCustomerReviewEntity(CustomerEntity customerReviewEntity) { this.customerReviewEntity = customerReviewEntity; }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewEntity that = (ReviewEntity) o;
        return reviewId == that.reviewId &&
                rating == that.rating &&
                Objects.equals(headline, that.headline) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(reviewTime, that.reviewTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, rating, headline, comment, reviewTime);
    }
}
