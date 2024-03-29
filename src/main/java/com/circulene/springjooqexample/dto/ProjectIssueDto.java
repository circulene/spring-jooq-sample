package com.circulene.springjooqexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectIssueDto {
    String projectName;
    String projectVersion;
    String releaseName;
    String releaseVersion;
    String issueName;
}