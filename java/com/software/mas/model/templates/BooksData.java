package com.software.mas.model.templates;

import java.time.LocalDateTime;

public record BooksData (String serviceId, LocalDateTime startAt, LocalDateTime endAt,boolean status,boolean allowComment) {
}
