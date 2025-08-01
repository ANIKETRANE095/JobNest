-- Create database
CREATE DATABASE IF NOT EXISTS jobnest;
USE jobnest;

-- Drop existing tables if any
DROP TABLE IF EXISTS applications;
DROP TABLE IF EXISTS jobs;
DROP TABLE IF EXISTS users;

-- USERS table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role ENUM('CANDIDATE', 'RECRUITER', 'ADMIN') NOT NULL
);

-- JOBS table
CREATE TABLE jobs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    company VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    posted_by INT,
    FOREIGN KEY (posted_by) REFERENCES users(id)
);

-- APPLICATIONS table
CREATE TABLE applications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    job_id INT,
    resume_link VARCHAR(255),
    applied_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (job_id) REFERENCES jobs(id)
);

-- Insert sample users
INSERT INTO users (name, email, password, role) VALUES
('Ravi Sharma', 'ravi.recruiter@gmail.com', 'pass123', 'RECRUITER'),
('Neha HR', 'neha.hr@example.com', 'secure456', 'RECRUITER'),
('Ankit Singh', 'ankit.candidate@gmail.com', 'pwd123', 'CANDIDATE'),
('Priya Patel', 'priya.candidate@gmail.com', 'mypassword', 'CANDIDATE');

-- Insert sample jobs
INSERT INTO jobs (title, description, company, location, posted_by) VALUES
('Java Developer', 'Experience with Spring Boot and REST APIs', 'CodeFactory Pvt Ltd', 'Pune', 1),
('React Developer', 'Strong frontend skills in React, Redux', 'Designify Inc', 'Bangalore', 2),
('Full Stack Engineer', 'Java + React full stack role', 'TechNest Solutions', 'Remote', 1);

-- Insert sample applications
INSERT INTO applications (user
