package com.circulene.springjooqexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectIssueDto {
    String issueName;
    String projectName;
    String releaseName;
}