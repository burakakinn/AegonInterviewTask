# Aegon Interview Task
> This project is on customer satisfaction survey. It presents customer a survey on how likely they are recommend a topic to their friends and collegue.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Usage Through Postman](#usage-through-postman)
* [Screenshots](#screenshots)
* [Important Notes](#important-notes)

## General info
> It is a Spring Boot Web Application that uses RESTful API for a customer satisfaction survey.

## Technologies
* Java 8
* Spring Boot
* Inner H2 Database
* Hibernate
* MapStruct 1.3.0 Final
* Querydsl
* Bootstrap 4
* Javascript


## Setup
Open the project as a Spring Boot Project in an IDE ( I Used Intellij IDEA). The "pom.xml" file will handle all the dependencies. Then just run the application Tomcat server will be working. 
Main page will be accessible in "http://localhost:8080/index".

## Usage Through Postman
* Creating Survey  
   >url : http://localhost:8080/survey/add  
   >method : POST  
   >body : {"topic":"AppName","question":"Question?"}  
   >returns : survey id
* Submitting Survey
    >url : http://localhost:8080/answer/add  
    method : POST  
    body : {"topicId":"topicId","score":"Score","feedback":"Feedback"}  
    bodyExample : {"topicId":"1","score":"9","feedback":"Excellent!"}  
    returns : answer id
* Listing Survey Answers
    >url : http://localhost:8080/answer/list/{topicId}  
    urlExample : http://localhost:8080/answer/list/1  
    method : GET  
    body : none  
    returns : Array of AnswerResultDTO as JSON
* Listing Survey Topics
    >url : http://localhost:8080/survey/allResults  
    method : GET  
    body : none  
    returns : Array of SurveyResultDTO as JSON


## Screenshots
![Example screenshot](./img/screenshot.png)