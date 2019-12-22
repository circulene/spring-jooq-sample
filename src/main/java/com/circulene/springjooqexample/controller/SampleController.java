package com.circulene.springjooqexample.controller;

import com.circulene.springjooqexample.dto.ProjectIssueDto;
import com.circulene.springjooqexample.service.SampleService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SampleController {
    
    private final SampleService service;
    
    @GetMapping("issues")
    public ProjectIssueDto getIssues() {
        return service.getProjectIssue();
    }
}