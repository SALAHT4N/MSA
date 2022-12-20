package com.software.mas.model.templates;

import javafx.scene.image.Image;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record Service(String name, int capacity , String description, List<Image> images, List<Pair<LocalDateTime, LocalDateTime>> tags) {
}
