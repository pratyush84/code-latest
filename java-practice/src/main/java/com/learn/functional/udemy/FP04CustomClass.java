package com.learn.functional.udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}

public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> courses = Arrays.asList(
                new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,18000),
                new Course("API","Microservices",97,22000),
                new Course("Microservices","Microservices",96,25000),
                new Course("FullStack","FullStack",92,14000),
                new Course("AWS","Cloud",91,21000),
                new Course("Azure","Cloud",96,21000),
                new Course("Docker","Cloud",92,20000),
                new Course("Kubernetes","Cloud",91,20000)
        );

        Predicate<Course> reviewScoreGreaterThan90 = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;

        Comparator<Course> comparingByNumberOfStudents = Comparator.comparing(Course::getNoOfStudents);

        System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan90));
        System.out.println(courses.stream().sorted(comparingByNumberOfStudents).collect(Collectors.toList()));
    }
}
