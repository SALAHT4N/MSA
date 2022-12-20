package com.software.mas.model.templates;

import java.time.LocalDate;
import java.util.Date;

public record CommentProfileData(String name, String content, String urlImg, Date date, double rating) {
}
