package com.software.mas.model.templates;

import java.util.List;

public record DetailsPageData(String providerName,
                              String providerProfilePhotoUrl,
                              String mobileNumber,
                              List<String> imageSlides) {
}
