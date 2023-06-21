package com.hcc.entities;

import javax.persistence.*;

@Entity
@Table(name="assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="status")
    private String status;

    @Column(name="number")
    Integer number;

    @Column(name="github_url")
    private String githubUrl;

    @Column(name="branch")
    private String branch;

    @Column(name="code_review_video_url")
    private String codeReviewVideoUrl;

    @ManyToOne
    private User user;
}
